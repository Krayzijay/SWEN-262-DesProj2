package src.Database;

import java.util.ArrayList;
import java.util.List;

public class Library {
    List<Song> SongCollection = new ArrayList<>();
    List<Artist> ArtistCollection = new ArrayList<>();
    List<Release> ReleaseCollection = new ArrayList<>();

    public List<Artist> getArtists() {return this.ArtistCollection;}
    public List<Song> getSongs() {return this.SongCollection;}
    public List<Release> getReleases() {return this.ReleaseCollection;}
}