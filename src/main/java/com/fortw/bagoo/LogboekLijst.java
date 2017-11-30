package com.fortw.bagoo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Anouar
 */
public class LogboekLijst {
    
    private String Datum;
    private String event;
    private String opmerking;

    public LogboekLijst(String Datum, String event, String opmerking) {
        this.Datum = Datum;
        this.event = event;
        this.opmerking = opmerking;
        
    }

    /**
     * @return the Datum
     */
    public String getDatum() {
        return Datum;
    }

    /**
     * @param Datum the Datum to set
     */
    public void setDatum(String Datum) {
        this.Datum = Datum;
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
    
    
    
    
    
}
