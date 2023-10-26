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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.finzly.demo.entity.Student;
import com.finzly.demo.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService studentService;

	/**
	 * Retrieve a list of all students from the database using JPA (Java Persistence
	 * API).
	 *
	 * This method queries the database to fetch all student records and returns
	 * them as a list.
	 *
	 * @return A list of Student objects representing all students in the database.
	 * @author SashikantSingh
	 */
	@GetMapping("/students")
	public List<Student> getAllFromDatabaseJPA() {
		return studentService.getAllFromDatabaseJPA();
	}

	/**
	 * Update a student in the database using JPA (Java Persistence API).
	 *
	 * This method is used to either create a new student or update an existing one
	 * in the database.
	 *
	 * @param student The student object containing the data to be created or
	 *                updated.
	 * @return A response message indicating the success or failure of the
	 *         operation.
	 * @author SashikantSingh
	 */

	@GetMapping("/new")
	public String setStudentJPA(@RequestBody Student student) {
		return studentService.setStudentJPA(student);
	}

	/**
	 * Retrieve a list of students by their name.
	 *
	 * This method queries the database to fetch all students with the specified
	 * name and returns them as a list.
	 *
	 * @param name The name of the students to retrieve.
	 * @return A list of Student objects with the specified name.
	 * @author SashikantSingh
	 */

	@GetMapping("/names/{name}")
	public List<Student> getAllByName(@PathVariable String name) {
		return studentService.getAllByName(name);
	}

	/**
	 * Retrieve a list of students by their city.
	 *
	 * This method queries the database to fetch all students with the specified
	 * city and returns them as a list.
	 *
	 * @param city The city of the students to retrieve.
	 * @return A list of Student objects with the specified city.
	 * @author SashikantSingh
	 */

	@GetMapping("/cities/{city}")
	public List<Student> getAllByCity(@PathVariable String city) {
		return studentService.getAllByCity(city);
	}

	/**
	 * Retrieve a list of students by their standards.
	 *
	 * This method queries the database to fetch all students with the specified
	 * standards and returns them as a list.
	 *
	 * @param standards The standards of the students to retrieve.
	 * @return A list of Student objects with the specified standards.
	 * @author SashikantSingh
	 */

	@PostMapping("/standards/{standard}")
	public List<Student> getAllByStandard(@PathVariable String standard) {
		return studentService.getAllByStandard(standard);
	}

	/**
	 * Retrieve a list of students by their school.
	 *
	 * This method queries the database to fetch all students with the specified
	 * school and returns them as a list.
	 *
	 * @param school The school of the students to retrieve.
	 * @return A list of Student objects with the specified school.
	 * @author SashikantSingh
	 */

	@GetMapping("/schools/{school}")
	public List<Student> getAllBySchool(@PathVariable String school) {
		return studentService.getAllBySchool(school);
	}

	/**
	 * Retrieve a list of students by their phone Number.
	 *
	 * This method queries the database to fetch all students with the specified
	 * phone Number and returns them as a list.
	 *
	 * @param phone Numbers The phone Numbers of the students to retrieve.
	 * @return A list of Student objects with the specified phone Numbers.
	 * @author SashikantSingh
	 */

	@GetMapping("/phoneNumbers/{phoneno}")
	public List<Student> getAllByPhoneno(@PathVariable String phoneno) {
		return studentService.getAllByPhoneno(phoneno);
	}

	/**
	 * Retrieve a list of students by their marks greater than the given marks.
	 *
	 * This method queries the database to fetch all students with the specified
	 * marks greater than the given marks and returns them as a list.
	 *
	 * @param marks greater than the given marks of the students to retrieve.
	 * @return A list of Student objects with the specified marks greater than the
	 *         given marks.
	 * @author SashikantSingh
	 */

	@GetMapping("/greaterMarks/{mark}")
	public List<Student> getAllGreaterMarks(@PathVariable("mark") int mark) {
		return studentService.getAllGreaterMarks(mark);
	}

	/**
	 * Update city of the student by their id.
	 *
	 * This method queries the database to update the specific student with the id .
	 *
	 * @param school The city of the students to retrieve.
	 * @return A message related to the update with the specified id.
	 * @author SashikantSingh
	 */

	@PutMapping("/updates/{id}")
	public String updateCityById(@PathVariable long id, @RequestParam String city) {
		return studentService.updateCityById(id, city);
	}

	/**
	 * Update full student detail by their id.
	 *
	 * This method queries the database to update the specific student with the id .
	 *
	 * @param city,name,phone number,standard of the students to retrieve.
	 * @return A message related to the update with the specified id.
	 * @author SashikantSingh
	 */

	@PutMapping("/updateByParams/{id}")
	public ResponseEntity<String> updateStudentById(@PathVariable long id, @RequestParam String city,
			@RequestParam String name, @RequestParam String phoneno, @RequestParam String standard) {
		return studentService.updateStudentById(id, city, name, phoneno, standard);
	}

	/**
	 * Update student by their id.
	 *
	 * This method queries the database to update the specific student with the id .
	 *
	 * @param student with respect to their jason file students to retrieve.
	 * @return A message related to the update with the specified id.
	 * @author SashikantSingh
	 */

	@PutMapping("/updateStudents/{id}")
	public String updateStudent(@PathVariable long id, @RequestBody Student student) {
		boolean updated = studentService.updateStudent(id, student);
		if (updated) {
			return "Student updated successfully.";
		} else {
			return "Student not found";
		}
	}

	/**
	 * Delete a student by their ID.
	 *
	 * This method handles the deletion of a student record from the database based
	 * on the provided ID.
	 *
	 * @param id The unique identifier of the student to be deleted.
	 * @return A message indicating whether the student was deleted successfully or
	 *         not.
	 * @author SashikantSingh
	 */
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
