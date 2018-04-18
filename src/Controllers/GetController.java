/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import App.FrmPrincipal;
import java.io.IOException;

/**
 *
 * @author clopez
 */
public class GetController {
    
     public static PrincipalController pc = null;
    
    public static PrincipalController getController(String Objeto) {
        try {
            if (pc == null) {
                pc = new PrincipalController(Objeto);
            } 
        } catch (IOException e) {
            System.out.println("error = " + e);
        }
        return pc;
    }
}
