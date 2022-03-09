package Database;

import java.util.ArrayList;
import java.util.List;

public class Artist {
    String GUID = null;
    String name = null;
    String type = null;
    List<Song> songs;
    List<Release> releases;

    public Artist(String GUID, String name, String type) {
        this.GUID = GUID;
        this.name = name;
        this.type = type;
        songs = new ArrayList<>();
        releases = new ArrayList<>();

    }

    public String getGUID() {
        return GUID;
    }
}
