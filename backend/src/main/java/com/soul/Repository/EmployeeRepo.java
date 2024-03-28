package com.soul.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soul.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>{

}
