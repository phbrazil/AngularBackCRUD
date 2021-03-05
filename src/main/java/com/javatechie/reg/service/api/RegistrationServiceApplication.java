package com.javatechie.reg.service.api;

import com.javatechie.reg.service.api.dao.ClientRepository;
import com.javatechie.reg.service.api.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.javatechie.reg.service.api.dao.UserRepository;
import com.javatechie.reg.service.api.exceptions.EmailExistsException;
import com.javatechie.reg.service.api.model.User;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@RestController
@CrossOrigin(origins = "*")
public class RegistrationServiceApplication {
//public class RegistrationServiceApplication extends SpringBootServletInitializer{

    @Autowired
    private UserRepository repository;

    @Autowired
    private ClientRepository repositoryClient;

    @PostMapping("/registerUser")
    public User registerUser(@RequestBody User user) {
        return repository.save(user);
        // return "Hi " + user.getName() + " your Registration process successfully completed";
    }

    //@valid serve para validar o bean de internacionalizacao de mensagens
    @PostMapping("/registerClient")
    public Cliente registerClient(@RequestBody @Valid Cliente cliente) throws EmailExistsException {

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

        Date date = new Date(System.currentTimeMillis());

        cliente.setDataCadastro(date);

        //System.out.println(formatter.format(cliente.getDataCadastro()));
        if (repositoryClient.existsByEmail(cliente.getEmail())) {
            throw new EmailExistsException("Email já existe");
            
        } else if(repositoryClient.existsByCpf(cliente.getCpf())) {
            throw new EmailExistsException("CPF já existe");
        }else {
            return repositoryClient.save(cliente);
        }

        // return "Hi " + user.getName() + " your Registration process successfully completed";
    }

    @GetMapping("/getAllUsers")
    public List<User> findAllUsers() {
        return repository.findAll();
    }

    @GetMapping("/getAllClients")
    public List<Cliente> findAllClients() {
        return repositoryClient.findAll();
    }

    @GetMapping("/findUser/{email}")
    public List<User> findUserEmail(@PathVariable String email) {
        return repository.findByEmail(email);
    }

    @GetMapping("/findClient/{email}")
    public List<Cliente> findClientEmail(@PathVariable String email) {
        return repositoryClient.findByEmail(email);
    }

    @GetMapping("/findUserCity/{city}")
    public List<User> findUserCity(@PathVariable String city) {
        return repository.findByCity(city);
    }

    @GetMapping("/findClientCPF/{cpf}")
    public List<Cliente> findClientCPF(@PathVariable String cpf) {
        return repositoryClient.findByCpf(cpf);
    }

    @GetMapping("/findUserID/{id}")
    public User findUserByID(@PathVariable Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }

    @GetMapping("/findClientID/{id}")
    public Cliente findClientByID(@PathVariable Integer id) {
        return repositoryClient.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }

    @DeleteMapping("/deleteUser/{id}")
    public List<User> deleteUser(@PathVariable int id) {
        repository.deleteById(id);
        return repository.findAll();
    }

    @DeleteMapping("/deleteClient/{id}")
    public List<Cliente> deleteClient(@PathVariable int id) {
        repositoryClient.deleteById(id);
        return repositoryClient.findAll();
    }

    public static void main(String[] args) {
        SpringApplication.run(RegistrationServiceApplication.class, args);
    }

}
