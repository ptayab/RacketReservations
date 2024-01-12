package com.example.RacketReservations;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CourtView extends StackPane {

    CourtModel modelA;
    Button GoUp1;
    Button GoDown1;
    Button GoUp2;
    Button GoDown2;
    Button GoUp3;
    Button GoDown3;

    Label Day = new Label();




    public CourtView() {

        modelA = new CourtModel();


        VBox root = new VBox(20);

        HBox title1 = new HBox();
        Label title1Label = new Label("UPCOMING BOOKINGS");
        title1Label.setFont(Font.font("Gill Sans Ultra Bold", 20));
        title1Label.setTextFill(Paint.valueOf("#ffffff"));
        title1Label.setPadding(new Insets(10));
        title1.getChildren().addAll(title1Label);
        title1.setStyle("-fx-background-color: #0a4223");

        HBox lst_of_bookings = new HBox(20);
        VBox booking1 = create_your_booking_view(new Label(modelA.getDay()), new Label(modelA.getDate()));
        VBox booking2 = create_your_booking_view(new Label("Tuesday"), new Label("Aug-02-2022"));
        VBox booking3 = create_your_booking_view(new Label("Wednesday"), new Label("Aug-03-2022"));
        VBox booking4 = create_your_booking_view(new Label("EMPTY"), new Label(""));
        VBox booking5 = create_your_booking_view(new Label("EMPTY"), new Label(""));
        VBox booking6 = create_your_booking_view(new Label("EMPTY"), new Label(""));
        lst_of_bookings.getChildren().addAll(booking1,booking2,booking3,booking4,booking5,booking6);

        HBox title2 = new HBox();
        Label title2Label = new Label("NEW BOOKING");
        title2Label.setFont(Font.font("Gill Sans Ultra Bold", 20));
        title2Label.setTextFill(Paint.valueOf("#ffffff"));
        title2Label.setPadding(new Insets(10));
        title2.getChildren().addAll(title2Label);
        title2.setStyle("-fx-background-color: #0a4223");

        HBox options = new HBox(100);
        VBox option1 = createCourtOption1(new Label(modelA.getDay()+"\n" + modelA.getDate()));
        VBox option2 = createCourtOption2(new Label(modelA.getCourt()));
        VBox option3 = createCourtOption3(new Label(modelA.getTime()));
        options.setAlignment(Pos.CENTER);
        options.getChildren().addAll(option1,option2, option3);

        HBox bottombox = new HBox(10);
        HBox bottombox1 = new HBox();
        HBox bottombox2 = new HBox();
        Button book = new Button("BOOK COURT");
        book.setOnAction(event -> createBookingConfirmWindow());
        book.setPrefSize(120, 30);
        book.setTextFill(Paint.valueOf("#ffffff"));
        book.setStyle("-fx-background-color: #0a4223");
        book.setFont(Font.font("Arial Black"));
        Button exit = new Button("EXIT");
        exit.setPrefSize(120, 30);

        HBox bottomborder = new HBox();
        Label appName = new Label("Racket Reservations");
        bottomborder.setPrefSize(780, 30);
        appName.setFont(Font.font("Algerian", 15));
        appName.setTextFill(Paint.valueOf("#0a4223"));
        bottomborder.setBorder(new Border(new BorderStroke(Color.DARKOLIVEGREEN, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        bottomborder.setAlignment(Pos.CENTER);
        bottomborder.getChildren().add(appName);

        bottombox1.getChildren().addAll(exit);
        bottombox2.setAlignment(Pos.BASELINE_LEFT);
        bottombox2.getChildren().addAll(book);
        bottombox2.setAlignment(Pos.BASELINE_RIGHT);
        bottombox.getChildren().addAll(bottombox1,bottomborder,bottombox2);





        root.getChildren().addAll(title1, lst_of_bookings, title2, options, bottombox);
        root.setPadding(new Insets(10));


        this.getChildren().add(root);
    }

    private VBox createCourtOption1(Label Name) {

        VBox Option = new VBox();


        GoUp1 = new Button("▲");
        GoUp1.setPrefSize(200,30);
        GoUp1.setTextFill(Paint.valueOf("#ffffff"));
        GoUp1.setStyle("-fx-background-color: #0a4223");
        GoUp1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                modelA.go_prev_day();
                modelA.go_prev_date();
                Name.setText(modelA.getDay()+"\n" + modelA.getDate());
            }
        });

        GoDown1 = new Button("▼");
        GoDown1.setPrefSize(200, 30);
        GoDown1.setTextFill(Paint.valueOf("#ffffff"));
        GoDown1.setStyle("-fx-background-color: #0a4223");
        GoDown1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                modelA.go_next_day();
                modelA.go_next_date();
                Name.setText(modelA.getDay()+"\n" + modelA.getDate());
            }
        });


        VBox OptionContent = new VBox();
        OptionContent.setBorder(new Border(new BorderStroke(Color.DARKOLIVEGREEN, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        OptionContent.setPrefSize(200, 150);
        OptionContent.setAlignment(Pos.CENTER);

        Name.setFont(Font.font("Arial Black", 15));
        OptionContent.getChildren().addAll(Name);

        Option.getChildren().addAll(GoUp1,OptionContent,GoDown1);

        return  Option;
    }

    private VBox createCourtOption2(Label Name) {

        VBox Option = new VBox();


        GoUp2 = new Button("▲");
        GoUp2.setPrefSize(200,30);
        GoUp2.setTextFill(Paint.valueOf("#ffffff"));
        GoUp2.setStyle("-fx-background-color: #0a4223");
        GoUp2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                modelA.go_prev_court();
                Name.setText(modelA.getCourt());
            }
        });

        GoDown2 = new Button("▼");
        GoDown2.setPrefSize(200, 30);
        GoDown2.setTextFill(Paint.valueOf("#ffffff"));
        GoDown2.setStyle("-fx-background-color: #0a4223");
        GoDown2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                modelA.go_next_court();
                Name.setText(modelA.getCourt());
            }
        });


        VBox OptionContent = new VBox();
        OptionContent.setBorder(new Border(new BorderStroke(Color.DARKOLIVEGREEN, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        OptionContent.setPrefSize(200, 150);
        OptionContent.setAlignment(Pos.CENTER);

        Name.setFont(Font.font("Arial Black", 15));
        OptionContent.getChildren().addAll(Name);

        Option.getChildren().addAll(GoUp2,OptionContent,GoDown2);

        return  Option;
    }

    private VBox createCourtOption3(Label Name) {

        VBox Option = new VBox();


        GoUp2 = new Button("▲");
        GoUp2.setPrefSize(200,30);
        GoUp2.setTextFill(Paint.valueOf("#ffffff"));
        GoUp2.setStyle("-fx-background-color: #0a4223");
        GoUp2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                modelA.go_prev_time();
                Name.setText(modelA.getTime());
            }
        });

        GoDown2 = new Button("▼");
        GoDown2.setPrefSize(200, 30);
        GoDown2.setTextFill(Paint.valueOf("#ffffff"));
        GoDown2.setStyle("-fx-background-color: #0a4223");
        GoDown2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                modelA.go_next_time();
                Name.setText(modelA.getTime());
            }
        });


        VBox OptionContent = new VBox();
        OptionContent.setBorder(new Border(new BorderStroke(Color.DARKOLIVEGREEN, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        OptionContent.setPrefSize(200, 150);
        OptionContent.setAlignment(Pos.CENTER);

        Name.setFont(Font.font("Arial Black", 15));
        OptionContent.getChildren().addAll(Name);

        Option.getChildren().addAll(GoUp2,OptionContent,GoDown2);

        return  Option;
    }

    private VBox create_your_booking_view(Label Day, Label Date) {

        VBox YourBooking = new VBox(10);
        YourBooking.setPrefSize(150,140);
        VBox BookingContents = new VBox();

        Button view = new Button("VIEW");
        view.setPrefSize(120, 30);
        view.setTextFill(Paint.valueOf("#ffffff"));
        view.setStyle("-fx-background-color: #0a4223");
        view.setOnAction(event -> createViewWindow());
        view.setFont(Font.font("Arial Black"));



        Button cancel = new Button("CANCEL");
        cancel.setPrefSize(120, 30);
        cancel.setTextFill(Paint.valueOf("#ffffff"));
        cancel.setStyle("-fx-background-color: #0a4223");
        cancel.setOnAction(event -> createCancelWindow());
        cancel.setFont(Font.font("Arial Black"));
        cancel.setAlignment(Pos.CENTER);



        BookingContents.getChildren().addAll(Day,Date);
        BookingContents.setPadding(new Insets(10, 0, 0,0));
        BookingContents.setAlignment(Pos.CENTER);
        YourBooking.setAlignment(Pos.CENTER);


        YourBooking.getChildren().addAll(BookingContents, view, cancel);
        YourBooking.setBorder(new Border(new BorderStroke(Color.DARKOLIVEGREEN, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        return YourBooking;
    }

    public void createBookingConfirmWindow() {

        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Confirm Booking");

        VBox confirmwindow = new VBox(10);
        Label dates = new Label(modelA.getDay() + ", " + modelA.getDate());
        dates.setPadding(new Insets(20,0,0,0));
        dates.setFont(Font.font("Arial Black"));
        Label times = new Label(modelA.getTime());
        times.setFont(Font.font("Arial Black"));
        Label court = new Label(modelA.getCourt());
        court.setFont(Font.font("Arial Black"));
        confirmwindow.setAlignment(Pos.CENTER);



        HBox input = new HBox();
        TextField nsid = new TextField("Enter NSID");
        Button confirm = new Button("Confirm");
        confirm.setTextFill(Paint.valueOf("#ffffff"));
        confirm.setStyle("-fx-background-color: #0a4223");
        confirm.setOnAction(event -> window.close());
        confirm.setOnAction(event -> createlastConfirmWindow());
        input.getChildren().addAll(nsid,confirm);
        confirmwindow.getChildren().addAll(dates,times,court,input);

        Scene scene = new Scene(confirmwindow);
        window.setScene(scene);
        window.showAndWait();

    }

    public void createViewWindow() {

        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("View Booking");

        VBox confirmwindow = new VBox(10);
        Label dates = new Label(modelA.getDay() + ", " + modelA.getDate());
        dates.setPadding(new Insets(20,0,0,0));
        dates.setFont(Font.font("Arial Black"));
        Label times = new Label(modelA.getTime());
        times.setFont(Font.font("Arial Black"));
        Label court = new Label(modelA.getCourt());
        court.setFont(Font.font("Arial Black"));
        confirmwindow.setAlignment(Pos.CENTER);


        Button confirm = new Button("Close");
        confirm.setTextFill(Paint.valueOf("#ffffff"));
        confirm.setStyle("-fx-background-color: #0a4223");
        confirm.setOnAction(event -> window.close());
        confirmwindow.getChildren().addAll(dates,times,court,confirm);

        Scene scene = new Scene(confirmwindow);
        window.setScene(scene);
        window.showAndWait();
    }

    public void createCancelWindow() {

        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Confirm Booking");

        VBox confirmwindow = new VBox(10);
        Label dates = new Label(modelA.getDay() + ", " + modelA.getDate());
        dates.setPadding(new Insets(20,0,0,0));
        dates.setFont(Font.font("Arial Black"));
        Label times = new Label(modelA.getTime());
        times.setFont(Font.font("Arial Black"));
        Label court = new Label(modelA.getCourt());
        court.setFont(Font.font("Arial Black"));
        confirmwindow.setAlignment(Pos.CENTER);



        HBox input = new HBox();
        TextField nsid = new TextField("Enter NSID");
        Button confirm = new Button("Cancel");
        confirm.setTextFill(Paint.valueOf("#ffffff"));
        confirm.setStyle("-fx-background-color: #0a4223");
        confirm.setOnAction(event -> createlastCancelWindow());
        input.getChildren().addAll(nsid,confirm);
        confirmwindow.getChildren().addAll(dates,times,court,input);

        Scene scene = new Scene(confirmwindow);
        window.setScene(scene);
        window.showAndWait();
    }

    public void createlastConfirmWindow() {

        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Confirm Booking");

        VBox confirmwindow = new VBox(10);
        Label dates = new Label("Your Court has been booked!");


        HBox input = new HBox(15);
        Button bookanother = new Button("Book Another");
        bookanother.setTextFill(Paint.valueOf("#ffffff"));
        bookanother.setStyle("-fx-background-color: #0a4223");
        bookanother.setOnAction(event -> window.close());
        Button confirm = new Button("Exit");
        confirm.setTextFill(Paint.valueOf("#ffffff"));
        confirm.setStyle("-fx-background-color: #0a4223");
        input.getChildren().addAll(bookanother,confirm);
        confirmwindow.getChildren().addAll(dates, input);

        Scene scene = new Scene(confirmwindow);
        window.setScene(scene);
        window.showAndWait();
    }

    public void createlastCancelWindow() {

        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Cancel Booking");

        VBox confirmwindow = new VBox(10);
        Label dates = new Label("Your Court has been Cancelled!");


        Button confirm = new Button("Close");
        confirm.setTextFill(Paint.valueOf("#ffffff"));
        confirm.setStyle("-fx-background-color: #0a4223");
        confirm.setOnAction(event -> window.close());
        confirm.setAlignment(Pos.CENTER);
        confirmwindow.getChildren().addAll(dates,confirm);

        Scene scene = new Scene(confirmwindow);
        window.setScene(scene);
        window.showAndWait();
    }




    public void setModel(CourtModel newModel) { modelA = newModel; }
//    public void setController(CourtController controller) {GoUp1.setOnAction(controller::han); }

    public void changeDate(CourtController newcontroller) { GoUp1.setOnAction(newcontroller::NextDay);}

    public void modelUpdated(){
        System.out.println("");
    }



}
