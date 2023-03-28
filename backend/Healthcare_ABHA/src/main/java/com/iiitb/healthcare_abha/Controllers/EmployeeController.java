package com.iiitb.healthcare_abha.Controllers;

import com.iiitb.healthcare_abha.DAO.EmployeeRepository;
import com.iiitb.healthcare_abha.model.Employee;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Data
@Controller
@RequestMapping("/api/v1/")
@CrossOrigin(maxAge = 3600)
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    //get all employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees()
    {
        return employeeRepository.findAll();
    }

    //create employee
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee)
    {
        return employeeRepository.save(employee);
    }

    //get employee by id
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> GetEmployeeByTd(@PathVariable Long id)
    {
        Employee employee;
        employee = employeeRepository.findByEid(id);//.orElseThrow(()-> new ResourceNotFoundException("Employee dont exist with id"+id));
        return ResponseEntity.ok(employee);


    }
    //update employee
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee employeeDetails)
    {
        Employee employee;
        employee = employeeRepository.findByEid(id);//.orElseThrow(()-> new ResourceNotFoundException("Employee dont exist with id"+id));
        employee.setAbhaid(employeeDetails.getAbhaid());
       employee.setEmployeeType(employeeDetails.getEmployeeType());
       employee.setAddress(employeeDetails.getAddress());
       employee.setAge(employeeDetails.getAge());
       employee.setDOB(employeeDetails.getDOB());
       employee.setBloodgroup(employee.getBloodgroup());
       employee.setEmail(employeeDetails.getEmail());
       employee.setGender(employeeDetails.getGender());
       employee.setName(employeeDetails.getName());
       employee.setMobileno(employeeDetails.getMobileno());
       employee.setJoiningDate(employeeDetails.getJoiningDate());
       employee.setPassword(employee.getPassword());

       Employee updatedEmployee=employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);

    }

    //delete employee
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Long id)
    {
        Employee employee;
        employee = employeeRepository.findByEid(id);//.orElseThrow(()-> new ResourceNotFoundException("Employee dont exist with id"+id));
        employeeRepository.delete(employee);
        Map<String,Boolean> response=new HashMap<>();
        response.put("Deleted record Successfully",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
