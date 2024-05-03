package com.recommendation.core.search;



import java.util.List;

public class SearchService {
    private final SearchRepository searchRepository;

    public SearchService(SearchRepository searchRepository) {
        this.searchRepository = searchRepository;
    }
    public List<Search> search(String query) {
        if (query.isEmpty()) {
            return searchRepository.list();
        } else {
            List<Search> nameResults = searchRepository.findByName(query);

            return nameResults;
        }
    }
}
