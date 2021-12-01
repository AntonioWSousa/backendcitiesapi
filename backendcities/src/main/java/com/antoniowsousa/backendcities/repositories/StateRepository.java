package com.antoniowsousa.backendcities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.antoniowsousa.backendcities.entities.State;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {
}