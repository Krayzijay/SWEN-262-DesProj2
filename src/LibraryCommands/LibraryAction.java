package LibraryCommands;


/**
 * The command interface for outlining implementations
 * of different system commands.
 * 
 * @author Bryson VerDow, Jackson Murphy
 */
public interface LibraryAction {
    public void performAction(String itemName, String date, int rating);
}
