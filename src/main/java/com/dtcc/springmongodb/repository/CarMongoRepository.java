package com.dtcc.springmongodb.repository;

import com.dtcc.springmongodb.model.Car;
import com.dtcc.springmongodb.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarMongoRepository extends MongoRepository<Car,String> {
   // public List<Car> findByMake(String make);

    @Query("{ 'make' : ?0 }")
    List<Car> findCarsByMake(String make);
}