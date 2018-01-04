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
@XmlRootElement(name = "types")
public class BagageTypeWrapper {

    private List<BagageType> types;

    @XmlElement(name = "type")
    public List<BagageType> getTypes() {
        return types;
    }

    public void setTypes(List<BagageType> types) {
        this.types = types;
    }
}