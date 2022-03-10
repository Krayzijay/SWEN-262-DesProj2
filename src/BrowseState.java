package src;

public class BrowseState implements State{

    @Override
    public void execute(Database.Library db, String[] tokens) {

        Browsing.browse(db);
    }
}
