package org.b3log.zephyr;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import javax.jms.Queue;

@SpringBootApplication
public class TipickerApplication {

	@Bean
	public Queue queue() {
		return new ActiveMQQueue("sample.queue");
	}

	public static void main(String[] args) {
		SpringApplication.run(TipickerApplication.class, args);
	}
}
/*
Paragraph的Tag应该是固定的，这是基本元素
这个Paragraph一般存储在一个Article中，但并不排除单拿出来的可能
Article可能被收录到任意Book中
Book也可能被任意Libarary保存
并且均可以重复出现。但是在同层级下不能重复
数据表层级保存：
Paragraph表保存Tag和正文
Article保存Tag和Paragraph
Book保存Tag和Article
Library保存Tag和Book
 */