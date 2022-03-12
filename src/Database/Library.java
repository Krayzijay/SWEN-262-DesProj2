package Database;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import parser.Reader;

/**
 * This class represents the database which contains the collection of artists, songs,
 * and releases
 * 
 * @author Michael Ambrose
 */

public class Library {
    List<Song> SongCollection;
    List<Artist> ArtistCollection;
    List<Release> ReleaseCollection;
    List<List<String>> data;

    public Library () {
        SongCollection = new ArrayList<>();
        ArtistCollection = new ArrayList<>();
        ReleaseCollection = new ArrayList<>();
    }

    //Populates the ArtistCollection with artists
    public synchronized void populateArtistData() throws IOException {
        //parses the csv file
        data = Reader.csvReader("data/artists.csv");

        for(int i = 0; i < data.size(); i++) {
            //if the size of the record = 2 (the artist has no type)
            if(data.get(i).size() == 2) {
                ArtistCollection.add(new Artist(data.get(i).get(0), data.get(i).get(1)));
            }
            //else the include the third value which is the artist's type
            else {
                ArtistCollection.add(new Artist(data.get(i).get(0), data.get(i).get(1), data.get(i).get(2)));
            }
        }
    }

    //Populates the SongCollection with songs
    public synchronized void populateSongData() throws IOException {
        //parses the csv file
        data = Reader.csvReader("data/songs.csv");

        //variables that relate to data in each record
        String guid = null;
        Artist matching_artist = null;
        int duration = 0;
        String title = null;
        
        for(int i = 0; i < data.size(); i++) {
            //record captures one line in the file
            List<String> record = data.get(i);

            //gets GUID
            guid = record.get(0);

            //searches the ArtistCollection
            for (Artist artist : ArtistCollection) {
                //if artist's guid matches the artist's guid in song, get artist
                if(artist.getArtist(record.get(1)))
                    matching_artist = artist;
            }

            //gets duration
            duration = Integer.parseInt(record.get(2));

            //gets title
            title = record.get(3);

            //if record size != 4 the title has a comma in it
            if(record.size() != 4) {
                //merges the separate values into the actual title
                for(int j = 4; j < record.size(); j++) {
                    title += "," + record.get(j);
                    
                    if(j + 1 == record.size())
                        title += record.get(j);
                }
            }

            //add new Song to the SongCollection
            SongCollection.add(new Song(guid, matching_artist, duration, title));
            matching_artist.songs.add(SongCollection.get(SongCollection.size() - 1));
        }
    }

    //Populates the ReleaseCollection with releases
    public synchronized void populateReleaseData() throws IOException {
        //parses the csv file
        data = Reader.csvReader("data/releases.csv");

        //variables that relate to data in each record
        String guid = null;
        Artist matching_artist = null;
        String title = null;
        String medium = null;
        String date = null;

        for(int i = 0; i < data.size(); i++) {
            //List of songs that will be part of a release
            List<Song> tracks = new ArrayList<>();
            //record captures one line in the file
            List<String> record = data.get(i);

            //Gets GUID
            guid = record.get(0);

            //Gets Artist by matching GUID of artist in collection with GUID of artist in release
            for (Artist artist : ArtistCollection) {
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
            //add new Release to the ReleaseCollection
            ReleaseCollection.add(new Release(guid, matching_artist, title, medium, date, tracks));  
            matching_artist.releases.add(ReleaseCollection.get(ReleaseCollection.size() - 1));
        }
    }

    //Given a guid, search SongCollection for the matching song with the same guid
    public Song songToTrack(String id) {
        Song song = null;
        for(Song o : SongCollection) {
            if(o.getGUID().equals(id))
                song = o;
        }
        return song;
    }

    public void addSong(Song song) {
        this.SongCollection.add(song);
    }

    public void addArtist(Artist artist) {
        this.ArtistCollection.add(artist);
    }
    
    public void addRelease(Release release) {
        this.ReleaseCollection.add(release);
    }

    public void removeRelease(Release release) {
        this.ReleaseCollection.remove(release);
    }

    public void removeArtist(Artist artist) {
        this.ArtistCollection.remove(artist);
    }

    public void removeSong(Song song) {
        this.SongCollection.remove(song);
    }

    
    public List<Artist> getArtists() {return this.ArtistCollection;}

    public List<Song> getSongs() {return this.SongCollection;}
    
    public List<Release> getReleases() {return this.ReleaseCollection;}
}