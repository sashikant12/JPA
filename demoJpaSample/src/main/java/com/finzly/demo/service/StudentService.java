package com.finzly.demo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.finzly.demo.entity.Student;
import com.finzly.demo.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	private final Logger logger = LoggerFactory.getLogger(StudentService.class);

	public List<Student> getAllFromDatabaseJPA() {
		logger.info("get all students using JPA");
		return studentRepository.findAll();
	}

	public String setStudentJPA(Student student) {
		try {
			logger.info("add students using JPA");
			studentRepository.save(student);
			return "Student Saved";
		} catch (Exception e) {
			logger.error("Student not added");
			return "Some Error, Not Saved" + e;
		}
	}

	public List<Student> getAllByCity(String city) {
		logger.info("get all students by city using JPA");
		return studentRepository.findByCity(city);
	}

	public List<Student> getAllByStandard(String standard) {
		logger.info("get all students by standrad using JPA");
		return studentRepository.findByStandard(standard);
	}

	public List<Student> getAllBySchool(String school) {
		logger.info("get all students by school using JPA");
		return studentRepository.findBySchool(school);
	}

	public List<Student> getAllByPhoneno(String phoneno) {
		logger.info("get all students by phone number using JPA");
		return studentRepository.findByPhoneno(phoneno);
	}

	public List<Student> getAllByName(String name) {
		logger.info("get all student  by name using JPA");
		return studentRepository.findByName(name);
	}

	public List<Student> getAllGreaterMarks(int mark) {
		logger.info("get all students marks greater than marks using JPA");
		return studentRepository.getAllGreaterMarks(mark);
	}

	public String updateCityById(long id, String city) {
		logger.info("get student city update by using  student id " + id + " using JPA");
		Optional<Student> s = studentRepository.findById(id);
		if (s.isPresent()) {
			logger.info("Student found with ID: " + id);
			studentRepository.updateCityById(id, city);
			return "City Updated";
		} else {
			logger.info("Student not found with ID: " + id);
			return "Student not found with ID: " + id;
		}
	}

	public ResponseEntity<String> updateStudentById(long id, String city, String name, String phoneno,
			String standard) {
		logger.info("get student info update by using PARAM and  student id " + id + " using JPA");
		Optional<Student> s = studentRepository.findById(id);
		if (s.isPresent()) {
			logger.info("Student  found with ID: " + id);
			studentRepository.updateStudentById(id, city, name, phoneno, standard);
			return ResponseEntity.status(HttpStatus.OK).body("Student Updated");
		} else {
			logger.info("Student not found with ID: " + id);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found with ID: " + id);
		}
	}

	public boolean updateStudent(long id, Student updatedStudent) {
		logger.info("get student city update by using JSON and student id " + id + " using JPA");
		Student existingStudent = studentRepository.findById(id).orElse(null);

		if (existingStudent != null) {
			logger.info("Student found with ID: " + id);
			// Update the student's information with the provided data
			existingStudent.setName(updatedStudent.getName());
			existingStudent.setPhoneno(updatedStudent.getPhoneno());
			existingStudent.setStandard(updatedStudent.getStandard());
			existingStudent.setCity(updatedStudent.getCity());
			existingStudent.setMarks(updatedStudent.getMarks());
			existingStudent.setSchool(updatedStudent.getSchool());
			studentRepository.save(existingStudent); // Save the updated entity
			return true; // Update successful
		}
		logger.info("Student not found with ID: " + id);
		return false; // Student not found, update failed
	}

	public boolean deleteStudentById(long id) {
		if (studentRepository.existsById(id)) {
			logger.info("Student  found with ID: " + id);
			studentRepository.deleteById(id); // Delete the student by id
			return true; // Deletion successful
		}
		logger.info("Student not found with ID: " + id);
		return false; // Student not found, deletion failed
	}

}
