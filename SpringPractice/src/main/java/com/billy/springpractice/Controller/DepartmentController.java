package com.billy.springpractice.Controller;

import com.billy.springpractice.Entity.DepartmentDTO;
import com.billy.springpractice.Entity.EmployeeDTO;
import com.billy.springpractice.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class DepartmentController {

    private DepartmentService ds;
    @Autowired
    public DepartmentController(DepartmentService ds) {
        this.ds = ds;
    }

    @GetMapping("/department")
    public ResponseEntity<List<DepartmentDTO>> getAllEmployee() {
        return new ResponseEntity<>(ds.getAllDepartment(), HttpStatus.OK);
    }
    @GetMapping("/department/{id}")
    public ResponseEntity<DepartmentDTO> getEmployeeById(@PathVariable Integer id) {
        return new ResponseEntity<>(ds.getDepartmentById(id),HttpStatus.OK);
    }
    @PutMapping("/department/{departmentId}")
    public ResponseEntity<DepartmentDTO> updateDepartmentById(@RequestBody DepartmentDTO departmentDTO, @PathVariable Integer departmentId) {
        try {
            ds.updateDepartmentById(departmentDTO,departmentId);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    @PostMapping("/department")
    public ResponseEntity<?> createDepartmentById(@RequestBody DepartmentDTO departmentDTO) {
        ds.addDepartment(departmentDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/department/{id}")
    public ResponseEntity<?> deleteDepartmentById(@PathVariable Integer id) {
        try {
            ds.deleteDepartmentById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
