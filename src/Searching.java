
import Database.*;
import SearchStrategys.SearchStrategy;

/**
 * This class keeps track of  and call various searchStrategys
 *
 * @author JP Dumont
 */

import java.util.List;

public class Searching {
    SearchStrategy currentStrategy;
    List<Song> SongCollection;
    List<Artist> ArtistCollection;
    List<Release> ReleaseCollection;


    public Searching(Library db){
        SongCollection = db.getSongs();
        ArtistCollection = db.getArtists();
        ReleaseCollection = db.getReleases();

        currentStrategy = null;
    }

    public void setStrategy(SearchStrategy s){
        this.currentStrategy = s;
    }
    public void executeStrategy(Library library, String param){
        this.currentStrategy.search(library, param);
    }
}
