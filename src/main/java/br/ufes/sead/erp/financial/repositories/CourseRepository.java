package br.ufes.sead.erp.financial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufes.sead.erp.financial.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
