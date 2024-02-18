package br.ufes.sead.erp.financial.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.ufes.sead.erp.financial.entities.Employee;
import br.ufes.sead.erp.financial.repositories.EmployeeRepository;
import br.ufes.sead.erp.financial.services.exceptions.DatabaseException;
import br.ufes.sead.erp.financial.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee findById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteById(Long id) {
        try {
            if (!employeeRepository.existsById(id))
                throw new ResourceNotFoundException(id);

            employeeRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public void delete(Employee employee) {
        try {
            if (!employeeRepository.existsById(employee.getId()))
                throw new ResourceNotFoundException(employee.getId());

            employeeRepository.delete(employee);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public Employee update(Long id, Employee employee) {
        try {
            Employee employeeEntityReference = employeeRepository.getReferenceById(id);

            employeeEntityReference.setGivenName(employee.getGivenName());
            employeeEntityReference.setSurname(employee.getSurname());
            employeeEntityReference.setIdentityNumber(employee.getIdentityNumber());
            employeeEntityReference.setBirthDate(employee.getBirthDate());
            employeeEntityReference.setEmail(employee.getEmail());

            return employeeRepository.save(employeeEntityReference);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

}
