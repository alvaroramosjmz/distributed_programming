/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project_delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author uSer
 */

@RestController
@RequestMapping("/restaurants")

public class RestaurantController {
    private final RestaurantService restaurantService;
    
     @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/{idRestaurant}")
    public ResponseEntity<Restaurant> getRestaurantByIdRestaurant(@PathVariable Long idRestaurant) {
        return restaurantService.getRestaurantByIdRestaurant(idRestaurant)
                .map(restaurant -> new ResponseEntity<>(restaurant, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant) {
        Restaurant createdRestaurant = restaurantService.createRestaurant(restaurant);
        return new ResponseEntity<>(createdRestaurant, HttpStatus.CREATED);
    }

    @DeleteMapping("/{idRestaurant}")
    public ResponseEntity<Void> deleteRestaurantByIdRestaurant(@PathVariable Long idRestaurant) {
        restaurantService.deleteRestaurantByIdRestaurant(idRestaurant);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @PutMapping("/{idRestaurant}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable Long idRestaurant, @RequestBody Restaurant restaurant) {
        return restaurantService.updateRestaurant(idRestaurant, restaurant)
                .map(updatedRestaurant -> new ResponseEntity<>(updatedRestaurant, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
////////////////////////////////////////////////////////////////////////////////    
    
    
    
    
    @GetMapping ("/{idRestaurant}/menus")
    public List<Menu> getAllMenus(@PathVariable Long idRestaurant) {
        return restaurantService.getAllMenus(idRestaurant);
    }

    @GetMapping("/{idRestaurant}/menus/{idMenu}")
    public ResponseEntity<Menu> getMenuByIdMenu(@PathVariable Long idRestaurant, @PathVariable Long idMenu) {
        return restaurantService.getMenuByIdMenu(idRestaurant, idMenu)
                .map(menu -> new ResponseEntity<>(menu, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping ("/{idRestaurant}/menus")
    public ResponseEntity<Menu> createMenu(@PathVariable Long idRestaurant, @RequestBody Menu menu) {
        Menu createdMenu = restaurantService.createMenu(idRestaurant, menu);
        return new ResponseEntity<>(createdMenu, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/{idRestaurant}/menus/{idMenu}")
    public ResponseEntity<Void> deleteMenuByIdMenu(@PathVariable Long idRestaurant, @PathVariable Long idMenu) {
        restaurantService.deleteMenuByIdMenu(idRestaurant, idMenu);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @PutMapping("/{idRestaurant}/menus/{idMenu}")
    public ResponseEntity<Menu> updateMenu(@PathVariable Long idRestaurant, @PathVariable Long idMenu, @RequestBody Menu menu) {
        return restaurantService.updateMenu(idRestaurant, idMenu, menu)
                .map(updatedMenu -> new ResponseEntity<>(updatedMenu, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    
 ////////////////////////////////////////////////////////////////////////////////    

    
    
    @GetMapping ("/{idRestaurant}/pedidos")
    public List<Pedido> getAllPedidos(@PathVariable Long idRestaurant) {
        return restaurantService.getAllPedidos(idRestaurant);
    }

    @GetMapping("/{idRestaurant}/pedidos/{idPedido}")
    public ResponseEntity<Pedido> getPedidoByIdPedido(@PathVariable Long idRestaurant, @PathVariable Long idPedido) {
        return restaurantService.getPedidoByIdPedido(idRestaurant, idPedido)
                .map(pedido -> new ResponseEntity<>(pedido, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping ("/{idRestaurant}/pedidos")
    public ResponseEntity<Pedido> createPedido(@PathVariable Long idRestaurant, @RequestBody Pedido pedido) {
        Pedido createdPedido = restaurantService.createPedido(idRestaurant, pedido);
        return new ResponseEntity<>(createdPedido, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/{idRestaurant}/pedidos/{idPedido}")
    public ResponseEntity<Void> deletePedidoByIdPedido(@PathVariable Long idRestaurant, @PathVariable Long idPedido) {
        restaurantService.deletePedidoByIdPedido(idRestaurant, idPedido);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @PutMapping("/{idRestaurant}/pedidos/{idPedido}")
    public ResponseEntity<Pedido> updatePedido(@PathVariable Long idRestaurant, @PathVariable Long idPedido, @RequestBody Pedido pedido) {
        return restaurantService.updatePedido(idRestaurant, idPedido, pedido)
                .map(updatedPedido -> new ResponseEntity<>(updatedPedido, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
////////////////////////////////////////////////////////////////////////////////    
   
    
    @GetMapping("/bikers")
    public List<Biker> getAllBikers() {
        return restaurantService.getAllBikers();
    }
    
    @GetMapping("/bikers/{idBiker}")
    public ResponseEntity<Biker> getBikerByIdBiker(@PathVariable Long idBiker) {
        return restaurantService.getBikerByIdBiker(idBiker)
                .map(biker -> new ResponseEntity<>(biker, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @PostMapping("/bikers")
    public ResponseEntity<Biker> createBiker(@RequestBody Biker biker) {
        Biker createdBiker = restaurantService.createBiker(biker);
        return new ResponseEntity<>(createdBiker, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/bikers/{idBiker}")
    public ResponseEntity<Void> deleteBikerByIdBiker(@PathVariable Long idBiker) {
        restaurantService.deleteBikerByIdBiker(idBiker);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @PutMapping("/bikers/{idBiker}")
    public ResponseEntity<Biker> updateBiker(@PathVariable Long idBiker, @RequestBody Biker biker) {
        return restaurantService.updateBiker(idBiker, biker)
                .map(updatedBiker -> new ResponseEntity<>(updatedBiker, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    
}
