package br.ufes.sead.erp.financial.fest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.ufes.sead.erp.exceptions.DatabaseException;
import br.ufes.sead.erp.exceptions.ResourceNotFoundException;
import br.ufes.sead.erp.financial.fest.entities.Project;
import br.ufes.sead.erp.financial.fest.repositories.ProjectRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    public Project findById(Long id) {
        Optional<Project> project = projectRepository.findById(id);
        return project.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Project save(Project project) {
        return projectRepository.save(project);
    }

    public void deleteById(Long id) {
        try {
            if (!projectRepository.existsById(id))
                throw new ResourceNotFoundException(id);

            projectRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public void delete(Project project) {
        try {
            if (!projectRepository.existsById(project.getId()))
                throw new ResourceNotFoundException(project.getId());

            projectRepository.delete(project);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public Project update(Long id, Project project) {
        try {
            Project projectEntityReference = projectRepository.getReferenceById(id);

            projectEntityReference.setName(project.getName());
            projectEntityReference.setCode(project.getCode());
            projectEntityReference.setStartDate(project.getStartDate());
            projectEntityReference.setEndDate(project.getEndDate());

            projectEntityReference.setGrantor(project.getGrantor());

            return projectRepository.save(projectEntityReference);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

}
