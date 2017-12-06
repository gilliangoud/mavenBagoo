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
public class Bagage {

    // Attributen
    private Integer bagageNr;
    private String type;
    private String merk;
    private String kleur;
    private String kleur2;
    private String gewicht;
    private String opmerking;
    private String breedte;
    private String hoogte;
    private String diepte;
    private Integer locatieNr;
    private Integer vluchtNr;
    
    
    // Lege Constructor
    public Bagage(){
    }
    
    // Constructor alle attributen
    public Bagage (int bagageNr, String type, String merk, String kleur, String kleur2, String gewicht, String opmerking, String breedte, String hoogte, String diepte, int locatieNr, int vluchtNr){
        this.bagageNr = bagageNr;
        this.type = type;
        this.merk = merk;
        this.kleur = kleur;
        this.kleur2 = kleur2;
        this.gewicht = gewicht;
        this.opmerking = opmerking;
        this.breedte = breedte;
        this.hoogte = hoogte;
        this.diepte = diepte;
        this.locatieNr = locatieNr;      
        this.vluchtNr = vluchtNr;
    }
    
    // Constructor zonder bagageID
        public Bagage (String type, String merk, String kleur, String kleur2, String gewicht, String opmerking, String breedte, String hoogte, String diepte, int locatieNr, int vluchtNr){
        this.type = type;
        this.merk = merk;
        this.kleur = kleur;
        this.kleur2 = kleur2;
        this.gewicht = gewicht;
        this.opmerking = opmerking;
        this.breedte = breedte;
        this.hoogte = hoogte;
        this.diepte = diepte;
        this.locatieNr = locatieNr;      
        this.vluchtNr = vluchtNr;
    }

    /**
     * @return the bagageNr
     */
    public Integer getBagageNr() {
        return bagageNr;
    }

    /**
     * @param bagageNr the bagageNr to set
     */
    public void setBagageNr(Integer bagageNr) {
        this.bagageNr = bagageNr;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the merk
     */
    public String getMerk() {
        return merk;
    }

    /**
     * @param merk the merk to set
     */
    public void setMerk(String merk) {
        this.merk = merk;
    }

    /**
     * @return the kleur
     */
    public String getKleur() {
        return kleur;
    }

    /**
     * @param kleur the kleur to set
     */
    public void setKleur(String kleur) {
        this.kleur = kleur;
    }

    /**
     * @return the kleur2
     */
    public String getKleur2() {
        return kleur2;
    }

    /**
     * @param kleur2 the kleur2 to set
     */
    public void setKleur2(String kleur2) {
        this.kleur2 = kleur2;
    }

    /**
     * @return the gewicht
     */
    public String getGewicht() {
        return gewicht;
    }

    /**
     * @param gewicht the gewicht to set
     */
    public void setGewicht(String gewicht) {
        this.gewicht = gewicht;
    }

    /**
     * @return the opmerking
     */
    public String getOpmerking() {
        return opmerking;
    }

    /**
     * @param opmerking the opmerking to set
     */
    public void setOpmerking(String opmerking) {
        this.opmerking = opmerking;
    }

    /**
     * @return the breedte
     */
    public String getBreedte() {
        return breedte;
    }

    /**
     * @param breedte the breedte to set
     */
    public void setBreedte(String breedte) {
        this.breedte = breedte;
    }

    /**
     * @return the hoogte
     */
    public String getHoogte() {
        return hoogte;
    }

    /**
     * @param hoogte the hoogte to set
     */
    public void setHoogte(String hoogte) {
        this.hoogte = hoogte;
    }

    /**
     * @return the diepte
     */
    public String getDiepte() {
        return diepte;
    }

    /**
     * @param diepte the diepte to set
     */
    public void setDiepte(String diepte) {
        this.diepte = diepte;
    }

    /**
     * @return the locatieNr
     */
    public Integer getLocatieNr() {
        return locatieNr;
    }

    /**
     * @param locatieNr the locatieNr to set
     */
    public void setLocatieNr(Integer locatieNr) {
        this.locatieNr = locatieNr;
    }

    /**
     * @return the vluchtNr
     */
    public Integer getVluchtNr() {
        return vluchtNr;
    }

    /**
     * @param vluchtNr the vluchtNr to set
     */
    public void setVluchtNr(Integer vluchtNr) {
        this.vluchtNr = vluchtNr;
    }
    
    
    
    
}
