package com.Employee.Service;

import com.Employee.Entity.Employee;
import com.Employee.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDetailsSaveService {

    @Autowired
    private
    EmployeeRepository employeeRepository;

    public void postEmployeeDetails(String firstName, String lastName) {
        Employee emp = new Employee();
        emp.setFirstName(firstName);
        emp.setLastName(lastName);
        employeeRepository.save(emp);
    }
}
