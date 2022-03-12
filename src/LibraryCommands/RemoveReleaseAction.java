package src.LibraryCommands;
import src.Database.Library;
import src.Database.Release;
/**
 * The concrete command implementation for removing a 
 * release from a user's library.
 * 
 * @author Bryson VerDow, Jackson Murphy
 */
public class RemoveReleaseAction implements LibraryAction {
    private Library global;
    private Library personal;

    public RemoveReleaseAction(Library global, Library personal) {
        this.global = global;
        this.personal = personal;
    }

    @Override
    public void performAction(String itemName, String date, int rating) {
        performAction(itemName, date, 0);
    }

    /**
     * Overloading method to only include removing Release by title and date
     * @param itemName
     * @param date
     */
    public void performAction(String itemName, String date) {
        for (Release release: personal.getReleases()) {
            boolean found = release.getDate().equals(date) && release.getTitle().equals(itemName);
            if (found) {
                personal.removeRelease(release);
                return;
            }
        }

        throw new IllegalArgumentException(String.format("%s doesn't exist in the personal collection.", itemName));
    }
    
}
