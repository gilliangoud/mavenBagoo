/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo.models;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Giel
 */
@XmlRootElement(name = "kleuren")
public class KleurWrapper {

    private List<Kleur> kleuren;

    @XmlElement(name = "kleur")
    public List<Kleur> getKleuren() {
        return kleuren;
    }

    public void setKleuren(List<Kleur> kleuren) {
        this.kleuren = kleuren;
    }
}