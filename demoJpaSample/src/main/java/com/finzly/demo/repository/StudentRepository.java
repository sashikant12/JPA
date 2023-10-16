package com.finzly.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.finzly.demo.entity.Student;

import jakarta.transaction.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	List<Student> findByName(String name);

	List<Student> findByCity(String city);

	List<Student> findByStandard(String standard);

	List<Student> findBySchool(String school);

	List<Student> findByPhoneno(String phoneno);

	Optional<Student> findById(Long Id);

	@Query("SELECT student FROM Student student WHERE student.marks > :mark")
	List<Student> getAllGreaterMarks(int mark);

	@Modifying
	@Transactional
	@Query("UPDATE Student s SET s.city = ?2 WHERE s.id = ?1")
	void updateCityById(long id, String city);

	@Modifying
	@Transactional
	@Query("UPDATE Student s SET s.city = :city, s.name = :name,  s.phoneno = :phoneno, s.standard = :standard WHERE s.id = :id")
	void updateStudentById(long id, String city, String name, String phoneno, String standard);

}
