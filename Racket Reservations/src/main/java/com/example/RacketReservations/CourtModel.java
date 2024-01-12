package com.example.RacketReservations;

public class CourtModel {

    private String Time;
    private String Court;
    private String Date;
    private String Day;

    private int day_tracker = 0;
    private int time_tracker = 0;

    private int court_tracker = 0;
    private int date_tracker = 0;

    private String Court_Array[] = new String[]{"Court 1", "Court 2", "Court 3", "Court 4", "Court 5", "Court 6"};

    private String Date_Array[] = new String[]{"Aug-01-2022", "Aug-02-2022", "Aug-03-2022", "Aug-04-2022", "Aug-05-2022", "Aug-06-2022", "Aug-07-2022" };
    private String Day_Array[] = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

    private String Time_Array[] = new String[]{"9:00 - 10:00 a.m.", "10:00 - 11:00 a.m.", "11:00 a.m. - 12:00 p.m.", "1:00 - 2:00 p.m.", "2:00 - 3:00 p.m.", "3:00 - 4:00 p.m.", "4:00 - 5:00 p.m.", "5:00 - 6:00 p.m.","6:00 - 7:00 p.m.","7:00 - 8:00 p.m.","8:00 - 9:00 p.m."};

    public CourtModel () {
        Time = "9:00a.m. - 10:00a.m.";
        Court = "Court 1";
        Date = "Aug-01-2022";
        Day = "Monday";
    }
    public CourtModel (String a_time, String court, String date, String day) {
        Time = a_time;
        Court = court;
        Date = date;
        Day = day;
    }



    public String getTime() {
        return Time;
    }

    public String getCourt() {
        return Court;
    }

    public String getDate() {
        return Date;
    }

    public String getDay() {
        return Day;
    }

    public void setTime(String time) {
        Time = time;
    }

    public void setCourt(String court) {
        Court = court;
    }

    public void setDate(String date) {
        Date = date;
    }

    public void setDay(String day) {
        Day = day;
    }

    public void go_next_day() {
        day_tracker ++;
        if (day_tracker > Day_Array.length - 1) {
            Day = Day_Array[0];
            date_tracker = 0;
        }
        else {
            Day = Day_Array[day_tracker];
        }
    }

    public void go_prev_day() {
        day_tracker --;
        if (day_tracker < 0) {
            Day = Day_Array[Day_Array.length - 1];
            day_tracker = Day_Array.length - 1;
        }
        else {
            Day = Day_Array[day_tracker];
        }
    }

    public void go_next_time() {
        time_tracker ++;
        if (time_tracker > Time_Array.length - 1) {
            Time = Time_Array[0];
            time_tracker = 0;
        }
        else {
            Time = Time_Array[day_tracker];
        }
    }

    public void go_prev_time() {
        time_tracker --;
        if (time_tracker < 0) {
            Time = Time_Array[Time_Array.length - 1];
            time_tracker = Time_Array.length - 1;
        }
        else {
            Time = Time_Array[time_tracker];
        }
    }

    public void go_prev_court() {
        court_tracker --;
        if (court_tracker < 0) {
            Court = Court_Array[Court_Array.length - 1];
            court_tracker = Court_Array.length - 1;
        }
        else {
            Court = Court_Array[court_tracker];
        }
    }

    public void go_next_court() {
        court_tracker ++;
        if (court_tracker > Court_Array.length - 1) {
            Court = Court_Array[0];
            court_tracker = 0;
        }
        else {
            Court = Court_Array[court_tracker];
        }
    }

    public void go_next_date() {
        date_tracker ++;
        if (date_tracker > Date_Array.length - 1) {
            Date = Date_Array[0];
            date_tracker = 0;
        }
        else {
            Date = Date_Array[date_tracker];
        }
    }

    public void go_prev_date() {
        date_tracker --;
        if (date_tracker < 0) {
            Date = Date_Array[Date_Array.length - 1];
            date_tracker = Date_Array.length - 1;
        }
        else {
            Date = Date_Array[date_tracker];
        }
    }


}
