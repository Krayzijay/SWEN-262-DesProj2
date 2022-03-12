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
import src.LibraryCommands.RateSongAction;
import src.LibraryCommands.RemoveReleaseAction;
import src.LibraryCommands.RemoveSongAction;

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

        // actual
        AddReleaseAction action = new AddReleaseAction(global, personal);
        action.performAction("a release", "01/01/2001");

        // test
        assertEquals(expected, personal.getReleases().get(0), "Testing if the release has been added to the user's collection");
    }

    /**
     * Tests that a song has been added to the personal collection
     * @throws IOException
     */
    @Test
    public void testAddSongAction() throws IOException {
        //setup
        Library personal = new Library();
        Library global = new Library();
        Artist artist = new Artist("GUID", "artist");
        Song song = new Song("GUID", artist, 1, "title");
        global.addSong(song);

        // actual
        AddSongAction action = new AddSongAction(global, personal);
        action.performAction("title");

        // test
        assertEquals(song, personal.getSongs().get(0), "Testing if the song has been added to the user's collection");
    }

    /**
     * Tests that a song has been added to the personal collection
     * @throws IOException
     */
    @Test
    public void testAddRatingAction() throws IOException {
        //setup
        Library personal = new Library();
        Library global = new Library();
        Artist artist = new Artist("GUID", "artist");
        Song song = new Song("GUID", artist, 1, "title");
        personal.addSong(song);

        // actual
        RateSongAction action = new RateSongAction(global, personal);
        action.performAction("title", 5);

        // test
        assertEquals(song.getUserRating(), personal.getSongs().get(0).getUserRating(), "Testing if the song has been rated by the user");
    }

    /**
     * Tests that a release has been remove from the personal collection
     * @throws IOException
     */
    @Test
    public void testRemoveReleaseAction() throws IOException {
        //setup
        Library personal = new Library();
        Library global = new Library();
        Artist artist = new Artist("GUID", "artist");
        ArrayList<Song> songs = new ArrayList<>() {{add(new Song("GUID", artist, 1, "title"));}};
        Release expected = new Release("1234", artist, "a release", "medium", "01/01/2001", songs);
        personal.addRelease(expected);

        // actual
        RemoveReleaseAction action = new RemoveReleaseAction(global, personal);
        action.performAction("a release", "01/01/2001");

        // test
        assertEquals(0, personal.getReleases().size(), "Testing if the release has been removed from the user's collection");
    }

    /**
     * Tests that a song has been remove from the personal collection
     * @throws IOException
     */
    @Test
    public void testRemoveSongAction() throws IOException {
        //setup
        Library personal = new Library();
        Library global = new Library();
        Artist artist = new Artist("GUID", "artist");
        Song song = new Song("GUID", artist, 1, "title");
        personal.addSong(song);

        // actual
        RemoveSongAction action = new RemoveSongAction(global, personal);
        action.performAction("title");

        // test
        assertEquals(0, personal.getSongs().size(), "Testing if the song has been removed from the user's collection");
    }

}
