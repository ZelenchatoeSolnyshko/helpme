package org.softwaretechnologies;

import org.softwaretechnologies.employee.Employee;
import org.softwaretechnologies.employee.EmployeeType;


import java.util.ArrayList;
import java.util.List;

public class Company {
    private final String name;
    private final List<Employee> employeeList;

    public Company(String name) {
        this.name = name;
        this.employeeList = new ArrayList<>();
    }

    public void addEmployee(String name, int baseSalary, EmployeeType type) {
        employeeList.add(EmployeeFactory.create(name, baseSalary,type));
    }

    public int getMonthSalary(int month) {
        int sum = 0;
        for (Employee e:employeeList){
            sum += e.getMonthSalary(month);
        }

        return sum;
    }

    public String getName() {
        return name;
    }
}
