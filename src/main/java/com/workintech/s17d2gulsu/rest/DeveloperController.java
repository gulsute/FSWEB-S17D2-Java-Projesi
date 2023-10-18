package com.workintech.s17d2gulsu.rest;

import com.workintech.s17d2gulsu.model.Developer;
import com.workintech.s17d2gulsu.model.DeveloperFactory;
import com.workintech.s17d2gulsu.tax.Taxable;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/developers")
public class DeveloperController {
    private Map<Integer, Developer> developers;
    private Taxable taxable;

    @PostConstruct
    public void init() {
        developers=new HashMap<>();
    }

    @Autowired
    public DeveloperController(Taxable taxable) {
        this.taxable = taxable;
    }

    @PostMapping("/")
    public Developer save(@RequestBody Developer developer){
        Developer savedDev= DeveloperFactory.createDeveloper(developer, taxable);
        if(savedDev != null){
            developers.put(savedDev.getId(), savedDev);
        }
        return savedDev;
    }

    @GetMapping("/")
    public List<Developer> get(){
        return developers.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Developer getByID(@PathVariable int id){
        return developers.get(id);
    }

    @PutMapping("/{id}")
    public Developer update(@PathVariable int id, @RequestBody Developer developer) {
        developer.setId(id);
        Developer updatedDev=DeveloperFactory.createDeveloper(developer,taxable);
        developers.put(id,updatedDev);
        return updatedDev;
    }

    @DeleteMapping("/{id}")
    public Developer remove(@PathVariable int id){
        Developer removedDev=developers.remove(id);
        return removedDev;
    }

}
