/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufps.util.colecciones_seed;

/**
 *
 * @author madar
 */
public class NodoHuffman implements Comparable{
    
    private char letra;
    private int repeticion;
    NodoHuffman izquierdo;
    NodoHuffman derecho;

    public NodoHuffman(char letra, int repeticion, NodoHuffman izquierdo, NodoHuffman derecho) {
        this.letra = letra;
        this.repeticion = repeticion;
        this.izquierdo = izquierdo;
        this.derecho = derecho;
    }
    
    
    public NodoHuffman(char letra, int repeticion){
        this.letra = letra;
        this.repeticion = repeticion;
        this.derecho = null;
        this.izquierdo = null;
    }

    
    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public int getRepeticion() {
        return repeticion;
    }

    public void setRepeticion(int repeticion) {
        this.repeticion = repeticion;
    }

    public NodoHuffman getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoHuffman izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoHuffman getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoHuffman derecho) {
        this.derecho = derecho;
    }

    @Override
    public int compareTo(Object arg) {
        NodoHuffman other = (NodoHuffman) arg;

        if (this.repeticion == other.repeticion) {
            return this.letra - other.letra;
        } else {
            return this.repeticion - other.repeticion;
        }
    }
    
    
    
}
