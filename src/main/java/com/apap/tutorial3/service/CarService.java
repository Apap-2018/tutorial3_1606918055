package com.apap.tutorial3.service;

import com.apap.tutorial3.model.CarModel;

import java.util.List;

/**
 * Car service
 */
public interface CarService {

    void addCar(CarModel car);

    List<CarModel> getCarList();

    CarModel getCarDetail(String id);

    CarModel removeCar(String id);
}
