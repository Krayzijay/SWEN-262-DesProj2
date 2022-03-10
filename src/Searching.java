package src;

import java.util.ArrayList;
import java.util.List;

public class Searching {
    SearchStrategy current;
    List<Database.Song> SongCollection;
    List<Database.Artist> ArtistCollection;
    List<Database.Release> ReleaseCollection;

    public Searching(Database.Library db){
        SongCollection = db.getSongs();
        ArtistCollection = db.getArtists();
        ReleaseCollection = db.getReleases();

        current = null;
    }

    public void setStrategy(SearchStrategy s){
        this.current = s;
    }
    public void executeStrategy( ){
        this.current.search();
    }
}
