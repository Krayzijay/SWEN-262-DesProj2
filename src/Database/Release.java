package Database;

import java.util.ArrayList;
import java.util.List;

public class Release {
    String GUID = null;
    String title = null;
    Artist artist = null;
    String date = null;
    Medium medium = null;
    List<Song> tracks = new ArrayList<>();
    float userRating = 0;
    float avgRating = 0;

    enum Medium {
        DIGITAL,
        CD, 
        VINYL
    }

    public Release(String GUID, Artist artist, String title, String date, Medium medium, List<Song> tracks) {
        this.GUID = GUID;
        this.artist = artist;
        this.date = date;
        this.medium = medium;
        this.tracks = tracks;
    }
    
}
