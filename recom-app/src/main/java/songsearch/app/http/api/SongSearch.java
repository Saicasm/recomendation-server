package songsearch.app.http.api;

public class SongSearch {
    private String _id;

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
    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

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
