package io.spring.searchsp.core.search;

import java.util.List;

public interface SearchRepository {
  List<MusicTrack> findByName(String query);
  List<MusicTrack> getRecommendation(List<MusicTrack> songsList);
}
