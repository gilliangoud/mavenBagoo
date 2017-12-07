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
    private String vluchthaven;
    private Integer klantNr;
    private Integer bagageNr;
    private String aangemaakt;
    private String laatsteUpdate;
    private String bagageLabel;
    private Integer vluchtNr;
    private String userAangemaakt;
    private String userBewerkt;

    // Lege Constructor
    public Vermissing() {
    }

    // Constructor alle attributen
    public Vermissing(Integer vermissingNr, String datumGevonden, String tijdGevonden, String vluchthaven, Integer klantNr, Integer bagageNr, String aangemaakt, String laatsteUpdate, String bagageLabel, Integer vluchtNr, String userAangemaakt, String userBewerkt) {
        this.vermissingNr = vermissingNr;
        this.datumGevonden = datumGevonden;
        this.tijdGevonden = tijdGevonden;
        this.vluchthaven = vluchthaven;
        this.klantNr = klantNr;
        this.bagageNr = bagageNr;
        this.aangemaakt = aangemaakt;
        this.laatsteUpdate = laatsteUpdate;
        this.bagageLabel = bagageLabel;
        this.vluchtNr = vluchtNr;
        this.userAangemaakt = userAangemaakt;
        this.userBewerkt = userBewerkt;
    }

    public Vermissing(String datumGevonden, String tijdGevonden, String vluchthaven, Integer klantNr, Integer bagageNr, String aangemaakt, String laatsteUpdate, String bagageLabel, Integer vluchtNr, String userAangemaakt, String userBewerkt) {
        this.datumGevonden = datumGevonden;
        this.tijdGevonden = tijdGevonden;
        this.vluchthaven = vluchthaven;
        this.klantNr = klantNr;
        this.bagageNr = bagageNr;
        this.aangemaakt = aangemaakt;
        this.laatsteUpdate = laatsteUpdate;
        this.bagageLabel = bagageLabel;
        this.vluchtNr = vluchtNr;
        this.userAangemaakt = userAangemaakt;
        this.userBewerkt = userBewerkt;
    }

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
     * @return the vluchthaven
     */
    public String getVluchthaven() {
        return vluchthaven;
    }

    /**
     * @param vluchthaven the vluchthaven to set
     */
    public void setVluchthaven(String vluchthaven) {
        this.vluchthaven = vluchthaven;
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

    /**
     * @return the userAangemaakt
     */
    public String getUserAangemaakt() {
        return userAangemaakt;
    }

    /**
     * @param userAangemaakt the userAangemaakt to set
     */
    public void setUserAangemaakt(String userAangemaakt) {
        this.userAangemaakt = userAangemaakt;
    }

    /**
     * @return the userBewerkt
     */
    public String getUserBewerkt() {
        return userBewerkt;
    }

    /**
     * @param userBewerkt the userBewerkt to set
     */
    public void setUserBewerkt(String userBewerkt) {
        this.userBewerkt = userBewerkt;
    }

}
