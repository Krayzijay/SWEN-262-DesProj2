package src.Database;


public class Song {
    String GUID = null;
    String title = null;
    Artist artist = null;
    int duration = 0;
    float userRating;
    float avgRating;

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
    
    public String toString() {
        return "Title: " + this.title + ", Artist: " + this.artist.getName() + ", Duration: " + this.duration;
    }
}
