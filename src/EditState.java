package src;
import src.Database.Library;

import java.util.Calendar;

public class EditState implements State{
    @Override
    public void execute(Library db, String[] tokens){
        String[] tokens2 = tokens[0].split(" ");

        Calendar c = Calendar.getInstance();
        int day = c.get(Calendar.DAY_OF_MONTH);
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        String date = month + "/" + day + "/" + year;
        // 'Edit Add Song 12/04/2003 "Mr. Blue Sky"'
        String command = tokens2[1];
        String itemType = tokens2[2];
        String name = tokens[1];
        //if date was added
        if(tokens2.length == 4){
            date = tokens2[3];
        }

        if (command.toLowerCase().equals("add")){
            if(itemType.toLowerCase().equals("song")){
                AddSongAction a = new AddSongAction();
                a.performAction(name, date);
            }
            if(itemType.toLowerCase().equals("release")){
                AddReleaseAction a = new AddReleaseAction();
                a.performAction(name, date);
            }

        }else if (command.toLowerCase().equals("remove")){
            if(itemType.toLowerCase().equals("song")){
                RemoveSongAction a = new RemoveSongAction();
                a.performAction(name, date);
            }
            if(itemType.toLowerCase().equals("release")){
                RemoveReleaseAction a = new RemoveReleaseAction();
                a.performAction(name, date);
            }

        }else if (command.toLowerCase().equals("rate")){
            if(itemType.toLowerCase().equals("song")){
                RateSongAction a = new RateSongAction();
                a.performAction(name, rating);
            }
            if(itemType.toLowerCase().equals("release")){
                RateSongAction a = new RateSongAction();
                a.performAction(name, rating);
            }

        }

        //how implement command strategy?
    }
}
