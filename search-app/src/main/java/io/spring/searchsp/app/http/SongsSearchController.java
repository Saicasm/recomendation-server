package io.spring.searchsp.app.http;

import io.spring.searchsp.core.search.*;
import io.spring.searchsp.kafka.KafkaConsumer;
import io.spring.searchsp.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/rec")
@CrossOrigin(origins = "http://ui.distributed-systems.com:30080/", allowedHeaders = "*", exposedHeaders = "*",methods = {
        RequestMethod.DELETE,
        RequestMethod.GET,
        RequestMethod.OPTIONS,
        RequestMethod.PATCH,
        RequestMethod.PUT,
})
public class SongsSearchController {
    private final SearchService searchService;
    private final KafkaProducer producer;
    private final KafkaConsumer consumer;
    @Autowired
    public SongsSearchController(SearchService searchService, KafkaProducer producer ,  KafkaConsumer consumer) {
        this.searchService = searchService;
        this.producer=producer;
        this.consumer=consumer;
    }
//    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/search")
    public ResponseEntity<List<MusicTrack>> getSongsForKeyword(@RequestParam("q") String query) {
        List<MusicTrack> songResults = searchService.search(query);
        return ResponseEntity.ok(songResults);
    }



//    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/recommendation")
    public ResponseEntity<List<MusicTrack>> getRecommendationForSongs(@RequestBody List<MusicTrack> recommendationRequest) throws Exception {
        producer.sendMessage("song-ids", recommendationRequest);
        List<MusicTrack> response = consumer.getResponse();
        return ResponseEntity.ok((response));
    }

}
