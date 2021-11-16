/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package genaro.choice;

import java.util.Arrays;

import io.helidon.webserver.Routing;
import io.helidon.webserver.ServerConfiguration;
import io.helidon.webserver.WebServer;

import java.net.InetAddress;
import java.net.UnknownHostException;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author felipegenaro
 */
public class ShopApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Welcome to Genaro Choice Shop");
        
        Customer c1 = new Customer("Pinky", 4);
        
        System.out.println("Where the Min Price is $" + Clothing.MIN_PRICE);
        
        Clothing item1 = new Clothing("Blue Jacket", 20.9, "M");
        Clothing item2 = new Clothing("Orange T-Shirt", 10.5, "S");
        
        Clothing[] items = {item1, item2, new Clothing("Green Scarf", 5.0, "S"), new Clothing("Blue T-Shirt", 10.5, "S")};
        
        // WebServer
        try {
            ItemList list = new ItemList(items);
            
            ServerConfiguration config = ServerConfiguration.builder().bindAddress(InetAddress.getLocalHost()).port(8888).build();
            
            Routing routing = Routing.builder().get("/items", list).build();
            
            WebServer ws = WebServer.create(config, routing);
            ws.start();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        
        c1.addItems(items);
        
        System.out.println("Customer is " + c1.getName() + ", his size is " + c1.getSize() + "and will pay $" + c1.getTotalClothingCost());
        
        System.out.println("List of products available:");
        for (Clothing item : c1.getItems()) {
            //System.out.println("Item " + item.getDescription() + ", size " + item.getSize() + " - " + item.getPrice());
            System.out.println(item);
        }
       
        // try/catch example
        //
        int average = 0;
        int count = 0;
        
        for (Clothing item : c1.getItems()) {
            if (item.getSize().equals("L")) {
                count++;
                average += item.getPrice();
            }
        }
        try {
            // avoiding the exception
            // average = (count == 0) ? 0 : average / count
            average = average / count;
            System.out.println("Average price " + average + ", Count ");
        } catch (ArithmeticException e) {
            System.out.println("There is no products of the size 'L'...");
        }
        //
        
        Arrays.sort(c1.getItems());
        System.out.println("Sorted list of items of Customer 1:");
        for (Clothing item : c1.getItems()) {
            //System.out.println("Item " + item.getDescription() + ", size " + item.getSize() + " - " + item.getPrice());
            System.out.println(item);
        }
    }
}
