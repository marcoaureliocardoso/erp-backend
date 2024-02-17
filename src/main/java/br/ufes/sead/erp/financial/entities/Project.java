package br.ufes.sead.erp.financial.entities;

import java.time.LocalDate;

public class Project {
    private long id;
    private String name;
    private String code;
    private Grantor grantor;
    private LocalDate startDate;
    private LocalDate endDate;

    public Project() {
    }

    public Project(long id, String name, String code, Grantor grantor, LocalDate startDate, LocalDate endDate) {
        this.id = id;
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
        return "Project [id=" + id + ", name=" + name + ", code=" + code + ", grantor=" + grantor + ", startDate="
                + startDate + ", endDate=" + endDate + "]";
    }

}
