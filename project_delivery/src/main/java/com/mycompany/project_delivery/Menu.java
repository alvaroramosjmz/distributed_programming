/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project_delivery;

import java.util.List;
/**
 *
 * @author uSer
 */
public class Menu {
     // server-side
    private Long idMenu;
    private List<Alimento> alimentos;

    // Constructor
    public Menu(){
    }
    public Menu(Long id, List<Alimento> alimento) {
        this.idMenu = id;
        this.alimentos = alimento;
    }
    
    public Long getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Long id) {
        this.idMenu = id;
    }

    public List<Alimento> getAlimentos() {
        return alimentos;
    }

    public void setAlimentos(List<Alimento> frutas) {
        this.alimentos = frutas;
    }
}

//POST http://localhost:8080/restaurants/{idRestaurant}/menus
/*
    "alimentos" : ["MANZANA", "PERA"]

    "alimentos" : ["KIWI"]
    
     "alimentos" : ["BANANA"]
    
*/