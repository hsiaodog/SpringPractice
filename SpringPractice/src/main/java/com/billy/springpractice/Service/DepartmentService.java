package com.billy.springpractice.Service;

import com.billy.springpractice.Entity.DepartmentDTO;
import com.billy.springpractice.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    // get department by id
    public DepartmentDTO getDepartmentById(int id) {
        return departmentRepository.getDepartmentById(id);
    }

    //get all
    public List<DepartmentDTO> getAllDepartment() {
        List<DepartmentDTO> departmentDTOs = departmentRepository.getAllDepartment();
        return departmentDTOs;
    }

    // update by id
    public void updateDepartmentById(DepartmentDTO departmentDTO, Integer departmentId) {
        departmentRepository.updateDepartmentDTOById(departmentDTO.getDepartment_Name(),departmentId);
    }

    public void deleteDepartmentById(int departmentId) {
        departmentRepository.deleteDepartmentDTOById(departmentId);
    }

    public void addDepartment(DepartmentDTO departmentDTO){
        departmentRepository.save(departmentDTO);
    }


}
