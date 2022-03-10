package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Browsing{

    public static void browse(Database.Library db){
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            //prints all artists
            System.out.println("List of Artists:");
            printArtists(db.getArtists());

            //user chooses an artist
            System.out.println("Please enter a Artist's name or \'Back\' to go back.:");
            String input = "";
            try{
                input = buffer.readLine();
            } catch (IOException e){}

            //checks if artist is in library
            int contains = 0;
            Database.Artist b = null;
            for (Database.Artist a : db.getArtists() ){
                if(a.getName().toLowerCase().equals(input.toLowerCase())){
                    contains = 1;
                    b = a;
                    break;
                }
            }

            //if artist wants to leave, end loop
            if (input.toLowerCase().equals("back")){
                break;
            }

            //if artist selects an artist
            else if (contains == 1){
                while(true){
                    //print single songs and releases
                    //needs toString in Artist class to get rid of error below
                    printArtistInfo(b);

                    System.out.println("Please enter a Release Title or \'Back\' to go back.:");
                    try{
                        input = buffer.readLine();
                    } catch (IOException e){}

                    //backs out to list of artists
                    if (input.toLowerCase().equals("back")){
                        break;
                    }else{
                        //print release info
                        printRelease(input)
                    }
                }

            }


        }

        /**
         * The user may choose one artist to explore.
         *
         * Individual songs (not part of a full release) will be displayed including title, duration, and rating.
         *
         * Releases will be displayed including title, date, media, average rating, total duration of all tracks.
         *
         * The user may choose to explore a release.
         *
         * Individual songs (part of the release) will be displayed including title, duration, and rating.
         *
         * The user may choose to back out to the artist.
         * The user may choose to back out to the list of artists.
         */


    }
    public static void printArtists(List<Database.Artist> list ){
        for (Database.Artist a : list ){
            System.out.println(a);
        }
    }

    public static void printRelease(String name){
        Release r = release list .get(name);
        System.out.println(r);
    }

    public static void printArtistInfo(String name){
        //finds the artist instance
        Artist a = artist list .get(name);

        //gets the artists songs and releases
        ArrayList allSongs = a.getSongs();
        ArrayList allReleases = a.getReleases();

        //list of songs belonging to the artist that arent part of a release
        ArrayList singleSongs = new ArrayList(allSongs.size());

        //finds which songs are not part of a release
        for(Song s : allSongs){
            for(Release r : allReleases){
                ArrayList songs = r.getSongs();
                if((songs.contains(s))){
                    //do nothing
                }
                else{
                    singleSongs.add(s);
                }
            }
        }

        //prints all single songs then all releases
        for(Song song : singleSongs){
            System.out.println(song);
        }
        for(Release release : allReleases){
            System.out.println(release);
        }
    }

}
