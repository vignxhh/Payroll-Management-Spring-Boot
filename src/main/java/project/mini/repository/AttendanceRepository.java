package project.mini.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.mini.entity.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

	
}
