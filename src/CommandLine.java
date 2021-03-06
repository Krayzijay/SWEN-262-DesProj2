
import java.io.*;
import Database.*;
import LibraryCommands.HelpAction;
import LibraryCommands.LibraryAction;
import LibraryCommands.SearchByAction;
/**
 * The main Runnable file that interacts with the user
 *
 * @author JP Dumont
 */
public class CommandLine {

    public static void main(String[] args){
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        State currentState = null;
        LibraryAction action = null;
        Library personal = new Library();
        Library global = new Library();
        try{
            global.populateArtistData();
            global.populateSongData();
            global.populateReleaseData();

            global.populateArtistsLists();
        }catch (IOException e){
            System.out.println("Failed to load Library");
        }

        while (true){
            System.out.println("\nPlease enter your request followed by any necessary parameters.\n" +
                    "RECOMMENDED: You can also enter \'Help\' to be shown a list of possible requests or \'SearchList\' " +
                    "to be shown a list of possible ways to search the libraries.\n" +
                    "Enter \'Exit\' to end the application.");

            String input = "";
            try{
                input = buffer.readLine();
            }catch (IOException e){

            }

            input = input.toLowerCase();
            String[] tokens = input.split("\"");
            String[] tokens2 = tokens[0].split(" ");
            if(tokens2[0].equals("help")) {
                action = new HelpAction();
                action.performAction(tokens[0],tokens[0], 0);
            }else if (tokens2[0].equals("searchlist")){
                action = new SearchByAction();
                action.performAction(tokens[0],tokens[0], 0);
            }
            else if(tokens2[0].equals("edit")){
                currentState = new EditState();
                currentState.execute(global, personal, tokens);
            }else if(tokens2[0].equals("browse")){
                currentState = new BrowseState();
                currentState.execute(global, personal, tokens);
            }else if(tokens2[0].equals("search")){
                currentState = new SearchState();
                currentState.execute(global, personal, tokens);
            }else if (tokens2[0].equals("exit")){
                System.out.println("Goodbye.");
                break;
            }
            else{
                //System.out.println(tokens.toString());
                System.out.println("You didn't enter one of the provided keywords. Please try again.");
            }
        }
    }
}
