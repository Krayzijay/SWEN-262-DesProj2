package SearchStrategys;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Database.Release;
import Database.Song;
import Database.Library;

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
        List<Release> releases = lib.getReleases();
        for(Release release : releases) {
            if(release.getTitle().equalsIgnoreCase(specification)) {
                List<Song> songs = release.getTracks();
                for(Song song : songs) {
                    result.add(song);
                }
            }
        }
        Collections.sort(result);
        System.out.print("Search Result: ");
        System.out.println(result);
    }
    
}
