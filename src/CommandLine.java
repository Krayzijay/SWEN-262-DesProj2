package src;
import java.io.*;
import src.Database.*;
import src.LibraryCommands.HelpAction;

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
                HelpAction help = new HelpAction();
                help.performAction();
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
