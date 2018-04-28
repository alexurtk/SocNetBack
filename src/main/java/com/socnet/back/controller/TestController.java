package com.socnet.back.controller;

import com.socnet.back.persistence.filter.Filter;
import com.socnet.back.persistence.filter.internal.Comparison;
import com.socnet.back.persistence.filter.internal.Condition;
import com.socnet.back.persistence.model.Car;
import com.socnet.back.persistence.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 26.04.2018.
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {

    private final CarRepository carRepository;

    @Autowired
    public TestController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    @GetMapping(value = "/t1")
    public String test(){
//        Car passat = new Car();
//        passat.brand = "volkswagen";
//        passat.model = "passat";
//
//        Car mazda = new Car();
//        mazda.brand = "mazda";
//        mazda.model = "6";
//
//        Car _350z = new Car();
//        _350z.brand = "nissan";
//        _350z.model = "350z";


//        Car car1 = new Car();
//        car1.brand = "volkswagen";
//        car1.model = "model1";
//
//        Car car2 = new Car();
//        car2.brand = "volkswagen";
//        car2.model = "model2";
//
//        Car car3 = new Car();
//        car3.brand = "mazda";
//        car3.model = "model1";
//
//        Car car4 = new Car();
//        car4.brand = "mazda";
//        car4.model = "model2";
//
//        Car car5 = new Car();
//        car5.brand = "volkswagen";
//        car5.model = "model3";
//
//        Car car6 = new Car();
//        car6.brand = "mazda";
//        car6.model = "model3";
//
//
//        carRepository.save(car1);
//        carRepository.save(car2);
//        carRepository.save(car3);
//        carRepository.save(car4);
//        carRepository.save(car5);
//        carRepository.save(car6);



        Filter filter = new Filter();
//        filter.addCondition(new Condition.Builder().setComparison(Comparison.eq).setField("brand").setValue("volkswagen").build());
//        filter.addCondition(new Condition.Builder().setComparison(Comparison.eq).setField("model").setValue("model1").build());

        List<String> list = new ArrayList<>();
        list.add("model1");
        list.add("model2");

        String[] arr = new String[]{"model1","model2"};

        List<String> list2 = new ArrayList<>();
        list2.add("mazda");


        filter.addCondition(new Condition.Builder().setComparison(Comparison.in).setField("model").setValue(list).build());
        filter.addCondition(new Condition.Builder().setComparison(Comparison.in).setField("brand").setValue(list2).build());

        List<Car> carList = carRepository.findAll(filter);




        return "test";
    }

}
