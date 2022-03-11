package src;
import src.Database.Library;
import src.SearchStrategys.*;

public class SearchState implements State{

    @Override
    public void execute(Library db, String[] tokens){
        Searching s = new Searching(db);

        String[] keyWords = tokens[0].split(" ");
        String library = keyWords[1].toLowerCase();
        String item = keyWords[2].toLowerCase();
        String searchBy = keyWords[3].toLowerCase();
        String param = tokens[1].toLowerCase();

        if(library.equals("global")){
            if(item.equals("artist")){
                if(searchBy.equals("byname")){
                    s.setStrategy(new SearchDatabaseArtistByName());
                }
            }else if(item.equals("song")){
                if(searchBy.equals("byname") || searchBy.equals("bytitle")){
                    s.setStrategy(new SearchDatabaseSongByTitle());
                }else if(searchBy.equals("bymaxduration")){
                    s.setStrategy(new SearchDatabaseSongByMaxDuration());
                }else if(searchBy.equals("byminduration")){
                    s.setStrategy(new SearchDatabaseSongByMinDuration());
                }else if(searchBy.equals("byartist")){
                    s.setStrategy(new SearchDatabaseSongByArtist());
                }

            }else if(item.equals("release")){
                if(searchBy.equals("byartistname")){
                    s.setStrategy(new SearchDatabaseReleaseByArtistName());
                }else if(searchBy.equals("byartistguid")){
                    s.setStrategy(new SearchDatabaseReleaseByArtistGUID());
                }else if(searchBy.equals("bydaterange")){
                    s.setStrategy(new SearchDatabaseReleaseByDateRange());
                }else if(searchBy.equals("bytitle")){
                    s.setStrategy(new SearchDatabaseReleaseByTitle());
                }else if(searchBy.equals("bytrackguid")){
                    s.setStrategy(new SearchDatabaseReleaseByTrackGUID());
                }else if(searchBy.equals("bytrackname")){
                    s.setStrategy(new SearchDatabaseReleaseByTrackName());
                }
            }
        }else if (library.equals("personal")) {
            if(item.equals("artist")){
                if(searchBy.equals("byminrating")){
                    s.setStrategy(new SearchLibraryArtistByMinRating());
                }else if(searchBy.equals("byname")){
                    s.setStrategy(new SearchLibraryArtistByName());
                }else if(searchBy.equals("bytype")){
                    s.setStrategy(new SearchLibraryArtistByType());
                }

            }else if(item.equals("song")){
                if(searchBy.equals("byartistguid")){
                    s.setStrategy(new SearchLibrarySongByArtistGUID());
                }else if(searchBy.equals("byartistname")){
                    s.setStrategy(new SearchLibrarySongByArtistName());
                }else if(searchBy.equals("bymaxduration")){
                    s.setStrategy(new SearchLibrarySongByMaxDuration());
                }else if(searchBy.equals("byminduration")){
                    s.setStrategy(new SearchLibrarySongByMinDuration());
                }else if(searchBy.equals("byminrating")){
                    s.setStrategy(new SearchLibrarySongByMinRating());
                }else if(searchBy.equals("byreleaseguid")){
                    s.setStrategy(new SearchLibrarySongByReleaseGUID());
                }else if(searchBy.equals("byreleasetitle")){
                    s.setStrategy(new SearchLibrarySongByReleaseTitle());
                }else if(searchBy.equals("bytitle")){
                    s.setStrategy(new SearchLibrarySongByTitle());
                }

            }else if(item.equals("release")){
                if(searchBy.equals("byartistguid")){
                    s.setStrategy(new SearchLibraryReleaseByArtistGUID());
                }else if(searchBy.equals("byartistname")){
                    s.setStrategy(new SearchLibraryReleaseByArtistName());
                }else if(searchBy.equals("bymaxduration")){
                    s.setStrategy(new SearchLibraryReleaseByMaxDuration());
                }else if(searchBy.equals("byminduration")){
                    s.setStrategy(new SearchLibraryReleaseByMinDuration());
                }else if(searchBy.equals("byminrating")){
                    s.setStrategy(new SearchLibraryReleaseByMinRating());
                }else if(searchBy.equals("bytitle")){
                    s.setStrategy(new SearchLibraryReleaseByTitle());
                }else if(searchBy.equals("bytrackguid")){
                    s.setStrategy(new SearchLibraryReleaseByTrackGUID());
                }else if(searchBy.equals("bytrackname")){
                    s.setStrategy(new SearchLibraryReleaseByTrackName());
                }

            }
        }
        s.executeStrategy(param);
    }
}
