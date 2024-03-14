package br.ufes.sead.erp.financial.fest.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;
    private String code;
    private LocalDate startDate;
    private LocalDate endDate;

    @OneToMany(mappedBy = "project")
    @JsonIgnoreProperties({"project", "eventReminders"})
    private List<Contract> contracts = new ArrayList<>();

    @ManyToOne
    @PrimaryKeyJoinColumn
    @JsonIgnoreProperties("projects")
    private Grantor grantor;

    public Project() {
    }

    public Project(String name, String code, Grantor grantor, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.code = code;
        this.grantor = grantor;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Grantor getGrantor() {
        return grantor;
    }

    public void setGrantor(Grantor grantor) {
        this.grantor = grantor;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
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
        Project other = (Project) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Project [id=" + id + ", name=" + name + ", code=" + code + ", startDate=" + startDate + ", endDate="
                + endDate + ", contracts=" + contracts + ", grantor=" + grantor + "]";
    }

}
