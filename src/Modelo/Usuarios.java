/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;

/**
 *
 * @author Mauricio Herrera
 */
public class Usuarios implements Serializable{
    private int id_user;
    private String documento;
    private String NombreCompleto;
    private String usuario;
    private String Password;

    public Usuarios(int id_user, String documento, String NombreCompleto, String usuario, String Password) {
        this.id_user = id_user;
        this.documento = documento;
        this.NombreCompleto = NombreCompleto;
        this.usuario = usuario;
        this.Password = Password;
    }    
    

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombreCompleto() {
        return NombreCompleto;
    }

    public void setNombreCompleto(String NombreCompleto) {
        this.NombreCompleto = NombreCompleto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    
}
