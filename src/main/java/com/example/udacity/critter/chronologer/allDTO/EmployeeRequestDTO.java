package com.example.udacity.critter.chronologer.allDTO;

import com.example.udacity.critter.chronologer.entity.EmployeeSkill;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.util.Set;

/**
 * Represents a request to find available employees by skills. Does not map
 * to the database directly.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeRequestDTO {
    private Set<EmployeeSkill> skills;
    private LocalDate date;

}
