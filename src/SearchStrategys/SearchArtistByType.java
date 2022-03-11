package src.SearchStrategys;

import java.util.ArrayList;
import java.util.List;

import src.Database.Artist;
import src.Database.Library;

/**
 * The concrete implementation for searching the given
 * library for artists by type.
 * 
 * @author Bryson VerDow
 */
public class SearchArtistByType implements SearchStrategy {

    @Override
    public void search(Library lib, String specification) {
        List<Artist> result = new ArrayList<>();
        List<Artist> artists = lib.getArtists();
        for(Artist artist : artists) {
            if(artist.getType().toLowerCase().contains(specification.toLowerCase())) {
                result.add(artist);
            }
        }
        result.sort();
        System.out.println(result);
    }
    
}