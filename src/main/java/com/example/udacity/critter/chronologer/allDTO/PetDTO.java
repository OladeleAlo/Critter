package com.example.udacity.critter.chronologer.allDTO;

import com.example.udacity.critter.chronologer.entity.PetType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Represents the form that pet request and response data takes. Does not map
 * to the database directly.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PetDTO {
    private long id;
    private PetType type;
    private String name;
    private LocalDate birthDate;
    private String notes;
    private long ownerId;


}
