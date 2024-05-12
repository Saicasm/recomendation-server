package io.spring.searchsp.kafka;

import io.spring.searchsp.core.search.MusicTrack;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.springframework.messaging.handler.annotation.Payload;
@Component
public class KafkaConsumer {

    private final BlockingQueue<List<MusicTrack>> responseQueue = new LinkedBlockingQueue<>();

    @KafkaListener(topics = "final-recommendation", groupId = "client-group")
    public void listen(@Payload List<MusicTrack> message ) {
        responseQueue.offer(message);
    }

    public List<MusicTrack> getResponse() throws InterruptedException {
        return responseQueue.take();
    }
}