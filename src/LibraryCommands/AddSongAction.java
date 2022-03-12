package src.LibraryCommands;
import src.Database.Library;
import src.Database.Song;
/**
 * The concrete command implementation for adding a 
 * song to a user's library.
 * 
 * @author Bryson VerDow, Jackson Murphy
 */
public class AddSongAction implements LibraryAction {
    private Library global;
    private Library personal;

    public AddSongAction(Library global, Library personal) {
        this.global = global;
        this.personal = personal;
    }

    @Override
    public void performAction(String itemName, String date, int rating) {
        performAction(itemName, "", 0);
    }

    /**
     * Overloading method to only include searching title
     * @param itemName
     * @param date
     */
    public void performAction(String itemName) {
        for (Song song: global.getSongs()) {
            boolean found = song.getTitle().equals(itemName);
            if (found) {
                personal.addSong(song);
                return;
            }
        }

        throw new IllegalArgumentException(String.format("%s doesn't exist in the library.", itemName));
    }
    
}
