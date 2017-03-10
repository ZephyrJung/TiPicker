package org.b3log.zephyr;

import org.b3log.zephyr.websocket.client.GreetingService;
import org.b3log.zephyr.websocket.client.SimpleGreetingService;
import org.b3log.zephyr.websocket.echo.DefaultEchoService;
import org.b3log.zephyr.websocket.echo.EchoService;
import org.b3log.zephyr.websocket.echo.EchoWebSocketHandler;
import org.b3log.zephyr.websocket.snake.SnakeWebSocketHandler;
import org.b3log.zephyr.websocket.reverse.ReverseWebSocketEndpoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.PerConnectionWebSocketHandler;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@SpringBootApplication
public class TipickerApplication extends SpringBootServletInitializer
		implements WebSocketConfigurer {

//	@Bean
//	public Queue queue() {
//		return new ActiveMQQueue("sample.queue");
//	}



	public static void main(String[] args) {
		SpringApplication.run(TipickerApplication.class, args);
	}

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(echoWebSocketHandler(), "/echo").withSockJS();
		registry.addHandler(snakeWebSocketHandler(), "/snake").withSockJS();
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(TipickerApplication.class);
	}

	@Bean
	public EchoService echoService() {
		return new DefaultEchoService("Did you say \"%s\"?");
	}

	@Bean
	public GreetingService greetingService() {
		return new SimpleGreetingService();
	}

	@Bean
	public WebSocketHandler echoWebSocketHandler() {
		return new EchoWebSocketHandler(echoService());
	}

	@Bean
	public WebSocketHandler snakeWebSocketHandler() {
		return new PerConnectionWebSocketHandler(SnakeWebSocketHandler.class);
	}


	@Bean
	public ReverseWebSocketEndpoint reverseWebSocketEndpoint() {
		return new ReverseWebSocketEndpoint();
	}

	@Bean
	public ServerEndpointExporter serverEndpointExporter() {
		return new ServerEndpointExporter();
	}
}
