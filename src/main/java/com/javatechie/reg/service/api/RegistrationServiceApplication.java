package com.javatechie.reg.service.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import com.javatechie.reg.service.api.dao.UserRepository;
import com.javatechie.reg.service.api.model.User;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RestController
@CrossOrigin(origins = "*")
public class RegistrationServiceApplication {

    @Autowired
    private UserRepository repository;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        repository.save(user);
        
        return "Hi " + user.getName() + " your Registration process successfully completed";
    }
    
    @GetMapping("/getAllUsers")
    public List<User> findAllUsers() {
        return repository.findAll();
    }

    @GetMapping("/findUser/{email}")
    public List<User> findUserEmail(@PathVariable String email) {
        return repository.findByEmail(email);
    }

    @GetMapping("/findUserCity/{city}")
    public List<User> findUserCity(@PathVariable String city) {
        return repository.findByCity(city);
    }

    @GetMapping("/findUserExperience/{experience}")
    public List<User> findUserExperience(@PathVariable int experience) {
        return repository.findByExperience(experience);
    }

    @GetMapping("/findUserID/{id}")
    public Optional<User> findUserByID(@PathVariable Integer id) {
        return repository.findById(id);

    }

    @DeleteMapping("/cancel/{id}")
    public List<User> cancelRegistration(@PathVariable int id) {
        repository.deleteById(id);
        return repository.findAll();
    }

    public static void main(String[] args) {
        SpringApplication.run(RegistrationServiceApplication.class, args);
    }

}


