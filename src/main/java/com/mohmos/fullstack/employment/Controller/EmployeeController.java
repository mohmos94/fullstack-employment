package com.mohmos.fullstack.employment.Controller;

import com.mohmos.fullstack.employment.Model.Employee;
import com.mohmos.fullstack.employment.Repository.EmployeeRepository;
import com.mohmos.fullstack.employment.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/API/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeService employeeService;

    public EmployeeController(EmployeeRepository employeeRepository, EmployeeService employeeService) {
        this.employeeRepository = employeeRepository;
        this.employeeService = employeeService;
    }

    /**
     * Endpoint for returning all the employe
     * @return of database is empty return http 404 or else return http status 302
     */
    @GetMapping("addAll")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        if(employeeService.findAllEployeeSerivce().isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(employeeService.findAllEployeeSerivce(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable(value = "id") long id){
        if(!employeeService.employeeExistById(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(employeeService.findEmployeeById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        if (employeeService.existsEmployeeByEmail(employee.getEmail())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(employeeService.addEmployeeService(employee), HttpStatus.OK);

    }
    @DeleteMapping("/delete/{id}")
    public void removeEmployee(@PathVariable(value = "id") long id){
        if(id >= 1 ) {
            if (!employeeService.employeeExistById(id)) {

                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND
                );
            }
        }
        employeeService.removeEmployeeService(id);
       throw new ResponseStatusException(
               HttpStatus.OK
       );
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(
            @PathVariable(value = "id") long id,
            @RequestBody Employee employe) {
        Employee employeeDB = employeeService.findEmployeeById(id);

        if(employeeService.employeeExistById(id)){
            employeeDB.setFirstName(employe.getFirstName());
            employeeDB.setLastName(employe.getLastName());
            employeeDB.setJobbTittel(employe.getJobbTittel());
            return new ResponseEntity<>(employeeService.saveEmployeeService(employe),HttpStatus.OK);
        }

        return null;
    }
}
