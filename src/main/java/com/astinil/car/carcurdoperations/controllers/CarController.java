package com.astinil.car.carcurdoperations.controllers;

import com.astinil.car.carcurdoperations.entity.Car;
import com.astinil.car.carcurdoperations.model.CarModel;
import com.astinil.car.carcurdoperations.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car-operations")
public class CarController {
    private final CarService carSevice;

    public CarController(CarService carSevice) {
        this.carSevice = carSevice;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Car>> getAllCars() {
        return carSevice.findAll();
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Car> findCarById(@PathVariable Integer id) {
        return carSevice.findCarById(id);
    }
    @PostMapping("/add")
    public ResponseEntity<Car> saveCar(@RequestBody CarModel carModel) {
        return carSevice.saveCar(carModel);
    }
    @PutMapping("/upadate/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Integer id, @RequestBody CarModel carModel) {
        return carSevice.updateCar(id, carModel);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Car> deleteCar(@PathVariable Integer id) {
        return carSevice.deleteCar(id);
    }
}
