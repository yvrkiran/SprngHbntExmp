package com.Employee.Repositories;

import com.Employee.Entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

   }