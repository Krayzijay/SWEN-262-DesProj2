package src.LibraryCommands;
import src.Database.Library;
import src.Database.Release;
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
        performAction(itemName, date, 0);
    }

    /**
     * Overloading method to only include searching title and date
     * @param itemName
     * @param date
     */
    public void performAction(String itemName, String date) {
        for (Release release: global.getReleases()) {
            boolean found = release.getDate().equals(date) && release.getTitle().equals(itemName);
            if (found) {
                personal.addRelease(release);
                return;
            }
        }

        throw new IllegalArgumentException(String.format("%s doesn't exist in the library.", itemName));
    }
    
}
