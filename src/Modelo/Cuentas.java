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
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Mauricio Herrera
 */
public class Cuentas {

    private int id_cuenta;
    private double valorPrestamo;
    private double valorCuota;
    private double intereses;
    private int cantCuotas;
    private double porcentajeInteres;
    private Date fechaRegistro;
    private Date fecha_primeraCuota;
    private int idCliente;
    private ArrayList<String> objectstemp;

    public Cuentas(int id_cuenta, double valorPrestamo, double valorCuota, double intereses, int cantCuotas, double porcentajeInteres, Date fechaRegistro, Date fecha_primeraCuota, int idCliente) {
        this.id_cuenta = id_cuenta;
        this.valorPrestamo = valorPrestamo;
        this.valorCuota = valorCuota;
        this.intereses = intereses;
        this.cantCuotas = cantCuotas;
        this.porcentajeInteres = porcentajeInteres;
        this.fechaRegistro = fechaRegistro;
        this.fecha_primeraCuota = fecha_primeraCuota;
        this.idCliente = idCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public double getValorPrestamo() {
        return valorPrestamo;
    }

    public void setValorPrestamo(double valorPrestamo) {
        this.valorPrestamo = valorPrestamo;
    }

    public double getValorCuota() {
        return valorCuota;
    }

    public void setValorCuota(double valorCuota) {
        this.valorCuota = valorCuota;
    }

    public double getIntereses() {
        return intereses;
    }

    public void setIntereses(double intereses) {
        this.intereses = intereses;
    }

    public int getCantCuotas() {
        return cantCuotas;
    }

    public void setCantCuotas(int cantCuotas) {
        this.cantCuotas = cantCuotas;
    }

    public double getPorcentajeInteres() {
        return porcentajeInteres;
    }

    public void setPorcentajeInteres(double porcentajeInteres) {
        this.porcentajeInteres = porcentajeInteres;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFecha_primeraCuota() {
        return fecha_primeraCuota;
    }

    public void setFecha_primeraCuota(Date fecha_primeraCuota) {
        this.fecha_primeraCuota = fecha_primeraCuota;
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
                objectstemp.add("" + sigienteId + "," + idCliente + "," + fechaRegistro + "," + fecha_primeraCuota + "," + cantCuotas + "," + porcentajeInteres + "," + intereses + "," + valorCuota + "," + valorPrestamo);
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
        String ruta = System.getProperty("user.dir") + "\\src\\Modelo\\Cuentas.txt";
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

    public ArrayList<String> getObjectstemp() {
        return objectstemp;
    }

    public void setObjectstemp(ArrayList<String> objectstemp) {
        this.objectstemp = objectstemp;
    }

}
