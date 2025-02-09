/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project_delivery;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 *
 * @author uSer
 */

@Service
public class RestaurantService {
    private final Map<Long, Restaurant> restaurantStore = new HashMap<>();
    private final AtomicLong nextIdRestaurant = new AtomicLong();
    private final AtomicLong nextIdMenu = new AtomicLong();
    private final AtomicLong nextIdPedido = new AtomicLong();
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    private final Map<Long, Biker> bikerStore = new HashMap<>();
    private final AtomicLong nextIdBiker = new AtomicLong();
    
    
////////////////////////////////////////////////////////////////////////////////    

    
    public List<Restaurant> getAllRestaurants() {
        return new ArrayList<>(restaurantStore.values());
    }

    public Optional<Restaurant> getRestaurantByIdRestaurant(Long idRestaurant) {
        return Optional.ofNullable(restaurantStore.get(idRestaurant));
    }

    public Restaurant createRestaurant(Restaurant restaurant) {
        restaurant.setIdRestaurant(nextIdRestaurant.incrementAndGet());
        restaurantStore.put(restaurant.getIdRestaurant(), restaurant);
        return restaurant;
    }

    public void deleteRestaurantByIdRestaurant(Long idRestaurant) {
        restaurantStore.remove(idRestaurant);
    }
    
    public Optional<Restaurant> updateRestaurant(Long idRestaurant, Restaurant updatedRestaurant) {
        if (restaurantStore.containsKey(idRestaurant)) {
            updatedRestaurant.setIdRestaurant(idRestaurant);
            restaurantStore.put(idRestaurant, updatedRestaurant);
            return Optional.of(updatedRestaurant);
        }
        return Optional.empty();
    }
    
    
////////////////////////////////////////////////////////////////////////////////    
    
    
    public Menu createMenu(Long idRestaurant, Menu menu) {
        Restaurant restaurant = restaurantStore.get(idRestaurant);
        
        menu.setIdMenu(nextIdMenu.incrementAndGet());
        List<Menu> menus = restaurant.getMenus();
        menus.add(menu);
        restaurant.setMenus(menus);
        return menu;
    }
    
    public List<Menu> getAllMenus(Long idRestaurant) {
        return new ArrayList<>(restaurantStore.get(idRestaurant).getMenus());
    }
    
    public Optional<Menu> getMenuByIdMenu(Long idRestaurant, Long idMenu) {
        List<Menu> menus = restaurantStore.get(idRestaurant).getMenus();
        Menu menu = new Menu();
        for(Menu i : menus){
            if (i.getIdMenu() == idMenu){
                menu = i;
            }
        }
        return Optional.ofNullable(menu);
    }
    
    public void deleteMenuByIdMenu(Long idRestaurant, Long idMenu) {
        List<Menu> menus = restaurantStore.get(idRestaurant).getMenus();
        Menu menu = new Menu();
        for(Menu i : menus){
            if (i.getIdMenu() == idMenu){
                menu = i;
                
            }
        }
        menus.remove(menu);
    }
    
    public Optional<Menu> updateMenu(Long idRestaurant, Long idMenu, Menu updatedMenu) {
        Restaurant restaurant = restaurantStore.get(idRestaurant);
        if (restaurant != null) {
            List<Menu> menus = restaurant.getMenus();
            for (int i = 0; i < menus.size(); i++) {
                if (menus.get(i).getIdMenu().equals(idMenu)) {
                    updatedMenu.setIdMenu(idMenu);
                    menus.set(i, updatedMenu);
                    return Optional.of(updatedMenu);
                }
            }
        }
        return Optional.empty();
    }

////////////////////////////////////////////////////////////////////////////////    

    
    public Pedido createPedido(Long idRestaurant, Pedido pedido) {
        Restaurant restaurant = restaurantStore.get(idRestaurant);
        
        pedido.setIdPedido(nextIdPedido.incrementAndGet());
        pedido.setEstado(Estado.PREPARING);
        List<Pedido> pedidos = restaurant.getPedidos();
        pedidos.add(pedido);
        
        restaurant.setPedidos(pedidos);
        
        scheduler.schedule(() -> {
            pedido.setEstado(Estado.READY);
            assignBikerToPedido(pedido);
        }, 10*pedido.getIdMenus().size(), TimeUnit.SECONDS);
         
        return pedido;
    }
    
    public List<Pedido> getAllPedidos(Long idRestaurant) {
        return new ArrayList<>(restaurantStore.get(idRestaurant).getPedidos());
    }
    
    public Optional<Pedido> getPedidoByIdPedido(Long idRestaurant, Long idPedido) {
        List<Pedido> pedidos = restaurantStore.get(idRestaurant).getPedidos();
        Pedido pedido = new Pedido();
        for(Pedido i : pedidos){
            if (i.getIdPedido() == idPedido){
                pedido = i;
            }
        }
        return Optional.ofNullable(pedido);
    }
    
    public void deletePedidoByIdPedido(Long idRestaurant, Long idPedido) {
        List<Pedido> pedidos = restaurantStore.get(idRestaurant).getPedidos();
        Pedido pedido = new Pedido();
        for(Pedido i : pedidos){
            if (i.getIdPedido() == idPedido){
                pedido = i;
            }
        }
        pedidos.remove(pedido);
    }
    
    public Optional<Pedido> updatePedido(Long idRestaurant, Long idPedido, Pedido updatedPedido) {
        Restaurant restaurant = restaurantStore.get(idRestaurant);
        if (restaurant != null) {
            List<Pedido> pedidos = restaurant.getPedidos();
            for (int i = 0; i < pedidos.size(); i++) {
                if (pedidos.get(i).getIdPedido().equals(idPedido)) {
                    updatedPedido.setIdPedido(idPedido);
                    pedidos.set(i, updatedPedido);
                    return Optional.of(updatedPedido);
                }
            }
        }
        return Optional.empty();
    }
    
////////////////////////////////////////////////////////////////////////////////    
    
    public Biker createBiker (Biker biker) {
        biker.setIdBiker(nextIdBiker.incrementAndGet());
        bikerStore.put(biker.getIdBiker(), biker);
        return biker;
    }
    
    
    public List<Biker> getAllBikers() {
        return new ArrayList<>(bikerStore.values());
    }
    
    public Optional<Biker> getBikerByIdBiker(Long idBiker) {
        return Optional.ofNullable(bikerStore.get(idBiker));
    }
    
    public void deleteBikerByIdBiker(Long idBiker) {
        bikerStore.remove(idBiker);
    }
    
    public Optional<Biker> updateBiker(Long idBiker, Biker updatedBiker) {
        if (bikerStore.containsKey(idBiker)) {
            updatedBiker.setIdBiker(idBiker);
            bikerStore.put(idBiker, updatedBiker);
            return Optional.of(updatedBiker);
        }
        return Optional.empty();
    }
     
    
    private void assignBikerToPedido(Pedido pedido) {
        
        Optional<Biker> freeBiker = bikerStore.values().stream()
            .filter(biker -> !biker.isOcupado())
            .findFirst();
        
        if (freeBiker.isPresent()){
            
            Biker biker = freeBiker.get();
            biker.setOcupado(true);
            pedido.setBiker(biker.getIdBiker());
            pedido.setEstado(Estado.DELIVERING);
            System.out.println("Pedido " + pedido.getIdPedido() + " asignado al biker " + biker.getName());

            scheduler.schedule(() -> {
                biker.setOcupado(false);
                pedido.setEstado(Estado.DELIVERED);
                System.out.println("Biker " + biker.getName() + " ahora está libre");
            }, new Random().nextInt(30, 45), TimeUnit.SECONDS);
        }
        else{
            System.out.println("No hay bikers disponibles, reintentando en 5 segundos...");
            scheduler.schedule(() -> assignBikerToPedido(pedido), 5, TimeUnit.SECONDS);
        }
    }
    
    
}
