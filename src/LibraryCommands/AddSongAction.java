package src.LibraryCommands;
import src.Database.Library;
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
        
    }
    
}
