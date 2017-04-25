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
public class OrdenarRadix extends OrdenadorService{

    @Override
    public ArregloDied ordenar(ArregloDied arrDesordenado) {
        arregloOrdenado = arrDesordenado.clonar();
        arregloOrdenado.inicializarContadores();
        Integer i;
        long max = arrDesordenado.get(0).valorOrdenamiento();
        long peso = 1;
        
        for(i=1;i<arregloOrdenado.tamanio();i++){
                //de acá tenemos que sacar el maximo del arrreglo
              if(arregloOrdenado.get(i).valorOrdenamiento().intValue()>max){
                  max=arregloOrdenado.get(i).valorOrdenamiento();
                  arregloOrdenado.mayor(0, 0);
                }
            }
        
        while (max / peso > 0){
            ColaDied[] aux1 = new ColaDied[10];
            for(i=0; i<10; i++){
                aux1[i] = new ColaDied(arregloOrdenado.tamanio());
            }
            for (i = 0; i < arregloOrdenado.tamanio(); i++){
                long d = (arregloOrdenado.get(i).valorOrdenamiento()/peso)%10;
                arregloOrdenado.mayor(0, 0);
                aux1[(int)d].enqueue(arregloOrdenado.get(i));             
            }
            int j=0;
            for (i = 0; i < 10; i++){ 
                while(!aux1[i].isEmpty()){
                    arregloOrdenado.agregarEnPosicion(j, aux1[i].dequeue());
                    j++;
                    }
                }
            peso *= 10;        

        }
        return arregloOrdenado;
    
    }
}

