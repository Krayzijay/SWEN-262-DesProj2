package src;

public interface State {
    public void execute(Database.Library db, String[] tokens);
}
