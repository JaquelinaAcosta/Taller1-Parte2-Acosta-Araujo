/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.tp.modelo;

import java.util.Date;

/**
 *
 * @author mdominguez
 */
public class Libro extends MaterialCapacitacion{
    private Double costo;
    private String isbn;
    private Integer paginas;
    
    public Libro() {
    }   
    
    public Libro(String titulo,Double costo,String isbn,Integer pagina) {
        super(titulo);
        this.costo=costo;
        this.isbn= isbn;
        this.paginas=pagina;
        this.estado=EstadoPromocion.ACCESO_TEMPRANO;
    } 

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    public Date getFechaPublicacion(){
        return this.fechaPublicacion;
    }
        
    public void publicar(Date fechaEspecifica){
        this.estado = EstadoPromocion.LANZAMIENTO;
        this.fechaPublicacion = fechaEspecifica;
    }
    
    @Override
    public Double precio(){
        
    
          if(this.estado==EstadoPromocion.REGULAR)
                return(costo+((costo*3)/100)*(this.paginas/150));
               
            if(this.estado==EstadoPromocion.ACCESO_TEMPRANO)
                return((costo+((costo*3)/100)*(this.paginas/150))*0.9);
                
            if(this.estado==EstadoPromocion.LANZAMIENTO)
                return((costo+((costo*3)/100)*(this.paginas/150))*1.2);
               
            if(this.estado==EstadoPromocion.OFERTA)
                return(costo*0.8);
        return null;
                   
      
    }
          
    @Override
    public void liquidar() {
        // implementar!!!!
        this.estado=EstadoPromocion.OFERTA;
    }

    public void suscribir(){
       super.suscribir();
       
    if((super.suscripciones()) >1){
        this.estado=EstadoPromocion.REGULAR;
    }

    
    
}
}