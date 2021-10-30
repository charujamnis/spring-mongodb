package com.dtcc.springmongodb.controller;

import com.dtcc.springmongodb.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller

public class UserController {
  /*  private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("carList", repository.findAll());
        return "home";
    }
   /* @PostMapping("/addUser")
    public String saveUser(@RequestBody User user){
        userRepository.save(user);
        return "New User Added with user id "+user.getId();
    }



    @GetMapping("/findAllUsers/{id}")
    public Optional<User> getUsers(@PathVariable Long id){
        return userRepository.findById(id);
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Long id){
         userRepository.deleteById(id);
        return "User deleted with user id "+id;
    }*/
}
