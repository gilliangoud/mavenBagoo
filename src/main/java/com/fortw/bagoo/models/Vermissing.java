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
public class Vermissing {

    // Attributen
    private Integer vermissingNr;
    private String datumGevonden;
    private String tijdGevonden;
    
    private Vluchthaven vluchthaven;
    private Klant klant;
    private Bagage bagage;
    
    private String aangemaakt;
    private String laatsteUpdate;
    private String bagageLabel;
    
    private Vlucht vlucht;
    private User userAangemaakt;
    private User userBewerkt;

    // Lege Constructor
    public Vermissing() {}

    /**
     * @return the vermissingNr
     */
    public Integer getVermissingNr() {
        return vermissingNr;
    }

    /**
     * @param vermissingNr the vermissingNr to set
     */
    public void setVermissingNr(Integer vermissingNr) {
        this.vermissingNr = vermissingNr;
    }

    /**
     * @return the datumGevonden
     */
    public String getDatumGevonden() {
        return datumGevonden;
    }

    /**
     * @param datumGevonden the datumGevonden to set
     */
    public void setDatumGevonden(String datumGevonden) {
        this.datumGevonden = datumGevonden;
    }

    /**
     * @return the tijdGevonden
     */
    public String getTijdGevonden() {
        return tijdGevonden;
    }

    /**
     * @param tijdGevonden the tijdGevonden to set
     */
    public void setTijdGevonden(String tijdGevonden) {
        this.tijdGevonden = tijdGevonden;
    }

    /**
     * @return the aangemaakt
     */
    public String getAangemaakt() {
        return aangemaakt;
    }

    /**
     * @param aangemaakt the aangemaakt to set
     */
    public void setAangemaakt(String aangemaakt) {
        this.aangemaakt = aangemaakt;
    }

    /**
     * @return the laatsteUpdate
     */
    public String getLaatsteUpdate() {
        return laatsteUpdate;
    }

    /**
     * @param laatsteUpdate the laatsteUpdate to set
     */
    public void setLaatsteUpdate(String laatsteUpdate) {
        this.laatsteUpdate = laatsteUpdate;
    }

    /**
     * @return the bagageLabel
     */
    public String getBagageLabel() {
        return bagageLabel;
    }

    /**
     * @param bagageLabel the bagageLabel to set
     */
    public void setBagageLabel(String bagageLabel) {
        this.bagageLabel = bagageLabel;
    }

    /**
     * @return the userAangemaakt
     */
    public User getUserAangemaakt() {
        return userAangemaakt;
    }

    /**
     * @return the userBewerkt
     */
    public User getUserBewerkt() {
        return userBewerkt;
    }

    /**
     * @return the klant
     */
    public Klant getKlant() {
        return klant;
    }

    /**
     * @param klant the klant to set
     */
    public void setKlant(Klant klant) {
        this.klant = klant;
    }

    /**
     * @return the bagage
     */
    public Bagage getBagage() {
        return bagage;
    }

    /**
     * @param bagage the bagage to set
     */
    public void setBagage(Bagage bagage) {
        this.bagage = bagage;
    }

    /**
     * @param userAangemaakt the userAangemaakt to set
     */
    public void setUserAangemaakt(User userAangemaakt) {
        this.userAangemaakt = userAangemaakt;
    }

    /**
     * @param userBewerkt the userBewerkt to set
     */
    public void setUserBewerkt(User userBewerkt) {
        this.userBewerkt = userBewerkt;
    }

    /**
     * @return the vluchthaven
     */
    public Vluchthaven getVluchthaven() {
        return vluchthaven;
    }

    /**
     * @param vluchthaven the vluchthaven to set
     */
    public void setVluchthaven(Vluchthaven vluchthaven) {
        this.vluchthaven = vluchthaven;
    }

    /**
     * @return the vlucht
     */
    public Vlucht getVlucht() {
        return vlucht;
    }

    /**
     * @param vlucht the vlucht to set
     */
    public void setVlucht(Vlucht vlucht) {
        this.vlucht = vlucht;
    }

}
