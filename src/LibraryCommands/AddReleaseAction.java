package LibraryCommands;
import Database.Library;
import Database.Release;
/**
 * The concrete command implementation for adding a 
 * release to a user's library.
 * 
 * @author Bryson VerDow, Jackson Murphy
 */
public class AddReleaseAction implements LibraryAction {
    private Library global;
    private Library personal;

    public AddReleaseAction(Library global, Library personal) {
        this.global = global;
        this.personal = personal;
    }

    @Override
    public void performAction(String itemName, String date, int rating) {

        performAction(itemName);
    }

    /**
     * Overloading method to only include searching title and date
     * @param itemName
     */
    public void performAction(String itemName) {
        for (Release release: global.getReleases()) {
            boolean found = release.getTitle().toLowerCase().equals(itemName);
            if (found) {
                personal.addRelease(release);
                System.out.println("The release \"" + release.getTitle() + "\" has been added to your Library.");
                if(personal.getArtists().contains(release.getArtist())){
                    return;
                }
                else{
                    personal.addArtist(release.getArtist());
                    System.out.println("The release's artist \""+ release.getArtist().getName() +"\" has been added to your Library as well.");
                }

                return;
            }
        }
        System.out.println("The release you specified doesn't exist. Please check your spelling.");
    }
    
}
