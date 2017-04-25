/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.tp.modelo;

/**
 *
 * @author st
 */
public class Video extends MaterialCapacitacion {

    private String titulo1;
     Double duracion;
     Double costo;
     
     public Video() {
    }   
     public Video(String titulo, Double precio,Double duracion){
         this.titulo1=titulo;
         this.costo=precio;
         this.duracion=duracion;
         this.estado=EstadoPromocion.REGULAR;
     
     }
     
    /**
     *
     * @return 
     */
    @Override
     public String getTitulo(){
         return titulo1;
     }
     public Double getPrecio(){
         return costo;
     }
     
     @Override
    public Double precio(){
    if(this.estado==EstadoPromocion.REGULAR)   
        return (duracion*costo);
     if(this.estado==EstadoPromocion.OFERTA)   
        return ((duracion*costo)/2);
         return 0.00;
     
     }
    

    @Override
    public void liquidar() {
         this.estado=EstadoPromocion.OFERTA;
    }
     
  
    
}
