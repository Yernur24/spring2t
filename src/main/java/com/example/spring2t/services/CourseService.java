package com.example.spring2t.services;

import com.example.spring2t.models.Course;
import com.example.spring2t.repositories.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    public List<Course> allCourses() {
        return courseRepository.findAll();
    }
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

}