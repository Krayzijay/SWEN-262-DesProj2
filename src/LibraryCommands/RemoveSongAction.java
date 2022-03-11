package src.LibraryCommands;
import src.Database.Library;
/**
 * The concrete command implementation for removing
 * a song from a user's library.
 * 
 * @author Bryson VerDow
 */
public class RemoveSongAction implements LibraryAction {
    private String oldSong;

    @Override
    public void performAction(Library global, Library personal, String itemName, String date, int rating) {
        
    }
    
}
