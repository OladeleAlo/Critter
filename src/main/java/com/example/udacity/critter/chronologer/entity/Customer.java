package com.example.udacity.critter.chronologer.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends User {

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(nullable = true)
    private String notes;

    // Use 1:M between Customer and Pets:
    @OneToMany(mappedBy = "customer", fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Pet> pets = new ArrayList<>();


}
