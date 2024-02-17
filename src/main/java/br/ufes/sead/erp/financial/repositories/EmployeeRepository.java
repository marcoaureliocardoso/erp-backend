package br.ufes.sead.erp.financial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufes.sead.erp.financial.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
