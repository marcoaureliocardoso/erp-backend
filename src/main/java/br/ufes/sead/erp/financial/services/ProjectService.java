package br.ufes.sead.erp.financial.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufes.sead.erp.financial.entities.Project;
import br.ufes.sead.erp.financial.repositories.ProjectRepository;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    public Project findById(Long id) {
        return projectRepository.findById(id).orElse(null);
    }

    public Project save(Project project) {
        return projectRepository.save(project);
    }

    public void deleteById(Long id) {
        projectRepository.deleteById(id);
    }

    public void delete(Project project) {
        projectRepository.delete(project);
    }

}
