package br.ufes.sead.erp.financial.fest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.ufes.sead.erp.exceptions.DatabaseException;
import br.ufes.sead.erp.exceptions.ResourceNotFoundException;
import br.ufes.sead.erp.financial.fest.entities.Course;
import br.ufes.sead.erp.financial.fest.repositories.CourseRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public Course findById(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        return course.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Course save(Course course) {
        return courseRepository.save(course);
    }

    public void deleteById(Long id) {
        try {
            if (!courseRepository.existsById(id))
                throw new ResourceNotFoundException(id);

            courseRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public void delete(Course course) {
        try {
            if (!courseRepository.existsById(course.getId()))
                throw new ResourceNotFoundException(course.getId());

            courseRepository.delete(course);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public Course update(Long id, Course course) {
        try {
            Course courseEntityReference = courseRepository.getReferenceById(id);

            courseEntityReference.setName(course.getName());

            return courseRepository.save(courseEntityReference);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

}
