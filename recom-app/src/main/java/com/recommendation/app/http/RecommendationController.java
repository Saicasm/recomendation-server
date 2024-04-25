package com.recommendation.app.http;

import com.recommendation.app.http.api.SongResults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/rec")
public class RecommendationController {

    @GetMapping("/search")
    public ResponseEntity<SongResults> getSongsForKeyword(@RequestParam("q") String query){
        SongResults songResults = null;
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
