package com.example.udacity.critter.chronologer.allDTO;

import com.example.udacity.critter.chronologer.entity.EmployeeSkill;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

/**
 * Represents the form that schedule request and response data takes. Does not map
 * to the database directly.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScheduleDTO {
    private long id;
    private LocalDate date;
    private Set<EmployeeSkill> activities;
    private List<Long> employeeIds;
    private List<Long> petIds;


}
