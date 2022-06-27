/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufps.vistas;

import ufps.util.colecciones_seed.ArbolHuffMan;
import ufps.util.colecciones_seed.ListaS;

/**
 *
 * @author Acer
 */
public class Test_examen {
    
    
    public static void main(String[] args) {
        ArbolHuffMan arbol = new ArbolHuffMan("sistemas");
        //arbol.cantidadLetrasRep();
        ListaS x = arbol.cuentaLetras2();
        arbol.juntaNodo(x);
    }
    
}
