package com.example.springapp.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.springapp.Models.Rating;
import com.example.springapp.Repositories.RatingRepo;

@Service
public class ApiService {

    @Autowired
    public RatingRepo ratingRepo;

    public boolean addRate(Rating rate) {
        return ratingRepo.save(rate) != null ? true : false; 
    }

    public List<Rating> getSorting(String field) {
        return (List<Rating>) ratingRepo.findAll(Sort.by(Sort.Direction.ASC,field));
    }

    public List<Rating> getSortingReq(String field,String sortDirection){
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection),field);
        return (List<Rating>) ratingRepo.findAll(sort);
    }

    public Page<Rating> getPagination(int offset, int pageSize){
        Page<Rating> info = ratingRepo.findAll(PageRequest.of(offset, pageSize));
        return info;
    }

    public Page<Rating> getPaginationWithSorting(int offset, int pageSize, String field){
        Page<Rating> info = ratingRepo.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
        return info;
    }

    
    
}
