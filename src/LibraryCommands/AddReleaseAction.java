package src.LibraryCommands;
import src.Database.Library;
/**
 * The concrete command implementation for adding a 
 * release to a user's library.
 * 
 * @author Bryson VerDow
 */
public class AddReleaseAction implements LibraryAction {
    private String newRelease;

    @Override
    public void performAction(Library global, Library personal, String itemName, String date, int rating) {
        
    }
    
}
