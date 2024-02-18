package project.mini.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import jakarta.servlet.http.HttpSession;
import project.mini.entity.Company;
import project.mini.entity.Employees;
import project.mini.repository.CompanyRepository;
import project.mini.repository.EmployeesRepository;
import project.mini.services.AttendanceServices;



@Controller
public class CompanyController {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private AttendanceServices attendanceServices;
	
	@Autowired
	private EmployeesRepository employeesRepository;

	@GetMapping("/reg")
	public String company(Model model) {
		Company cmp= new Company();
		model.addAttribute("compReg", cmp);
		return "companyReg";
	}
	
	@PostMapping("/regcompany")
	public String regCompany(@ModelAttribute Company cmp,HttpSession session,@RequestParam(value = "reg_no")String reg_no) {
		
		boolean f=companyRepository.existsByReg_no(reg_no) != null;
		if(f)
		{
			session.setAttribute("regid", "Registrtion id Already Exists");
			 
		}
		else
			companyRepository.save(cmp);
			return "redirect:/reg";
	}

	@GetMapping("/addemp")
	public String employee() {
		//Employees emp= new Employees();
		//model.addAttribute("addemp", emp);
		return "addemployee";
	}
	
	@PostMapping("/saveemp")
	public String addEmployee(@ModelAttribute Employees emp,@RequestParam(value="c_id")Long c_id,HttpSession session) {
		
		if(!companyRepository.existsById(c_id)) 
		{
			session.setAttribute("nocomp", "There Is No Company Exists");
			 
		}
		else
			employeesRepository.save(emp);
			return "redirect:/addemp";
		
		
	}
	
	@GetMapping("/attendance")
	public String attendance(Model model) {
		LocalDate currentdate = LocalDate.now();
		List<Employees> emplist=employeesRepository.findAll();
		model.addAttribute("currentdate", currentdate);
		model.addAttribute("attend", emplist);
		return "attendance";
	}
	
	@PostMapping("/markattend")
	public String markAttendance(//@RequestParam(value="date") LocalDate date,
									@RequestParam Map<Long,String>attendanceMap) {
		
			System.out.println("Below  This printed");
		for(Map.Entry<Long,String> entry:attendanceMap.entrySet()) {
			System.out.println(entry.getKey()+"  This printed");
			System.out.println(entry.getValue()+"  This printed");
			Long empid = entry.getKey();
			boolean present = entry.getValue().equals("present");
			Employees employee = employeesRepository.findById(empid).orElse(null);
			attendanceServices.markAttendance(employee, present);
		}
		return "redirect:/attendance";
		
	}
	
}



