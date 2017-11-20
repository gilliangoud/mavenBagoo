/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo;

/**
 *
 * @author gilli
 */
public class FoundLuggage {
    
    private int registrationNr;
    private String dateFound;
    private String timeFound;
    private String luggageType;
    private String brand;
    public static int lastGivenregistrationNr = 0;
    
    public FoundLuggage(){
        lastGivenregistrationNr++;
        int newRegistrationNr = lastGivenregistrationNr;
        this.registrationNr = newRegistrationNr;
        this.dateFound = "xxx";
        this.timeFound = "xxx";
        this.luggageType = "xxx";
        this.brand = "xxx";
    }
    
    public FoundLuggage(int registrationNr, String dateFound, 
            String timeFound, String luggageType, String brand){
        if (registrationNr > lastGivenregistrationNr){
        lastGivenregistrationNr = registrationNr;}
        int newRegistrationNr = registrationNr;
        this.registrationNr = newRegistrationNr;
        this.dateFound = dateFound;
        this.timeFound = timeFound;
        this.luggageType = luggageType;
        this.brand = brand;
    }

    /**
     * @return the registrationNr
     */
    public int getRegistrationNr() {
        return registrationNr;
    }

    /**
     * @param registrationNr the registrationNr to set
     */
    public void setRegistrationNr(int registrationNr) {
        this.registrationNr = registrationNr;
    }

    /**
     * @return the dateFound
     */
    public String getDateFound() {
        return dateFound;
    }

    /**
     * @param dateFound the dateFound to set
     */
    public void setDateFound(String dateFound) {
        this.dateFound = dateFound;
    }

    /**
     * @return the timeFound
     */
    public String getTimeFound() {
        return timeFound;
    }

    /**
     * @param timeFound the timeFound to set
     */
    public void setTimeFound(String timeFound) {
        this.timeFound = timeFound;
    }

    /**
     * @return the luggageType
     */
    public String getLuggageType() {
        return luggageType;
    }

    /**
     * @param luggageType the luggageType to set
     */
    public void setLuggageType(String luggageType) {
        this.luggageType = luggageType;
    }

    /**
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @param brand the brand to set
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }  
}
