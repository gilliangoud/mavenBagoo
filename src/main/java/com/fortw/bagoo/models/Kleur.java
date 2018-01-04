/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo.models;

/**
 * De class voor de beschikbare kleuren waarin bagage kan voorkomen
 * @author Giel
 */
public class Kleur {
    private int RAL;
    private String engels;
    private String nederlands;
    private String spaans;
    private String turks;
    
    Kleur(){}

    /**
     * @return the RAL
     */
    public int getRAL() {
        return RAL;
    }

    /**
     * @param RAL the RAL to set
     */
    public void setRAL(int RAL) {
        this.RAL = RAL;
    }

    /**
     * @return the engels
     */
    public String getEngels() {
        return engels;
    }

    /**
     * @param engels the engels to set
     */
    public void setEngels(String engels) {
        this.engels = engels;
    }

    /**
     * @return the nederlands
     */
    public String getNederlands() {
        return nederlands;
    }

    /**
     * @param nederlands the nederlands to set
     */
    public void setNederlands(String nederlands) {
        this.nederlands = nederlands;
    }

    /**
     * @return the spaans
     */
    public String getSpaans() {
        return spaans;
    }

    /**
     * @param spaans the spaans to set
     */
    public void setSpaans(String spaans) {
        this.spaans = spaans;
    }

    /**
     * @return the turks
     */
    public String getTurks() {
        return turks;
    }

    /**
     * @param turks the turks to set
     */
    public void setTurks(String turks) {
        this.turks = turks;
    }
    
    @Override
    public String toString(){
        return this.getNederlands();
    }
    
}
