package src;
import java.io.*;
import java.util.Locale;

public class CommandLine {

    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        State currentState = null;
        Library db = new Library();
        while (true){
            System.out.println("Please enter \'Edit\', \'Browse\', or \'Search\' " +
                    "if you want to edit, browse or search your library. Otherwise, " +
                    "enter \'Exit\' if you want to exit.");

            String input = buffer.readLine();
            input = input.toLowerCase();
            if(input.equals("edit")){
                currentState = new EditState();
                currentState.execute(db);
            }else if(input.equals("browse")){
                currentState = new BrowseState();
                currentState.execute(db);
            }else if(input.equals("search")){
                currentState = new SearchState();
                currentState.execute(db);
            }else if (input.equals("exit")){
                break;
            }
            else{
                System.out.println("You didn't enter one of the provided keywords. Please try again.");
            }
        }
    }
}
