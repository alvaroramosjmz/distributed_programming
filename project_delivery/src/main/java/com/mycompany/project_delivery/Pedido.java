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
public class Pedido {
    private Long idPedido;
    private List<Integer> idMenus;
    private Estado estado;
    private Long biker;

    // Constructores

    public Pedido() {
    }
    
    
    public Pedido(Long id, List<Integer> idMenus) {
        this.idPedido = id;
        this.idMenus = idMenus;
        this.estado = Estado.ACCEPTED;
        this.biker = 0L;
    }

    public Long getBiker() {
        return biker;
    }

    public void setBiker(Long biker) {
        this.biker = biker;
    }
    
    
    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long id) {
        this.idPedido = id;
    }

    public List<Integer> getIdMenus() {
        return idMenus;
    }

    public void setIdMenus(List<Integer> idMenus) {
        this.idMenus = idMenus;
    }
    
    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}

//POST http://localhost:8080/restaurants/{idRestaurant}/pedidos
/*
    "idMenus" : [1]

    "idMenus" : [2]
    
*/
