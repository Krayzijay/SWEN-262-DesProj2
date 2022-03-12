package tests;

import java.io.IOException;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

import src.Database.Library;
import src.LibraryCommands.AddSongAction;

@Testable
public class Command {
    @Test
    public void testAddReleaseAction() throws IOException {
        //setup
        Library personal = new Library();
        Library global = new Library();
        global.populateArtistData();
        global.populateReleaseData();
        global.populateSongData();

        //
        AddSongAction action = new AddSongAction(global, personal);

    }
}
