package org.sj.repositories;


import org.sj.models.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

/**
 * Created by subhrajyoti_majumder on 09/10/16.
 * Spring data Repo
 */
public interface CarRepository extends MongoRepository<Car, String> {

    @Query("{}")
    Stream<Car> all();

    CompletableFuture<Car> findById(String id);
}
