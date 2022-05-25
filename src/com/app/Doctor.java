package com.app;

public class Doctor extends Person implements Hospital{
    private int ID;
    private String spec;

    public Doctor() {
        super();
        this.ID = 0;
        this.spec ="";
    }

    public Doctor(String name, String age, int ID, String spec) {
        super(name, age);
        this.ID = ID;
        this.spec = spec;
    }

    @Override
    public void getMedication() {
        System.out.println("doctor is giving medication");
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }
}
