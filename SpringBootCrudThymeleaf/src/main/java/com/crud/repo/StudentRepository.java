package com.crud.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.model.Student;

//@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	
	//List<Student> finByName(String name);

}
