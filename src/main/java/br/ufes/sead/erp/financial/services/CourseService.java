package br.ufes.sead.erp.financial.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufes.sead.erp.financial.entities.Course;
import br.ufes.sead.erp.financial.repositories.CourseRepository;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public Course findById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    public Course save(Course course) {
        return courseRepository.save(course);
    }

    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }

    public void delete(Course course) {
        courseRepository.delete(course);
    }

}
