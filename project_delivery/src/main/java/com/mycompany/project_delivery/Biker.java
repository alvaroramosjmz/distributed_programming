/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project_delivery;

/**
 *
 * @author uSer
 */
public class Biker {
    private Long idBiker;
    private String name;
    private boolean ocupado;

    public Biker() {
    }
    
    public Biker(Long id, String name) {
        this.idBiker = id;
        this.name = name;
        this.ocupado = false;
    }

    public Long getIdBiker() { 
        return idBiker; 
    }
    public void setIdBiker(Long id){
        this.idBiker = id;
    }
    
    public String getName() { 
        return name; 
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public boolean isOcupado() { 
        return ocupado; 
    }
    public void setOcupado(boolean ocupado) { 
        this.ocupado = ocupado; 
    }
}

//POST http://localhost:8080/restaurants/bikers
/*
    "name" : "B1"

    "name" : "B2"
    
*/