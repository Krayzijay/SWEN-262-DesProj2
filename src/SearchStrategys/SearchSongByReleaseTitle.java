package src.SearchStrategys;

import java.util.ArrayList;
import java.util.List;

import src.Database.Song;
import src.Database.Library;

/**
 * The concrete implementation for searching the given
 * library for songs by release title.
 * 
 * @author Bryson VerDow
 */
public class SearchSongByReleaseTitle implements SearchStrategy {

    @Override
    public void search(Library lib, String specification) {
        List<Song> result = new ArrayList<>();
        List<Song> songs = lib.getSongs();
        for(Song song : songs) {
            
        }
        result.sort();
        System.out.println(result);
    }
    
}
