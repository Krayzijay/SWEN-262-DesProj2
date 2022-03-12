package SearchStrategys;
import Database.Library;

/**
 * The interface for outlining the strategy pattern
 * for searching in the system.
 * 
 * @author Bryson VerDow
 */
public interface SearchStrategy {
    public void search(Library lib, String specification);
}
