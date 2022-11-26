package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import javafx.scene.control.Label;


import java.io.FileNotFoundException;

import static java.lang.Math.*;


public class App extends Application{
    int horizontal,vertical,width=70, height=50;
    private Vector2d lowerLeft, upperRight;
    private final GridPane gridPane = new GridPane();
    MapDirection orientation = MapDirection.NORTH;


    @Override
    public void start(Stage primaryStage) {
        TextField textField = new TextField();
        Button startButton = getStartButton(textField);
        Button directionButton = getDirectionButton();
        HBox hBox = new HBox(this.gridPane, textField, startButton, directionButton);
        Scene scene = new Scene(hBox, 800, 800);
//        Scene scene = new Scene(this.gridPane, (this.horizontal+1)*this.constant, (this.vertical+1)*this.constant);
        primaryStage.setScene(scene);
        primaryStage.show();
    }



    public void createGrid(IWorldMap map){

        this.lowerLeft = map.getLowerLeft();
        this.upperRight =map.getUpperRight();
        int xMin = min(lowerLeft.x, upperRight.x);
        int xMax = max(lowerLeft.x, upperRight.x);
        int yMin = min(lowerLeft.y, upperRight.y);
        int yMax = max(lowerLeft.y, upperRight.y);
        this.horizontal = xMax - xMin + 1;
        this.vertical = yMax - yMin + 1;

        Label headerLabel = new Label("y/x");
        this.gridPane.add(headerLabel,0,0,1,1);
        this.gridPane.getColumnConstraints().add(new ColumnConstraints(width));
        this.gridPane.getRowConstraints().add(new RowConstraints(height));
        GridPane.setHalignment(headerLabel, HPos.CENTER);

        int column = xMin;
        for (int i = 1; i <= horizontal; i++) {
            Label columnNumber = new Label("" + column);
            this.gridPane.add(columnNumber, i, 0, 1, 1);
            GridPane.setHalignment(columnNumber, HPos.CENTER);
            this.gridPane.getColumnConstraints().add(new ColumnConstraints(width));
            column++;
        }

        int row = yMax;
        for (int i = 1; i <= vertical; i++) {
            Label rowNumber = new Label("" + row);
            this.gridPane.add(rowNumber, 0, i, 1, 1);
            GridPane.setHalignment(rowNumber, HPos.CENTER);
            this.gridPane.getRowConstraints().add(new RowConstraints(height));
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

    public void createMap(IWorldMap map){
        this.gridPane.getChildren().clear();
        this.gridPane.getColumnConstraints().clear();
        this.gridPane.getRowConstraints().clear();
        this.gridPane.setGridLinesVisible(false);
        this.gridPane.setGridLinesVisible(true);
        createGrid(map);
        try {
             placeObjectsOnGrid(map);
        } catch (FileNotFoundException e) {
           throw new RuntimeException(e);
        }
    }

    public Button getStartButton(TextField textField) {
        Button startButton = new Button("Start");
        startButton.setOnAction((action) -> {
            String text = textField.getText();
            MoveDirection[] directions = new OptionsParser().parse(text.split(" "));
            IWorldMap map = new GrassField(10);
            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
            IEngine engine = new SimulationEngine(directions, map, positions, this.orientation, this);
            Thread engineThread = new Thread(engine::run);
            engineThread.start();
        });
        return startButton;
    }

    public Button getDirectionButton() {
        Button directionButton = new Button(orientation.toString());
        directionButton.setOnAction((action) -> {
            this.orientation = this.orientation.next();
            directionButton.setText(this.orientation.toString());
        });
        return directionButton;
    }


}
