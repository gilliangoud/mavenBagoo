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
    private Integer type;
    private String merk;
    private Integer kleur;
    private Integer kleur2;
    private String gewicht;
    private String opmerking;
    private String breedte;
    private String hoogte;
    private String diepte;
    private Integer locatieNr;
    private String vluchtNr;
    private String labelNr;

    // Lege Constructor
    public Bagage() {
        this.bagageNr = null;
        this.type = 0;
        this.merk = "";
        this.kleur = 0;
        this.kleur2 = 0;
        this.gewicht = "";
        this.opmerking = "";
        this.breedte = "";
        this.hoogte = "";
        this.diepte = "";
        this.locatieNr = 0;
        this.vluchtNr = "";
        this.labelNr = "";
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
    public Integer getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(Integer type) {
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
    public Integer getKleur() {
        return kleur;
    }

    /**
     * @param kleur the kleur to set
     */
    public void setKleur(Integer kleur) {
        this.kleur = kleur;
    }

    /**
     * @return the kleur2
     */
    public Integer getKleur2() {
        return kleur2;
    }

    /**
     * @param kleur2 the kleur2 to set
     */
    public void setKleur2(Integer kleur2) {
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
    public String getVluchtNr() {
        return vluchtNr;
    }

    /**
     * @param vluchtNr the vluchtNr to set
     */
    public void setVluchtNr(String vluchtNr) {
        this.vluchtNr = vluchtNr;
    }

//bagageNr;
//type;
//merk;
//kleur;
//kleur2;
//gewicht;
//opmerking;
//breedte;
//hoogte;
//diepte;
//locatieNr;
//vluchtNr;
    @Override
    public String toString() {
        String s = Integer.toString(getBagageNr());
        return s;
    }

    /**
     * @return the labelNr
     */
    public String getLabelNr() {
        return labelNr;
    }

    /**
     * @param labelNr the labelNr to set
     */
    public void setLabelNr(String labelNr) {
        this.labelNr = labelNr;
    }
}
