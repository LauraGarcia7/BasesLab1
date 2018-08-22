/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author Johan Sánchez
 */
class Producto {
    private String nombre;
    private int codigo, cantidad;
    private double precio;
    private int codigoBarra;
    private Date entrada, cadusidad;
    private String proveedor;
    private double precioUnitario;
    private int estado;// 0->No hay, 1-> Hay, -1->Esta en bodega

    public Producto() {
    }

    public Producto(String nombre, int codigo, int cantidad, double precio, int codigoBarra, Date entrada, Date cadusidad, String proveedor, double precioUnitario, int estado) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.precio = precio;
        this.codigoBarra = codigoBarra;
        this.entrada = entrada;
        this.cadusidad = cadusidad;
        this.proveedor = proveedor;
        this.precioUnitario = precioUnitario;
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(int codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public Date getEntrada() {
        return entrada;
    }

    public void setEntrada(Date entrada) {
        this.entrada = entrada;
    }

    public Date getCadusidad() {
        return cadusidad;
    }

    public void setCadusidad(Date cadusidad) {
        this.cadusidad = cadusidad;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
}
