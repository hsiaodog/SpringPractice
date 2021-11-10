package com.billy.springpractice.Controller;

import com.billy.springpractice.Entity.EmployeeDTO;
import com.billy.springpractice.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class EmployeeController {
    private final EmployeeService es;

    @Autowired
    public EmployeeController(EmployeeService es) {
        this.es = es;
    }

    @GetMapping("/employee")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployee() {
        return new ResponseEntity<List<EmployeeDTO>>(es.getAllEmployee(), HttpStatus.OK);
    }
    @GetMapping("/employee/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Integer id) {
        return new ResponseEntity<EmployeeDTO>(es.getEmployeeById(id),HttpStatus.OK);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<?> putEmployeeById(@RequestBody EmployeeDTO employeeDTO, @PathVariable Integer id) {
        try {
            es.updateEmployeeById(employeeDTO, id);
            return new ResponseEntity<EmployeeDTO>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<EmployeeDTO>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<?> putEmployeeById(@PathVariable Integer id) {
        try {
            es.deleteEmployee(id);
            return new ResponseEntity<EmployeeDTO>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<EmployeeDTO>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/employee")
    public ResponseEntity<?> createEmployeeById(@RequestBody EmployeeDTO employeeDTO) {
        es.addEmployee(employeeDTO);
        return new ResponseEntity<EmployeeDTO>(HttpStatus.OK);
    }
//    @ExceptionHandler(.class)
//    public ResponseEntity<?> errorResponse() {
//
//    }
}