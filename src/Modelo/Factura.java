/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Johan Sánchez
 */
public class Factura implements  Serializable{
    private int efectivoResibido, cambio;
    private Date fechaFactura;
    private double impuesto;
    private Cliente miCl;

    public Factura(int efectivoResibido, int cambio, Date fechaFactura, double impuesto, Cliente miCl) {
        this.efectivoResibido = efectivoResibido;
        this.cambio = cambio;
        this.fechaFactura = fechaFactura;
        this.impuesto = impuesto;
        this.miCl = miCl;
    }

    public int getEfectivoResibido() {
        return efectivoResibido;
    }

    public void setEfectivoResibido(int efectivoResibido) {
        this.efectivoResibido = efectivoResibido;
    }

    public int getCambio() {
        return cambio;
    }

    public void setCambio(int cambio) {
        this.cambio = cambio;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    public Cliente getMiCl() {
        return miCl;
    }

    public void setMiCl(Cliente miCl) {
        this.miCl = miCl;
    }
    
    
    
}
