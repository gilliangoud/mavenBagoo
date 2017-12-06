package com.fortw.bagoo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jules
 */
public class ClaimLijst {
private String Klantennummer;
private String Datum;
private String Reden;

    public ClaimLijst(String Klantennummer, String Datum, String Reden) {
        this.Klantennummer = Klantennummer;
        this.Datum = Datum;
        this.Reden = Reden;
    }

    public String getKlantennummer() {
        return Klantennummer;
    }

    public void setKlantennummer(String Klantennummer) {
        this.Klantennummer = Klantennummer;
    }

    public String getDatum() {
        return Datum;
    }

    public void setDatum(String Datum) {
        this.Datum = Datum;
    }

    public String getReden() {
        return Reden;
    }

    public void setReden(String Reden) {
        this.Reden = Reden;
    }


    
}
