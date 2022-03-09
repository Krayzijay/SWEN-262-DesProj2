package src;
import java.io.*;
//import java.util.Locale;

public class CommandLine {

    public static void main(String[] args){
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        State currentState = null;
        Library db = new Library();
        while (true){
            System.out.println("Please enter your request followed by any necessary parameters." +
                    "Or, enter \'Help\', to be shown a list of possible requests.");

            String input = "";
            try{
                input = buffer.readLine();
            }catch (IOException e){

            }

            input = input.toLowerCase();
            String[] tokens = input.split("'");
            String[] tokens2 = tokens[0].split(" ");
            if(tokens2[0].equals("help")) {
                System.out.println("Possible Requests and Parameters:" +
                        "\n\nRequests: \'Edit\' (allows for editing your personal library), " +
                        "\'Browse\' (allows user to browse through their personal library), " +
                        "\'Search\' (Allows the user to search for songs in their personal or global library)." +

                        "\n\nParameters: \'Edit\' ()," +
                        "\'Browse\' (No parameters)," +
                        "\'Search\' (What you are searching for(Artist, Song, Release), " +
                        "how you want to search for it, and what the system should use to search for it." +
                        "\nRequest Example: \"Search Song ByTitle \'Mr. Blue Sky\'\" (please make sure " +
                        "the final parameter has \"\" around it.");
            }else if(tokens2[0].equals("edit")){
                currentState = new EditState();
                currentState.execute(db, tokens);
            }else if(tokens2[0].equals("browse")){
                currentState = new BrowseState();
                currentState.execute(db, tokens);
            }else if(tokens2[0].equals("search")){
                currentState = new SearchState();
                currentState.execute(db, tokens);
            }else if (tokens2[0].equals("exit")){
                break;
            }
            else{
                System.out.println(tokens.toString());
                //System.out.println("You didn't enter one of the provided keywords. Please try again.");
            }
        }
    }
}
