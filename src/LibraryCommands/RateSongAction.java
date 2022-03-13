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

        performAction(itemName, rating);
    }

    /**
     * Overloading method to only include searching title, and adding song by item name
     * @param itemName
     * @param rating
     */
    public void performAction(String itemName, int rating) {
        List<Song> songs = personal.getSongs();
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getTitle().toLowerCase().equals(itemName)) {
                songs.get(i).setUserRating(rating);
                System.out.println(songs.get(i).getTitle() + " has received a rating of " + rating);
                return;
            }
        }

        System.out.println("The song you specified isn't in your library. Please add it to your library first if it exists.");
    }
    
}
