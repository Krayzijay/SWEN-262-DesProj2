package src.LibraryCommands;
import src.Database.Library;
/**
 * The concrete command implementation for rating a song.
 * 
 * @author Bryson VerDow, Jackson Murphy
 */
public class RateSongAction implements LibraryAction {
    private Library global;
    private Library personal;

    public RateSongAction(Library global, Library personal) {
        this.global = global;
        this.personal = personal;
    }

    @Override
    public void performAction(String itemName, String date, int rating) {
        
    }
    
}
