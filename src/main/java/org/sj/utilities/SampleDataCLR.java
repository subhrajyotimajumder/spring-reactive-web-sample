package org.sj.utilities;

import org.sj.models.Car;
import org.sj.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.stream.Stream;

/**
 * Created by subhrajyoti_majumder on 09/10/16.
 * Data Generator
 */
@Component
public class SampleDataCLR implements CommandLineRunner {

    @Autowired
    private CarRepository carRepository;
    private Random carReleaseYear = new Random();

    @Override
    public void run(String... strings) throws Exception {

        Stream.of("Volkswagen Ameo", "Hyundai Verna", "Toyota Corolla Altis", "BMW M3", "Porsche 911")
                .forEach(carName -> carRepository.save(new Car(carName, getCarReleaseYear())));
        carRepository.all().forEach(car->System.out.println(car.toString()));
    }


    private int getCarReleaseYear(){
        return 2000+carReleaseYear.nextInt(16);
    }

    public void setCarRepository(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
}
