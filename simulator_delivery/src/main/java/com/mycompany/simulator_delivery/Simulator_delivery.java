/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.simulator_delivery;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


/**
 *
 * @author uSer
 */
public class Simulator_delivery {
    
    private static final String BASE_URL = "http://localhost:8080/restaurants";
    private static final RequestMethods methods = new RequestMethods();
    private static final Map<Long, String> pedidoEstados = new HashMap<>();
    
    public static void main(String[] args) throws Exception {
       
        // Crear 4 pedidos
        for (int i = 0; i < 4; i++) {
            String nuevoPedido = "{\"idMenus\": [1, 2]}";
            Long pedidoId = methods.sendPostRequestIdPedido(BASE_URL + "/1/pedidos", nuevoPedido);
            if (pedidoId != null) {
                pedidoEstados.put(pedidoId, "ACCEPTED"); // Estado inicial asumido
                System.out.println("Pedido creado con ID: " + pedidoId);
            }
        }
        
         // Monitorear cambios de estado en los pedidos
        while (!pedidoEstados.isEmpty()) {
            for (Long pedidoId : pedidoEstados.keySet()) {
                String nuevoEstado = methods.checkPedidoEstado(BASE_URL + "/1/pedidos/" + pedidoId);
                if (nuevoEstado != null && !nuevoEstado.equals(pedidoEstados.get(pedidoId))) {
                    System.out.println("Pedido " + pedidoId + " ha cambiado de estado: " + nuevoEstado);
                    pedidoEstados.put(pedidoId, nuevoEstado);

                    if ("DELIVERING".equals(nuevoEstado)) {
                        Long idBiker = methods.checkPedidoBiker(BASE_URL + "/1/pedidos/" + pedidoId);
                        System.out.println("Pedido " + pedidoId + " ha sido recogido por el biker: " + idBiker);
                    }
                }
            }
            TimeUnit.SECONDS.sleep(5); // Consultar cada 5 segundos
            
        }
        
    }
}
