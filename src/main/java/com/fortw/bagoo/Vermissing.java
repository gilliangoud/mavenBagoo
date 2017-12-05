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
    private String achternaam;
    private String voornaam;
    private String adres;
    private String postcode;
    private String plaats;
    private String land;
    private String telefoonnummer;
    private String email;
    private String flightnummer;
    public Vermissing(String achternaam, String voornaam, String adres, String postcode, String plaats, String land, String telefoonnummer, String email, String flightnummer) {
        this.achternaam = achternaam;
        this.voornaam = voornaam;
        this.adres = adres;
        this.postcode = postcode;
        this.plaats = plaats;
        this.land = land;
        this.telefoonnummer = telefoonnummer;
        this.email = email;
        this.flightnummer = flightnummer;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getAdres() {
        return adres;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getPlaats() {
        return plaats;
    }

    public String getLand() {
        return land;
    }

    public String getTelefoonnummer() {
        return telefoonnummer;
    }

    public String getEmail() {
        return email;
    }

    public String getFlightnummer() {
        return flightnummer;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setPlaats(String plaats) {
        this.plaats = plaats;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public void setTelefoonnummer(String telefoonnummer) {
        this.telefoonnummer = telefoonnummer;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFlightnummer(String flightnummer) {
        this.flightnummer = flightnummer;
    }
    
    
}
