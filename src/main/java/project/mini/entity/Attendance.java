package project.mini.entity;


import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="attendance")
public class Attendance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY,targetEntity = Company.class,cascade = CascadeType.ALL)
	@JoinColumn(name="company_id")
	private Company cid;
	
	@ManyToOne
	@JoinColumn(name="emp_id")
	private Employees eid;
	
	@Column(name="date")
	private LocalDate date;
	
	@Column(name="attendance")
	private boolean attendance;
	
	@Column(name="attcount")
	private String attcount;


	public Attendance(Employees employee, boolean present) {
		this.eid=employee;
		
		this.attendance=present;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Company getCid() {
		return cid;
	}

	public void setCid(Company cid) {
		this.cid = cid;
	}

	public Employees getEid() {
		return eid;
	}

	public void setEid(Employees eid) {
		this.eid = eid;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public boolean getAttendance() {
		return attendance;
	}

	public void setAttendance(boolean attendance) {
		this.attendance = attendance;
	}

	public String getAttcount() {
		return attcount;
	}

	public void setAttcount(String attcount) {
		this.attcount = attcount;
	}
	
	
	
}
