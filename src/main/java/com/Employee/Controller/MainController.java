package com.Employee.Controller;

import com.Employee.Service.AddressDetailsSaveService;
import com.Employee.Service.EmployeeDetailsSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


@RestController  // This means that this class is a Controller
@RequestMapping(path = "/employee")// This means URL's start with /employee (after Application path)
public class MainController {

    @Autowired
    private EmployeeDetailsSaveService employeeDetailsSaveService;
    @Autowired
    private AddressDetailsSaveService addressDetailsSaveService;

    @PostMapping(path = "/addName")
    public @ResponseBody
    String addNewUser(@RequestParam String firstName, @RequestParam String lastName) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        employeeDetailsSaveService.postEmployeeDetails(firstName, lastName);
        return "Accounts Saved";
    }

    @PostMapping(path = "/addAddress")
    public @ResponseBody
    void addNewAddress(@RequestBody Map<String, Object>[] payload)
    // String addNewAddress(@RequestParam String street, @RequestParam String city, @RequestParam String state, @RequestParam long empid)
    {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        //addressDetailsSaveService.postAddressDetails(street, city, state, empid);
        //return "address saved";
        System.out.println(Arrays.toString(payload));

    }

    // JSON Input
    // JSON Input Validation (Binding)
    // Aspect (Advice for exception Handling)
    // Logging in ProperFormat (MDC Config)
    // Response Senarios (200,404,500,400)
    // Unit testcase using SPoc or Junit
    // Folder Struture


//
////    @GetMapping(path = "/all")
////    public @ResponseBody
////    Iterable<Employee> getAllUsers() {
////           // This returns a JSON or XML with the users
////
////       return employeeRepository.findAll();
////    }
}