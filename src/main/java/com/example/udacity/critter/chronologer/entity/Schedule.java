package com.example.udacity.critter.chronologer.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

// Schedules that indicate one or more employees will be meeting one or more pets
// to perform one or more activities on a specific day.
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate date;

    // Many Employee Activities have Many Schedules
    @ElementCollection
    @JoinTable(name = "schedule_activities")
    private Set<EmployeeSkill> activities;

    // Many Employees have Many Schedules
    @ManyToMany
    @JoinTable(
            name = "schedule_employee",
            joinColumns = @JoinColumn(name = "schedule_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id")
    )
    private List<Employee> employees;

    // Many Pets have Many Schedules
    @ManyToMany
    @JoinTable(
            name = "schedule_pet",
            joinColumns = @JoinColumn(name = "schedule_id"),
            inverseJoinColumns = @JoinColumn(name = "pet_id")
    )
    private List<Pet> pets;

}
