package src.SearchStrategys;

import java.util.ArrayList;
import java.util.List;

import src.Database.Song;
import src.Database.Library;

/**
 * The concrete implementation for searching the given
 * library for songs by title.
 * 
 * @author Bryson VerDow
 */
public class SearchSongByTitle implements SearchStrategy {

    @Override
    public void search(Library lib, String specification) {
        List<Song> result = new ArrayList<>();
        List<Song> songs = lib.getSongs();
        for(Song song : songs) {
            if(song.getTitle().toLowerCase().contains(specification.toLowerCase())) {
                result.add(song);
            }
        }
        result.sort();
        System.out.println(result);
    }
    
}
