package br.ufes.sead.erp.financial.fest.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String givenName;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false)
    private String identityNumber;
    private LocalDate birthDate;
    private String email;

    @OneToMany(mappedBy = "employee")
    @JsonIgnoreProperties({"employee", "eventReminders"})
    private List<Contract> contracts = new ArrayList<>();

    public Employee() {
    }

    public Employee(String givenName, String surname, String identityNumber, LocalDate birthDate,
            String email) {
        this.givenName = givenName;
        this.surname = surname;
        this.identityNumber = identityNumber;
        this.birthDate = birthDate;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", givenName=" + givenName + ", surname=" + surname + ", identityNumber="
                + identityNumber + ", birthDate=" + birthDate + ", email=" + email + ", contracts=" + contracts + "]";
    }

}