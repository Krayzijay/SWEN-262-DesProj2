package src.SearchStrategys;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import src.Database.Song;
import src.Database.Library;

/**
 * The concrete implementation for searching the given
 * library for songs by artist GUID.
 * 
 * @author Bryson VerDow
 */
public class SearchSongByArtistGUID implements SearchStrategy {

    @Override
    public void search(Library lib, String specification) {
        List<Song> result = new ArrayList<>();
        List<Song> songs = lib.getSongs();
        for(Song song : songs) {
            if(song.getArtist().getGUID().toLowerCase().contains(specification.toLowerCase())) {
                result.add(song);
            }
        }
        Collections.sort(result);
        System.out.println(result);
    }
    
}
