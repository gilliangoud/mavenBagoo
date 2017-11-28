
/* Class: Login
*  @Author Ramon Mocking
*  Doel: Deze Class controleerd de of de ingevulde inloggegevens overeenkomen 
*  met de inloggegevens uit de database.
 */
package com.fortw.bagoo;

public class Login {

    private String gebruikersnaam;
    private String wachtwoord;
    private int level;

    public boolean ControleerLogin(String gebruikersnaam, String wachtwoord) {
        if (this.gebruikersnaam = gebruikersnaam && this.wachtwoord = wachtwoord) {
            return true;
        } else if (this.gebruikersnaam != gebruikersnaam || this.wachtwoord != wachtwoord) {
            return false;
        }
        
    public String getGebruikersnaam(){
        return gebruikersnaam;
    }
}