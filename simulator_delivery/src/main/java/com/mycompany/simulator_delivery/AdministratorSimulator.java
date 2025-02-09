/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulator_delivery;


////////////////////
/// 
/**
 *
 * @author uSer
 */
public class AdministratorSimulator {
    private static final String BASE_URL = "http://localhost:8080/restaurants";
    private static final RequestMethods methods = new RequestMethods();

    public static void main(String[] args) throws Exception {
        
        String restaurant1 = "{\"name\":\"A\","
                           + "\"address\":\"A\"}";
        String restaurant2 = "{\"name\":\"A\","
                           + "\"address\":\"A\"}";
        String restaurant3 = "{\"name\":\"A\","
                           + "\"address\":\"A\"}";
        String restaurant4 = "{\"name\":\"A\","
                           + "\"address\":\"A\"}";
        
        methods.sendPostRequest(BASE_URL, restaurant1);
        methods.sendPostRequest(BASE_URL, restaurant2);
        methods.sendPostRequest(BASE_URL, restaurant3);
        methods.sendPostRequest(BASE_URL, restaurant4);
    
        // Obtener todos los restaurantes
        methods.sendGetRequest(BASE_URL);
        
        // Actualizar un restaurante (ejemplo con ID 3)
        String updatedRestaurant = "{\"name\":\"C_modificado\","
                                    + "\"address\":\"C_modificado\"}";
        methods.sendPutRequest(BASE_URL + "/3", updatedRestaurant);
        
        
        // Eliminar un restaurante (ejemplo con ID 4)
        methods.sendDeleteRequest(BASE_URL + "/4");
        
        // Obtener todos los restaurantes
        methods.sendGetRequest(BASE_URL);
        
        ////////////////////////////////////////////////////////////////////////
       
        // Crear nuevos menus
        String menu1 = "{\"alimentos\":[\"MANZANA\",\"PERA\"]}";
        String menu2 = "{\"alimentos\":[\"KIWI\",\"PERA\"]}";
        String menu3 = "{\"alimentos\":[\"BANANA\"]}";
        String menu4 = "{\"alimentos\":[\"MANGO\",\"MANZANA\",\"MANZANA\"]}";
        String menu5 = "{\"alimentos\":[\"UVA\",\"BANANA\"]}";
        String menu6 = "{\"alimentos\":[\"UVA\",\"UVA\"]}";
        String menu7 = "{\"alimentos\":[\"MANZANA\",\"PERA\"]}";
        
                
        methods.sendPostRequest(BASE_URL + "/1/menus", menu1);
        methods.sendPostRequest(BASE_URL + "/1/menus", menu2);
        methods.sendPostRequest(BASE_URL + "/2/menus", menu3);
        methods.sendPostRequest(BASE_URL + "/2/menus", menu4);
        methods.sendPostRequest(BASE_URL + "/3/menus", menu5);
        methods.sendPostRequest(BASE_URL + "/3/menus", menu6);
        methods.sendPostRequest(BASE_URL + "/3/menus", menu7);
        
        
        // Obtener todos los menus del restaurante 3
        methods.sendGetRequest(BASE_URL + "/3/menus");
        
        // Actualizar un restaurante (ejemplo con ID 6)
        String updatedMenu = "{\"alimentos\":[\"BANANA\",\"PERA\"]}";
        methods.sendPutRequest(BASE_URL + "/3/menus/6", updatedMenu);
        
        
        // Eliminar un restaurante (ejemplo con ID 7)
        methods.sendDeleteRequest(BASE_URL + "/3/menus/7");
        
        // Obtener todos los restaurantes
        methods.sendGetRequest(BASE_URL + "/3/menus");
        
        ////////////////////////////////////////////////////////////////////////
        
       
        // Crear nuevos bikers
        String biker1 = "{\"name\" : \"B1\"}";
        String biker2 = "{\"name\" : \"B2\"}";
        String biker3 = "{\"name\" : \"B3\"}";
        String biker4 = "{\"name\" : \"B4\"}";
       
        
                
        methods.sendPostRequest(BASE_URL + "/bikers", biker1);
        methods.sendPostRequest(BASE_URL + "/bikers", biker2);
        methods.sendPostRequest(BASE_URL + "/bikers", biker3);
        methods.sendPostRequest(BASE_URL + "/bikers", biker4);
        
        // Obtener todos los bikers
        methods.sendGetRequest(BASE_URL + "/bikers");
        
        // Actualizar un biker (ejemplo con ID 3)
        String updatedBiker = "{\"name\" : \"B3_modificado\"}";
        methods.sendPutRequest(BASE_URL + "/bikers/3", updatedBiker);
        
        
        // Eliminar un biker (ejemplo con ID 4)
        methods.sendDeleteRequest(BASE_URL + "/bikers/4");
        
        // Obtener todos los bikers
        methods.sendGetRequest(BASE_URL + "/bikers");
        
        ////////////////////////////////////////////////////////////////////////
        
        
    }
    
}
