package com.dtcc.springmongodb.repository;

import com.dtcc.springmongodb.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
    public User findByFirstName(String firstName);
}
