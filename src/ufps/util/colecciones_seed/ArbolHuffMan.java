/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufps.util.colecciones_seed;

import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 *
 * @author madarme
 */
public class ArbolHuffMan {
    
    private NodoHuffman raiz;
    private String cadena;
    
    
    public ArbolHuffMan() {
        raiz = null;
    }

    public ArbolHuffMan(NodoHuffman raizArbol) {
        this.raiz = raizArbol;
    }

    public ArbolHuffMan(String cadena) {
        this.cadena = cadena;
    }
    
    public NodoHuffman getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoHuffman raiz) {
        this.raiz = raiz;
    }
    
    
    
    /**
     * Dada una cadena que se paso como atributo de la clase, 
     * se crea el árbol y retorna la secuencia de pasos.
     * Ejemplo:
     * cadena= SISTEMAS
     * Retornaría:
     * Paso Frecuencia:  (S,3)->(I,1)->(T,1)->(E,1)->(M,1)->(A,1)->null
        Ordenar Frecuencia:  (I,1)->(T,1)->(E,1)->(M,1)->(A,1)->(S,3)->null
        Paso 1:  (E,1)->(M,1)->(A,1)->((null,2),((I,1)->(T,1)))->(S,3)->null
        Paso 2:  (A,1)->(( null,2)->((I,1)->(T,1))->((2, null), (E,1)->(M,1))->(S,3)-> null
        Paso 3:  ((null, 2), (E,1)->(M,1))->(S,3)->((null,3),(A,1)->(( null,2)->((I,1)->(T,1))-> null
        Paso 4:  ((null,3),(A,1)->(( null,2)->((I,1)->(T,1))-> ((null,5),((null, 2), ((E,1)->(M,1))->(S,3))-->null
        Paso 5:  (null, 8),((null,3),(A,1)->(( null,2)->((I,1)->(T,1))-> ((null,5),((null, 2), ((E,1)->(M,1))->(S,3))-->null
     * 
     * @return un String con la secuencia de pasos.
     */
    public String crear()
    {
    
        return ":)";
    }
    
    /**
     * Obtiene en una cadena todas las ramas del árbol.
     * Ejemplo: 
     * Si cadena= "SISTEMAS".
     * El String generado sería:
     *  Rama 1: (null, 8)- (null,3) -(A,1)
        Rama 2: (null, 8)-(null,3)-(null,2)-(I,1)
        Rama 3: (null, 8)-(null,3)-(null,2)-(T,1)
        Rama 4: (null, 8)-(null,5)-(null,2)-(E,1)
        Rama 5: (null, 8)-(null,5)-(null,2)-(M,1)
        Rama 6: (null, 8)-(null,5)-(S,3)

     * @return un String con las ramas del árbol generado
     */
    public String getRamas()
    {
        return ":)";
    }
    
    /**
     * Obtiene la codificaciòn representada en el árbol con la cadena que se pasa como argumento
     * Ejemplo: Si cadena="SISTEMAS"
     * El String generado sería:
     * S :  11
       I :  010
       T :  011
       E :  100
       M :  101
       A :  00
       SISTEMAS: 11010110111010011
     * @return un String con la codificación de la palabra
     */
    public String getCodificación()
    {
        return "";
    }
    
    
    
    
    //--------------------------------------
    //          metodos Nuevos
    
    
    
    /*
    Metodo que devuelve un mapa con las letras y la cantidad 
    de veces que se encuentra en la cadena, se usa LinkedHashmap
    para mantener el orden de insercion.
    */
    public LinkedHashMap cantidadLetrasRep() {
        LinkedHashMap<Character, Integer> mapa = new LinkedHashMap<>();
        for (int i = 0; i < cadena.length(); i++) {
            if(mapa.get(cadena.charAt(i)) != null){
                mapa.put(cadena.charAt(i), mapa.get(cadena.charAt(i))+1);
            }else{
                mapa.put(cadena.charAt(i), 1);
            } 
        }
        //System.out.println("MAPA: " + mapa);
        return mapa;
    }
    
    public ListaS cuentaLetras2() {
        ListaS la = new ListaS();
        LinkedHashMap<Character, Integer> x = this.cantidadLetrasRep();
        for (char clave : x.keySet()) {
               NodoHuffman nuevo = new NodoHuffman(clave, x.get(clave));
               la.insertarOrdenado(nuevo);
               System.out.println("letra: " + clave + " - cant: " + x.get(clave));
        }
        
//        Iterator<NodoHuffman> it =la.iterator();
//        while(it.hasNext()){
//            NodoHuffman t = it.next();
//            System.out.println("letra: " + t.getLetra() + " - Repeticion: " + t.getRepeticion());            
//        }                     
        
        return la;
    }   
    
    public ListaS juntaNodo(ListaS l) {
        Nodo<ArbolHuffMan> aux = l.getCabeza();
        
        Nodo<ArbolHuffMan> aux2 = null;
        while ((aux != null) && (aux.getSig() != null)) {
            l.setCabeza(aux.getSig());
            aux.setSig(null);
            aux2 = l.getCabeza();
            l.setCabeza(aux2.getSig());
            aux2.setSig(null);
            NodoHuffman nuevo = this.uneNodos(aux, aux2);
            //Arbol a = new Arbol(nuevo);
            l.insertarOrdenado(nuevo);
            aux = l.getCabeza();
        }
		// Arbol a=l.getInicio().getDato();
        // a.enOrder(a.getRaiz());
        // a.encuentraCamino(a.getRaiz(), "");
        // System.out.println("dato: "+l.getInicio().getDato().getRaiz().getDato());
        // System.out.println("letra: "+l.getInicio().getDato().getRaiz().getLetra());
        return l;
    }
    
       public NodoHuffman uneNodos(Nodo<ArbolHuffMan> a, Nodo<ArbolHuffMan> b) {
        NodoHuffman c = new NodoHuffman('\u0000',((a.getInfo().getRaiz().getRepeticion()) + (b.getInfo().getRaiz().getRepeticion())));
        c.setIzquierdo(a.getInfo().getRaiz());
        c.setDerecho(b.getInfo().getRaiz());
        //System.out.println("arbol: " + c.toString());
        return c;
    }
    
}
