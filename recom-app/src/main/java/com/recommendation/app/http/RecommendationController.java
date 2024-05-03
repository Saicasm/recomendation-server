package com.recommendation.app.http;

import com.recommendation.app.http.api.SongResults;
import com.recommendation.core.search.Search;
import com.recommendation.core.search.SearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("api/v1/rec")
public class RecommendationController {
    private final SearchService searchService;

    public RecommendationController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<Search>> getSongsForKeyword(@RequestParam("q")  String query){
        List<Search> songResults = searchService.search(query);
        return ResponseEntity.ok(songResults);
    }

    @PostMapping("/playlist")
    public ResponseEntity<SongResults> getRecommendationForPlaylist(){
        SongResults songResults =  null;
        return ResponseEntity.ok(songResults);
    }
    @PostMapping("/recommendation")
    public ResponseEntity<SongResults> getRecommendationForSongs(){
        SongResults songResults =  null;
        return ResponseEntity.ok(songResults);
    }
}
