/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import App.BuscarClientes;
import App.FrmPrincipal;
import Modelo.Clientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Mauricio Herrera
 */
public final class PrincipalController implements ActionListener {

    FrmPrincipal fp;
    ArrayList<String> telefonos = new ArrayList();
    String ObjecClient = "";

    public PrincipalController(String Objeto) throws IOException {
        this.fp = GetFrmPrincipal.getFrmPrincipal();
        iniComponents();
        cargarusuarios();
        ObjecClient = Objeto;
    }

    public void iniComponents() {
        fp.btnCancel.addActionListener(this);
        fp.btnNewClient.addActionListener(this);
        fp.btnNewTelefono.addActionListener(this);
        fp.btnFindCliente.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fp.btnNewClient) {
            Clientes c = new Clientes(0, fp.txtDoc.getText(), fp.txtNombres.getText(), fp.txtApellidos.getText(),
                    fp.txtDir.getText(), telefonos, fp.txtCorreo.getText());
            try {
                if (c.nuevoCliente()) {
                    JOptionPane.showMessageDialog(null, "Cliente Creado on exito");
                    cargarusuarios();
                    limpiarFormClientes();
                } else {
                    JOptionPane.showMessageDialog(null, "No se ha creado el cliente");
                }
            } catch (IOException ex) {
                System.out.println("error " + ex);
            }

        }

        if (e.getSource() == fp.btnNewTelefono) {
            String telefono = JOptionPane.showInputDialog("Ingresa telefono");
            String cadenaTels = "";
            telefonos.add(telefono);
            cadenaTels = telefonos.stream().map((telefono1) -> telefono1 + " ").reduce(cadenaTels, String::concat);
            fp.txtTel.setText(cadenaTels);
        }

        if (e.getSource() == fp.btnCancel) {
            try {
                cargarusuarios();
            } catch (IOException ex) {
                System.out.println("error " + ex);
            }
            limpiarFormClientes();
        }

        //********************************//
        //Cuentas//
        if (e.getSource() == fp.btnFindCliente) {
            BuscarClientes bc = new BuscarClientes(fp, true);
            bc.setLocationRelativeTo(null);
            bc.setVisible(true);
        }
    }

    public void cargarusuarios() throws IOException {
        Clientes c = new Clientes();
        fp.tblClientes.setModel(c.cargarClientes());
        c = null;
    }

    private void limpiarFormClientes() {
        fp.txtDoc.setText("");
        fp.txtNombres.setText("");
        fp.txtApellidos.setText("");
        fp.txtDir.setText("");
        fp.txtCorreo.setText("");
        fp.txtTel.setText("");
    }

}
