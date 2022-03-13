package LibraryCommands;
import Database.Artist;
import Database.Library;
import Database.Release;
import Database.Song;

/**
 * The concrete command implementation for removing a 
 * release from a user's library.
 * 
 * @author Bryson VerDow, Jackson Murphy
 */
public class RemoveReleaseAction implements LibraryAction {
    private Library personal;

    public RemoveReleaseAction(Library personal) {
        this.personal = personal;
    }

    @Override
    public void performAction(String itemName, String date, int rating) {

        performAction(itemName);
    }

    /**
     * Overloading method to only include removing Release by title
     * @param itemName
     */
    public void performAction(String itemName) {
        for (Release release: personal.getReleases()) {
            boolean found = release.getTitle().toLowerCase().equals(itemName);
            if (found) {
                personal.removeRelease(release);
                System.out.println("The release \"" + release.getTitle() + "\" has been removed from your Library");

                Artist a = release.getArtist();
                for (Song s: a.getSongs()){
                    if(personal.getSongs().contains(s)){
                        return;
                    };
                }
                personal.removeArtist(a);
                System.out.println("Since \"" + release.getTitle() + "\" contained the last of " + a.getName() +
                        "'s songs in your library, "+ a.getName() +" has been removed from your Library as well");



                return;
            }
        }

        System.out.println("The release you specified doesn't exist. Please check your spelling.");
    }
    
}
