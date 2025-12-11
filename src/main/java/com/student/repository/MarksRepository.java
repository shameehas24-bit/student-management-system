package com.student.repository;
import com.student.entity.Marks;
import org.springframework.data.jpa.repository.JpaRepository;
public interface MarksRepository extends JpaRepository<Marks, Long> { }
