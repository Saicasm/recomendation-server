package io.spring.searchsp.app.config;

//import org.springframework.kafka.core.KafkaTemplate;
import io.spring.searchsp.core.search.SearchService;
//import io.spring.searchsp.kafka.MessageProducer;
import io.spring.searchsp.mongo.MongoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

public class CoreConfig {
    @Bean
    public SearchService searchService(MongoTemplate mongoTemplate) {
        // an example of 'hiding' the details implementation, only the SearchService can be grabbed via DI
        return new SearchService(new MongoRepository(mongoTemplate));
    }
    @Bean
    public MongoRepository mongoRepository(MongoTemplate mongoTemplate) {
        return new MongoRepository(mongoTemplate);
    }

//    @Bean
//    public MessageProducer kafkaMessageProducer(KafkaTemplate<String, String> kafkaTemplate) {
//        return new MessageProducer(kafkaTemplate);
//    }
}
