package com.example.springapp.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.Models.Rating;
import com.example.springapp.Services.ApiService;


@RestController
public class ApiController {

    @Autowired
    public ApiService apiService;

    @PostMapping("/")
    public boolean addRate(@RequestBody Rating rating){
        return apiService.addRate(rating);
    }
    
    @GetMapping("/{field}")
    public List<Rating> getSorting(@PathVariable String field){
        return apiService.getSorting(field);
    }

    @GetMapping("/{offset}/{pagesize}")
    public Page<Rating> getPagination(@PathVariable int offset, @PathVariable int pagesize){
        return apiService.getPagination(offset,pagesize);
    }

    @GetMapping("/{offset}/{pagesize}/{field}")
    public Page<Rating> getPaginationWithSorting(@PathVariable int offset, @PathVariable int pagesize,@PathVariable String field){
        return apiService.getPaginationWithSorting(offset,pagesize,field);
    }

    @GetMapping("/rating")
    public List<Rating> getReqSort(@RequestParam String field,@RequestParam(defaultValue = "ASC") String sortDirection){
        return apiService.getSortingReq(field, sortDirection);
    }


}
