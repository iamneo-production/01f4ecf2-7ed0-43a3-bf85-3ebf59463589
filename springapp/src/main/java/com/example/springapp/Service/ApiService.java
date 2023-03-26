package com.example.springapp.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.Models.Cycle;
import com.example.springapp.Repositories.CycleRepo;

@Service
public class ApiService {

    @Autowired
    private CycleRepo cycleRepo;

    public boolean addNew(Cycle cycle) {
      return cycleRepo.save(cycle) != null ? true : false;
    }

    public Cycle getOneCycle(int id) {
      return cycleRepo.findById(id).get();
    }

    public List<Cycle> getAllCycle() {
      return cycleRepo.findAll();
    }

    public Cycle updateCycle(Cycle cycle,int id) {
      Cycle cycle2 = cycleRepo.findById(id).get();
      cycle2.setCycleName(cycle.getCycleName());
      cycle2.setPrice(cycle.getPrice());
      cycle2.setSize(cycle.getSize());
      cycle2.setType(cycle.getCycleName());
      return cycleRepo.save(cycle2);
    }

    public boolean deleteOneCycle(int id) {
      if(cycleRepo.findById(id).isPresent()){
        cycleRepo.deleteById(id);
        return true;
      }
      return false;
    }
    
}
