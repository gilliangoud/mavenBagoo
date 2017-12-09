/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo.models;

/**
 *
 * @author jules
 */
public class Claim {

    public static void setklantennummer(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void setdatum(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void setreden(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   private int klantennummer;
    private String datum;
    private String reden;
    
    

    public Claim(){
    }
    
    public Claim(int klantennummer, String datum, String reden){
        this.klantennummer = klantennummer;
        this.datum = datum;
        this.reden = reden;
        
    }
    

    public Claim(String datum, String reden, int klantennummer){
        this.klantennummer = klantennummer;
        this.datum = datum;
        this.reden = reden;
    }    

    public Integer getKlantennummer() {
        return klantennummer;
    }

    public void setKlantennummer(Integer klantennummer) {
        this.klantennummer = klantennummer;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getReden() {
        return reden;
    }

    public void setReden(String reden) {
        this.reden = reden;
    }
    
    
        
}
