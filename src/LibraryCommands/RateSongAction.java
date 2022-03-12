package LibraryCommands;
import java.util.List;

import Database.Library;
import Database.Song;
/**
 * The concrete command implementation for rating a song.
 * 
 * @author Bryson VerDow, Jackson Murphy
 */
public class RateSongAction implements LibraryAction {
    private Library personal;

    public RateSongAction(Library personal) {
        this.personal = personal;
    }

    @Override
    public void performAction(String itemName, String date, int rating) {
        performAction(itemName, "", rating);
    }

    /**
     * Overloading method to only include searching title, and adding song by item name
     * @param itemName
     * @param rating
     */
    public void performAction(String itemName, int rating) {
        List<Song> songs = personal.getSongs();
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getTitle().equals(itemName)) {
                songs.get(i).setUserRating(rating);

                return;
            }
        }

        throw new IllegalArgumentException(String.format("%s doesn't exist in the personal collection.", itemName));
    }
    
}
