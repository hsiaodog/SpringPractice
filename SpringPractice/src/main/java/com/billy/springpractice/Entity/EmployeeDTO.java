package com.billy.springpractice.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Employees")
public class EmployeeDTO {
    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employee_id;

    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "age")
    private int age;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private DepartmentDTO department;

    @Override
    public String toString() {
        return String.format("Employee [EmployeeID = %d, Full Name = %s %s, Age = %d, Department_ID = %d ]", employee_id, first_name, last_name, age, department);
    }
}
