package src.LibraryCommands;
import src.Database.Library;
/**
 * The concrete command implementation for performing
 * the help command.
 * 
 * @author Bryson VerDow, Jackson Murphy
 */
public class HelpAction implements LibraryAction {

    @Override
    public void performAction(String itemName, String date, int rating) {
        performAction();
    }

    /**
     * Overloading help command
     */
    public void performAction() {
        System.out.println("Possible Requests and Parameters:" +
                        "\n\nRequests: \'Edit\' (allows for editing your personal library), " +
                        "\'Browse\' (allows user to browse through their personal library), " +
                        "\'Search\' (Allows the user to search for songs in their personal or global library)." +

                        "\n\nParameters: \'Edit\' (Whether you want to \'Add\', \'Remove\', or \'Rate\' a Song/Artist/Release, What item you want tp edit " +
                        "(Song, Release, Artist), and the Name/Title of the Song/Artist/Release. If you are rating a Song or Release," +
                        "please enter a number between 1 - 5 before the Song/Release name. \nIf you are adding a Song or Release, you can include the date (Month/Day/Year)" +
                        "however, this is optionally and the current date will be used if no date is given." +
                        "\nRequest Example (Add): \'Edit Add Song 12/04/2003 \"Mr. Blue Sky\"\'" +
                        "\nRequest Example (Remove): \'Edit Remove Song \"Mr. Blue Sky\"\' " +
                        "\nRequest Example (Rate): \'Edit Rate Song 3 \"Mr. Blue Sky\"\' " +
                        " (please make sure the final parameter (Name/Title) has \"\" around it.)" +
                        "\'Browse\' (No parameters, just enter \'Browse\')," +
                        "\'Search\' (What you are searching for(Artist, Song, Release), " +
                        "which library you want to search (personal vs global), how you want to search for it, and what the system should use to search for it.)" +
                        "\nRequest Example: \"Search Personal Song ByTitle \'Mr. Blue Sky\'\" (please make sure " +
                        "the final parameter (the name/title) has \"\" around it.");
    }
    
}
