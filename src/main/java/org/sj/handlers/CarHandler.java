package org.sj.handlers;

import org.sj.models.Car;
import org.sj.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.Request;
import org.springframework.web.reactive.function.Response;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by subhrajyoti_majumder on 09/10/16.
 *
 * Business logic is written here, it is like traditional service layer.
 */
@Component
public class CarHandler {

    @Autowired
    private CarRepository carRepository;

    /**
     * Retrieve all car
     * @return
     */
    public Response<Flux<Car>> allCar() {
        final Flux<Car> carFlux = Flux.fromStream(carRepository.all());
        return Response.ok().body(BodyInserters.fromPublisher(carFlux, Car.class));
    }

    /**
     * Retrieve car by Id
     *
     * @param request
     * @return
     */
    public Response<Mono<Car>> byId(Request request){
        return request.pathVariable("id").map(id->carRepository.findById(id)).map(Mono::fromFuture).
                map(mono -> Response.ok().body(BodyInserters.fromPublisher(mono, Car.class)))
                .orElseThrow(()-> new IllegalArgumentException("id not found"));
    }
}
