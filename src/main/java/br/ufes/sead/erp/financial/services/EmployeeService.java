package br.ufes.sead.erp.financial.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufes.sead.erp.financial.entities.Employee;
import br.ufes.sead.erp.financial.repositories.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }

}
