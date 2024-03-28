package com.mysql.databrase;

public class Doctor {


    int doctor_Num;
    String doctor_Name;
    String WorkDays;


    public Doctor(int doctor_Num, String doctor_Name, String WorkDays) {
        super();
        this.doctor_Num = doctor_Num;
        this.doctor_Name = doctor_Name;
        this.WorkDays = WorkDays;
    }


    public int getDoctor_Num() {
        return doctor_Num;
    }


    public void setDoctor_Num(int doctor_Num) {
        this.doctor_Num = doctor_Num;
    }


    public String getDoctor_Name() {
        return doctor_Name;
    }


    public void setDoctor_Name(String doctor_Name) {
        this.doctor_Name = doctor_Name;
    }


    public String getWorkDays() {
        return WorkDays;
    }


    public void setWorkDays(String workDays) {
        WorkDays = workDays;
    }





}
