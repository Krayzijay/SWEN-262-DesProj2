package src;
import java.io.*;
import src.Database.*;

public class CommandLine {

    public static void main(String[] args){
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        State currentState = null;
        Library personal = new Library();
        Library global = new Library();
        try{
            global.populateArtistData();
            global.populateReleaseData();
            global.populateSongData();
        }catch (IOException e){
            System.out.println("Cannot load Library");
        }

        while (true){
            System.out.println("Please enter your request followed by any necessary parameters." +
                    "You can also enter \'Help\' to be shown a list of possible requests.");

            String input = "";
            try{
                input = buffer.readLine();
            }catch (IOException e){

            }

            input = input.toLowerCase();
            String[] tokens = input.split("\"");
            String[] tokens2 = tokens[0].split(" ");
            if(tokens2[0].equals("help")) {
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
            }else if(tokens2[0].equals("edit")){
                currentState = new EditState();
                currentState.execute(global, personal, tokens);
            }else if(tokens2[0].equals("browse")){
                currentState = new BrowseState();
                currentState.execute(global, personal, tokens);
            }else if(tokens2[0].equals("search")){
                currentState = new SearchState();
                currentState.execute(global, personal, tokens);
            }else if (tokens2[0].equals("exit")){
                break;
            }
            else{
                //System.out.println(tokens.toString());
                System.out.println("You didn't enter one of the provided keywords. Please try again.");
            }
        }
    }
}
