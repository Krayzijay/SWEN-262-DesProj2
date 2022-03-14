
import Database.Library;
import LibraryCommands.*;

import java.util.Calendar;

public class EditState implements State{
    @Override
    public void execute(Library global, Library personal, String[] tokens){
        String[] tokens2 = tokens[0].split(" ");

        Calendar c = Calendar.getInstance();
        int day = c.get(Calendar.DAY_OF_MONTH);
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        String date = month + "/" + day + "/" + year;
        String command = tokens2[1];
        String itemType = tokens2[2];
        String name = tokens[1];
        int rating = 0;
        LibraryAction action = null;

        //if date was added
        if((tokens2.length == 4) && (command.toLowerCase().equals("add"))){
            date = tokens2[3];
        }
        else if((tokens2.length == 4) && (command.toLowerCase().equals("rate"))){
            rating = Integer.parseInt(tokens2[3]);
        }

        if (command.toLowerCase().equals("add")){
            if(itemType.toLowerCase().equals("song")){
                action = new AddSongAction(global, personal);
                action.performAction(name, date, rating);
            }
            else if(itemType.toLowerCase().equals("release")){
                action = new AddReleaseAction(global, personal);
                action.performAction(name, date, rating);
            }

        }else if (command.toLowerCase().equals("remove")){
            if(itemType.toLowerCase().equals("song")){
                action = new RemoveSongAction(personal);
                action.performAction(name, date, rating);
            }
            else if(itemType.toLowerCase().equals("release")){
                action = new RemoveReleaseAction(personal);
                action.performAction(name, date, rating);
            }

        }else if (command.toLowerCase().equals("rate")){
            if(itemType.toLowerCase().equals("song")){
                action = new RateSongAction(personal);
                action.performAction(name, date, rating);
            }
        }else{
            System.out.println("Sorry that is not a feasible command, please try again");
        }


    }
}
