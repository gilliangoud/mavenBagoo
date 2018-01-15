/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo.models;

import java.sql.Date;

/**
 *
 * @author Giel
 */
public class Logboek {
    private Integer logboekNr;
    private Date datum;
    private String event;
    private String opmerking;
    private Integer vermissingNr;

    
    /**
     *
     */
    public Logboek(){
    }

    /**
     * @return the logboekNr
     */
    public Integer getLogboekNr() {
        return logboekNr;
    }

    /**
     * @param logboekNr the logboekNr to set
     */
    public void setLogboekNr(Integer logboekNr) {
        this.logboekNr = logboekNr;
    }

    /**
     * @return the datum
     */
    public Date getDatum() {
        return datum;
    }

    /**
     * @param datum the datum to set
     */
    public void setDatum(Date datum) {
        this.datum = datum;
    }

    /**
     * @return the event
     */
    public String getEvent() {
        return event;
    }

    /**
     * @param event the event to set
     */
    public void setEvent(String event) {
        this.event = event;
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

}
