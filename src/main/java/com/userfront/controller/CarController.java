package com.userfront.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import com.userfront.dao.CarDAo;

public class CarController {

    private CarDAo carDao;

    @GetMapping("/cars")
    public List<CarDAo> getCars() {
        return carDao.cars;
    }

}   