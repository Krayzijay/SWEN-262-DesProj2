package src;
import src.Database.*;
import java.util.ArrayList;
import java.util.List;

public class Searching {
    SearchStrategy current;
    List<Song> DBSongCollection;
    List<Artist> DBArtistCollection;
    List<Release> DBReleaseCollection;

    List<Song> LibrarySongCollection;
    List<Artist> LibraryArtistCollection;
    List<Release> LibraryReleaseCollection;

    public Searching(Library db){
        DBSongCollection = db.getDatabaseSongCollection();
        DBArtistCollection = db.getDatabaseArtistCollection();
        DBReleaseCollection = db.getDatabaseReleaseCollection();

        LibrarySongCollection = db.getLibrarySongCollection();
        LibraryArtistCollection = db.getLibraryArtistCollection();
        LibraryReleaseCollection = db.getLibraryReleaseCollection();

        current = null;
    }

    public void setStrategy(SearchStrategy s){
        this.current = s;
    }
    public void executeStrategy(String param){
        this.current.search(param);
    }
}
