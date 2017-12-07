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
public class Vermissing {
    private String vluchthavenAITA;
    private int klantID;
    private int bagageID;
   

    public String getVluchthavenAITA() {
        return vluchthavenAITA;
    }

    public void setVluchthavenAITA(String vluchthavenAITA) {
        this.vluchthavenAITA = vluchthavenAITA;
    }

    public int getKlantID() {
        return klantID;
    }

    public void setKlantID(int klantID) {
        this.klantID = klantID;
    }

    public int getBagageID() {
        return bagageID;
    }

    public void setBagageID(int bagageID) {
        this.bagageID = bagageID;
    }

   

    public Vermissing(String vluchthavenAITA, int klantID, int bagageID, String Datum) {
        this.vluchthavenAITA = vluchthavenAITA;
        this.klantID = klantID;
        this.bagageID = bagageID;
        
        
        
        
        
    }
    
    
}
