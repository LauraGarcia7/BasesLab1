/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Johan Sánchez
 */
public class CajaRegistradora {

    private int idCaja,  idVendedor;
    private ComputadorPersonal cP;
    
   // private ArrayList<Producto> productosFactura;

    public CajaRegistradora(int idCaja, int idVendedor, ComputadorPersonal cP) {
        this.idCaja = idCaja;
        this.idVendedor = idVendedor;
        this.cP = cP;
        // this.prroductosFactura = new ArrayList<>();
    }

    //inicializar factura
    public Factura crearFactura(int efectivoResibido, int cambio,double impuesto, Cliente miCL) {
       Factura miFactura = new Factura(efectivoResibido, cambio, new Date(), impuesto, miCL);
return miFactura;
    }

    public int getIdCaja() {
        return idCaja;
    }

    public void setIdCaja(int idCaja) {
        this.idCaja = idCaja;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }
}
