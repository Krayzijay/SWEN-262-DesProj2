package src.Database;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import parser.Reader;

public class Library {
    List<Song> DatabaseSongCollection;
    List<Artist> DatabaseArtistCollection;
    List<Release> DatabaseReleaseCollection;
    List<Song> LibrarySongCollection;
    List<Artist> LibraryArtistCollection;
    List<Release> LibraryReleaseCollection;
    List<List<String>> data;

    public Library () {
        DatabaseSongCollection = new ArrayList<>();
        DatabaseArtistCollection = new ArrayList<>();
        DatabaseReleaseCollection = new ArrayList<>();

        LibrarySongCollection = new ArrayList<>();
        LibraryArtistCollection = new ArrayList<>();
        LibraryReleaseCollection = new ArrayList<>();

    }

    public synchronized void populateArtistData() throws IOException {
        data = Reader.csvReader("data/artists.csv");

        for(int i = 0; i < data.size(); i++) {
            if(data.get(i).size() == 2) {
                DatabaseArtistCollection.add(new Artist(data.get(i).get(0), data.get(i).get(1)));
            }
            else {
                DatabaseArtistCollection.add(new Artist(data.get(i).get(0), data.get(i).get(1), data.get(i).get(2)));
            }
        }
    }

    public synchronized void populateSongData() throws IOException {
        data = Reader.csvReader("data/songs.csv");
        String guid = null;
        Artist matching_artist = null;
        int duration = 0;
        String title = null;

        for(int i = 0; i < data.size(); i++) {
            List<String> record = data.get(i);

            guid = record.get(0);

            for (Artist artist : DatabaseArtistCollection) {
                if(artist.getArtist(record.get(1)))
                    matching_artist = artist;
            }

            duration = Integer.parseInt(record.get(2));

            title = record.get(3);

            if(record.size() != 4) {
                for(int j = 4; j < record.size(); j++) {
                    title += "," + record.get(j);
                    
                    if(j + 1 == record.size())
                        title += record.get(j);
                }
            }

            DatabaseSongCollection.add(new Song(guid, matching_artist, duration, title));
        }
    }

    public synchronized void populateReleaseData() throws IOException {
        data = Reader.csvReader("data/releases.csv");
        String guid = null;
        Artist matching_artist = null;
        String title = null;
        String medium = null;
        String date = null;

        for(int i = 0; i < data.size(); i++) {
            List<Song> tracks = new ArrayList<>();
            List<String> record = data.get(i);

            //Gets GUID
            guid = record.get(0);

            //Gets Artist by matching GUID of artist in collection with GUID of artist in release
            for (Artist artist : DatabaseArtistCollection) {
                if(artist.getArtist(record.get(1)))
                    matching_artist = artist;
            }

            //If there is a comma in the title
            if(record.get(2).charAt(0) == '\"') {
                title = record.get(2) + "," + record.get(3);
                medium = record.get(4);
                date = record.get(5);
            } else {
                title = record.get(2);
                medium = record.get(3);
                date = record.get(4);
                
                for(int j = 5; j < record.size(); j++) {
                    tracks.add(songToTrack(record.get(j)));
                }
            }

            DatabaseReleaseCollection.add(new Release(guid, matching_artist, title, medium, date, tracks));
        }
    }

    public List<Artist> getDatabaseArtistCollection() {
        return DatabaseArtistCollection;
    }

    public List<Release> getDatabaseReleaseCollection() {
        return DatabaseReleaseCollection;
    }

    public List<Song> getDatabaseSongCollection() {
        return DatabaseSongCollection;
    }

    public List<Artist> getLibraryArtistCollection() {
        return LibraryArtistCollection;
    }

    public List<Release> getLibraryReleaseCollection() {
        return LibraryReleaseCollection;
    }

    public List<Song> getLibrarySongCollection() {
        return LibrarySongCollection;
    }

    public Song songToTrack(String id) {
        Song song = null;
        for(Song o : DatabaseSongCollection) {
            if(o.getGUID().equals(id))
                song = o;
        }
        return song;
    }

    public static void main(String[] args) throws IOException {
        Library lib = new Library();
        lib.populateArtistData();
        lib.populateSongData();
        lib.populateReleaseData();

        System.out.println(lib.DatabaseReleaseCollection.get(5).getTracks().get(0).getGUID());
    }
}