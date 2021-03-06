package SearchStrategys;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Database.Release;
import Database.Song;
import Database.Library;

/**
 * The concrete implementation for searching the given
 * library for releases by track name.
 * 
 * @author Bryson VerDow
 */
public class SearchReleaseByTrackName implements SearchStrategy {

    @Override
    public void search(Library lib, String specification) {
        List<Release> result = new ArrayList<>();
        List<Release> releases = lib.getReleases();
        for(Release release : releases) {
            List<Song> songs = release.getTracks();
            for(Song song : songs) {
                if(song.getTitle().toLowerCase().contains(specification.toLowerCase())) {
                    result.add(release);
                }
            }
        }
        Collections.sort(result);
        System.out.print("Search Result: ");

        System.out.println(result);
    }
    
}
