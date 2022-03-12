package Database;

import java.util.ArrayList;
import java.util.List;

/**
 * A class which represents a Release
 * 
 * @author Michael Ambrose
 */
public class Release {
    private String GUID = null;
    private String title = null;
    private Artist artist = null;
    private String date = null;
    private String medium = null;
    List<Song> tracks = new ArrayList<>();
    float avgRating = 0;

    public Release(String GUID, Artist artist, String title,String medium, String date, List<Song> tracks) {
        this.GUID = GUID;
        this.artist = artist;
        this.title = title;
        this.medium = medium;
        this.date = date;
        this.tracks = tracks;
    }

    //Returns the combined duration for each song in the release
    public int getDurationforRelease() {
        int duration = 0;
        for(Song song : this.getTracks()) {
            duration += song.getDuration();
        }

        return duration;
    }

    //Calculates the average rating for the release
    public void calculateRating() {
        float rating = 0;
        int size = 0;

        for(Song song : this.getTracks()) {
            rating += song.getRating();

            if(song.getRating() != 0)
                size++;
        }
        
        this.avgRating = rating/size;
    }

    public String getGUID() {return this.GUID;}

    public String getTitle() {return this.title;}

    public Artist getArtist() {return this.getArtist();}

    public String getMedium() {return this.medium;}

    public String getDate() {return this.date;}

    public List<Song> getTracks() {return this.tracks;}

    public float getRating() {return this.avgRating;}

    public String toString() {
        return "Title: " + this.title + ", Artist: " + this.artist.getName() + ", " + this.medium + ", Issued: " + this.date;
    }
    
    public int compareTo(Release other) {
        return this.title.compareTo(other.getTitle());
    }
}
