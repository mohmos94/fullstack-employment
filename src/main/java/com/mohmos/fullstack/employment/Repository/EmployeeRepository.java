package com.mohmos.fullstack.employment.Repository;

import com.mohmos.fullstack.employment.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Boolean existsEmployeeByEmail(String email);
    Employee findEmployeeByEmail(String email);
    Employee findEmployeeById(long id);


}
