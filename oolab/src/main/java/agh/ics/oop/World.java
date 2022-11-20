package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Application;

public class World {
    public static void main(String[] args) {
        try {
            Application.launch(App.class, args);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        // pkt 10
//        Stworzyć publiczną  tablice wypełnioną zerami, jeśli na jakimś polu znajduje się zwierze
//        to w tablicy pod indeksami odpowiadającymi pozycji zwierzęcia znajduje się jedynka lub wskaźnik na zwierze
//        które znajduje się na danym polu.
//        Dodać warunek w Animal.move, aby na danym polu nie mogły stanąć dwa zwierzęta.

    }
}


