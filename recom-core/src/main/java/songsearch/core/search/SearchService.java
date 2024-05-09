package songsearch.core.search;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchService {
    private final SearchRepository searchRepository;

    @Autowired
    public SearchService(SearchRepository searchRepository) {
        this.searchRepository = searchRepository;
    }

    public List<MusicTrack> search(String query) {
        if (query.isEmpty()) {
            return null;
        } else {
            return searchRepository.findByName(query);
        }
    }
}
