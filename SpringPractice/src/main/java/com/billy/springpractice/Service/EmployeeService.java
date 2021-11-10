package com.billy.springpractice.Service;

import com.billy.springpractice.Entity.DepartmentDTO;
import com.billy.springpractice.Entity.EmployeeDTO;
import com.billy.springpractice.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeDTO> getAllEmployee(){
        List<EmployeeDTO> employeeDTOs = (List<EmployeeDTO>) employeeRepository.getAllEmployee();
        return employeeDTOs;
    };
    public EmployeeDTO getEmployeeById(int id) {
        return employeeRepository.getEmployeeById(id);
    };
    public void updateEmployeeById(EmployeeDTO employeeDTO, int employeeId) {
        if (employeeId == employeeDTO.getEmployee_id()) {
            employeeRepository.updateEmployeeDTOById(employeeDTO.getFirst_name(),employeeDTO.getLast_name(),employeeDTO.getAge(),employeeDTO.getDepartment().getDepartment_Id(), employeeId);
        }
    };

    public void deleteEmployee(int employeeId) {
        employeeRepository.deleteById(employeeId);
    };

    public void addEmployee(EmployeeDTO employeeDTO) {
        employeeRepository.save(employeeDTO);
    };
}
