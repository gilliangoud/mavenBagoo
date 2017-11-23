/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo;

/**
 *
 * @author gilli
 */
public interface ParentControllerContext {
    
    public void notifyCloseChild();
    
    public void notifyChildHasUpdated();
    
    public void displayStatusMessage(String message);
    
}
