package com.mysql.databrase;

public class description {

    int DoctorID;
    int PatientID;
    int MedicationID;
    String Description;

    public description(int DoctorID, int PatientID, int MedicationID, String Description) {
        super();
        this.DoctorID = DoctorID;
        this.PatientID = PatientID;
        this.MedicationID = MedicationID;
        this.Description = Description;

    }

    public int getDoctorID() {
        return DoctorID;
    }

    public void setDoctorID(int DoctorID) {
        this.DoctorID = DoctorID;
    }

    public int getPatientID() {
        return PatientID;
    }

    public void setPatientID(int PatientID) {
        this.PatientID = PatientID;
    }

    public int getMedicationID() {
        return MedicationID;
    }

    public void setMedicationID(int MedicationID) {
        this.MedicationID = MedicationID;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

}