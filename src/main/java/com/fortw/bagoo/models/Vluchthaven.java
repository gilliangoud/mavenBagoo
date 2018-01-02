/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo.models;

/**
 *
 * @author Rayman
 */
public class Vluchthaven {

    // Attributen
    private String iata;
    private String naam;
    private String locatie;
    private String land;
    private String tijdzone;
    private Boolean dagLichtBesparing;

    // Lege Constructor
    public Vluchthaven() {}

    /**
     * @return the iata
     */
    public String getIata() {
        return iata;
    }

    /**
     * @param iata the iata to set
     */
    public void setIata(String iata) {
        this.iata = iata;
    }

    /**
     * @return the locatie
     */
    public String getLocatie() {
        return locatie;
    }

    /**
     * @param locatie the locatie to set
     */
    public void setLocatie(String locatie) {
        this.locatie = locatie;
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
     * @return the tijdzone
     */
    public String getTijdzone() {
        return tijdzone;
    }

    /**
     * @param tijdzone the tijdzone to set
     */
    public void setTijdzone(String tijdzone) {
        this.tijdzone = tijdzone;
    }

    /**
     * @return the dagLichtBesparing
     */
    public Boolean getDagLichtBesparing() {
        return dagLichtBesparing;
    }

    /**
     * @param dagLichtBesparing the dagLichtBesparing to set
     */
    public void setDagLichtBesparing(Boolean dagLichtBesparing) {
        this.dagLichtBesparing = dagLichtBesparing;
    }
    
//iata;
//locatie;
//land;
//tijdzone;
//dagLichtBesparing;

    @Override
    public String toString(){
        String s;
        if(getNaam().length() <= 1){
            s = getIata() + " ," + getLocatie() + " ," + getLand();
        } else {
            s = getNaam() + " ," + getLocatie() + " ," + getLand();
        }
        return s; 
    }

    /**
     * @return the naam
     */
    public String getNaam() {
        return naam;
    }

    /**
     * @param naam the naam to set
     */
    public void setNaam(String naam) {
        this.naam = naam;
    }
}
