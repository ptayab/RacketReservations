package com.example.RacketReservations;

import javafx.event.ActionEvent;

public class CourtController {

    CourtModel model;

    public CourtController() {}
    public void setModel(CourtModel newModel) {
        model = newModel;
    }

    public void NextDay(ActionEvent event) {
        model.go_next_day();
    }

    public void PrevDay(ActionEvent event) {
        model.go_prev_day();
    }

    public void NextTime(ActionEvent event) {
        model.go_next_time();
    }

    public void PrevTime(ActionEvent event) {
        model.go_prev_time();
    }

    public void NextCourt(ActionEvent event) {
        model.go_next_court();
    }

    public void PrevCourt(ActionEvent event) {
        model.go_prev_court();
    }

}
