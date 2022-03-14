package LibraryCommands;
import Database.Library;
import Database.Song;
/**
 * The concrete command implementation for adding a 
 * song to a user's library.
 * 
 * @author Bryson VerDow, Jackson Murphy
 */
public class AddSongAction implements LibraryAction {
    private Library global;
    private Library personal;

    public AddSongAction(Library global, Library personal) {
        this.global = global;
        this.personal = personal;
    }

    @Override
    public void performAction(String itemName, String date, int rating) {

        performAction(itemName);

    }

    /**
     * Overloading method to only include searching title
     * @param itemName
     */
    public void performAction(String itemName) {
        for (Song song: global.getSongs()) {
            boolean found = song.getTitle().toLowerCase().equals(itemName);
            if (found) {
                personal.addSong(song);
                System.out.println("The song \""+ song.getTitle() +"\" has been added to your Library.");
                if(personal.getArtists().contains(song.getArtist())){
                    return;
                }
                else{
                    personal.addArtist(song.getArtist());
                    System.out.println("The song's artist \""+ song.getArtist().getName() +"\" has been added to your Library as well.");
                }
                return;
            }
        }
        System.out.println("The song you specified doesn't exist. Please check your spelling.");
    }

}
