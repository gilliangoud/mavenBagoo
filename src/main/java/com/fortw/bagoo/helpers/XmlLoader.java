/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo.helpers;

import com.fortw.bagoo.models.BagageTypeWrapper;
import com.fortw.bagoo.models.KleurWrapper;
import java.io.File;
import java.util.List;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Giel
 */
public class XmlLoader {
    public static List loadKleurData() {
        KleurWrapper wrapper = new KleurWrapper();
        File file = new File(""
                + "src/main/resources/com/fortw/bagoo/kleuren.xml");
    try {
        JAXBContext context = JAXBContext
                .newInstance(KleurWrapper.class);
        Unmarshaller um = context.createUnmarshaller();

        // Reading XML from the file and unmarshalling.
        wrapper = (KleurWrapper) um.unmarshal(file);

    } catch (Exception e) { // catches ANY exception
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Could not load data");
        alert.setContentText("Could not load data from file:\n" + file.getPath());
        alert.showAndWait();
    }
        return wrapper.getKleuren();
    }
    
    public static List loadBagageTypeData() {
        BagageTypeWrapper wrapper = new BagageTypeWrapper();
        File file = new File(""
                + "src/main/resources/com/fortw/bagoo/bagageTypes.xml");
    try {
        JAXBContext context = JAXBContext
                .newInstance(BagageTypeWrapper.class);
        Unmarshaller um = context.createUnmarshaller();

        // Reading XML from the file and unmarshalling.
        wrapper = (BagageTypeWrapper) um.unmarshal(file);

    } catch (Exception e) { // catches ANY exception
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Could not load data");
        alert.setContentText("Could not load data from file:\n" + file.getPath());
        System.out.println("++" + e);
        alert.showAndWait();
    }
        return wrapper.getTypes();
    }
}
