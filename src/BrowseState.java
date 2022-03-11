package src;
import src.Database.Library;
public class BrowseState implements State{

    @Override
    public void execute(Library db, String[] tokens) {

        Browsing.browse(db);
    }
}
