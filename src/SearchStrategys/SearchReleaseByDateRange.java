package SearchStrategys;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Database.Release;
import Database.Library;

/**
 * The concrete implementation for searching the given
 * library for releases in a given date range.
 * 
 * @author Bryson VerDow
 */
public class SearchReleaseByDateRange implements SearchStrategy {

    @Override
    public void search(Library lib, String specification) {
        List<Release> result = new ArrayList<>();
        List<Release> releases = lib.getReleases();
        String[] dates = specification.split(" ");
        LocalDate date1 = LocalDate.parse(dates[0]);
        LocalDate date2 = LocalDate.parse(dates[1]);
        for(Release release : releases) {
            LocalDate releaseDate = LocalDate.parse(release.getDate());
            if(releaseDate.compareTo(date1) >= 0 && releaseDate.compareTo(date2) <= 0) {
                result.add(release);
            }
        }
        Collections.sort(result);
        System.out.println(result);
    }
    
}
