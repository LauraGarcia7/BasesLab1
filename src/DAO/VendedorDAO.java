/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Vendedor;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Johan Sánchez
 */
public class VendedorDAO {

    private RandomAccessFile file;
    private int nregs = 0;
    private int tamañoreg = 0;
    private boolean regsEliminados = false;

    public VendedorDAO(File fichero) throws IOException {
        if (fichero.exists() && !fichero.isFile()) {
            throw new IOException(fichero.getName() + "no es un fichero");
        }
        file = new RandomAccessFile(fichero, "rw");
        nregs = (int) Math.ceil((double) file.length() / (double) tamañoreg);
    }

    public void cerrarFichero() throws IOException {
        file.close();
    }

    public int numeroDeRegs() {
        return nregs;
    }

    public boolean escribirReg(int i, Vendedor vendedor) throws IOException {
        if (i >= 0 && i <= nregs) {
            file.seek(i * tamañoreg);
            // public Vendedor(int idVendedor, int id, String nombre, int telefono, String correo) {
            file.writeInt(vendedor.getIdVendedor());
            file.writeInt(vendedor.getContraseña());
            file.writeInt(vendedor.getId());
            for (int j = 0; j < vendedor.getNombre().length(); j++) {
                file.writeChar(vendedor.getNombre().charAt(j));
            }
            file.writeInt(vendedor.getTelefono());
            for (int j = 0; j < vendedor.getCorreo().length(); j++) {
                file.writeChar(vendedor.getCorreo().charAt(j));
            }
            this.tamañoreg = (int) file.length();
            return true;
        }
        return false;
    }

    public Vendedor leerReg(int i) throws IOException {
        if (i >= 0 && i < nregs) {
            file.seek(i * tamañoreg);
            int idVendedor = file.readInt();
            int contraseña = file.readInt();
            int id = file.readInt();
            String nombre = "";
            for (int j = 0; j < 20; j++) {
                nombre = nombre + file.readChar();
            }

            int telefono = file.readInt();
            String correo = "";
            for (int j = 0; j < 20; j++) {
                correo = correo + file.readChar();
            }
            return new Vendedor(idVendedor,contraseña, id, nombre, telefono, correo);
        }
        System.out.println("Numero de registro fuera de limites");
        return null;
    }

    public void añadirReg(Vendedor vendedor) throws IOException {
        if (escribirReg(nregs, vendedor)) {
            nregs++;
        }
    }

    public boolean eliminarReg(int id) throws IOException {
        Vendedor vendedor;
        for (int i = 0; i < nregs; i++) {
            vendedor = leerReg(i);
            if (vendedor.getIdVendedor() == id) {
                vendedor.setId(0);
                escribirReg(i, vendedor);
                regsEliminados = true;
                return true;
            }
        }
        return false;
    }

    public boolean tieneRegseliminados() {
        return regsEliminados;
    }

    public int buscarReg(int id, int pos) throws IOException {
        Vendedor vendedor;
        int idVendedor;
        if (id == 0) {
            return -1;
        }
        if (pos < 0) {
            pos = 0;
        }
        for (int i = 0; i < nregs; i++) {
            vendedor = leerReg(i);
            idVendedor = vendedor.getIdVendedor();
            if (id == idVendedor) {
                return i;
            }

        }
        return -1;

    }

}
