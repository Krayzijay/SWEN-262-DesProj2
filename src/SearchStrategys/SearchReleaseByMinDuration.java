package src.SearchStrategys;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import src.Database.Release;
import src.Database.Library;

/**
 * The concrete implementation for searching the given
 * library for releases by minimum duration.
 * 
 * @author Bryson VerDow
 */
public class SearchReleaseByMinDuration implements SearchStrategy {

    @Override
    public void search(Library lib, String specification) {
        List<Release> result = new ArrayList<>();
        List<Release> releases = lib.getReleases();
        int minDuration = Integer.parseInt(specification);
        for(Release release : releases) {
            int duration = release.getDuration();
            if(duration > minDuration) {
                result.add(release);
            }
        }
        Collections.sort(result);
        System.out.println(result);
    }
    
}
