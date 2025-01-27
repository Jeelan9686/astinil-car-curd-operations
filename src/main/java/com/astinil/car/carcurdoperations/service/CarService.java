package com.astinil.car.carcurdoperations.service;

import com.astinil.car.carcurdoperations.entity.Car;
import com.astinil.car.carcurdoperations.model.CarModel;
import com.astinil.car.carcurdoperations.repository.CarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public ResponseEntity<Car> saveCar(CarModel carModel) {
        Car car = new Car();
        car.setName(carModel.getName());
        car.setBrand(carModel.getBrand());
        car.setModel(carModel.getModel());
        car.setColor(carModel.getColor());
        car.setPrice(carModel.getPrice());
        car.setType(carModel.getType());
        return new ResponseEntity<>(carRepository.save(car), HttpStatus.CREATED);
    }

    public ResponseEntity<Car> updateCar(Integer id, CarModel carModel) {
        carRepository.findById(id).ifPresent((carUpdate) -> {
            Car car = new Car();
            car.setName(carUpdate.getName());
            car.setBrand(carUpdate.getBrand());
            car.setModel(carUpdate.getModel());
            car.setColor(carUpdate.getColor());
            car.setPrice(carUpdate.getPrice());
            car.setType(carUpdate.getType());
            carRepository.save(carUpdate);
        });
        if (carRepository.findById(id).isPresent()) {
            return new ResponseEntity<>(carRepository.findById(id).get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Car> deleteCar(Integer id) {
        if (carRepository.findById(id).isPresent()) {
            carRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Car> findCarById(Integer id) {
        if (carRepository.findById(id).isPresent()) {
            return new ResponseEntity<>(carRepository.findById(id).get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<List<Car>> findAll() {
        return new ResponseEntity<>(carRepository.findAll(), HttpStatus.OK);
    }
}
