package com.recommendation.mongo;

import com.recommendation.core.search.MusicTrack;
import com.recommendation.core.search.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

        // Projecting only specific fields
//        query.fields().include("artistName").include("trackName").include("popularity");

        return mongoTemplate.find(query, MusicTrack.class);
    }

//    @Override
//    public List<Search> list() {
//        return null;
//    }
}
