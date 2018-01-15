/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo.models;

/**
 *
 * @author Giel
 */
public class BagageType {
    private int typeId;
    private String engels;
    private String nederlands;
    private String spaans;
    private String turks;
    
    BagageType(){}

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

    /**
     * @return the typeId
     */
    public int getTypeId() {
        return typeId;
    }

    /**
     * @param typeId the typeId to set
     */
    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }
    
}
