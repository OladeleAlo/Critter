package com.example.udacity.critter.chronologer.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import java.time.DayOfWeek;
import java.util.Set;

@Entity
@Data

public class Employee extends User {

    @ElementCollection
    @JoinTable(name="employee_skills")
    private Set<EmployeeSkill> skills;

    // join table of Employee and DayOfWeek enum
    @ElementCollection
    @JoinTable(name="employee_availability")
    private Set<DayOfWeek> daysAvailable;
    public Employee() {}

    public Employee(Set<EmployeeSkill> skills, Set<DayOfWeek> daysAvailable) {
        this.skills = skills;
        this.daysAvailable = daysAvailable;
    }

    public Set<EmployeeSkill> getSkills() {
        return skills;
    }

    public void setSkills(Set<EmployeeSkill> skills) {
        this.skills = skills;
    }

    public Set<DayOfWeek> getDaysAvailable() {
        return daysAvailable;
    }

    public void setDaysAvailable(Set<DayOfWeek> daysAvailable) {
        this.daysAvailable = daysAvailable;
    }



}
