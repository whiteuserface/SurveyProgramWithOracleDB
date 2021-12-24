package cafe3;
import java.util.HashMap;
import java.sql.Connection;
public interface interfaceMethod {
	public void selectAllSource(HashMap<String,String> getproperties);
	public void updateSource(HashMap<String,String> getproperties,Connection conn,int plusCount ,String foodName);
	public void insertSource(HashMap<String,String> getproperties,Connection conn, String foodName);
}
