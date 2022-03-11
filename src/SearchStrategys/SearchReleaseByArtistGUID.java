package src.SearchStrategys;

import java.util.ArrayList;
import java.util.List;

import src.Database.Release;
import src.Database.Library;

/**
 * The concrete implementation for searching the given
 * library for releases by artist GUID.
 * 
 * @author Bryson VerDow
 */
public class SearchReleaseByArtistGUID implements SearchStrategy {

    @Override
    public void search(Library lib, String specification) {
        List<Release> result = new ArrayList<>();
        List<Release> releases = lib.getReleases();
        for(Release release : releases) {
            if(release.getGUID().toLowerCase().contains(specification.toLowerCase())) {
                result.add(release);
            }
        }
        result.sort();
        System.out.println(result);
    }
    
}