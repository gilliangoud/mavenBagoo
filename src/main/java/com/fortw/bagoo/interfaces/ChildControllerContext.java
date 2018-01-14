package com.fortw.bagoo.interfaces;

import com.fortw.bagoo.models.Vermissing;
import com.fortw.bagoo.models.Klant;

/**
 * De code voorziet een communicatielaag tussen controllers waarbij deze 
 * geimplementeerd word. Dit maakt het mogelijk om delen van de applicatie beter
 * te kunnen "nesten".
 * 
 * @author Giel
 */
public interface ChildControllerContext {
    
    /**
     *  Deze methode kan geimplementeerd worden bij de child, de parent kan deze
     *  aanroepen wanneer die in de child de gegevens ververst wilt hebben.
     * 
     *  het liefst door meteen alle data te verversen.
     */
    public void notifyRefresh();

    /**
     *  Deze methode kan geimplementeerd worden bij de child, de parent kan deze
     *  aanroepen om zo in de child zijn statusbalk een statusbericht achter te
     *  laten.
     * 
     *  Deze methode zou ook gebruikt kunnen worden voor andere 
     *  intracommunicatie.
     * @param message
     */
    public void displayStatusMessage(String message);

    public Vermissing getSelectedItem();
    
}
