package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

import src.Database.Artist;
import src.Database.Library;
import src.Database.Release;
import src.Database.Song;
import src.LibraryCommands.AddReleaseAction;
import src.LibraryCommands.AddSongAction;

@Testable
public class TestCommand {

    /**
     * Tests that a release has been added to the personal collection
     * @throws IOException
     */
    @Test
    public void testAddReleaseAction() throws IOException {
        //setup
        Library personal = new Library();
        Library global = new Library();
        Artist artist = new Artist("GUID", "artist");
        ArrayList<Song> songs = new ArrayList<>() {{add(new Song("GUID", artist, 1, "title"));}};

        Release expected = new Release("1234", artist, "a release", "medium", "01/01/2001", songs);
        global.addRelease(expected);

        
        //
        AddReleaseAction action = new AddReleaseAction(global, personal);
        action.performAction("a release", "01/01/2001");

        assertEquals(expected, personal.getReleases().get(0), "Testing if the release has been added to the user's collection");
    }
}
