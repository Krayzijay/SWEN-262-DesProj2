package src.SearchStrategys;

import java.util.ArrayList;
import java.util.List;

import src.Database.Release;
import src.Database.Song;
import src.Database.Library;

/**
 * The concrete implementation for searching the given
 * library for releases by track GUID.
 * 
 * @author Bryson VerDow
 */
public class SearchReleaseByTrackGUID implements SearchStrategy {

    @Override
    public void search(Library lib, String specification) {
        List<Release> result = new ArrayList<>();
        List<Release> releases = lib.getReleases();
        for(Release release : releases) {
            List<Song> songs = release.getTracks();
            for(Song song : songs) {
                if(song.getGUID().toLowerCase().contains(specification.toLowerCase())) {
                    result.add(release);
                }
            }
        }
        result.sort();
        System.out.println(result);
    }
    
}
