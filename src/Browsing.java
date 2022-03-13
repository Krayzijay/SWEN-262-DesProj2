import Database.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Browsing{

    public static void browse(Library personal){
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            //prints all artists
            System.out.println("List of Artists:");
            printAllArtists(personal.getArtists());

            //user chooses an artist
            System.out.println("Please enter a Artist's name or \'Back\' to go back.:");
            String input = "";
            try{
                input = buffer.readLine();
            } catch (IOException e){}

            //if user wants to leave, end loop
            if (input.toLowerCase().equals("back")){
                break;
            }

            //checks if artist is in library
            Artist artist = null;
            for (Artist a : personal.getArtists() ){
                if(a.getName().toLowerCase().equals(input.toLowerCase())){
                    artist = a;
                    break;
                }
            }

            //if artist selects an artist and the artist is in the library
            if (artist != null){
                while(true){
                    //print single songs and releases
                    printArtistInfo(artist, personal);
                    System.out.println("Please enter a Release Title or \'Back\' to go back.:");
                    try{
                        input = buffer.readLine().toLowerCase();
                    } catch (IOException e){}

                    //backs out to list of artists
                    if (input.toLowerCase().equals("back")){
                        break;
                    }else{
                        //print release info
                        printRelease(personal.getReleases(), artist, input);
                    }

                    System.out.println("Enter \"Back\" when you want to go back to the list of songs and releases.");
                    String exit = "";
                    while (true) {
                        try {
                            exit = buffer.readLine().toLowerCase();
                            if (exit.equals("back")) {
                                break;
                            }
                        } catch (IOException e) {
                        }
                    }

                }

            }else{
                System.out.println("The artist you chose does not exist in your library.");
            }
        }

    }
    public static void printAllArtists(List<Artist> list ){
        for (Artist a : list ){
            System.out.print("Artist's Name: " + a.getName() + ", Disambiguation: " + a.getType() +
                    ", Total Duration: " + a.getDuration());
            System.out.println(" milliseconds");
        }
    }

    public static void printRelease(List<Release> releases, Artist artist, String name){

        for(Release r : releases){
            if(r.getArtist().equals(artist) && r.getTitle().toLowerCase().equals(name)){
                System.out.println("List of songs in \"" + r.getTitle() +"\":");
                for(Song song : r.getTracks()){
                    System.out.println("Song Title: "+ song.getTitle() + ", Duration:" + song.getDuration() + ", Rating: "+ song.getRating());
                }
                break;
            }
        }
        System.out.println("Couldn't find that release. Please check your spelling.");
    }

    public static void printArtistInfo(Artist chosenArtist, Library personal){

        //prints all single songs then all releases
        System.out.println("Songs In Personal Library:");
        for(Song song : personal.getSongs()){
            int check = 0;
            if(song.getArtist().equals(chosenArtist)){
                check = 1;
                for(Release r : personal.getReleases()){
                    if(r.getTracks().contains(song)){
                        check = 2;
                        break;
                    }
                }
                if(check == 1){
                    System.out.println("Song Name: "+ song + ", Duration:" + song.getDuration() + ", Rating: "+ song.getRating());
                }
            }
        }

        System.out.println("Releases In Personal Library:");
        //title, date, media, average rating, total duration of all tracks
        for(Release r : personal.getReleases()){
            if(r.getArtist().equals(chosenArtist)){
                System.out.println("Release Title: "+ r.getTitle() +", Date: "+ r.getDate() +", Media: "+ r.getMedium() +
                        ", Average Rating: "+ r.getRating() +", Total Duration: " + r.getDuration());
            }
        }
    }

}
