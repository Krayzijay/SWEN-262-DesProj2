
import Database.Library;
public interface State {
    public void execute(Library global, Library personal, String[] tokens);
}
