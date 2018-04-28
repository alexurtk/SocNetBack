package com.socnet.back.persistence.repository;

import com.socnet.back.persistence.model.Car;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long>, JpaSpecificationExecutor<Car> {
}