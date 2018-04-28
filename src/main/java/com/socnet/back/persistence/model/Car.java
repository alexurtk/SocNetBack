package com.socnet.back.persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Year;

@Entity
public class Car {

    @Id
    @GeneratedValue
    public Long id;

    public String brand, model;
    public Year year;

}