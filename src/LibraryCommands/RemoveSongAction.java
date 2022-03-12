package src.LibraryCommands;
import src.Database.Library;
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
        
    }
    
}
