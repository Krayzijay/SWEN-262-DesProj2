package src.SearchStrategys;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import src.Database.Song;
import src.Database.Library;

/**
 * The concrete implementation for searching the given
 * library for songs by maximum duration.
 * 
 * @author Bryson VerDow
 */
public class SearchSongByMaxDuration implements SearchStrategy {

    @Override
    public void search(Library lib, String specification) {
        List<Song> result = new ArrayList<>();
        List<Song> songs = lib.getSongs();
        int maxDuration = Integer.parseInt(specification);
        for(Song song : songs) {
            if(song.getDuration() < maxDuration) {
                result.add(song);
            }
        }
        Collections.sort(result);
        System.out.println(result);
    }
    
}
