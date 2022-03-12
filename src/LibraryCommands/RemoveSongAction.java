package src.LibraryCommands;
import src.Database.Library;
import src.Database.Song;
/**
 * The concrete command implementation for removing
 * a song from a user's library.
 * 
 * @author Bryson VerDow, Jackson Murphy
 */
public class RemoveSongAction implements LibraryAction {
    private Library global;
    private Library personal;

    public RemoveSongAction(Library global, Library personal) {
        this.global = global;
        this.personal = personal;
    }

    @Override
    public void performAction(String itemName, String date, int rating) {
        performAction(itemName, "", 0);
    }

    /**
     * Overloading method to only include removing Song by title and date
     * @param itemName
     * @param date
     */
    public void performAction(String itemName) {
        for (Song song: personal.getSongs()) {
            boolean found = song.getTitle().equals(itemName);
            if (found) {
                personal.removeSong(song);
                return;
            }
        }

        throw new IllegalArgumentException(String.format("%s doesn't exist in the personal collection.", itemName));
    }
    
}
