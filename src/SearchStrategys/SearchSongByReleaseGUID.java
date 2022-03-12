package SearchStrategys;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Database.Release;
import Database.Song;
import Database.Library;

/**
 * The concrete implementation for searching the given
 * library for songs by release GUID.
 * 
 * @author Bryson VerDow
 */
public class SearchSongByReleaseGUID implements SearchStrategy {

    @Override
    public void search(Library lib, String specification) {
        List<Song> result = new ArrayList<>();
        List<Release> releases = lib.getReleases();
        for(Release release : releases) {
            if(release.getGUID().equals(specification)) {
                List<Song> songs = release.getTracks();
                for(Song song : songs) {
                    result.add(song);
                }
            }
        }
        Collections.sort(result);
        System.out.println(result);
    }
    
}
