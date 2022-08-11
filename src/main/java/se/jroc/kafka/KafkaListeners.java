package se.jroc.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(
            topics = "jxro",
            groupId = "groupId",
            containerFactory = "messageFactory"
    )
    void listener(Message data) {
        System.out.println("Listener received: " + data + " 🎉");
    }
}
