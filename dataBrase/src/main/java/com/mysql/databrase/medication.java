package com.mysql.databrase;

public class medication {
    int numberMedication;
    String NameMedication;

    public medication(int numberMedication, String NameMedication) {
        super();
        this.numberMedication = numberMedication;
        this.NameMedication = NameMedication;

    }

    public int getNumberMedication() {
        return numberMedication;
    }

    public void setNumberMedication(int numberMedication) {
        this.numberMedication = numberMedication;
    }

    public String getNameMedication() {
        return NameMedication;
    }

    public void setNameMedication(String NameMedication) {
        this.NameMedication = NameMedication;
    }

}