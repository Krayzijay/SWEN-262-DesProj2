package src.Database;

import java.util.ArrayList;
import java.util.List;

/**
 * A class which represents an Artist
 * 
 * @author Michael Ambrose
 */
public class Artist {
    String GUID = null;
    String name = null;
    String type = null;
    List<Song> songs;
    List<Release> releases;

    //Constructor without type
    public Artist(String GUID, String name) {
        this.GUID = GUID;
        this.name = name;
        songs = new ArrayList<>();
        releases = new ArrayList<>();
    }

    //Constructor with type
    public Artist(String GUID, String name, String type) {
        this.GUID = GUID;
        this.name = name;
        this.type = type;
        songs = new ArrayList<>();
        releases = new ArrayList<>();
    }

    //returns true if the given guid matches an artist's guid
    public boolean getArtist(String id) {
        return this.GUID.equals(id);
    }

    public String getGUID() {return this.GUID;}

    public String getName() {return this.name;}

    public String getType() {
        if(this.type == null)
            return "None";
        else
            return this.type;
    }

    public List<Release> getReleases() {
        return releases;
    }

    public List<Song> getSongs() {
        return songs;
    }

    @Override
    public String toString() {
        if(this.type != null)
            return "Name: " + this.name + ", Type: " + this.type;
        else
            return "Name: " + this.name;
    }

    @Override
    public int compareTo(Artist other) {
        return this.name.compareTo(other.getName());
    }
}
