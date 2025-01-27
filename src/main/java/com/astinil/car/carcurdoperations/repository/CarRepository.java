package com.astinil.car.carcurdoperations.repository;

import com.astinil.car.carcurdoperations.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
}
