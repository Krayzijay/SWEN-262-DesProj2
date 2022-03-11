package src.LibraryCommands;
import src.Database.Library;
/**
 * The concrete command implementation for rating a song.
 * 
 * @author Bryson VerDow
 */
public class RateSongAction implements LibraryAction {
    private String song;

    @Override
    public void performAction(Library global, Library personal, String itemName, String date, int rating) {
        
    }
    
}
