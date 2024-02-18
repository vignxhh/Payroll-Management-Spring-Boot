package project.mini.entity;




import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="employees")
public class Employees {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empid;
	
	@ManyToOne(fetch = FetchType.LAZY,targetEntity = Company.class)
	@JoinColumn(name="company_id")
	private Company c_id;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="basic")
	private Double basic;
	
	@Column(name="hra")
	private Double hra;
	
	@Column(name="da")
	private Double da;
	
	@Column(name="pf")
	private Double pf;
	
	@Column(name="esi")
	private Double esi;
	
	@Column(name="totalsal")
	private Double totalsal;
	
	@Column(name="granttot")
	private Double granttot;
	
	@Column(name="otherallow")
	private Double oa;
	
	@OneToMany(mappedBy = "eid",cascade = CascadeType.ALL)
	private List<Attendance> attendance;

	public Long getEmpid() {
		return empid;
	}

	public void setEmpid(Long empid) {
		this.empid = empid;
	}

	
	public Company getC_id() {
		return c_id;
	}

	public void setC_id(Company c_id) {
		this.c_id = c_id;
	}

	public Double getBasic() {
		return basic;
	}

	public void setBasic(Double basic) {
		this.basic = basic;
	}

	public Double getHra() {
		return hra;
	}

	public void setHra(Double hra) {
		this.hra = hra;
	}

	public Double getDa() {
		return da;
	}

	public void setDa(Double da) {
		this.da = da;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Double getPf() {
		return pf;
	}

	public void setPf(Double pf) {
		this.pf = pf;
	}

	public Double getEsi() {
		return esi;
	}

	public void setEsi(Double esi) {
		this.esi = esi;
	}

	public Double getTotalsal() {
		return totalsal;
	}

	public void setTotalsal(Double totalsal) {
		this.totalsal = totalsal;
	}

	public Double getGranttot() {
		return granttot;
	}

	public void setGranttot(Double granttot) {
		this.granttot = granttot;
	}

	public Double getOa() {
		return oa;
	}

	public void setOa(Double oa) {
		this.oa = oa;
	}
	
	
}
