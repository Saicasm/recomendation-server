package songsearch.app.config;

import org.springframework.kafka.core.KafkaTemplate;
import songsearch.core.search.SearchService;
import songsearch.kafka.MessageProducer;
import songsearch.mongo.MongoRepository;
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

    @Bean
    public MessageProducer kafkaMessageProducer(KafkaTemplate<String, String> kafkaTemplate) {
        return new MessageProducer(kafkaTemplate);
    }
}
