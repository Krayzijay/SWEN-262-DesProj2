package src;
import src.Database.Library;
public interface State {
    public void execute(Library db, String[] tokens);
}
