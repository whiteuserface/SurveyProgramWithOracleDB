package cafe3;
import java.util.HashMap;
public abstract class abstractMethod {
	HashMap<String, String> sendProperties;
	public abstract void connectDatabase(HashMap<String, String> hashmap);
	public abstract void getProperties();
}
