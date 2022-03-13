package LibraryCommands;
import Database.Library;
import Database.Song;
import Database.Artist;
/**
 * The concrete command implementation for removing
 * a song from a user's library.
 * 
 * @author Bryson VerDow, Jackson Murphy
 */
public class RemoveSongAction implements LibraryAction {
    private Library personal;

    public RemoveSongAction(Library personal) {
        this.personal = personal;
    }

    @Override
    public void performAction(String itemName, String date, int rating) {

        performAction(itemName);
    }

    /**
     * Overloading method to only include removing Song by title and date
     * @param itemName
     */
    public void performAction(String itemName) {
        for (Song song: personal.getSongs()) {
            boolean found = song.getTitle().toLowerCase().equals(itemName);
            if (found) {
                personal.removeSong(song);
                System.out.println("The song \"" + song.getTitle() + "\" has been removed from your Library");
                Artist a = song.getArtist();
                for (Song s: a.getSongs()){
                    if(personal.getSongs().contains(s)){
                        return;
                    };
                }
                personal.removeArtist(a);
                System.out.println("Since \"" + song.getTitle() + "\" was " + a.getName() +
                        "'s last song in your library, "+ a.getName() +" has been removed from your Library as well");

                return;
            }
        }

        System.out.println("The song you specified doesn't exist. Please check your spelling.");
    }
    
}
