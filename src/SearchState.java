
import Database.Library;
import SearchStrategys.*;

/**
 * The ConcreteState class which determines how to search through the specified library \
 * @author JP Dumont
 */

public class SearchState implements State{

    @Override
    public void execute(Library global, Library personal, String[] tokens){
        Searching g = new Searching(global);
        Searching p = new Searching(personal);

        String[] keyWords = tokens[0].split(" ");
        String library = keyWords[1].toLowerCase();
        String item = keyWords[2].toLowerCase();
        String searchBy = keyWords[3].toLowerCase();
        String param = tokens[1].toLowerCase();

        int whichLibrary = 0;

        if(library.equals("global")){
            whichLibrary = 1;
            if(item.equals("artist")){
                if(searchBy.equals("byname")){
                    g.setStrategy(new SearchArtistByName());
                }else{
                    System.out.println("Sorry, you cant search for an artist in this library using that method of searching. " +
                            "Make sure that the method you chose is compatible with the library you want to search in " +
                            "and the type of item you are searching for. To learn about the various searching methods, " +
                            "please enter \'SearchBy\' as a request and a list of possible search methods and their compatibility will appear.");
                }
            }else if(item.equals("song")){
                if(searchBy.equals("bysongtitle")){
                    g.setStrategy(new SearchSongByTitle());
                }else if(searchBy.equals("bymaxduration")){
                    g.setStrategy(new SearchSongByMaxDuration());
                }else if(searchBy.equals("byminduration")){
                    g.setStrategy(new SearchSongByMinDuration());
                }else if(searchBy.equals("byartistname")){
                    g.setStrategy(new SearchSongByArtistName());
                }else{
                    System.out.println("Sorry, you cant search for a song in this library using that method of searching. " +
                            "Make sure that the method you chose is compatible with the library you want to search in " +
                            "and the type of item you are searching for. To learn about the various searching methods, " +
                            "please enter \'SearchBy\' as a request and a list of possible search methods and their compatibility will appear.");
                }

            }else if(item.equals("release")){
                if(searchBy.equals("byartistname")){
                    g.setStrategy(new SearchReleaseByArtistName());
                }else if(searchBy.equals("byartistguid")){
                    g.setStrategy(new SearchReleaseByArtistGUID());
                }else if(searchBy.equals("bydaterange")){
                    g.setStrategy(new SearchReleaseByDateRange());
                }else if(searchBy.equals("byreleasetitle")){
                    g.setStrategy(new SearchReleaseByTitle());
                }else if(searchBy.equals("bytrackguid")){
                    g.setStrategy(new SearchReleaseByTrackGUID());
                }else if(searchBy.equals("bytrackname")){
                    g.setStrategy(new SearchReleaseByTrackName());
                }else{
                    System.out.println("Sorry, you cant search for a release in this library using that method of searching. " +
                            "Make sure that the method you chose is compatible with the library you want to search in " +
                            "and the type of item you are searching for. To learn about the various searching methods, " +
                            "please enter \'SearchBy\' as a request and a list of possible search methods and their compatibility will appear.");
                }
            }else{
                System.out.println("The item type you entered was not a song, release or artist. Please check your spelling.");
            }

        }else if (library.equals("personal")) {
            whichLibrary = 2;
            if(item.equals("artist")){
                if(searchBy.equals("byminrating")){
                    p.setStrategy(new SearchArtistByMinRating());
                }else if(searchBy.equals("byname")){
                    p.setStrategy(new SearchArtistByName());
                }else if(searchBy.equals("bytype")){
                    p.setStrategy(new SearchArtistByType());
                }else{
                    System.out.println("Sorry, you cant search for an artist in this library using that method of searching. " +
                            "Make sure that the method you chose is compatible with the library you want to search in " +
                            "and the type of item you are searching for. To learn about the various searching methods, " +
                            "please enter \'SearchBy\' as a request and a list of possible search methods and their compatibility will appear.");
                }

            }else if(item.equals("song")){
                if(searchBy.equals("byartistguid")){
                    p.setStrategy(new SearchSongByArtistGUID());
                }else if(searchBy.equals("byartistname")){
                    p.setStrategy(new SearchSongByArtistName());
                }else if(searchBy.equals("bymaxduration")){
                    p.setStrategy(new SearchSongByMaxDuration());
                }else if(searchBy.equals("byminduration")){
                    p.setStrategy(new SearchSongByMinDuration());
                }else if(searchBy.equals("byminrating")){
                    p.setStrategy(new SearchSongByMinRating());
                }else if(searchBy.equals("byreleaseguid")){
                    p.setStrategy(new SearchSongByReleaseGUID());
                }else if(searchBy.equals("byreleasetitle")){
                    p.setStrategy(new SearchSongByReleaseTitle());
                }else if(searchBy.equals("bysongtitle")){
                    p.setStrategy(new SearchSongByTitle());
                }else{
                    System.out.println("Sorry, you cant search for a song in this library using that method of searching. " +
                            "Make sure that the method you chose is compatible with the library you want to search in " +
                            "and the type of item you are searching for. To learn about the various searching methods, " +
                            "please enter \'SearchBy\' as a request and a list of possible search methods and their compatibility will appear.");
                }

            }else if(item.equals("release")){
                if(searchBy.equals("byartistguid")){
                    p.setStrategy(new SearchReleaseByArtistGUID());
                }else if(searchBy.equals("byartistname")){
                    p.setStrategy(new SearchReleaseByArtistName());
                }else if(searchBy.equals("bymaxduration")){
                    p.setStrategy(new SearchReleaseByMaxDuration());
                }else if(searchBy.equals("byminduration")){
                    p.setStrategy(new SearchReleaseByMinDuration());
                }else if(searchBy.equals("byminrating")){
                    p.setStrategy(new SearchReleaseByMinRating());
                }else if(searchBy.equals("byreleasetitle")){
                    p.setStrategy(new SearchReleaseByTitle());
                }else if(searchBy.equals("bytrackguid")){
                    p.setStrategy(new SearchReleaseByTrackGUID());
                }else if(searchBy.equals("bytrackname")){
                    p.setStrategy(new SearchReleaseByTrackName());
                }else{
                    System.out.println("Sorry, you cant search for a release in this library using that method of searching. " +
                            "Make sure that the method you chose is compatible with the library you want to search in " +
                            "and the type of item you are searching for. To learn about the various searching methods, " +
                            "please enter \'SearchBy\' as a request and a list of possible search methods and their compatibility will appear.");
                }

            }else{
                System.out.println("The item type you entered was not a song, release or artist. Please check your spelling.");
            }

        }else{
            System.out.println("The library type you entered was not \'Global\' or \'Personal\'. Please check your spelling.");
        }

        if (whichLibrary == 1){
            g.executeStrategy(global, param);
        }else if (whichLibrary == 2){
            p.executeStrategy(personal, param);
        }
        else{
            System.out.println("Something went wrong, please try again");
        }

    }
}
