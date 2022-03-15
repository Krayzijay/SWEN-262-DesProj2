
import Database.Library;
/**
 * The ConcreteState class which determines if the user's personal library is empty or not
 * before attmepting to browse through it.
 *
 * @author JP Dumont
 */

public class BrowseState implements State{

    @Override
    public void execute(Library global,Library personal, String[] tokens) {
        if(personal.getArtists().isEmpty()){
            System.out.println("\nYour Personal Library is empty. Please add a song or release to your library before attempting to browse.\n");
        }
        else{
            Browsing.browse(personal);
        }
    }
}
