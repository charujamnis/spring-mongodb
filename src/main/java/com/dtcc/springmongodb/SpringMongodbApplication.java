package com.dtcc.springmongodb;

import com.dtcc.springmongodb.model.User;
import com.dtcc.springmongodb.repository.CarMongoRepository;
import com.dtcc.springmongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.MongoDbFactoryParser;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = CarMongoRepository.class)
public class SpringMongodbApplication  {

    @Autowired
    private UserRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(SpringMongodbApplication.class, args);
    }

  /*  @Bean
    public MongoTemplate mongoTemplate(MongoDatabaseFactory mongoDbFactory, MongoMappingContext context) {

        MappingMongoConverter converter = new MappingMongoConverter(new DefaultDbRefResolver(mongoDbFactory), context);
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));

        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory, converter);

        return mongoTemplate;

    }*/
   /* @Override
    public void run(String... args) throws Exception {
        repository.save(new User("Meera", "JAckson","Roy","mj"));
        repository.save(new User("Sam", "Mark","Rey","mj"));

        // fetch all customers
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (User user : repository.findAll()) {
            System.out.println(user);
        }
        System.out.println();

        System.out.println("User found with findByFirstName('Meera'):");
        System.out.println("--------------------------------");
        System.out.println(repository.findByFirstName("Sam"));
    }*/
}
