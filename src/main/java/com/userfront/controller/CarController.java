package com.userfront.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.userfront.dao.CarDAo;
@Controller
@RequestMapping("/car")
public class CarController {

    private CarDAo carDao;

    @GetMapping("/cars")
    public List<CarDAo> getCars() {
        return carDao.cars;
    }

}   