package src.LibraryCommands;
import src.Database.Library;
/**
 * The concrete command implementation for adding a 
 * song to a user's library.
 * 
 * @author Bryson VerDow
 */
public class AddSongAction implements LibraryAction {
    private String newSong;

    @Override
    public void performAction(Library db, String itemName, String date, int rating) {
        
    }
    
}
