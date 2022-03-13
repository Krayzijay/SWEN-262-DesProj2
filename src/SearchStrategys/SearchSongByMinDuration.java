package SearchStrategys;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Database.Song;
import Database.Library;

/**
 * The concrete implementation for searching the given
 * library for songs by minimum duration.
 * 
 * @author Bryson VerDow
 */
public class SearchSongByMinDuration implements SearchStrategy {

    @Override
    public void search(Library lib, String specification) {
        List<Song> result = new ArrayList<>();
        List<Song> songs = lib.getSongs();
        int maxDuration = Integer.parseInt(specification);
        for(Song song : songs) {
            if(song.getDuration() > maxDuration) {
                result.add(song);
            }
        }
        Collections.sort(result);
        System.out.print("Search Result: ");
        System.out.println(result);
    }
    
}
