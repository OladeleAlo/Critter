package com.example.udacity.critter.chronologer.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;

// Two different kinds of users - Employees and Customers.

/**
 * User is a Parent class of Employee and Customer
 * use InheritanceType.JOINED to share only common attributes
 * supports polymorphic queries by UNIONing subclass tables
 * */
@Entity
@AllArgsConstructor
@Data
@Builder
@Inheritance(strategy= InheritanceType.JOINED)
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Nationalized
    private String name;

    public User() {}

    public User(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
