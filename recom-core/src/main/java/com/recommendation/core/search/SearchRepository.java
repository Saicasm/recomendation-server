package com.recommendation.core.search;

import java.util.List;

public interface SearchRepository {
  List<Search> findByName(String query);
  List<Search> list();
}
