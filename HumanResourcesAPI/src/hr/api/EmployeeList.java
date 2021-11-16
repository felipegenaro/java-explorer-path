/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.api;

import io.helidon.common.http.Http;
import io.helidon.webserver.Handler;
import io.helidon.webserver.ServerRequest;
import io.helidon.webserver.ServerResponse;

/**
 *
 * @author felipegenaro
 */
public class EmployeeList implements Handler {
    private Employee[] empls;
    
    public EmployeeList(Employee[] empls) {
        this.empls = empls;
    }
    
    @Override
    public void accept(ServerRequest req, ServerResponse res) {
        res.status(Http.Status.OK_200);
        
        res.headers().put("Content-Type", "text/plain; charset=UTF-8");
        
        StringBuilder result = new StringBuilder();
        for (Employee item : empls) {
            result.append(item + "\n");
        }
        
        res.send(result);
    }
}
