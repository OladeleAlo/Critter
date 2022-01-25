package com.example.udacity.critter.chronologer.services;


import com.example.udacity.critter.chronologer.entity.Customer;
import com.example.udacity.critter.chronologer.entity.Employee;
import com.example.udacity.critter.chronologer.entity.Pet;
import com.example.udacity.critter.chronologer.entity.Schedule;
import com.example.udacity.critter.chronologer.repository.CustomerRepository;
import com.example.udacity.critter.chronologer.repository.EmployeeRepository;
import com.example.udacity.critter.chronologer.repository.PetRepository;
import com.example.udacity.critter.chronologer.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ScheduleService {

    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    PetRepository petRepository;

    @Autowired
    CustomerRepository customerRepository;

    // save new schedule, with list of employee ids and pet ids:
    public Schedule save(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    // get all schedules:
    public List<Schedule> findAllSchedules() {
        return scheduleRepository.findAll();
    }

    // find all schedules of an employee by employee id:
    public List<Schedule> findSchedulesByEmployeeId(Long employeeId) {

        // find an employee by employee id:
        Employee employee = employeeRepository.getOne(employeeId);

        // return all schedules of an employee using JPA Repository:
        return scheduleRepository.getAllByEmployeesContains(employee);
    }

    // find all schedules of a pet by pet id:
    public List<Schedule> findSchedulesByPetId(Long petId) {

        // find a pet by pet id:
        Pet pet = petRepository.getOne(petId);

        // return all schedules for the pet:
        return scheduleRepository.getAllByPetsContains(pet);
    }

    // find all schedules of a customer by customer id
    // has to find list of pets using petRepository because customer db does not have joined table with schedule db:
    public List<Schedule> findScheduleByOwnerId(Long ownerId) {

        // find owner by owner Id:
        Customer owner = customerRepository.getOne(ownerId);

        // return list of pets of a customer
        // find owner by ownerId, then retrieve a list of pet of that owner
        // then, find in schedule table in a joined table with pet table
        return scheduleRepository.getAllByPetsIn(owner.getPets());
    }
}
