package com.app;

public class TreatmentP extends Patient implements Hospital{
    private String treatmentType;

    public TreatmentP() {
        super();
        this.treatmentType = "";
    }

    public TreatmentP(String name, String age, int ID, String date, String time, String treatmentType) {
        super(name, age, ID, date, time);
        this.treatmentType = treatmentType;
    }

    public String getTreatmentType() {
        return treatmentType;
    }

    public void setTreatmentType(String treatmentType) {
        this.treatmentType = treatmentType;
    }

    @Override
    public void getMedication() {
        System.out.println("patient got medication");
    }
}
