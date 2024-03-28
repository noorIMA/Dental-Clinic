package com.mysql.databrase;

public class Appointment {
    int AppNumber;
    String next_review;
    String dtae_of_firstRev;
    int DocNumber;


    public Appointment() {
        super();
    }

    public Appointment(int appNumber, String next_review, String dtae_of_firstRev, int docNumber) {
        super();
        AppNumber = appNumber;
        this.next_review = next_review;
        this.dtae_of_firstRev = dtae_of_firstRev;
        DocNumber = docNumber;
    }

    public int getAppNumber(Integer integer) {
        return AppNumber;
    }

    public void setAppNumber(int appNumber) {
        AppNumber = appNumber;
    }

    public String getNext_review() {
        return next_review;
    }

    public void setNext_review(String next_review) {
        this.next_review = next_review;
    }

    public String getDtae_of_firstRev() {
        return dtae_of_firstRev;
    }

    public void setDtae_of_firstRev(String dtae_of_firstRev) {
        this.dtae_of_firstRev = dtae_of_firstRev;
    }

    public int getDocNumber() {
        return DocNumber;
    }

    public void setDocNumber(int docNumber) {
        DocNumber = docNumber;
    }

    public int getAppNumber() {
        // TODO Auto-generated method stub
        return 0;
    }

    public void getDocNumber(Integer newValue) {
        // TODO Auto-generated method stub

    }
}
