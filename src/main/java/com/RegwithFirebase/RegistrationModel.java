package com.RegwithFirebase;

public class RegistrationModel {
    public String name, dob, clgName,email;
    public Double currentLPA;
    public int yearOfPassing;
    public int exp;
    public boolean employed;
    RegistrationModel(String name1, String dob1, String email1, String clgName1, int yearOfPassing1, Boolean employed1, int exp1, double currentLPA1) {
        name = name1;
        dob = dob1;
        clgName = clgName1;
        email=email1;
        yearOfPassing = yearOfPassing1;
        employed = employed1;
        exp = exp1;
        currentLPA = currentLPA1;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setClgName(String clgName) {
        this.clgName = clgName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCurrentLPA(Double currentLPA) {
        this.currentLPA = currentLPA;
    }

    public void setYearOfPassing(int yearOfPassing) {
        this.yearOfPassing = yearOfPassing;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void setEmployed(boolean employed) {
        this.employed = employed;
    }

    String getName(String name) {
        return this.name;
    }

    String getDob(String dob) {
        return this.dob;
    }

    String getClgName() {
        return clgName;
    }
    String getEmail() {
        return email;
    }

    int getYearOfPassing(String yearOfPassing) {
        return this.yearOfPassing;
    }

    boolean getEmployed(String employed) {
        return this.employed;
    }

    int getExp(String exp) {
        return this.exp;
    }

    Double getCurrentLPA(String currentLPA) {
        return this.currentLPA;
    }

}
