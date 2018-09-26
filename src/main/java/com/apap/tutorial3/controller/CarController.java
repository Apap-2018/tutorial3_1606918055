package com.apap.tutorial3.controller;

import com.apap.tutorial3.model.CarModel;
import com.apap.tutorial3.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarController {

    @Autowired
    private CarService mobilService;

    private static String redirectTo404() {
        return "http404";
    }

    @RequestMapping("/car/add")
    public String add(@RequestParam(value = "id") String id,
                      @RequestParam(value = "brand") String brand,
                      @RequestParam(value = "type") String type,
                      @RequestParam(value = "price") long price,
                      @RequestParam(value = "amount") int amount) {
        CarModel car = new CarModel(id, brand, type, price, amount);
        mobilService.addCar(car);
        return "add";
    }

    private String viewCarById(String id, Model model) {
        CarModel car = mobilService.getCarDetail(id);
        if(car == null) {
            return CarController.redirectTo404();
        }

        model.addAttribute("car", car);
        return "view-car";
    }

    @RequestMapping("/car/view")
    public String view(@RequestParam(value = "id", required = false) String id, Model model) {
        return this.viewCarById(id, model);
    }

    @RequestMapping("/car/view/{id}")
    public String viewPath(@PathVariable String id, Model model) {
        return this.viewCarById(id, model);
    }

    @RequestMapping("/car/viewall")
    public String viewAll(Model model) {
        model.addAttribute("listCar", mobilService.getCarList());
        return "viewall-car";
    }

    @RequestMapping("/car/{id}/amount/{amount}")
    public String updateAmount(@PathVariable String id, @PathVariable int amount, Model model) {
        CarModel car = mobilService.getCarDetail(id);
        if (car == null) {
            return CarController.redirectTo404();
        }

        car.setAmount(amount);
        model.addAttribute("message", "Update Amount");
        return "success";
    }

    @RequestMapping("/car/delete/{id}")
    public String deleteCar(@PathVariable String id, Model model) {
        CarModel car = mobilService.removeCar(id);

        if(car == null) {
            return CarController.redirectTo404();
        }

        model.addAttribute("message", "Mobile id:" + id + " berhasil dihapus");
        return "success";
    }

    @RequestMapping("/404")
    public String http404() {
        return "http404";
    }
}
