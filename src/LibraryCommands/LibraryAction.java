package src.LibraryCommands;

import src.Database.Library;

/**
 * The command interface for outlining implementations
 * of different system commands.
 * 
 * @author Bryson VerDow
 */
public interface LibraryAction {
    public void performAction(Library db, String itemName, String date, int rating);
}
