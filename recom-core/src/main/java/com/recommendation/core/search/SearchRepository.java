package com.recommendation.core.search;

import java.util.List;

public interface SearchRepository {
  List<MusicTrack> findByName(String query);
//  List<Search> list();
}
