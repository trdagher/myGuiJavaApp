package com.app;

public class SurgeryP  extends Patient implements Hospital{
private String surgeryType;

    public SurgeryP(String name, String age, int ID, String date, String time, String surgeryType) {
        super(name, age, ID, date, time);
        this.surgeryType = surgeryType;
    }

    public SurgeryP() {
        super();
        this.surgeryType = "";
    }


    @Override
    public void getMedication() {
        System.out.println("getting surgery");
    }

    public String getSurgeryType() {
        return surgeryType;
    }

    public void setSurgeryType(String surgeryType) {
        this.surgeryType = surgeryType;
    }
}
