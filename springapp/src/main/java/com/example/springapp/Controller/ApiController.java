package com.example.springapp.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.Models.Cycle;
import com.example.springapp.Service.ApiService;

@RestController
public class ApiController {

    @Autowired
    public ApiService apiService;

    @PostMapping("/")
    public boolean addNewCycle(@RequestBody Cycle cycle){
        return apiService.addNew(cycle);
    }

    @GetMapping("/{id}")
    public Cycle getOneCycle(@PathVariable int id){
         return apiService.getOneCycle(id);
    }

    @GetMapping("/")
    public List<Cycle> getAllCycle(){
         return apiService.getAllCycle();
    }

    @PutMapping("/{id}")
    public Cycle updateCycle(@RequestBody Cycle cycle,@PathVariable int id){
         return apiService.updateCycle(cycle, id);
    }

//     @DeleteMapping("/{id}")
//     public boolean deleteOneCycle(@PathVariable int id){
//          return apiService.deleteOneCycle(id);
//     }
}