package songsearch.app.config;

import songsearch.core.search.SearchService;
import songsearch.mongo.MongoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

public class CoreConfig {
    @Bean
    public SearchService search(MongoTemplate mongoTemplate) {
        // an example of 'hiding' the details implementation, only the SearchService can be grabbed via DI
        return new SearchService(new MongoRepository(mongoTemplate));
    }

}
