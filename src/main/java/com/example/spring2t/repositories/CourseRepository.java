package com.example.spring2t.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.spring2t.models.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}



