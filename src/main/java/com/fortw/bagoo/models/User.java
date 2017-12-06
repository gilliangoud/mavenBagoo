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
public class User {
    private int personeelNr;
    private String gebruikersnaam;
    private String wachtwoord;
    private String aangemaaktDatum;
    private int level;
    
    /**
     *
     */
    public User(){
    }
    
    /**
     *
     * @param personeelNr
     * @param gebruikersnaam
     * @param wachtwoord
     * @param aangemaaktDatum
     * @param level
     */
    public User(int personeelNr, String gebruikersnaam, String wachtwoord,
            int level){
        this.personeelNr = personeelNr;
        this.gebruikersnaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;
        this.aangemaaktDatum = "vandaag";
        this.level = level;
    }
    
    /**
     *
     * @param gebruikersnaam
     * @param wachtwoord
     * @param level
     */
    public User(String gebruikersnaam, String wachtwoord, int level){
        //this.personeelNr = personeelNr;
        this.gebruikersnaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;
        this.aangemaaktDatum = "vandaag";
        this.level = level;
    }

    /**
     * @return the personeelNr
     */
    public int getPersoneelNr() {
        return personeelNr;
    }

    /**
     * @return the gebruikersnaam
     */
    public String getGebruikersnaam() {
        return gebruikersnaam;
    }

    /**
     * @param gebruikersnaam the gebruikersnaam to set
     */
    public void setGebruikersnaam(String gebruikersnaam) {
        this.gebruikersnaam = gebruikersnaam;
    }

    /**
     * @return the wachtwoord
     */
    public String getWachtwoord() {
        return wachtwoord;
    }

    /**
     * @param wachtwoord the wachtwoord to set
     */
    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    /**
     * @return the aangemaaktDatum
     */
    public String getAangemaaktDatum() {
        return aangemaaktDatum;
    }

    /**
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * @param personeelNr the personeelNr to set
     */
    public void setPersoneelNr(int personeelNr) {
        this.personeelNr = personeelNr;
    }

    /**
     * @param aangemaaktDatum the aangemaaktDatum to set
     */
    public void setAangemaaktDatum(String aangemaaktDatum) {
        this.aangemaaktDatum = aangemaaktDatum;
    }
}
