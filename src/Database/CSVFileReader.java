package Database;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class is used to read a given csv file and store the data into lists, these lists
 * will be stored into one big list offering ease to access a group of specific information
 * 
 * @author Michael Ambrose
 */

public class CSVFileReader {

    // Reads a given csv file and returns a List<List<String>> with the contained information
    public static List<List<String>> csvReader(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader reader = new BufferedReader(fileReader);
        List<List<String>> data = new ArrayList<>();
        String line = "";

        //while a line in the csv file != null
        while((line = reader.readLine()) != null) {
            //splits line into separate records
            String[] tokens = line.split(",");
            //converts tokens into a list and adds the list to the general list
            //containing all the information
            data.add(Arrays.asList(tokens));
        }

        fileReader.close();
        reader.close();
        //return the list of lists containing data
        return data;
    }
}


