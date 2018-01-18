package com.Employee.Service;

import com.Employee.Entity.Address;

import com.Employee.Repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressDetailsSaveService {
    @Autowired
    private
    AddressRepository addressRepository;

    public void postAddressDetails(String street, String city, String state, long empid) {
        Address address = new Address();
        address.setStreet(street);
        address.setCity(city);
        address.setState(state);
        address.setEmpid(empid);

        addressRepository.save(address);
    }
}
