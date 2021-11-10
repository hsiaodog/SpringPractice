package com.billy.springpractice.Entity;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "departments")
public class DepartmentDTO {
    @Id
    @Column(name = "department_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int department_Id;

    @Column(name = "department_name")
    private String department_Name;

    @Override
    public String toString() {
        return String.format("Departments [DepartmentID = %d, DepartmentName = %s]", department_Id, department_Name);
    }
}
