package com.example.springapp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springapp.Models.Rating;

@Repository
public interface RatingRepo extends JpaRepository<Rating,Integer> {
    
}
