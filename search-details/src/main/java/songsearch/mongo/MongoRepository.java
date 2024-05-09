package songsearch.mongo;

import songsearch.core.search.MusicTrack;
import songsearch.core.search.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;



@Repository
public class MongoRepository implements SearchRepository {
    private final  MongoTemplate mongoTemplate;

    @Autowired
    public MongoRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<MusicTrack> findByName(String query1) {
        Query query = new Query();
        query.addCriteria(Criteria.where("track_name").regex(query1, "i"));
        // Adding sorting by field "fieldName" in ascending order
        query.with(Sort.by(Sort.Direction.DESC, "popularity"));
        // Adding limit to the query
        query.limit(10); // Limiting to 10 documents
        return mongoTemplate.find(query, MusicTrack.class);
    }

    @Override
    public List<MusicTrack> getRecommendation(List<MusicTrack> songsList) {
        return null;
    }

}
