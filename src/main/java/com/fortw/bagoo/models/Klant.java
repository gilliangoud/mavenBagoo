/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo.models;

/**
 *
 * @author Giel
 */
public class Klant {
    private Integer klantNr;
    private String voorNaam;
    private String tussenVoegsel;
    private String achterNaam;
    private String woonplaats;
    private String straat;
    private String huisNummer;
    private String postcode;
    private String land;
    private String telefoonNr;
    private String email;
    private String checkInDatum;
    

    public Klant(){
    }
    
    public Klant(Integer klantNr, String voorNaam, String tussenVoegsel, String achterNaam, String woonplaats, String straat, String huisNummer, String postcode, String land, String telefoonNr, String email){
        this.klantNr = klantNr;
        this.voorNaam = voorNaam;
        this.tussenVoegsel = tussenVoegsel;
        this.achterNaam = achterNaam;
        this.woonplaats = woonplaats;
        this.straat = straat;
        this.huisNummer = huisNummer;
        this.postcode = postcode;
        this.land = land;
        this.telefoonNr = telefoonNr;
        this.email = email;        
    }
    

    public Klant(String voorNaam, String tussenVoegsel, String achterNaam, String woonplaats, String straat, String huisNummer, String postcode, String land, String telefoonNr, String email){
        this.voorNaam = voorNaam;
        this.tussenVoegsel = tussenVoegsel;
        this.achterNaam = achterNaam;
        this.woonplaats = woonplaats;
        this.straat = straat;
        this.huisNummer = huisNummer;
        this.postcode = postcode;
        this.land = land;
        this.telefoonNr = telefoonNr;
        this.email = email;        
    }

    /**
     * @return the klantNr
     */
    public Integer getKlantNr() {
        return klantNr;
    }

    /**
     * @param klantNr the klantNr to set
     */
    public void setKlantNr(Integer klantNr) {
        this.klantNr = klantNr;
    }

    /**
     * @return the naam
     */
    public String getNaam() {
        String volledigeNaam;
        if(this.getTussenVoegsel().length() > 1) {        
            volledigeNaam = this.getVoorNaam() + " " + this.getTussenVoegsel() + " " + this.getAchterNaam();
        } else {
            volledigeNaam = this.getVoorNaam() + " " + this.getAchterNaam();
        }
        return volledigeNaam;
    }

    /**
     * @return the woonplaats
     */
    public String getWoonplaats() {
        return woonplaats;
    }

    /**
     * @param woonplaats the woonplaats to set
     */
    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }

    /**
     * @return the postcode
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * @param postcode the postcode to set
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    /**
     * @return the land
     */
    public String getLand() {
        return land;
    }

    /**
     * @param land the land to set
     */
    public void setLand(String land) {
        this.land = land;
    }

    /**
     * @return the telefoonNr
     */
    public String getTelefoonNr() {
        return telefoonNr;
    }

    /**
     * @param telefoonNr the telefoonNr to set
     */
    public void setTelefoonNr(String telefoonNr) {
        this.telefoonNr = telefoonNr;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the voorNaam
     */
    public String getVoorNaam() {
        return voorNaam;
    }

    /**
     * @param voorNaam the voorNaam to set
     */
    public void setVoorNaam(String voorNaam) {
        this.voorNaam = voorNaam;
    }

    /**
     * @return the tussenVoegsel
     */
    public String getTussenVoegsel() {
        return tussenVoegsel;
    }

    /**
     * @param tussenVoegsel the tussenVoegsel to set
     */
    public void setTussenVoegsel(String tussenVoegsel) {
        this.tussenVoegsel = tussenVoegsel;
    }

    /**
     * @return the achterNaam
     */
    public String getAchterNaam() {
        return achterNaam;
    }

    /**
     * @param achterNaam the achterNaam to set
     */
    public void setAchterNaam(String achterNaam) {
        this.achterNaam = achterNaam;
    }

    /**
     * @return the straat
     */
    public String getStraat() {
        return straat;
    }

    /**
     * @param straat the straat to set
     */
    public void setStraat(String straat) {
        this.straat = straat;
    }

    /**
     * @return the huisNummer
     */
    public String getHuisNummer() {
        return huisNummer;
    }

    /**
     * @param huisNummer the huisNummer to set
     */
    public void setHuisNummer(String huisNummer) {
        this.huisNummer = huisNummer;
    }
    
//klantNr;
//voorNaam;
//tussenVoegsel;
//achterNaam;
//woonplaats;
//straat;
//huisNummer;
//postcode;
//land;
//telefoonNr;
//email;
    
    @Override
    public String toString(){
        String s = getKlantNr() + ": " + getVoorNaam() + " " + getAchterNaam();
        return s; 
    }

    /**
     * @return the checkInDatum
     */
    public String getCheckInDatum() {
        return checkInDatum;
    }

    /**
     * @param checkInDatum the checkInDatum to set
     */
    public void setCheckInDatum(String checkInDatum) {
        this.checkInDatum = checkInDatum;
    }

}
