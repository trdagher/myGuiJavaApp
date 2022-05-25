package com.app;

public class Nurse extends Person {
    private int ID;
    private String department;


    public Nurse() {
        super();
        this.ID = 0;
        this.department = "";
    }

    public Nurse(String name, String age, int ID, String department) {
        super(name, age);
        this.ID = ID;
        this.department = department;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }


}
