package com.app;

public class DayShift extends Nurse implements Hospital{
    private String Date;
    private String time;

    public DayShift() {
        super();
        Date = "";
        this.time = "";
    }

    public DayShift(String name, String age, int ID, String department, String date, String time) {
        super(name, age, ID, department);
        Date = date;
        this.time = time;
    }

    @Override
    public void getMedication() {
        System.out.println("the day shift nurse is giving treatment");
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
