package project.mini.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.mini.entity.Employees;

public interface EmployeesRepository extends JpaRepository<Employees, Long> {
	
	

}
