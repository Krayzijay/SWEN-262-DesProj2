package Database;

import java.util.ArrayList;
import java.util.List;

public class Artist {
    String GUID = null;
    String name = null;
    String type = null;
    List<Song> songs;
    List<Release> releases;

    public Artist(String GUID, String name) {
        this.GUID = GUID;
        this.name = name;
        songs = new ArrayList<>();
        releases = new ArrayList<>();
    }

    public Artist(String GUID, String name, String type) {
        this.GUID = GUID;
        this.name = name;
        this.type = type;
        songs = new ArrayList<>();
        releases = new ArrayList<>();
    }

    public boolean getArtist(String id) {
        return this.GUID.equals(id);
    }

    public String getGUID() {
        return GUID;
    }

    public String getName() {return this.name;}

    public String getType() {
        if(this.type == null)
            return "None";
        else
            return this.type;
    }

    public String toString() {
        if(this.type != null)
            return "Name: " + this.name + ", Type: " + this.type;
        else
            return "Name: " + this.name;
    }
}
