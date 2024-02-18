package project.mini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.mini.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

	
	public boolean existsById(Long c_id);
	
	@Query(value = "select count(*) from Company where reg_no=?1")
	public String existsByReg_no(String reg_no);
	
}
