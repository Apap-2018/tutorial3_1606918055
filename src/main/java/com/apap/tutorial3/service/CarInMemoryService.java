package com.apap.tutorial3.service;

import com.apap.tutorial3.model.CarModel;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Service
public class CarInMemoryService implements CarService {

    private List<CarModel> archiveCar;

    public CarInMemoryService() {
        this.archiveCar = new LinkedList<>();
    }

    @Override
    public void addCar(CarModel car) {
        this.archiveCar.add(car);
    }

    @Override
    public List<CarModel> getCarList() {
        return this.archiveCar;
    }

    @Override
    public CarModel getCarDetail(String id) {
        CarModel car = null;

        Iterator<CarModel> iter = this.archiveCar.iterator();
        while(iter.hasNext() && car == null) {
            CarModel temp = iter.next();
            if(temp.getId().equals(id)) {
                car = temp;
            }
        }

        return car;
    }

    @Override
    public CarModel removeCar(String id) {
        CarModel car = this.getCarDetail(id);
        if(car != null)
            this.getCarList().remove(car);
        return car;
    }
}
