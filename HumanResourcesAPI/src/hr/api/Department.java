/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.api;

/**
 *
 * @author felipegenaro
 */
public class Department {
    private String name;
    private Employee[] employees = new Employee[10];
    private int lastAddedEmployeeIndex = -1;

    public Department(String aName) {
        name = aName;
    }

    public String getName() {
        return name;
    }

    public void setName(String aName) {
        name = aName;
    }
    
    public String toString() {
        return name;
    }
    
    public void addEmpl(Employee anEmployee) {
        if (lastAddedEmployeeIndex < employees.length) {
            lastAddedEmployeeIndex++;
            employees[lastAddedEmployeeIndex] = anEmployee;
        }
    }
    
    public Employee[] getEmployees() {
        Employee[] actualEmployees = new Employee[lastAddedEmployeeIndex+1];
        
        for(int i=0; i<actualEmployees.length; i++) {
            actualEmployees[i] = employees[i];
        }
        return actualEmployees;
    }
    
    public int getEmployeeCount() {
        return lastAddedEmployeeIndex+1;
    }
    
    public Employee getEmployeeById(int emplId) {
        for(Employee empl : employees) {
            if (empl != null) {
                if (empl.getId() == (emplId)) {
                    return empl;
                }
            }
        }
        return null;
    }
    
    public double getTotalSalary() {
        double totalSalary = 0.0;
        for(int i=0; i<=lastAddedEmployeeIndex; i++) {
            totalSalary += employees[i].getSalary();
        }
        return totalSalary;
    }
    
    public double getAverageSalary() {
        if (lastAddedEmployeeIndex > -1) {
            return getTotalSalary() / (lastAddedEmployeeIndex+1);
        }
        return 0.0;
    }
}
