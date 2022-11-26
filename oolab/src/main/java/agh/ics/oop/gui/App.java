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


public class App extends Application{
    private MoveDirection[] directions;
    private IWorldMap map;
    int horizontal,vertical,constant,xMin,xMax,yMin,yMax;
    Vector2d lowerLeft, upperRight;
    GridPane gridPane;


    public void init() {
        directions = new OptionsParser().parse(getParameters().getRaw().toArray(new String[0]));
        this.map = new GrassField(10);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        IEngine engine = new SimulationEngine(directions, this.map, positions, this);
        engine.run();
    }

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        createGrid(this.map);
        Scene scene = new Scene(this.gridPane, (this.horizontal+1)*this.constant, (this.vertical+1)*this.constant);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void createGrid(IWorldMap map){

        this.lowerLeft = map.getLowerLeft();
        this.upperRight =map.getUpperRight();
        this.xMin = min(lowerLeft.x, upperRight.x);
        this.xMax = max(lowerLeft.x, upperRight.x);
        this.yMin = min(lowerLeft.y, upperRight.y);
        this.yMax = max(lowerLeft.y, upperRight.y);
        this.horizontal = xMax - xMin + 1;
        this.vertical = yMax - yMin + 1;
        this.constant = 50;
        // zmienna constant jest równa szerokości oraz wysokości poszczególnych komórek

        this.gridPane = new GridPane();
        this.gridPane.setGridLinesVisible(true);
        Label headerLabel = new Label("y/x");
        this.gridPane.add(headerLabel,0,0,1,1);
        this.gridPane.getColumnConstraints().add(new ColumnConstraints(this.constant));
        this.gridPane.getRowConstraints().add(new RowConstraints(this.constant));
        GridPane.setHalignment(headerLabel, HPos.CENTER);

        int column = xMin;
        for (int i = 1; i <= horizontal; i++) {
            Label columnNumber = new Label("" + column);
            this.gridPane.add(columnNumber, i, 0, 1, 1);
            GridPane.setHalignment(columnNumber, HPos.CENTER);
            this.gridPane.getColumnConstraints().add(new ColumnConstraints(constant));
            column++;
        }

        int row = yMax;
        for (int i = 1; i <= vertical; i++) {
            Label rowNumber = new Label("" + row);
            this.gridPane.add(rowNumber, 0, i, 1, 1);
            GridPane.setHalignment(rowNumber, HPos.CENTER);
            this.gridPane.getRowConstraints().add(new RowConstraints(constant));
            row--;
        }
   }
    public void placeObjectsOnGrid(IWorldMap map) throws FileNotFoundException {
        for (int x = 1; x <= horizontal; x++)
            for (int y = 1; y <= vertical; y++) {
                IMapElement mapObject = (IMapElement) map.objectAt(new Vector2d((x - 1) + lowerLeft.x, upperRight.y - (y - 1)));
                if (mapObject != null) {
                    GuiElementBox guiElementBox = new GuiElementBox(mapObject);
                    this.gridPane.add(guiElementBox.getvBox(), x, y, 1, 1);
                    GridPane.setHalignment(guiElementBox.getvBox(), HPos.CENTER);
                }
            }
    }

    public void createMap(IWorldMap map) throws FileNotFoundException{
        this.gridPane.setGridLinesVisible(false);
        this.gridPane.getColumnConstraints().clear();
        this.gridPane.getRowConstraints().clear();
        this.gridPane.getChildren().clear();
        this.gridPane.setGridLinesVisible(true);
        createGrid(map);
        placeObjectsOnGrid(map);
    }




}
