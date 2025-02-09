/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project_delivery;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author uSer
 */
public class Restaurant {
    // server-side
    private Long idRestaurant;
    private String name;
    private String address;
    private List <Menu> menus;
    private List <Pedido> pedidos;

    public Restaurant() {
        this.menus = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }
    
    
    public Long getIdRestaurant() { 
        return idRestaurant; 
    }

    public void setIdRestaurant(Long id) { 
        this.idRestaurant = id; 
    }

    public String getName() { 
        return name; 
    }

    public void setName(String name) { 
        this.name = name; 
    }

    public String getAddress() { 
        return address; 
    }

    public void setAddress(String address) { 
        this.address = address; 
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    
    
    
}

//POST http://localhost:8080/restaurants
/*
    "name" : "A",
    "address" : "A"

    "name" : "B",
    "address" : "B"

    "name" : "C",
    "address" : "C"

    "name": "n",
    "address": "n",
    "menus": [
        {
            "idMenu": null,
            "alimentos": [
                "MANZANA"
            ]
        },
        {
            "idMenu": null,
            "alimentos": [
                "KIWI"
            ]
        }
    ],
    "pedidos": []
*/