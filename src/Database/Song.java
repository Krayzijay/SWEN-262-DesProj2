package src.Database;


/**
 * A class which represents a Song
 * 
 * @author Michael Ambrose
 */
public class Song {
    String GUID = null;
    String title = null;
    Artist artist = null;
    int duration = 0;
    float userRating;
    float avgRating;

    //Constructor
    public Song(String GUID, Artist artist, int duration, String title) {
        this.GUID = GUID;
        this.artist = artist;
        this.duration = duration;
        this.title = title;
        userRating = 0;
        avgRating = 0;
    }

    public String getGUID() {
        return this.GUID;
    }

    public String getTitle() {
        return this.title;
    }

    public Artist getArtist() {
        return this.artist;
    }

    public float getUserRating() {
        return userRating;
    }

    public float getAvgRating() {
        return avgRating;
    }

    public void setUserRating(float userRating) {
        this.userRating = userRating;
    }

    public void setAvgRating(float avgRating) {
        this.avgRating = avgRating;
    }
    
    public String toString() {
        return "Title: " + this.title + ", Artist: " + this.artist.getName() + ", Duration: " + this.duration;
    }
    @Override
    public int compareTo(Song other) {
        return this.title.compareTo(other.getTitle());
    }
}
