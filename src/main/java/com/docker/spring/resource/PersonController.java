package com.docker.spring.resource;

import com.docker.spring.entity.Person;
import com.docker.spring.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @PostMapping("/create")
    public ResponseEntity<?> createPerson(@RequestBody Person person)
    {
        personRepository.save(person);
        return new ResponseEntity<>("Created a person", HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllPerson()
    {
        return new ResponseEntity<>(personRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id)
    {
        return new ResponseEntity<>(personRepository.findById(id), HttpStatus.OK);
    }
}
