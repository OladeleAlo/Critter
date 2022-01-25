package com.example.udacity.critter.chronologer.repository;

import com.example.udacity.critter.chronologer.entity.Employee;
import com.example.udacity.critter.chronologer.entity.Pet;
import com.example.udacity.critter.chronologer.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    // find all schedules in Schedule db that has matching employee:
    List<Schedule> getAllByEmployeesContains(Employee employee);

    // find all schedules in Schedule db that has matching pet:
    List<Schedule> getAllByPetsContains(Pet pet);

    // find a list of pets in Schedule db that has pets:
    List<Schedule> getAllByPetsIn(List<Pet> pets);
}
