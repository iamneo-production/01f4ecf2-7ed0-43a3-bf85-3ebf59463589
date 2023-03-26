package com.example.springapp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springapp.Models.Cycle;

@Repository
public interface CycleRepo extends JpaRepository<Cycle,Integer>{
    
}
