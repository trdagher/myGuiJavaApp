package com.app;

public class Patient extends Person{
  private int ID;
  private String date;
  private String time;
  public Patient(){
      super();
      this.ID=0;
      this.date="";
      this.time="";
  }
    public Patient(String name, String age ,int ID,String date,String time) {
        super(name, age);
        this.ID =ID;
        this.date = date;
        this.time= time;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    public String prtPAcient(){
      return super.prtPerson()+"\n"
              +"id= "+this.ID+"\n" +
              "date= "+this.date+"\n"
              +"time= "+this.time+"\n";
    }
}
