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
public interface DepartmentRepository extends JpaRepository<DepartmentDTO, Integer> {
    //@Query("select d from DepartmentDTO d")
    @Query(value = "select * from Departments", nativeQuery = true)
    public List<DepartmentDTO> getAllDepartment();

    //@Query("select d from DepartmentDTO d where d.department_Id = :id")
    @Query(value = "select * from Departments where department_id = :id", nativeQuery = true)
    public DepartmentDTO getDepartmentById(@Param("id") int departmentId);

    @Modifying
    @Transactional
    @Query(value = "delete from Departments where department_id = :id", nativeQuery = true)
    public void deleteDepartmentDTOById(@Param("id") int departmentId);

    @Modifying
    @Transactional
    @Query(value = "update Departments set department_name = :name where department_id = :id", nativeQuery = true)
    public void updateDepartmentDTOById(@Param("name") String departmentName , @Param("id") int departmentId);

    //@Query(value = "insert into Departments(department_name) values('name')", nativeQuery = true)
    //public void addDepartmentDTOById(@Param("name") String departmentName);
}
