package io.spring.searchsp.core.search;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "dataset")
public class MusicTrack {



    private String artist_name;

    private String track_name;
    private String track_id;
    public String getTrackId() {
        return track_id;
    }

    public void setTrackId(String trackId) {
        this.track_id = trackId;
    }


    // Getters and Setters


    public String getArtist_name() {
        return artist_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }

    public String getTrack_name() {
        return track_name;
    }

    public void setTrack_name(String track_name) {
        this.track_name = track_name;
    }
}
