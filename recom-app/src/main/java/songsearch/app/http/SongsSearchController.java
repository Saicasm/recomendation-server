package songsearch.app.http;

import songsearch.core.search.MusicTrack;
import songsearch.kafka.MessageProducer;
import songsearch.core.search.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/rec")
public class SongsSearchController {
    private final MessageProducer messageProducer;
    private final SearchService searchService;

    @Autowired
    public SongsSearchController(SearchService searchService, MessageProducer messageProducer) {
        this.searchService = searchService;
        this.messageProducer = messageProducer;
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/search")
    public ResponseEntity<List<MusicTrack>> getSongsForKeyword(@RequestParam("q") String query) {
        List<MusicTrack> songResults = searchService.search(query);
        return ResponseEntity.ok(songResults);
    }

//    @PostMapping("/playlist")
//    public ResponseEntity<SongResults> getRecommendationForPlaylist() {
//        SongResults songResults = null;
//        return ResponseEntity.ok(songResults);
//    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/recommendation")
    public  ResponseEntity<List<MusicTrack>> getRecommendationForSongs(@RequestBody List<MusicTrack> recommendationRequest) {
        messageProducer.sendMessage("RecommendationRequest", recommendationRequest.toString());
        return ResponseEntity.ok(recommendationRequest);
    }
}
