package src;
import src.Database.Library;
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
                    s.setStrategy(new src.SearchDatabaseArtistByName());
                }
            }else if(item.equals("song")){
                if(searchBy.equals("byname") || searchBy.equals("bytitle")){
                    s.setStrategy(new src.SearchDatabaseSongByTitle());
                }else if(searchBy.equals("bymaxduration")){
                    s.setStrategy(new src.SearchDatabaseSongByMaxDuration());
                }else if(searchBy.equals("byminduration")){
                    s.setStrategy(new src.SearchDatabaseSongByMinDuration());
                }else if(searchBy.equals("byartist")){
                    s.setStrategy(new src.SearchDatabaseSongByArtist());
                }

            }else if(item.equals("release")){
                if(searchBy.equals("byartistname")){
                    s.setStrategy(new src.SearchDatabaseReleaseByArtistName());
                }else if(searchBy.equals("byartistguid")){
                    s.setStrategy(new src.SearchDatabaseReleaseByArtistGUID());
                }else if(searchBy.equals("bydaterange")){
                    s.setStrategy(new src.SearchDatabaseReleaseByDateRange());
                }else if(searchBy.equals("bytitle")){
                    s.setStrategy(new src.SearchDatabaseReleaseByTitle());
                }else if(searchBy.equals("bytrackguid")){
                    s.setStrategy(new src.SearchDatabaseReleaseByTrackGUID());
                }else if(searchBy.equals("bytrackname")){
                    s.setStrategy(new src.SearchDatabaseReleaseByTrackName());
                }
            }
        }else if (library.equals("personal")) {
            if(item.equals("artist")){
                if(searchBy.equals("byminrating")){
                    s.setStrategy(new src.SearchLibraryArtistByMinRating());
                }else if(searchBy.equals("byname")){
                    s.setStrategy(new src.SearchLibraryArtistByName());
                }else if(searchBy.equals("bytype")){
                    s.setStrategy(new src.SearchLibraryArtistByType());
                }

            }else if(item.equals("song")){
                if(searchBy.equals("byartistguid")){
                    s.setStrategy(new src.SearchLibrarySongByArtistGUID());
                }else if(searchBy.equals("byartistname")){
                    s.setStrategy(new src.SearchLibrarySongByArtistName());
                }else if(searchBy.equals("bymaxduration")){
                    s.setStrategy(new src.SearchLibrarySongByMaxDuration());
                }else if(searchBy.equals("byminduration")){
                    s.setStrategy(new src.SearchLibrarySongByMinDuration());
                }else if(searchBy.equals("byminrating")){
                    s.setStrategy(new src.SearchLibrarySongByMinRating());
                }else if(searchBy.equals("byreleaseguid")){
                    s.setStrategy(new src.SearchLibrarySongByReleaseGUID());
                }else if(searchBy.equals("byreleasetitle")){
                    s.setStrategy(new src.SearchLibrarySongByReleaseTitle());
                }else if(searchBy.equals("bytitle")){
                    s.setStrategy(new src.SearchLibrarySongByTitle());
                }

            }else if(item.equals("release")){
                if(searchBy.equals("byartistguid")){
                    s.setStrategy(new src.SearchLibraryReleaseByArtistGUID());
                }else if(searchBy.equals("byartistname")){
                    s.setStrategy(new src.SearchLibraryReleaseByArtistName());
                }else if(searchBy.equals("bymaxduration")){
                    s.setStrategy(new src.SearchLibraryReleaseByMaxDuration());
                }else if(searchBy.equals("byminduration")){
                    s.setStrategy(new src.SearchLibraryReleaseByMinDuration());
                }else if(searchBy.equals("byminrating")){
                    s.setStrategy(new src.SearchLibraryReleaseByMinRating());
                }else if(searchBy.equals("bytitle")){
                    s.setStrategy(new src.SearchLibraryReleaseByTitle());
                }else if(searchBy.equals("bytrackguid")){
                    s.setStrategy(new src.SearchLibraryReleaseByTrackGUID());
                }else if(searchBy.equals("bytrackname")){
                    s.setStrategy(new src.SearchLibraryReleaseByTrackName());
                }

            }
        }
        s.executeStrategy(param);
    }
}
