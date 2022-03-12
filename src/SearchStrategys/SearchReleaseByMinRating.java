package SearchStrategys;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Database.Release;
import Database.Library;

/**
 * The concrete implementation for searching the given
 * library for releases by minimum rating.
 * 
 * @author Bryson VerDow
 */
public class SearchReleaseByMinRating implements SearchStrategy {

    @Override
    public void search(Library lib, String specification) {
        List<Release> result = new ArrayList<>();
        List<Release> releases = lib.getReleases();
        int minRating = Integer.parseInt(specification);
        for(Release release : releases) {
            if(release.getRating() > minRating) {
                result.add(release);
            }
        }
        Collections.sort(result);
        System.out.println(result);
    }
    
}
