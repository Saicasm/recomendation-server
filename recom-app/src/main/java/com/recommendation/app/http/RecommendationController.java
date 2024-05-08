package com.recommendation.app.http;

import com.recommendation.core.search.MusicTrack;
import com.recommendation.kafka.MessageProducer;
import com.recommendation.app.http.api.RecomRequest;
import com.recommendation.app.http.api.SongResults;
import com.recommendation.core.search.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/rec")
public class RecommendationController {
    private final MessageProducer messageProducer;
    private final SearchService searchService;

    @Autowired
    public RecommendationController(SearchService searchService, MessageProducer messageProducer) {
        this.searchService = searchService;
        this.messageProducer = messageProducer;
    }

    @GetMapping("/search")
    public ResponseEntity<List<MusicTrack>> getSongsForKeyword(@RequestParam("q") String query) {
        List<MusicTrack> songResults = searchService.search(query);
        return ResponseEntity.ok(songResults);
    }

    @PostMapping("/playlist")
    public ResponseEntity<SongResults> getRecommendationForPlaylist() {
        SongResults songResults = null;
        return ResponseEntity.ok(songResults);
    }

    @PostMapping("/recommendation")
    public ResponseEntity<SongResults> getRecommendationForSongs(@RequestBody List<RecomRequest> recommendationRequest) {
        messageProducer.sendMessage("RecommendationRequest", recommendationRequest.toString());
        SongResults songResults = null;
        return ResponseEntity.ok(songResults);
    }
}
