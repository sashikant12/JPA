package com.finzly.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.finzly.demo.entity.Student;
import com.finzly.demo.service.StudentService;


@RestController
public class StudentController {
	@Autowired
	StudentService studentService;
	
	@GetMapping("/students")
	public List<Student> getAllFromDatabaseJPA() {
		return studentService.getAllFromDatabaseJPA();
	}
	
	@GetMapping("/newStudent")
	public String setStudentNameJPA(@RequestBody Student student) {
		return studentService.setStudentNameJPA(student);
	}
	
	@GetMapping("/names/{name}")
	public List<Student> getAllByName(@PathVariable String name){
		return studentService.getAllByName(name);
	}
	
	@GetMapping("/cities/{city}")
	public List<Student> getAllByCity(@PathVariable String city) {
		return studentService.getAllByCity(city);
	}
	
	@PostMapping("/standards/{standard}")
	public List<Student> getAllByStandard(@PathVariable String standard) {
		return studentService.getAllByStandard(standard);
	}
	
	@GetMapping("/schools/{school}")
	public List<Student> getAllBySchool(@PathVariable String school) {
		return studentService.getAllBySchool(school);
	}
	
	@GetMapping("/phoneNumbers/{phoneno}")
	public List<Student> getAllByPhoneno(@PathVariable String phoneno) {
		return studentService.getAllByPhoneno(phoneno);
	}
	
	@GetMapping("/marks/{mark}")
	public List<Student> getAllGreaterMarks(@PathVariable("mark") int mark){
		return studentService.getAllGreaterMarks(mark);
	}
	
	@PutMapping("/updates/{id}")
	public String updateCityById(@PathVariable long id, @RequestParam String city) {		
			return studentService.updateCityById(id,city);
	}
	
	@PutMapping("/updateByParams/{id}")
	public ResponseEntity<String> updateStudentById(@PathVariable long id,
			@RequestParam String city,
			@RequestParam String name,
			@RequestParam String phoneno,
			@RequestParam String standard) {		
			return studentService.updateStudentById(id,city,name,phoneno,standard);
	}
	
	@PutMapping("/updateStudents/{id}")
	 public String updateStudent(@PathVariable long id, @RequestBody Student student) {
        boolean updated = studentService.updateStudent(id, student);
        if (updated) {
            return "Student updated successfully.";
        } else {
            return "Student not found";
        }
    }
	
	@DeleteMapping("Delete/{id}")
	public String deleteStudent(@PathVariable long id) {
		  boolean deleted = studentService.deleteStudentById(id);

	        if (deleted) {
	            return "Student deleted successfully.";
	        } else {
	            return "Student not found with ID: " + id;
	        }
	    }
	
}
