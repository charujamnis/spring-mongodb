package com.dtcc.springmongodb.controller;

import com.dtcc.springmongodb.model.Car;
import com.dtcc.springmongodb.model.User;
import com.dtcc.springmongodb.repository.CarMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@Controller
public class CarController {

    @Autowired
    CarMongoRepository carRepository;

    //to remove leading and trailing whitespaces
    @InitBinder()
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }


    @GetMapping("/getHomePage")
    public String showHome(Model model){

        Car newCar =new Car();
        model.addAttribute("carList",carRepository.findAll());
        model.addAttribute("car",newCar);
        model.addAttribute("search","");
        return "home";
    }

    @PostMapping("/addCar")
    public String addCar(@Valid @ModelAttribute("car") Car car, BindingResult result, ModelMap model) {

        if (result.hasErrors()) {
            model.addAttribute("carList",carRepository.findAll());
            model.addAttribute("search","");
            return "home";
        }

        if(car.getId()==null){
            carRepository.insert(car);
        }
         else{
            carRepository.save(car);
        }
         model.addAttribute("carList",carRepository.findAll());
         model.addAttribute("car",new Car());
         model.addAttribute("search","");
        //carRepository.insert(car);
        return "home";
    }

    @GetMapping("/getAllCars")
    public String getAllCars(Model model){
        model.addAttribute("allCars",carRepository.findAll());
        return "home";
    }


    @GetMapping("/searchCars")
    public String searchCars(@RequestParam String search,Model model) {
        System.out.println("The search is "+search);
        model.addAttribute("carList",carRepository.findAll());
        model.addAttribute("car",new Car());
        model.addAttribute("carsSearchList",carRepository.findCarsByMake(search));
        System.out.println(carRepository.findCarsByMake(search));
        System.out.println();
        return "home";
    }

    @GetMapping("/updateCarById/{id}")
    public String updateCarById(@PathVariable("id") String id, Model model){
        Optional<Car> car=carRepository.findById(id);
        if(car.isEmpty()){
            System.out.println("in empty");
            return "home";
        }
        else{
            System.out.println("updates Car row i s"+car);
            model.addAttribute("car",car);
            return "updateCar";
        }
    }

    //NOT WORKING
   // @PutMapping("/updateCar")
  /*  @PutMapping("/updateCar")
    public String updateTheCar(@ModelAttribute("updateCarRow") Car updateCarRow, Model model){
        System.out.println("in update car");
        Car updatedCar=carRepository.save(updateCarRow);
        System.out.println("saved teh object"+updatedCar);
        model.addAttribute("carList",carRepository.findAll());

        model.addAttribute("car",new Car());
        model.addAttribute("carsSearchList",carRepository.findCarsByMake(""));
        System.out.println("going home");
        return "home";
    }*/
}

/*
* user = mongoTemplate.findOne(
  Query.query(Criteria.where("name").is("Jack")), User.class);
user.setName("Jim");
mongoTemplate.save(user, "user");*/