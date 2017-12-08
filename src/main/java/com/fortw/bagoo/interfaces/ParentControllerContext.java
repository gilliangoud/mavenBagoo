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
    
    public void notifyCloseChild();
    public void notifyChildHasUpdated();
    public void displayStatusMessage(String message);
    
}
