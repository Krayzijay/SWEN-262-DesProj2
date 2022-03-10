package parser;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    @author Michael Ambrose

    This class is used to read a given csv file and store the data into lists, these lists
    will be stored into one big list offering ease to access a group of specific information
*/

public class Reader {

    // Reads a given csv file and returns a List<List<String>> with the contained information
    public static List<List<String>> csvReader(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader reader = new BufferedReader(fileReader);
        List<List<String>> data = new ArrayList<>();
        String line = "";

        while((line = reader.readLine()) != null) {
            String[] tokens = line.split(",");
            data.add(Arrays.asList(tokens));
        }

        fileReader.close();
        reader.close();
        return data;
    }
}


