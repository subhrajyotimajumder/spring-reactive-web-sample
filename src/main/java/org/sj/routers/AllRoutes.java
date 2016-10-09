package org.sj.routers;

import org.sj.handlers.CarHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.RequestPredicates;
import org.springframework.web.reactive.function.RouterFunction;
import org.springframework.web.reactive.function.RouterFunctions;

/**
 * Created by subhrajyoti_majumder on 09/10/16.
 * Request mappings
 */
@Component
public class AllRoutes {

    @Bean
    public RouterFunction<?> routers(CarHandler carHandler){
        return RouterFunctions.route(RequestPredicates.GET("/car"), request -> carHandler.allCar()).
                and(RouterFunctions.route(RequestPredicates.GET("/car/{id}"), carHandler::byId));
    }
}
