package Database;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A class which represents a Release
 * 
 * @author Michael Ambrose
 */
public class Release implements Comparable{
    String GUID = null;
    String title = null;
    Artist artist = null;
    String date = null;
    String medium = null;
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
    public int getDuration() {
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
        if(size == 0){
            this.avgRating = 0;
        }else{
            this.avgRating = rating/size;
        }
    }

    public String getGUID() {return this.GUID;}

    public Artist getArtist() {
        return this.artist;
    }

    public String getMedium() {return this.medium;}

    public String getDate() {return this.date;}

    public List<Song> getTracks() {return this.tracks;}

    public float getRating() {
        calculateRating();
        return this.avgRating;
    }

    public String getTitle() {
        return title;
    }

    public String toString() {
        return "Release Title: " + this.title + ", Artist: " + this.artist.getName() + ", " + this.medium + ", Issued: " + this.date;
    }

    @Override
    public int compareTo(Object o) {
        Release r = (Release)o;
        return this.title.compareTo(r.getTitle());
    }
}
