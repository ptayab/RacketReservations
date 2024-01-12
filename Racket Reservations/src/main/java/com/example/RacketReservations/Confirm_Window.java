package com.example.RacketReservations;

import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Confirm_Window {

    public static void display(String title, String message) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);

        Label label = new Label();

    }
}
