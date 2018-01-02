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
public class Vlucht {

    // Attributen
    private String vluchtNr;
    private String vliegtuigmaatschappij;
    private String van;
    private String naar;

    // Lege Constructor
    public Vlucht() {}

    /**
     * @return the vluchtNr
     */
    public String getVluchtNr() {
        return vluchtNr;
    }

    /**
     * @param vluchtNr the vluchtNr to set
     */
    public void setVluchtNr(String vluchtNr) {
        this.vluchtNr = vluchtNr;
    }

    /**
     * @return the vliegtuigmaatschappij
     */
    public String getVliegtuigmaatschappij() {
        return vliegtuigmaatschappij;
    }

    /**
     * @param vliegtuigmaatschappij the vliegtuigmaatschappij to set
     */
    public void setVliegtuigmaatschappij(String vliegtuigmaatschappij) {
        this.vliegtuigmaatschappij = vliegtuigmaatschappij;
    }

    /**
     * @return the van
     */
    public String getVan() {
        return van;
    }

    /**
     * @param van the van to set
     */
    public void setVan(String van) {
        this.van = van;
    }

    /**
     * @return the naar
     */
    public String getNaar() {
        return naar;
    }

    /**
     * @param naar the naar to set
     */
    public void setNaar(String naar) {
        this.naar = naar;
    }
    
    @Override
    public String toString(){
        String s = vluchtNr + ": " + van + " " + naar;
        return s; 
    }

}
