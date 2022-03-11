package src.Database;

import java.util.ArrayList;
import java.util.List;

/**
 * A class which represents a Release
 * 
 * @author Michael Ambrose
 */
public class Release {
    String GUID = null;
    String title = null;
    Artist artist = null;
    String date = null;
    String medium = null;
    List<Song> tracks = new ArrayList<>();
    float userRating = 0;
    float avgRating = 0;

    public Release(String GUID, Artist artist, String title,String medium, String date, List<Song> tracks) {
        this.GUID = GUID;
        this.artist = artist;
        this.title = title;
        this.medium = medium;
        this.date = date;
        this.tracks = tracks;
    }

    public String getTitle() {
        return title;
    }

    public String getGUID() {return this.GUID;}

    public Artist getArtist() {return this.getArtist();}

    public String getMedium() {return this.medium;}

    public String getDate() {return this.date;}

    public List<Song> getTracks() {return this.tracks;}

    public String toString() {
        return "Title: " + this.title + ", Artist: " + this.artist.getName() + ", " + this.medium + ", Issued: " + this.date;
    }
}
