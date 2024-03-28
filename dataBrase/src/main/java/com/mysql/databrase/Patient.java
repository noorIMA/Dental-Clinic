package com.mysql.databrase;

public class Patient {

    int PID;
    String PName;
    String PGender;
    double PAge;
    String state_Of_healthe;
    String diangnosis;
    long insurance_num;
    long phonNumber;
    String address;

    public Patient(int PID, String PName, String PGender, double PAge, String state_Of_healthe, String diangnosis,
                   long insurance_num, long phonNumber, String address) {
        this.PID = PID;
        this.PName = PName;
        this.PGender = PGender;
        this.PAge = PAge;
        this.state_Of_healthe = state_Of_healthe;
        this.diangnosis = diangnosis;
        this.insurance_num = insurance_num;
        this.phonNumber = phonNumber;
        this.address = address;
    }
    public int getPID() {
        return PID;
    }
    public void setPID(int pID) {
        PID = pID;
    }
    public String getPName() {
        return PName;
    }
    public void setPName(String pName) {
        PName = pName;
    }
    public String getPGender() {
        return PGender;
    }
    public void setPGender(String pGender) {
        PGender = pGender;
    }
    public double getPAge() {
        return PAge;
    }
    public void setPAge(double pAge) {
        PAge = pAge;
    }
    public String getState_Of_healthe() {
        return state_Of_healthe;
    }
    public void setState_Of_healthe(String state_Of_healthe) {
        this.state_Of_healthe = state_Of_healthe;
    }
    public String getDiangnosis() {
        return diangnosis;
    }
    public void setDiangnosis(String diangnosis) {
        this.diangnosis = diangnosis;
    }
    public long getInsurance_num() {
        return insurance_num;
    }
    public void setInsurance_num(long insurance_num) {
        this.insurance_num = insurance_num;
    }
    public long getPhonNumber() {
        return phonNumber;
    }
    public void setPhonNumber(long phonNumber) {
        this.phonNumber = phonNumber;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

}

