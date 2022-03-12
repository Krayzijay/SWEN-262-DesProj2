package src.SearchStrategys;

import java.util.ArrayList;
import java.util.Collections;
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
        int maxDuration = Integer.parseInt(specification);
        for(Release release : releases) {
            int duration = release.getDuration();
            if(duration < maxDuration) {
                result.add(release);
            }
        }
        Collections.sort(result);
        System.out.println(result);
    }
    
}
