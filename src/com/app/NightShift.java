package com.app;

public class NightShift extends Nurse implements Hospital{
    private String shift;
    private String time;

    public NightShift() {
        super();
        this.shift = "";
        this.time = "";
    }

    public NightShift(String name, String age, int ID, String department, String shift, String time) {
        super(name, age, ID, department);
        this.shift = shift;
        this.time = time;
    }

    @Override
    public void getMedication() {
        System.out.println("the Night Shift nurse is giving treatment ");
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
