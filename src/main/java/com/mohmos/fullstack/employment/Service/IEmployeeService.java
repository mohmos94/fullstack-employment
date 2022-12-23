package com.mohmos.fullstack.employment.Service;

import com.mohmos.fullstack.employment.Model.Employee;
import com.mohmos.fullstack.employment.Repository.EmployeeRepository;

import java.util.List;

public interface IEmployeeService {

    List<Employee> findAllEployeeSerivce();
    Boolean employeeExistById(long id);

    Employee addEmployeeService(Employee employee);

    void removeEmployeeService(Long id);

    Employee findEmployeeByEmail(String email);

    Employee saveEmployeeService(Employee employee);
}
