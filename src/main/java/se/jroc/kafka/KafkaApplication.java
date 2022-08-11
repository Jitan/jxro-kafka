package se.jroc.jxrokafka;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

import java.time.LocalDateTime;

@SpringBootApplication
public class JxroKafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JxroKafkaApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(KafkaTemplate<String, Message> kafkaTemplate) {
        return args -> {
            for (int i = 0; i < 99; i++) {
                kafkaTemplate.send("jxro",
                        new Message("Hello World " + i, LocalDateTime.now()));
            }

        };
    }
}
