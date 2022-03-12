package Database;

public class Song implements Comparable<Song> {
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

    @Override
    public int compareTo(Song other) {
        return this.title.compareTo(other.getTitle());
    }
}
