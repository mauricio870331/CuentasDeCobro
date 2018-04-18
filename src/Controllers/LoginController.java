/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import App.FrmPrincipal;
import App.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Mauricio Herrera
 */
public final class LoginController implements ActionListener {

    Login lg;

    public LoginController(Login lg) {
        this.lg = lg;
        iniComponets();
    }

    public void iniComponets() {
        lg.btnIniciar.addActionListener(this);
        lg.btncancel.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == lg.btnIniciar) {
            try {
                if (validarUsuario(lg.txtUser.getText(), lg.txtpass.getText())) {
                    lg.dispose();
                    FrmPrincipal fp = GetFrmPrincipal.getFrmPrincipal();
                    GetController.getController("");
                    fp.setLocationRelativeTo(null);
                    fp.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta");
                }
            } catch (IOException ex) {
                System.out.println("error " + ex);
            }
        }
        
        if (e.getSource() == lg.btncancel) {
           System.exit(0);
        }
    }

    public boolean validarUsuario(String user, String pass) throws FileNotFoundException, IOException {
        boolean result = false;
        String cadena;
        String ruta = System.getProperty("user.dir") + "\\src\\Modelo\\Usuarios.txt";
        FileReader f = new FileReader(ruta);
        BufferedReader b = new BufferedReader(f);
        while ((cadena = b.readLine()) != null) {
            String[] data = cadena.split(",");
            if (data[3].equals(user) && data[4].equals(pass)) {
                result = true;
                break;
            }
        }
        b.close();
        return result;
    }

}
