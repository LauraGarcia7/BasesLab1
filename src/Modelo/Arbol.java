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
public abstract class Arbol {

    private Nodo raíz = null;

    private class Nodo {

        private Object datos;
        private Nodo izquierdo;
        private Nodo derecho;

        public Nodo() {
        }
    }

    public static final int CORRECTO = 000;
    public static final int NO_DATOS = 100;
    public static final int YA_EXISTE = 101;
    public static final int NO_EXISTE = 102;

    public Arbol() {
    }

    public abstract int comparar(Object obj1, Object obj2);

    public abstract void procesar(Object obj);

    public Object buscar(Object obj) {
        Nodo actual = raíz;
        int nComp = 0;
        while (actual != null) {
            if ((nComp = comparar(obj, actual.datos)) == 0) {
                return (actual.datos);
            } else if (nComp < 0) {
                actual = actual.izquierdo;
            } else {
                actual = actual.derecho;
            }
        }
        return null;
    }

    public int insertar(Object obj) {
        Nodo último = null, actual = raíz;
        int nComp = 0;
        if (obj == null) {
            return NO_DATOS;
        }

        while (actual != null) {
            if ((nComp = comparar(obj, actual.datos)) == 0) {
                break;
            } else {
                último = actual;
                if (nComp < 0) {
                    actual = actual.izquierdo;
                } else {
                    actual = actual.derecho;
                }
            }
        }
        if (actual == null) {
            Nodo nuevoNodo = new Nodo();
            nuevoNodo.datos = obj;
            nuevoNodo.izquierdo = nuevoNodo.derecho = null;

            if (último == null) {
                raíz = nuevoNodo;
            } else if (nComp < 0) {
                último.izquierdo = nuevoNodo;
            } else {
                último.derecho = nuevoNodo;
            }
            return CORRECTO;
        } else {
            return YA_EXISTE;
        }
    }

    public Object borrar(Object obj) 
    {

        Nodo ultimo = null, actual = raíz;
        Nodo marcado = null, sucesor = null;
        int nAnteriorComp = 0, nComp = 0;

        if (obj == null) 
            return null;
        

        while (actual != null) 
        {
            nAnteriorComp = nComp;
            if ((nComp = comparar(obj, actual.datos)) == 0) 
                break;
             else 
            {
                ultimo = actual;
                if (nComp < 0) 
                    actual = actual.izquierdo;
                else 
                    actual = actual.derecho;
                
            }
        }
//
        if (actual != null) 
        {
            marcado = actual;
            if ((actual.izquierdo == null && actual.derecho == null)) 
                sucesor = null;
            else if (actual.izquierdo == null) 
                    sucesor = actual.derecho;
                 else if (actual.derecho == null) 
                        sucesor = actual.izquierdo;
                    else 
                 {
                        sucesor = actual = actual.derecho;
                        while (actual.izquierdo != null) 
                            actual = actual.izquierdo;
                        
                        marcado.datos = actual.datos;
                        if (actual.derecho == null) 
                            marcado.derecho = null;
                        
                        marcado = actual;
                        ultimo = sucesor;
                        sucesor = actual.derecho;
                    }
//
                    if (ultimo != null) 
                    {
                        if (nAnteriorComp < 0) 
                            ultimo.izquierdo = sucesor;
                        else 
                            ultimo.derecho = sucesor;
                        
                    } else 
                        raíz = sucesor;
                    
                    return marcado.datos;
                }
            
        else
            
        return null;
        
    }

    private void inorden(Nodo r, boolean nodoRaiz) {
        Nodo actual = null;
        if (nodoRaiz) {
            actual = raíz;
        } else {
            actual = r;
            if (actual != null) {

                inorden(actual.izquierdo, false);
                procesar(actual.datos);
                inorden(actual.derecho, false);
            }
        }

    }

    public void inorden() {

        inorden(null, true);
    }
}
