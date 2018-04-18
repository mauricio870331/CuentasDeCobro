/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mauricio Herrera
 */
public class Clientes implements Serializable {

    private int idCliente;
    private String Documento;
    private String Nombres;
    private String Apellidos;
    private String Direccion;
    private ArrayList<String> telefonos;
    private String correo;
    private ArrayList<String> objectstemp;

    public Clientes(int idCliente, String Documento, String Nombres, String Apellidos, String Direccion, ArrayList<String> telefonos, String correo) {
        this.idCliente = idCliente;
        this.Documento = Documento;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Direccion = Direccion;
        this.telefonos = telefonos;
        this.correo = correo;
    }

    public Clientes() {
    }

    
        
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getDocumento() {
        return Documento;
    }

    public void setDocumento(String Documento) {
        this.Documento = Documento;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public ArrayList<String> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(ArrayList<String> telefonos) {
        this.telefonos = telefonos;
    }

    public boolean nuevoCliente() throws IOException {
        boolean r = false;
        int sigienteId = nextId();
        String ruta = System.getProperty("user.dir") + "\\src\\Modelo\\Clientes.txt";
        File fichero = new File(ruta);
        BufferedWriter bw = null;
        try {
            if (fichero.exists()) {
                bw = new BufferedWriter(new FileWriter(ruta));
                String tels = "";
                tels = telefonos.stream().map((telefono) -> telefono + "_").reduce(tels, String::concat);
                objectstemp.add("" + sigienteId + "," + Documento + "," + Nombres + "," + Apellidos + "," + Direccion + "," + tels + "," + correo);
//                System.out.println("objectstemp " + objectstemp.size());
                for (String obj : objectstemp) {
                    bw.write(obj + "\n");
                }
            }
            r = true;
            objectstemp = null;
        } catch (IOException e) {
            System.out.println("error " + e);
        } finally {
            try {
                if (null != fichero) {
                    bw.close();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return r;
    }

    public int nextId() throws FileNotFoundException, IOException {
        int result = 0;
        objectstemp = new ArrayList();
        String cadena;
        String ruta = System.getProperty("user.dir") + "\\src\\Modelo\\Clientes.txt";
        FileReader f = new FileReader(ruta);
        BufferedReader b = new BufferedReader(f);
        while ((cadena = b.readLine()) != null) {
            objectstemp.add(cadena);
//            System.out.println(cadena);
            result += 1;
        }
        b.close();
        return result;
    }

    public DefaultTableModel cargarClientes() throws FileNotFoundException, IOException {
        DefaultTableModel modelo;
        String Titulos[] = {"id", "Documento", "Nombres", "Apellidos", "Dirección", "Teléfono", "Correo"};
        modelo = new DefaultTableModel(null, Titulos) {
            @Override
            public boolean isCellEditable(int row, int column) { //para evitar que las celdas sean editables
                return false;
            }
        };
        Object[] columna = new Object[7];
        String cadena;
        String ruta = System.getProperty("user.dir") + "\\src\\Modelo\\Clientes.txt";
        FileReader f = new FileReader(ruta);
        BufferedReader b = new BufferedReader(f);
        while ((cadena = b.readLine()) != null) {
            String[] objeto = cadena.split(",");
            columna[0] = Integer.parseInt(objeto[0]);
            columna[1]= objeto[1];
            columna[2]= objeto[2];
            columna[3]= objeto[3];
            columna[4]= objeto[4];
            columna[5]= objeto[5];
            columna[6]= objeto[6];
            modelo.addRow(columna);
        }
        b.close();       
        return modelo;
    }

}
