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
@Table(name = "bonds")
public class Bond {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @OneToMany(mappedBy = "bond", cascade = { jakarta.persistence.CascadeType.ALL }, orphanRemoval = true)
    @JsonIgnoreProperties("bond")
    private List<BondEventReminder> eventReminders = new ArrayList<>();

    @ManyToOne
    @PrimaryKeyJoinColumn
    @JsonIgnoreProperties("bonds")
    private Project project;

    @ManyToOne
    @PrimaryKeyJoinColumn
    @JsonIgnoreProperties("bonds")
    private Course course;

    @ManyToOne
    @PrimaryKeyJoinColumn
    @JsonIgnoreProperties("bonds")
    private Employee employee;

    public Bond() {
    }

    public Bond(Project project, Course course, Employee employee, LocalDate startDate,
            LocalDate endDate) {
        this.project = project;
        this.course = course;
        this.employee = employee;
        this.startDate = startDate;
        if (endDate == null)
            this.endDate = startDate.plusYears(1);
        else
            this.endDate = endDate;
    }

    public Bond(Project project, Course course, Employee employee, LocalDate startDate) {
        this.project = project;
        this.course = course;
        this.employee = employee;
        this.startDate = startDate;
        this.endDate = startDate.plusYears(1);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public LocalDate getFirstReportLimitDate() {
        return startDate.plusMonths(6);
    }

    public LocalDate getSecondReportLimitDate() {
        return startDate.plusMonths(12);
    }

    public List<BondEventReminder> getEventReminders() {
        return eventReminders;
    }

    public void addEventReminder(BondEventReminder eventReminder) {
        eventReminders.add(eventReminder);
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
        Bond other = (Bond) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Bond [id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", eventReminders=" + eventReminders
                + ", project=" + project + ", course=" + course + ", employee=" + employee
                + "firstRecessInformLimitDate" + getFirstRecessInformLimitDate() + "secondRecessInformLimitDate"
                + getSecondRecessInformLimitDate() + "firstReportLimitDate" + getFirstReportLimitDate()
                + "secondReportLimitDate" + getSecondReportLimitDate() + "]";
    }

}
