package Database;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A class which represents an Artist
 * 
 * @author Michael Ambrose
 */
public class Artist implements Comparable{
    String GUID = null;
    String name = null;
    String type = null;
    float avgRating;
    List<Song> songs;
    List<Release> releases;

    //Constructor without type
    public Artist(String GUID, String name) {
        this.GUID = GUID;
        this.name = name;
        avgRating = 0;
        songs = new ArrayList<>();
        releases = new ArrayList<>();
    }

    //Constructor with type
    public Artist(String GUID, String name, String type) {
        this.GUID = GUID;
        this.name = name;
        this.type = type;
        avgRating = 0;
        songs = new ArrayList<>();
        releases = new ArrayList<>();
    }

    //returns true if the given guid matches an artist's guid
    public boolean getArtist(String id) {
        return this.GUID.equals(id);
    }

    public void calculateAvgRating() {
        float rating = 0;
        int size = 0;
        
        for(Song song : songs) {
            if(song.getRating() != 0) {
                rating += song.getRating();
                size++;
            }
        }

        this.avgRating = rating/size;
    }

    public int getDuration(){
        int duration = 0;
        for(Song s : this.songs){
            duration += s.getDuration();
        }
        return duration;
    }
    public void addSong(Song s){
        this.songs.add(s);
    }

    public void addRelease(Release r){
        this.releases.add(r);
    }

    public String getGUID() {return this.GUID;}

    public String getName() {return this.name;}

    public String getType() {
        if(this.type == null)
            return "None";
        else
            return this.type;
    }

    public float getRating() {return this.avgRating;}

    public List<Song> getSongs() {return this.songs;}
    
    public List<Release> getReleases() {return this.releases;}

    public String toString() {
        if(this.type != null)
            return "Name: " + this.name + ", Type: " + this.type;
        else
            return "Name: " + this.name;
    }

    @Override
    public int compareTo(Object o) {
        Artist r = (Artist)o;
        return this.name.compareTo(r.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return name.equals(artist.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(GUID, name);
    }
}
