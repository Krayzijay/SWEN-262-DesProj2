
import Database.Library;
import SearchStrategys.*;

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
                    g.setStrategy(new SearchDatabaseArtistByName());
                }
            }else if(item.equals("song")){
                if(searchBy.equals("byname") || searchBy.equals("bytitle")){
                    g.setStrategy(new SearchDatabaseSongByTitle());
                }else if(searchBy.equals("bymaxduration")){
                    g.setStrategy(new SearchDatabaseSongByMaxDuration());
                }else if(searchBy.equals("byminduration")){
                    g.setStrategy(new SearchDatabaseSongByMinDuration());
                }else if(searchBy.equals("byartist")){
                    g.setStrategy(new SearchDatabaseSongByArtist());
                }

            }else if(item.equals("release")){
                if(searchBy.equals("byartistname")){
                    g.setStrategy(new SearchDatabaseReleaseByArtistName());
                }else if(searchBy.equals("byartistguid")){
                    g.setStrategy(new SearchDatabaseReleaseByArtistGUID());
                }else if(searchBy.equals("bydaterange")){
                    g.setStrategy(new SearchDatabaseReleaseByDateRange());
                }else if(searchBy.equals("bytitle")){
                    g.setStrategy(new SearchDatabaseReleaseByTitle());
                }else if(searchBy.equals("bytrackguid")){
                    g.setStrategy(new SearchDatabaseReleaseByTrackGUID());
                }else if(searchBy.equals("bytrackname")){
                    g.setStrategy(new SearchDatabaseReleaseByTrackName());
                }
            }

        }else if (library.equals("personal")) {
            whichLibrary = 2;
            if(item.equals("artist")){
                if(searchBy.equals("byminrating")){
                    p.setStrategy(new SearchLibraryArtistByMinRating());
                }else if(searchBy.equals("byname")){
                    p.setStrategy(new SearchLibraryArtistByName());
                }else if(searchBy.equals("bytype")){
                    p.setStrategy(new SearchLibraryArtistByType());
                }

            }else if(item.equals("song")){
                if(searchBy.equals("byartistguid")){
                    p.setStrategy(new SearchLibrarySongByArtistGUID());
                }else if(searchBy.equals("byartistname")){
                    p.setStrategy(new SearchLibrarySongByArtistName());
                }else if(searchBy.equals("bymaxduration")){
                    p.setStrategy(new SearchLibrarySongByMaxDuration());
                }else if(searchBy.equals("byminduration")){
                    p.setStrategy(new SearchLibrarySongByMinDuration());
                }else if(searchBy.equals("byminrating")){
                    p.setStrategy(new SearchLibrarySongByMinRating());
                }else if(searchBy.equals("byreleaseguid")){
                    p.setStrategy(new SearchLibrarySongByReleaseGUID());
                }else if(searchBy.equals("byreleasetitle")){
                    p.setStrategy(new SearchLibrarySongByReleaseTitle());
                }else if(searchBy.equals("bytitle")){
                    p.setStrategy(new SearchLibrarySongByTitle());
                }

            }else if(item.equals("release")){
                if(searchBy.equals("byartistguid")){
                    p.setStrategy(new SearchLibraryReleaseByArtistGUID());
                }else if(searchBy.equals("byartistname")){
                    p.setStrategy(new SearchLibraryReleaseByArtistName());
                }else if(searchBy.equals("bymaxduration")){
                    p.setStrategy(new SearchLibraryReleaseByMaxDuration());
                }else if(searchBy.equals("byminduration")){
                    p.setStrategy(new SearchLibraryReleaseByMinDuration());
                }else if(searchBy.equals("byminrating")){
                    p.setStrategy(new SearchLibraryReleaseByMinRating());
                }else if(searchBy.equals("bytitle")){
                    p.setStrategy(new SearchLibraryReleaseByTitle());
                }else if(searchBy.equals("bytrackguid")){
                    p.setStrategy(new SearchLibraryReleaseByTrackGUID());
                }else if(searchBy.equals("bytrackname")){
                    p.setStrategy(new SearchLibraryReleaseByTrackName());
                }

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
}
