package com.mohmos.fullstack.employment.Service;

import com.mohmos.fullstack.employment.Model.Employee;
import com.mohmos.fullstack.employment.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAllEployeeSerivce() {

        return employeeRepository.findAll();
    }

    public Boolean existsEmployeeByEmail(String mail){
       return employeeRepository.existsEmployeeByEmail(mail);
    }

    public Employee findEmployeeById(long id){
        return employeeRepository.findEmployeeById(id);
    }

    @Override
    public Boolean employeeExistById(long id) {
        return employeeRepository.existsById(id);
    }



    @Override
    public Employee addEmployeeService(Employee employee) {
        return employeeRepository.save(employee);
    }


    @Override
    public void removeEmployeeService(Long id) {
     employeeRepository.deleteById(id);

    }

    @Override
    public Employee findEmployeeByEmail(String email){
        return employeeRepository.findEmployeeByEmail(email);
    }

    @Override
    public Employee saveEmployeeService(Employee employee) {
        return employeeRepository.save(employee);
    }
}
