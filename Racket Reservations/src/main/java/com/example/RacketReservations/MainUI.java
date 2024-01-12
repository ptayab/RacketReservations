package com.example.RacketReservations;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import static javafx.application.Application.launch;

public class MainUI extends StackPane {

    public MainUI() {



        CourtView view = new CourtView();
        CourtModel model = new CourtModel();
        CourtController controller = new CourtController();

        view.setModel(model);

        view.changeDate(controller);
        controller.setModel(model);

        VBox root = new VBox();
        root.getChildren().add(view);
        this.getChildren().add(root);
    }

}
