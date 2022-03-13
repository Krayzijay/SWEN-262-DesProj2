package LibraryCommands;

public class SearchByAction implements LibraryAction{

    @Override
    public void performAction(String itemName, String date, int rating) {
        performAction();
    }

    /**
     * Overloading help command
     */
    public void performAction(){
        System.out.println("\nPossible Search Methods:" +
                "\nFor Global Library:" +
                "\n\tSongs:\n\t\t\'BySongTitle\', \'ByMaxDuration\', \'ByMinDuration\', \'ByArtistName\'" +
                "\n\tArtists:\n\t\t\'ByName\'" +
                "\n\tReleases:\n\t\t\'ByReleaseTitle\', \'ByArtistGUID\', \'ByDateRange\', \'ByArtistName\', \'ByTrackGUID\'" +
                "\n\nFor Personal Library:" +
                "\n\tSongs:\n\t\t\'ByMaxDuration\', \'ByArtistGUID\', \'ByDateRange\', \'ByArtistName\', \'ByMinDuration\'" +
                "\'ByMinRating\', \'ByReleaseGUID\', \'ByReleaseTitle\', \'BySongTitle\', \'ByTrackGUID\'" +
                "\n\tArtists:\n\t\t\'ByName\', \'ByMinRating\', \'ByType\'" +
                "\n\tReleases:\n\t\t\'ByReleaseTitle\', \'ByArtistGUID\', \'ByDateRange\', \'ByArtistName\', \'ByMaxDuration\'" +
                "\'ByMinDuration\', \'ByMinRating\', \'ByTrackName\', \'ByTrackGUID\'");


    }
}
