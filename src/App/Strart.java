/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import Controllers.LoginController;
import com.jtattoo.plaf.acryl.AcrylLookAndFeel;
import java.util.Properties;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Mauricio Herrera
 */
public class Strart {

    public static void main(String[] args) {
        try {
            Properties props = new Properties();
            props.put("logoString", "M-Systems");
            AcrylLookAndFeel.setCurrentTheme(props);
            UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.out.println("error " + e);
        }
        Login lg = new Login();
        LoginController loginController = new LoginController(lg);
        lg.setLocationRelativeTo(null);
        lg.setVisible(true);
    }

}
