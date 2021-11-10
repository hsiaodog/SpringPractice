package com.billy.springpractice.Repository;

import com.billy.springpractice.Entity.DepartmentDTO;
import com.billy.springpractice.Entity.EmployeeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDTO, Integer> {
    @Query(value = "select * from Employees", nativeQuery = true)
    public List<EmployeeDTO> getAllEmployee();

    //@Query("select d from EmployeeDTO d where d.Employee_Id = :id")
    @Query(value = "select * from Employees where Employee_id = :id", nativeQuery = true)
    public EmployeeDTO getEmployeeById(@Param("id") int EmployeeId);

    @Modifying
    @Transactional
    @Query(value = "delete from Employees where Employee_id = :id", nativeQuery = true)
    public void deleteEmployeeDTOById(@Param("id") int EmployeeId);

    @Modifying
    @Transactional
    @Query(value = "update Employees set first_name = :firstName, last_name = :lastName, age = :age, department_id = :departmentId where Employee_id = :id", nativeQuery = true)
    public void updateEmployeeDTOById(@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("age") int age, @Param("departmentId") int departmentId, @Param("id") int EmployeeId);
}
