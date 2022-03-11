package src.SearchStrategys;

import java.util.ArrayList;
import java.util.List;

import src.Database.Release;
import src.Database.Library;

/**
 * The concrete implementation for searching the given
 * library for releases by maximum duration.
 * 
 * @author Bryson VerDow
 */
public class SearchReleaseByMaxDuration implements SearchStrategy {

    @Override
    public void search(Library lib, String specification) {
        List<Release> result = new ArrayList<>();
        List<Release> releases = lib.getReleases();
        for(Release release : releases) {
            
        }
        result.sort();
        System.out.println(result);
    }
    
}
