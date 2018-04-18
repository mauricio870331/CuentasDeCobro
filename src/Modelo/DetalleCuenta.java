/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author Mauricio Herrera
 */
public class DetalleCuenta {
    private int id_detalle;
    private int id_cuenta;
    private double valorAbonado;
    private Date fecha_pago;
    private Date proximo_pago;

    public DetalleCuenta(int id_detalle, int id_cuenta, double valorAbonado, Date fecha_pago, Date proximo_pago) {
        this.id_detalle = id_detalle;
        this.id_cuenta = id_cuenta;
        this.valorAbonado = valorAbonado;
        this.fecha_pago = fecha_pago;
        this.proximo_pago = proximo_pago;
    }

    public Date getProximo_pago() {
        return proximo_pago;
    }

    public void setProximo_pago(Date proximo_pago) {
        this.proximo_pago = proximo_pago;
    }

    public int getId_detalle() {
        return id_detalle;
    }

    public void setId_detalle(int id_detalle) {
        this.id_detalle = id_detalle;
    }

    public int getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public double getValorAbonado() {
        return valorAbonado;
    }

    public void setValorAbonado(double valorAbonado) {
        this.valorAbonado = valorAbonado;
    }

    public Date getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(Date fecha_pago) {
        this.fecha_pago = fecha_pago;
    }
    
    
    
}
