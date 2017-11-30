package com.fortw.bagoo;


import javafx.scene.control.DatePicker;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Anouar
 */
public class LogboekLog {
    private DatePicker datum;
    private String event;
    private String opmerking;

    public LogboekLog(DatePicker datum, String event, String opmerking) {
        this.datum = datum;
        this.event = event;
        this.opmerking = opmerking;
    }

    /**
     * @return the datum
     */
    public DatePicker getDatum() {
        return datum;
    }

    /**
     * @param datum the datum to set
     */
    public void setDatum(DatePicker datum) {
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
    
    
}
