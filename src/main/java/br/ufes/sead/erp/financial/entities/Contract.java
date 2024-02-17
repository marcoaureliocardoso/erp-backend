package br.ufes.sead.erp.financial.entities;

import java.time.LocalDate;

public class Contract {
    private long id;
    private Grantor grantor;
    private Project project;
    private Course course;
    private Employee employee;
    private LocalDate startDate;
    private LocalDate endDate;

    public Contract() {
    }

    public Contract(long id, Grantor grantor, Project project, Course course, Employee employee, LocalDate startDate,
            LocalDate endDate) {
        this.id = id;
        this.grantor = grantor;
        this.project = project;
        this.course = course;
        this.employee = employee;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Grantor getGrantor() {
        return grantor;
    }

    public void setGrantor(Grantor grantor) {
        this.grantor = grantor;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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

    public LocalDate getFirstRecessInformLimitDate() {
        return startDate.plusMonths(6);
    }

    public LocalDate getSecondRecessInformLimitDate() {
        return startDate.plusMonths(12);
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
        Contract other = (Contract) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Contract [id=" + id + ", grantor=" + grantor + ", project=" + project + ", course=" + course
                + ", employee=" + employee + ", startDate=" + startDate + ", endDate=" + endDate
                + ", firstRecessInformDate=" + getFirstRecessInformLimitDate() + ", secondRecessInformDate="
                + getSecondRecessInformLimitDate() + "]";
    }

}
