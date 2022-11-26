package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import javafx.scene.control.Label;


import java.io.FileNotFoundException;

import static java.lang.Math.*;


public class App extends Application {
    private MoveDirection[] directions;
    private IWorldMap map;

    public void init() {
        directions = new OptionsParser().parse(getParameters().getRaw().toArray(new String[0]));
        this.map = new GrassField(10);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
    }

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        Vector2d lowerLeft = this.map.getLowerLeft();
        Vector2d upperRight = this.map.getUpperRight();
        int xMin = min(lowerLeft.x, upperRight.x);
        int xMax = max(lowerLeft.x, upperRight.x);
        int yMin = min(lowerLeft.y, upperRight.y);
        int yMax = max(lowerLeft.y, upperRight.y);
        int horizontal = xMax-xMin+1;
        int vertical = yMax-yMin+1;
        int constant=50;
        // zmienna constant jest równa szerokości oraz wysokości poszczególnych komórek

        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);
        Label headerLabel = new Label("y/x");
        gridPane.add(headerLabel,0,0,1,1);
        gridPane.getColumnConstraints().add(new ColumnConstraints(constant));
        gridPane.getRowConstraints().add(new RowConstraints(constant));
        GridPane.setHalignment(headerLabel, HPos.CENTER);

        int column=xMin;
        for(int i=1; i<=horizontal; i++){
            Label columnNumber = new Label(""+ column);
            gridPane.add(columnNumber,i , 0, 1, 1);
            GridPane.setHalignment(columnNumber, HPos.CENTER);
            gridPane.getColumnConstraints().add(new ColumnConstraints(constant));
            column++;
        }

        int row=yMax;
        for(int i=1; i<=vertical; i++){
            Label rowNumber = new Label("" + row);
            gridPane.add(rowNumber, 0, i, 1, 1);
            GridPane.setHalignment(rowNumber, HPos.CENTER);
            gridPane.getRowConstraints().add(new RowConstraints(constant));
            row--;
        }

        for(int x=1; x<=horizontal; x++)
            for(int y=1; y<=vertical; y++){
                IMapElement mapObject = (IMapElement) this.map.objectAt(new Vector2d((x-1)+lowerLeft.x,upperRight.y-(y-1)));
                if(mapObject!=null){
                    Label grassOrAnimal = new Label(mapObject.toString());
                    GuiElementBox guiElementBox = new GuiElementBox(mapObject);
                    gridPane.add(guiElementBox.getvBox(),x,y,1,1);
                    GridPane.setHalignment(guiElementBox.getvBox(), HPos.CENTER);

                }
            }

        Scene scene = new Scene(gridPane, (horizontal+1)*constant, (vertical+1)*constant);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
