package org.b3log.zephyr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TipickerApplication{

//	@Bean
//	public Queue queue() {
//		return new ActiveMQQueue("sample.queue");
//	}
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		return application.sources(TipickerApplication.class);
//	}

	public static void main(String[] args) {
		SpringApplication.run(TipickerApplication.class, args);
	}

}
