/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import App.FrmPrincipal;

/**
 *
 * @author clopez
 */
public class GetFrmPrincipal {

    public static FrmPrincipal frm = null;

    public static FrmPrincipal getFrmPrincipal() {
        try {
            if (frm == null) {
                frm = new FrmPrincipal();
            }
        } catch (Exception e) {
            System.out.println("error " + e);
        }
        return frm;

    }
}
