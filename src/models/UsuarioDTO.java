/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Sulay2016
 */
public class UsuarioDTO {
    public String nombre;
    public String cedula;
    public String telefono;
    public String direccion;
    public String usuario;
    public String password;
    
    //1 administrador, 2 cajero
    public Integer perfil;
    
}
