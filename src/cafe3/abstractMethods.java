package cafe3;
import java.util.Properties;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.util.HashMap;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Connection;



public class abstractMethods extends abstractMethod {
	private HashMap<String, String> thisProperties;
//	private Connection conn = null;
	
	public HashMap<String, String> getThisProperties() {
		HashMap<String, String> tmp = this.thisProperties;
		return tmp;
	}
//	
//	public Connection getConn() {
////		Connection tmp = this.conn;
//		return this.conn;
//	}
	
	
	
	@Override
	public void connectDatabase(HashMap<String, String>thisProperties) {
		// TODO Auto-generated method stub
		
		try {
			Class.forName(thisProperties.get("driver"));
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
//			catch(SQLException e1) {
//			e1.printStackTrace();
//		}
	}
	@Override
	public void getProperties() {
		 sendProperties = new HashMap<>(); 
		try {
			Properties ptDb = new Properties();
			FileReader frDb = new FileReader("./resources/DbInformation.properties");
			Properties ptSql = new Properties();
			FileReader frSql = new FileReader("./resources/Sql.properties");
			
			ptDb.load(frDb);
			ptSql.load(frSql);
			sendProperties.put("driver", ptDb.getProperty("driver"));
			sendProperties.put("user", ptDb.getProperty("user"));
			sendProperties.put("url",ptDb.getProperty("url"));
			sendProperties.put("password",ptDb.getProperty("password"));
			sendProperties.put("selectAll",ptSql.getProperty("selectAll"));
			sendProperties.put("insert",ptSql.getProperty("insert"));
			sendProperties.put("update",ptSql.getProperty("update"));
			sendProperties.put("selectCount",ptSql.getProperty("selectCount"));
			sendProperties.put("selectNum",ptSql.getProperty("selectNum"));
			
			} catch(FileNotFoundException e) {
				e.printStackTrace();
			} catch(IOException e1) {
				e1.printStackTrace();
			}
			
			this.thisProperties = sendProperties;
	}
}
