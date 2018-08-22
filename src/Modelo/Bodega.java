/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Johan Sánchez
 */
public class Bodega {
    //idBodega va a decir en que zona de la bodega se encuentra
  private int idBodega, idinventario;

    public Bodega(int idBodega, int idinventario) {
        this.idBodega = idBodega;
        this.idinventario = idinventario;
    }

    public int getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(int idBodega) {
        this.idBodega = idBodega;
    }

    public int getIdinventario() {
        return idinventario;
    }

    public void setIdinventario(int idinventario) {
        this.idinventario = idinventario;
    }
  
}
