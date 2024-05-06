package com.recommendation.dummy;

import com.recommendation.core.search.Search;
import com.recommendation.core.search.SearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmptyDataSearchRepository implements SearchRepository {
    @Override
    public List<Search> findByName(String query) {
        return null;
    }

    @Override
    public List<Search> list() {
        return null;
    }
}
