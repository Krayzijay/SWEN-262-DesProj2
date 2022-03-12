package src.SearchStrategys;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import src.Database.Artist;
import src.Database.Library;

/**
 * The concrete implementation for searching the given
 * library for artists by name.
 * 
 * @author Bryson VerDow
 */
public class SearchArtistByName implements SearchStrategy {

    @Override
    public void search(Library lib, String specification) {
        List<Artist> result = new ArrayList<>();
        List<Artist> artists = lib.getArtists();
        for(Artist artist : artists) {
            if(artist.getName().toLowerCase().contains(specification.toLowerCase())) {
                result.add(artist);
            }
        }
        Collections.sort(result);
        System.out.println(result);
    }
    
}
