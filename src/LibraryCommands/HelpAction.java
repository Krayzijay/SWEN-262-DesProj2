package LibraryCommands;
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
        System.out.println("\nPossible Requests:" +
                        "\n\'Edit\' (allows for editing your personal library), " +
                        "\n\'Browse\' (allows user to browse through their personal library), " +
                        "\n\'Search\' (Allows the user to search for songs in their personal or global library)." +

                        "\n\nPossible Parameters: \n\'Edit\' (Whether you want to \'Add\', \'Remove\', or \'Rate\' a Song/Artist/Release, What item you want tp edit " +
                        "(Song, Release, Artist), and the Name/Title of the Song/Artist/Release. " +
                        "\nIf you are rating a Song or Release, please enter a number between 1 - 5 before the Song/Release name. \nIf you are adding a Song or Release, you can include the date (Month/Day/Year)" +
                        "however, this is optionally and the current date will be used if no date is given." +
                        "\nEdit Request Example (Add): \'Edit Add Song 12/04/2003 \"Mr. Blue Sky\"\'" +
                        "\nEdit Request Example (Remove): \'Edit Remove Song \"Mr. Blue Sky\"\' " +
                        "\nEdit Request Example (Rate): \'Edit Rate Song 3 \"Mr. Blue Sky\"\' " +
                        "\nIMPORTANT: Make sure the final parameter (Name/Title) has \"\" around it." +

                        "\n\n\'Browse\' (No parameters, just enter \'Browse\')," +

                        "\n\n\'Search\' (What you are searching for(Artist, Song, Release), " +
                        "which library you want to search (personal vs global), how you want to search for it, and your search parameter.)" +
                        "\nSearch Request Example: \"Search Personal Song BySongTitle \"Mr. Blue Sky\"\" " +
                        "\nIMPORTANT: Make sure the final parameter (Name/Title/Date) has \"\" around it." +
                        "If you are searching \'ByDateRange\', please enter the two dates in the following format." +
                        "\n FORMAT: \'YYYY-MM-DD YYYY-MM-DD\'. Please make sure the earlier date is first and is followed by an older date.\n\n");
    }
    
}
