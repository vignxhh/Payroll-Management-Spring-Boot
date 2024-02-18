package project.mini.services;


import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.mini.entity.Attendance;
import project.mini.entity.Employees;
import project.mini.repository.AttendanceRepository;

@Service
public class AttendanceServices {
	
	@Autowired
	private AttendanceRepository attendanceRepository;

	public void markAttendance(Employees employee,boolean present) {
		Attendance attendance=new Attendance(employee,present);
		attendanceRepository.save(attendance);
		
	}
}
