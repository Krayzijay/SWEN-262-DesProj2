package src.LibraryCommands;
import src.Database.Library;
/**
 * The concrete command implementation for performing
 * the help command.
 * 
 * @author Bryson VerDow, Jackson Murphy
 */
public class HelpAction implements LibraryAction {
    private Library global;
    private Library personal;

    public HelpAction(Library global, Library personal) {
        this.global = global;
        this.personal = personal;
    }


    @Override
    public void performAction(String itemName, String date, int rating) {
        
    }
    
}
