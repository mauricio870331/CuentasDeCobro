/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import App.FrmPrincipal;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author clopez
 */
public class GetController {

    public static PrincipalController pc = null;

    public static PrincipalController getController() {
        if (pc == null) {
            try {
                pc = new PrincipalController();
            } catch (IOException ex) {
                System.out.println("error " + ex);
            }
        }
        return pc;
    }
}
