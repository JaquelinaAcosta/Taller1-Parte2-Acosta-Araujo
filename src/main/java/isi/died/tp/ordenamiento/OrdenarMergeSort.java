/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.tp.ordenamiento;

/**
 *
 * @author mdominguez
 */
public class OrdenarMergeSort extends OrdenadorService{

    @Override
    public ArregloDied ordenar(ArregloDied arrDesordenado) {
        ArregloDied temp=new ArregloDied(arrDesordenado.tamanio());
        
       
        arregloOrdenado = arrDesordenado.clonar();
        arregloOrdenado.inicializarContadores();
        long primero=0;
        long ultimo=arregloOrdenado.tamanio()-1;
        mergerSort(arregloOrdenado,primero,ultimo);
        return arregloOrdenado;
      
    }
    static void mergerSort(ArregloDied arreglo,long primero,long ultimo)
    {
       long central;
       if(primero < ultimo){ 
        central=(primero+ultimo)/2;
        mergerSort(arreglo,primero,central);
        mergerSort(arreglo,central+1,ultimo);
        mezcla(arreglo,primero,central,ultimo);
                            }
    }

     // public static void merge(int A[],int izq, int m, int der){
    public static void mezcla(ArregloDied a,long izq,long medio,long der){
        int i, j, k;
        ArregloDied b=new ArregloDied(a.tamanio());
        
        for (i=(int)izq; i<=(int)der; i++){//copia ambas mitades en el array auxiliar
            b.agregarEnPosicion(i,a.get(i));
        }
        i=(int)izq; 
        j=(int)medio+1;
        k=(int)izq;
        while (i<=(int)medio && j<=(int)der){ //copia el siguiente elemento más grande
            if(b.mayorIgual(j, i))
                a.agregarEnPosicion(k++,b.get(i++));
            else
                a.agregarEnPosicion(k++,b.get(j++));
        }
        while (i<=(int)medio){ //copia los elementos que quedan de la
            a.agregarEnPosicion(k++,b.get(i++));
        }
        while (j<=(int)der){ //copia los elementos que quedan de la
            a.agregarEnPosicion(k++,b.get(j++));
        }
        
    }

}  
