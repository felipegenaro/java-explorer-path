/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hr.api;

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
public class HumanResourcesAPI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Employee e1 = new Employee(110, "Jerry", 45500.0);
        Employee e2 = new Employee(220, "Gracie", 35500.0);
        
        Department dept = new Department("Sales");
        
        dept.addEmpl(e1);
        dept.addEmpl(e2);
        dept.addEmpl(new Employee(330, "Jack", 55500.0));
        
        Employee[] empls = dept.getEmployees();
        
        // WebServer
        try {
            EmployeeList list = new EmployeeList(empls);
            
            ServerConfiguration config = ServerConfiguration.builder().bindAddress(InetAddress.getLocalHost()).port(8888).build();
            
            Routing routing = Routing.builder().get("/employees", list).build();
            
            WebServer ws = WebServer.create(config, routing);
            ws.start();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        
        for(Employee empl : empls) {
            System.out.println(empl);
        }
        
        System.out.println("Total Amount of Salaries: " + dept.getTotalSalary());
        System.out.println("Average of Salaries: " + dept.getAverageSalary());
    }
    
}
