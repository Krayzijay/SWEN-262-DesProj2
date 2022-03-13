
import Database.Library;
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
