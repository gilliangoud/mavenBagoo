package com.fortw.bagoo.interfaces;

/**
 * ParentControllerContext Gekregen vanuit een voorbeeld op de VLO
 * https://vlo.informatica.hva.nl/main/document/document.php?cidReq=1000PFYS14B&id_session=0&gidReq=0&gradebook=0&origin=&action=download&id=66442
 * 
 * De code voorziet een communicatielaag tussen controllers waarbij deze 
 * geimplementeerd word. Dit maakt het mogelijk om delen van de applicatie beter
 * te kunnen "nesten".
 * 
 * @author Giel
 */
public interface ParentControllerContext {
    
    /**
     *  Deze methode kan geimplementeerd worden bij de parent, the child kan
     *  dan deze methode aanroepen om aan te geven dat de child gesloten moet
     *  worden.
     * 
     *  verwacht wordt is dat de parent de subschermen sluit en zijn hoofdscherm
     *  of vorige scherm opnieuw opent.
     */
    public void notifyCloseChild();
    
    /**
     *  Deze methode kan geimplementeerd worden bij de parent, de child kan deze
     *  aanroepen wanneer die gegevens heeft aangepast en in de parent de 
     *  gegevens ververst moeten worden.
     * 
     *  het liefst door meteen alle data te verversen.
     */
    public void notifyChildHasUpdated();

    /**
     *  Deze methode kan geimplementeerd worden bij de parent, de child kan deze
     *  aanroepen om zo in de parent zijn statusbalk een statusbericht achter te
     *  laten.
     * 
     *  Deze methode zou ook gebruikt kunnen worden voor andere 
     *  intracommunicatie.
     * @param message
     */
    public void displayStatusMessage(String message);
    
}
