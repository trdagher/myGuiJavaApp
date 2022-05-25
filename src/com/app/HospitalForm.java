package com.app;


import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HospitalForm extends JFrame{
    private JPanel PanelMain;
    private JPanel PanelTop;
    private JPanel PanelPersonType;
    private JLabel PersonType;
    private JPanel PanelLeft;
    private JPanel PanelRight;
    private JFormattedTextField textName;
    private JFormattedTextField textAge;
    private JFormattedTextField textId;
    private JFormattedTextField textDate;
    private JFormattedTextField textTime;
    private JFormattedTextField textSpeciality;
    private JFormattedTextField textDepartement;
    private JFormattedTextField textShift;
    private JFormattedTextField textTreatment;
    private JFormattedTextField textSurgery;
    private JButton buttonNew;
    private JButton buttonSave;
    private JButton DoctorButton;
    private JButton patientButton;
    private JButton NurseButton;
    private JButton SurgeryButton;
    private JButton treatmentButton;
    private JList listPeople;
    private JButton dayShiftButton;
    private JButton nightShiftButton;
    private JButton clearButton;
    private static ArrayList<Person> people;
    private DefaultListModel listPeopleModel;

//    private int Doctorflag = 0;
    HospitalForm(){
        super("my Hospital Project");
        this.setContentPane(this.PanelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();// pack the whole screen together
        people = new ArrayList<Person>();
        listPeopleModel = new DefaultListModel<>();
        textName.setEnabled(false);
        textAge.setEnabled(false);
        textDate.setEnabled(false);
        textDepartement.setEnabled(false);
        textId.setEnabled(false);
        textTime.setEnabled(false);
        textSurgery.setEnabled(false);
        textShift.setEnabled(false);
        textSpeciality.setEnabled(false);
        textTreatment.setEnabled(false);
        // set all fields to false until you push the bottun of one specific type

        listPeople.setModel(listPeopleModel);
        //at first both buttons are disabled
        buttonNew.setEnabled(false);
        buttonSave.setEnabled(false);
      // those are normal setup for the form
        // i set the button save to disable so i can enable it only when there is existing data to change
          // now each button of person type will enable the field nessesery to it
        DoctorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonCleartext(e);//just for security
               doctorButton();

            }
        });
        // save new button
        buttonNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               buttonNewClick(e);
            }
        });
        //list event listener
        listPeople.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                listPeopleSelection(e);// just so i don't write all the code in the constructer
            }
        });
        // save existing button
        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSavedClick(e);
            }
        });
        // nurce btn
        NurseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonCleartext(e);//just for security
                NurseButton();
            }
        });
        //patient button
        patientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonCleartext(e);
                PatientButton();
            }
        });
        // treatment button
        treatmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonCleartext(e);
                TreatmentButton();
            }
        });
        //surgery button
        SurgeryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonCleartext(e);
                surgeryButton();
            }
        });
        // night shift nurse
        nightShiftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonCleartext(e);
                NightShiftButton();
            }
        });
        // day shift nurce
        dayShiftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonCleartext(e);
                DayShiftButton();
            }
        });
        // clear btn
        // this btn is just to clear the input and open all people btns that in case you shoose the person and you want to change eg : i shose dr and i want now to change it to nurce before submit
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              ClearButton();
            }
        });
    }
    public void doctorButton(){
        PersonType.setText("Doctor");
        buttonNew.setEnabled(true);//open the button save new
        NurseButton.setEnabled(false);
        patientButton.setEnabled(false);
        treatmentButton.setEnabled(false);
        SurgeryButton.setEnabled(false);
        nightShiftButton.setEnabled(false);
        dayShiftButton.setEnabled(false);
        // when you push dr button set all others to false
        // i will enable everything again in the buttons of save
       //set everything else but the dr buttons to false
       textDepartement.setEnabled(false);
       textDate.setEnabled(false);
       textSurgery.setEnabled(false);
       textTime.setEnabled(false);
       textTreatment.setEnabled(false);
       textShift.setEnabled(false);
       textName.setEnabled(true);
       textAge.setEnabled(true);
        textId.setEnabled(true);
        textSpeciality.setEnabled(true);

    }
    public void NurseButton(){
        PersonType.setText("Nurse");
        buttonNew.setEnabled(true);
        DoctorButton.setEnabled(false);
        patientButton.setEnabled(false);
        treatmentButton.setEnabled(false);
        SurgeryButton.setEnabled(false);
        nightShiftButton.setEnabled(false);
        dayShiftButton.setEnabled(false);

        textDepartement.setEnabled(true);
        textDate.setEnabled(false);
        textSurgery.setEnabled(false);
        textTime.setEnabled(false);
        textTreatment.setEnabled(false);
        textShift.setEnabled(false);
        textName.setEnabled(true);
        textAge.setEnabled(true);
        textId.setEnabled(true);
        textSpeciality.setEnabled(false);

    }
    public void PatientButton(){
        PersonType.setText("Patient");
        buttonNew.setEnabled(true);
        DoctorButton.setEnabled(false);
        NurseButton.setEnabled(false);
        treatmentButton.setEnabled(false);
        SurgeryButton.setEnabled(false);
        nightShiftButton.setEnabled(false);
        dayShiftButton.setEnabled(false);

        textDepartement.setEnabled(false);
        textDate.setEnabled(true);
        textSurgery.setEnabled(false);
        textTime.setEnabled(true);
        textTreatment.setEnabled(false);
        textShift.setEnabled(false);
        textName.setEnabled(true);
        textAge.setEnabled(true);
        textId.setEnabled(true);
        textSpeciality.setEnabled(false);
    }
    public void TreatmentButton(){
        PersonType.setText("Patient/Treatment");
        buttonNew.setEnabled(true);
        DoctorButton.setEnabled(false);
        NurseButton.setEnabled(false);
        patientButton.setEnabled(false);
        SurgeryButton.setEnabled(false);
        nightShiftButton.setEnabled(false);
        dayShiftButton.setEnabled(false);

        textDepartement.setEnabled(false);
        textDate.setEnabled(true);
        textSurgery.setEnabled(false);
        textTime.setEnabled(true);
        textTreatment.setEnabled(true);
        textShift.setEnabled(false);
        textName.setEnabled(true);
        textAge.setEnabled(true);
        textId.setEnabled(true);
        textSpeciality.setEnabled(false);
    }
    public void surgeryButton(){
        PersonType.setText("Patient/Surgery");
        buttonNew.setEnabled(true);
        DoctorButton.setEnabled(false);
        NurseButton.setEnabled(false);
        patientButton.setEnabled(false);
        treatmentButton.setEnabled(false);
        nightShiftButton.setEnabled(false);
        dayShiftButton.setEnabled(false);

        textDepartement.setEnabled(false);
        textDate.setEnabled(true);
        textSurgery.setEnabled(true);
        textTime.setEnabled(true);
        textTreatment.setEnabled(false);
        textShift.setEnabled(false);
        textName.setEnabled(true);
        textAge.setEnabled(true);
        textId.setEnabled(true);
        textSpeciality.setEnabled(false);

    }
    public void NightShiftButton(){
        PersonType.setText("Night Shift Nurse");
        buttonNew.setEnabled(true);
        DoctorButton.setEnabled(false);
        NurseButton.setEnabled(false);
        patientButton.setEnabled(false);
        treatmentButton.setEnabled(false);
        dayShiftButton.setEnabled(false);
        SurgeryButton.setEnabled(false);

        textDepartement.setEnabled(true);
        textDate.setEnabled(false);
        textSurgery.setEnabled(false);
        textTime.setEnabled(true);
        textTreatment.setEnabled(false);
        textShift.setEnabled(true);
        textName.setEnabled(true);
        textAge.setEnabled(true);
        textId.setEnabled(true);
        textSpeciality.setEnabled(false);

    }
    public void DayShiftButton(){
        PersonType.setText("Day Shift Nurse");
        buttonNew.setEnabled(true);
        DoctorButton.setEnabled(false);
        NurseButton.setEnabled(false);
        patientButton.setEnabled(false);
        treatmentButton.setEnabled(false);
        nightShiftButton.setEnabled(false);
        SurgeryButton.setEnabled(false);

        textDepartement.setEnabled(true);
        textDate.setEnabled(true);
        textSurgery.setEnabled(false);
        textTime.setEnabled(true);
        textTreatment.setEnabled(false);
        textShift.setEnabled(false);
        textName.setEnabled(true);
        textAge.setEnabled(true);
        textId.setEnabled(true);
        textSpeciality.setEnabled(false);

    }
    public void ClearButton(){
        closeAllFields();
        openButtons();
        buttonNew.setEnabled(false);
        buttonSave.setEnabled(false);
        PersonType.setText("Person Type");
    }
    //for the save new button
    public void buttonNewClick(ActionEvent e){
        PersonType.setText("Person type");
        // the id is int and the input in the gui is string i will parseint to transform the string to the int however i have to catch the input exeption and i will set the id to
        int theId;
        try {
            theId = Integer.parseInt(textId.getText());
        }catch (NumberFormatException ex){
            theId = 0;
        }
      // case 1 if i am saving a doctor
        if(DoctorButton.isEnabled()){
            Person p = new Doctor(textName.getText(),textAge.getText(),theId,textSpeciality.getText());
            people.add(p);
        }
      // case 2 if im saving a nurse
        if(NurseButton.isEnabled()){
            Person p=new Nurse(textName.getText(),textAge.getText(),theId,textDepartement.getText());
         people.add(p);
        }
        //case 3 Patient
        if(patientButton.isEnabled()){
            Person p = new Patient(textName.getText(),textAge.getText(),theId,textDate.getText(),textTime.getText());
        people.add(p);
        }
        //case 4 treatment
        if(treatmentButton.isEnabled()){
           Person tr = new TreatmentP(textName.getText(),textAge.getText(),theId,textDate.getText(),textTime.getText(),textTreatment.getText());
        people.add(tr);
        }
        //case 5 surgery
        if(SurgeryButton.isEnabled()){
            Person srp = new SurgeryP(textName.getText(),textAge.getText(),theId,textDate.getText(),textTime.getText(),textSurgery.getText());
            people.add(srp);
        }
        // case 6 night shift nurse
        if(nightShiftButton.isEnabled()){
            Person sfn = new NightShift(textName.getText(),textAge.getText(),theId,textDepartement.getText(),textShift.getText(),textTime.getText());
           people.add(sfn);
        }
        // case 7 day shift nurse
        if(dayShiftButton.isEnabled()){
            Person sfd = new DayShift(textName.getText(),textAge.getText(),theId,textDepartement.getText(),textDate.getText(),textTime.getText());
          people.add(sfd);
        }
        refrechPeopleList();
       buttonCleartext(e);
       // open all buttons (of persons) after save
       openButtons();
       //after saving close both buttons(of save)
       buttonNew.setEnabled(false);
       buttonSave.setEnabled(false);
       //close all fields untill shoosing a field
        closeAllFields();
    }
    // for the save existing button
    public void buttonSavedClick(ActionEvent e){
        PersonType.setText("Person type");
        int theId;
        try {
            theId = Integer.parseInt(textId.getText());
        }catch (NumberFormatException ex){
            theId = 0;
        }
        int personNumber = listPeople.getSelectedIndex();
        if(personNumber>=0){
            Person p = people.get(personNumber);
            p.setName(textName.getText());
           p.setAge(textAge.getText());
           // case 1 doctor
            if(p.getClass().getName() == "com.app.Doctor"){
                Doctor d = (Doctor) people.get(personNumber);
                d.setID(theId);// in the text this is a string i am transforming to a int
                d.setSpec(textSpeciality.getText());
            }
            //case 2 nurse
            if(p.getClass().getName() == "com.app.Nurse"){
                Nurse n =(Nurse) people.get(personNumber);
                n.setDepartment(textDepartement.getText());
                n.setID(theId);
            }
            //case 3 patient
            if(p.getClass().getName() == "com.app.Patient"){
                Patient pt = (Patient) people.get(personNumber);
                pt.setID(theId);
                pt.setDate(textDate.getText());
                pt.setTime(textTime.getText());
            }
            //case 4 treatment
            if(p.getClass().getName() == "com.app.TreatmentP"){
                TreatmentP tr = (TreatmentP) people.get(personNumber);
                tr.setID(theId);
                tr.setDate(textDate.getText());
                tr.setTime(textTime.getText());
                tr.setTreatmentType(textTreatment.getText());
            }
            //case 5 surgery
            if(p.getClass().getName() == "com.app.SurgeryP"){
                SurgeryP srp =(SurgeryP) people.get(personNumber);
                srp.setID(theId);
                srp.setDate(textDate.getText());
                srp.setTime(textTime.getText());
                srp.setSurgeryType(textSurgery.getText());
            }
            // case 6 night shift nurse
            if(p.getClass().getName() == "com.app.NightShift"){
                NightShift sfn = (NightShift) people.get(personNumber);
                sfn.setID(theId);
                sfn.setDepartment(textDepartement.getText());
                sfn.setShift(textShift.getText());
                sfn.setTime(textTime.getText());
            }
            //case 7 day shift nurse
            if(p.getClass().getName() == "com.app.DayShift"){
                DayShift sfd =(DayShift) people.get(personNumber);
                sfd.setID(theId);
                sfd.setDepartment(textDepartement.getText());
               sfd.setDate(textDate.getText());
                sfd.setTime(textTime.getText());
            }

            refrechPeopleList();
        }
        buttonCleartext(e);

        // open all buttons (of persons) after save
        openButtons();
        //after saving close both buttons(of save)
        buttonNew.setEnabled(false);
        buttonSave.setEnabled(false);
        //close all fields untill shoosing a field
        closeAllFields();

    }
    // this is just to clear all text when clicking the new button
    public void buttonCleartext(ActionEvent e){
        textName.setText("");
        textAge.setText("");
        textSpeciality.setText("");
        textTreatment.setText("");
        textId.setText("");
        textShift.setText("");
        textSurgery.setText("");
        textDate.setText("");
        textTime.setText("");
        textDepartement.setText("");
    }
    public void refrechPeopleList(){
        listPeopleModel.removeAllElements();
        System.out.println("removing all people from model");
        for(Person p: people){
            System.out.println("adding person to list : " +p.getName());
            listPeopleModel.addElement(p.getName());
        }
    }
    // this method will be called when clicking on the list the idea first is to fill the text
    //fields with the input
    public void listPeopleSelection(ListSelectionEvent e){
       closeAllFields();//first close fields for security because after clicking on diffrent type of person the fields start to open
        int personNumber = listPeople.getSelectedIndex();// just get the index in the list
        if(personNumber >=0){
            Person p = people.get(personNumber); // create person object get the clicked object
            textName.setText(p.getName()); // name and age can be set because person has the gettters and setters of those
            textAge.setText(p.getAge());
            textName.setEnabled(true);
            textAge.setEnabled(true);
            //case1 doctor selected
            if(p.getClass().getName() == "com.app.Doctor"){//this will give me the com.app.Doctor if the object is of doctor type
                Doctor d = (Doctor) people.get(personNumber);
                textId.setText(Integer.toString(d.getID()));// because the id is int and we have to set it to string in the text field
                textSpeciality.setText(d.getSpec()); // now i can add the properties of doctor
                textId.setEnabled(true);
                textSpeciality.setEnabled(true);// because after saving i closed those fields

            }
            //case  2 nurse
            if(p.getClass().getName() == "com.app.Nurse"){
                Nurse n = (Nurse) people.get(personNumber);
                textId.setText(Integer.toString(n.getID()));
                textDepartement.setText(n.getDepartment());
                textId.setEnabled(true);
                textDepartement.setEnabled(true);
            }
            //case 3 Patient
            if(p.getClass().getName() == "com.app.Patient"){
                Patient pt = (Patient) people.get(personNumber);
                textId.setText(Integer.toString(pt.getID()));
                textDate.setText(pt.getDate());
                textTime.setText(pt.getTime());
                textId.setEnabled(true);
                textDate.setEnabled(true);
                textTime.setEnabled(true);

            }
            // case 4 treatment
            if(p.getClass().getName() == "com.app.TreatmentP"){
                TreatmentP tr = (TreatmentP) people.get(personNumber);
                textId.setText(Integer.toString(tr.getID()));
                textDate.setText(tr.getDate());
                textTime.setText(tr.getTime());
                textTreatment.setText(tr.getTreatmentType());

                textId.setEnabled(true);
                textDate.setEnabled(true);
                textTime.setEnabled(true);
                textTreatment.setEnabled(true);
            }
            // case 5 surgery
            if(p.getClass().getName() == "com.app.SurgeryP"){
                SurgeryP srp = (SurgeryP) people.get(personNumber);
                textId.setText(Integer.toString(srp.getID()));
                textDate.setText(srp.getDate());
                textTime.setText(srp.getTime());
                textSurgery.setText(srp.getSurgeryType());

                textId.setEnabled(true);
                textDate.setEnabled(true);
                textTime.setEnabled(true);
                textSurgery.setEnabled(true);
            }
            //case 6 night shift nurse
            if(p.getClass().getName() == "com.app.NightShift"){
                NightShift sfn = (NightShift) people.get(personNumber);
                textId.setText(Integer.toString(sfn.getID()));
                textDepartement.setText(sfn.getDepartment());
                textShift.setText(sfn.getShift());
                textTime.setText(sfn.getTime());

                textId.setEnabled(true);
                textDepartement.setEnabled(true);
                textShift.setEnabled(true);
                textTime.setEnabled(true);

            }
            //case 7  day shift nurse
            if(p.getClass().getName() == "com.app.DayShift"){
                DayShift sfd = (DayShift) people.get(personNumber);
                textId.setText(Integer.toString(sfd.getID()));
                textDepartement.setText(sfd.getDepartment());
                textDate.setText(sfd.getDate());
                textTime.setText(sfd.getTime());

                textId.setEnabled(true);
                textDepartement.setEnabled(true);
                textDate.setEnabled(true);
                textTime.setEnabled(true);
            }

            buttonSave.setEnabled(true);// now i can save existing
        }else{//just to make sure if the person number <0 (no persons then set the button to false)
            buttonSave.setEnabled(false);
        }
    }
    public void openButtons(){
        NurseButton.setEnabled(true);
        patientButton.setEnabled(true);
        treatmentButton.setEnabled(true);
        SurgeryButton.setEnabled(true);
        DoctorButton.setEnabled(true);
        nightShiftButton.setEnabled(true);
        dayShiftButton.setEnabled(true);

    }
    // this is used to close all fields when clicking the save btn
    public void closeAllFields(){
        textDepartement.setEnabled(false);
        textDate.setEnabled(false);
        textSurgery.setEnabled(false);
        textTime.setEnabled(false);
        textTreatment.setEnabled(false);
        textShift.setEnabled(false);
        textName.setEnabled(false);
        textAge.setEnabled(false);
        textId.setEnabled(false);
        textSpeciality.setEnabled(false);

    }
}