package src.LibraryCommands;
import src.Database.Library;
/**
 * The concrete command implementation for removing a 
 * release from a user's library.
 * 
 * @author Bryson VerDow
 */
public class RemoveReleaseAction implements LibraryAction {
    private String oldRelease;

    @Override
    public void performAction(Library global, Library personal, String itemName, String date, int rating) {
        
    }
    
}
