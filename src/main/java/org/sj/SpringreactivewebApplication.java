package org.sj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.RouterFunction;
import org.springframework.web.reactive.function.RouterFunctions;
import reactor.ipc.netty.http.HttpServer;

@SpringBootApplication
public class SpringreactivewebApplication {

	/**
	 * Reactor Netty Server, handles reactive http routes
	 * @param router
	 * @return
     */
	@Bean
	public HttpServer server(RouterFunction<?> router){
		HttpHandler httpHandler = RouterFunctions.toHttpHandler(router);
		HttpServer httpServer = HttpServer.create(8000);
		httpServer.start(new ReactorHttpHandlerAdapter(httpHandler));
		return  httpServer;
	}

	/**
	 * All we know probably simplest way to boot.
	 * @param args
     */
	public static void main(String[] args) {
		SpringApplication.run(SpringreactivewebApplication.class, args);
	}
}
