import java.io.IOException;
import java.util.ArrayList;


import Database.Artist;
import Database.Library;
import Database.Release;
import Database.Song;
import LibraryCommands.AddReleaseAction;
import LibraryCommands.AddSongAction;
import LibraryCommands.RateSongAction;
import LibraryCommands.RemoveReleaseAction;
import LibraryCommands.RemoveSongAction;

public class TestCommand {

    /**
     * Tests that a release has been added to the personal collection
     * @throws IOException
     */
    public void testAddReleaseAction() throws IOException {
        //setup
        Library personal = new Library();
        Library global = new Library();
        Artist artist = new Artist("GUID", "artist");
        ArrayList<Song> songs = new ArrayList<>() {{add(new Song("GUID", artist, 1, "title"));}};
        Release expected = new Release("1234", artist, "a release", "medium", "01/01/2001", songs);
        global.addRelease(expected);

        // actual
        AddReleaseAction action = new AddReleaseAction(global, personal);//
//        action.performAction("a release", "01/01/2001");

        // test
    }

    /**
     * Tests that a song has been added to the personal collection
     * @throws IOException
     */
    public void testAddSongAction() throws IOException {
        //setup
        Library personal = new Library();
        Library global = new Library();
        Artist artist = new Artist("GUID", "artist");
        Song song = new Song("GUID", artist, 1, "title");
        global.addSong(song);

        // actual
        AddSongAction action = new AddSongAction(global, personal);
        //action.performAction("title");

        // test
    }

    /**
     * Tests that a song has been added to the personal collection
     * @throws IOException
     */
    public void testAddRatingAction() throws IOException {
        //setup
        Library personal = new Library();
        Artist artist = new Artist("GUID", "artist");
        Song song = new Song("GUID", artist, 1, "title");
        personal.addSong(song);

        // actual
        RateSongAction action = new RateSongAction(personal);
        action.performAction("title", 5);

        // test
    }

    /**
     * Tests that a release has been remove from the personal collection
     * @throws IOException
     */
    public void testRemoveReleaseAction() throws IOException {
        //setup
        Library personal = new Library();
        Artist artist = new Artist("GUID", "artist");
        ArrayList<Song> songs = new ArrayList<>() {{add(new Song("GUID", artist, 1, "title"));}};
        Release expected = new Release("1234", artist, "a release", "medium", "01/01/2001", songs);
        personal.addRelease(expected);

        // actual
        RemoveReleaseAction action = new RemoveReleaseAction(personal);
        //action.performAction("a release", "01/01/2001");

        // test
    }

    /**
     * Tests that a song has been remove from the personal collection
     * @throws IOException
     */
    public void testRemoveSongAction() throws IOException {
        //setup
        Library personal = new Library();
        Artist artist = new Artist("GUID", "artist");
        Song song = new Song("GUID", artist, 1, "title");
        personal.addSong(song);

        // actual
        RemoveSongAction action = new RemoveSongAction(personal);
        action.performAction("title");

        // test
    }

}
