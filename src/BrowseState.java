package src;
import src.Database.Library;
public class BrowseState implements State{

    @Override
    public void execute(Library global,Library personal, String[] tokens) {

        Browsing.browse(personal);
    }
}
