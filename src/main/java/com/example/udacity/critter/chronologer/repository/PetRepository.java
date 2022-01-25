package com.example.udacity.critter.chronologer.repository;


import com.example.udacity.critter.chronologer.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

}
