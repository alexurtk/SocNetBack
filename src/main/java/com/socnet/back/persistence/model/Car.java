package com.socnet.back.persistence.model;

import lombok.Data;

import javax.persistence.*;
import java.time.Year;

@Data
@Entity
@Table(name = "CAR")
public class Car {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    public Long id;

    @Column(name = "BRAND")
    private String brand;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "YEAR")
    private Year year;

}