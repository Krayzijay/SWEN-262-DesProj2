package Database;

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
    
    //Constructor
    public Song(String GUID, Artist artist, int duration, String title) {
        this.GUID = GUID;
        this.artist = artist;
        this.duration = duration;
        this.title = title;
        userRating = 0;
    }

    public void rateSong(float rating) {this.userRating = rating;}

    public String getGUID() {return this.GUID;}

    public String getTitle() {return this.title;}

    public Artist getArtist() {return this.artist;}

    public int getDuration() {return this.duration;}

    public float getRating() {return this.userRating;}
    
    public String toString() {
        return "Title: " + this.title + ", Artist: " + this.artist.getName() + ", Duration: " + this.duration;
    }
}
