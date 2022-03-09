package src;

public class SearchState implements State{

    @Override
    public void execute(Library db, String[] tokens){
        String[] keyWords = tokens[0].split(" ");
        //Search Song ByTitle 'Mr. Blue Sky
        String item = keyWords[1];
        String searchBy = keyWords[2];
        String param = tokens[1];

        to do list:
        setstrategy()
        execute()
        post data
    }
}
