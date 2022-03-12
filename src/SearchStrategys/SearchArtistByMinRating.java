package src.SearchStrategys;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import src.Database.Artist;
import src.Database.Library;

/**
 * The concrete implementation for searching the given
 * library for artists by minimum rating.
 * 
 * @author Bryson VerDow
 */
public class SearchArtistByMinRating implements SearchStrategy {

    @Override
    public void search(Library lib, String specification) {
        List<Artist> result = new ArrayList<>();
        List<Artist> artists = lib.getArtists();
        int minRating = Integer.parseInt(specification);
        for(Artist artist : artists) {
            if(artist.getRating() > minRating) {
                result.add(artist);
            }
        }
        Collections.sort(result);
        System.out.println(result);
    }
    
}
