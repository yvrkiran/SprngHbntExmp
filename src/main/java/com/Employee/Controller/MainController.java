package com.Employee.Controller;


import com.Employee.Entity.Employee;
import com.Employee.Repositories.EmployeeRepository;
import com.Employee.Service.AddressDetailsSaveService;
import com.Employee.Service.EmployeeDetailsSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController  // This means that this class is a Controller
@RequestMapping(path = "/employee")// This means URL's start with /employee (after Application path)
public class MainController {

    @Autowired
    private EmployeeDetailsSaveService employeeDetailsSaveService;
    @Autowired
    private AddressDetailsSaveService addressDetailsSaveService;
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping(path = "/addName")
    public @ResponseBody
    String addNewUser(@RequestParam String firstName, @RequestParam String lastName) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        employeeDetailsSaveService.postEmployeeDetails(firstName, lastName);
        return "Accounts Saved";
    }

    @PostMapping(path = "/addAddr")
    public @ResponseBody
    String addNewAddr(@RequestParam String street, @RequestParam String city, @RequestParam String state, @RequestParam long empid) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        addressDetailsSaveService.postAddressDetails(street, city, state, empid);
        return "Address Saved";
    }

    // JSON Input
    // JSON Input Validation (Binding)
    // Aspect (Advice for exception Handling)
    // Logging in ProperFormat (MDC Config)
    // Response Senarios (200,404,500,400)
    // Unit testcase using SPoc or Junit
    // Folder Struture


    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Employee> getAllUsers() {
        // This returns a JSON or XML with the users

        return employeeRepository.findAll();
        //return employeeRepository.findById(1);
    }

    @GetMapping(path = "/byId")
    public @ResponseBody
    Optional<Employee> getAUser(@RequestParam long empid) {
        // This returns a JSON or XML with the users

        Optional<Employee> employee = employeeRepository.findById(empid);
        System.out.println(employee.isPresent());
        return employee;

        //return employeeRepository.findById(1);
    }
}