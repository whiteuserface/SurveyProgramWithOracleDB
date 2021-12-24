package cafe3;

import java.util.HashMap;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class interfaceMethods implements interfaceMethod {
	abstractMethods getConn = new abstractMethods();
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	Connection conn = null;
	int selectAllFirtstValue = 0;
	String selectAllSecondValue = "";
	
	public Connection getConn() {
		return conn;
	}
	
	
	
	@Override
	public void selectAllSource(HashMap<String, String> getproperties) {
		// TODO Auto-generated method stub
		try {
//			StringBuffer sql = new StringBuffer();
			conn = DriverManager.getConnection(getproperties.get("url"),getproperties.get("user"),getproperties.get("password"));
			StringBuffer sql = new StringBuffer();
			sql.append(getproperties.get("selectAll"));
//			String sql = "select * from \"CAFE3\"";
//			String sql = getproperties.get("selectAll");
//			sql.append(getproperties.get("selectAll"));
//			conn = DriverManager.getConnection(getproperties.get("url"),getproperties.get("user"),getproperties.get("password"));
//			System.out.println(getproperties.get("selectAll"));
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.print(rs.getLong(1)+" ");
				 System.out.print(rs.getString(2)+" ");
				 System.out.print(rs.getString(3));
				System.out.println();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(NullPointerException e1) {
			e1.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
//			if(conn != null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
		}
	}
	
	public HashMap<Integer,String> getFoodNameAndNum(HashMap<String, String> getproperties, int searchNum) {
		// TODO Auto-generated method stub
		HashMap<Integer, String> getNumAndName = new HashMap<>();
		String getName = "";
		int getNum = 0;
		
		try {
//			
			conn = DriverManager.getConnection(getproperties.get("url"),getproperties.get("user"),getproperties.get("password"));
			StringBuffer sql = new StringBuffer();
			sql.append(getproperties.get("selectNum"));
		
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setLong(1, searchNum);
			rs = pstmt.executeQuery();
			while(rs.next()) {
			getNum = (int)rs.getLong(1);
			getName = rs.getString(2);
				System.out.println();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(NullPointerException e1) {
			e1.printStackTrace();
		} finally {
			getNumAndName.put(getNum, getName);
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
//			if(conn != null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
		}
		return getNumAndName;
	}
	
	@Override
	public void insertSource(HashMap<String,String>getproperties,Connection conn, String foodName) {
		// TODO Auto-generated method stub
		this.conn = conn;
		try {
			StringBuffer sql = new StringBuffer();
			conn = DriverManager.getConnection(getproperties.get("url"),getproperties.get("user"),getproperties.get("password"));
			sql.append(getproperties.get("insert"));
//			String sql = getproperties.get("selectAll");
//			sql.append(getproperties.get("selectAll"));
//			conn = DriverManager.getConnection(getproperties.get("url"),getproperties.get("user"),getproperties.get("password"));
//			System.out.println(getproperties.get("selectAll"));
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, foodName);
			int result = pstmt.executeUpdate();
			System.out.println(result + "행이 삽입되었습니다.");
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(NullPointerException e1) {
			e1.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
			
	}
	
	@Override
	public void updateSource(HashMap<String, String> getproperties,Connection conn, int plusCount ,String foodName) {
		// TODO Auto-generated method stub
		this.conn = conn;
		String plusCountStringChanger = Integer.toString(plusCount);
		try {
			StringBuffer sql = new StringBuffer();
			conn = DriverManager.getConnection(getproperties.get("url"),getproperties.get("user"),getproperties.get("password"));
			sql.append(getproperties.get("update"));
//			String sql = getproperties.get("selectAll");
//			sql.append(getproperties.get("selectAll"));
//			conn = DriverManager.getConnection(getproperties.get("url"),getproperties.get("user"),getproperties.get("password"));
//			System.out.println(getproperties.get("selectAll"));
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, plusCountStringChanger);
			pstmt.setString(2, foodName);
			int result = pstmt.executeUpdate();
			System.out.println(result + "1개행의 Count가 올라가게 되었습니다.");
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(NullPointerException e1) {
			e1.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public int getAndPlusCount(HashMap<String, String> getproperties,Connection conn, String foodName) {
		int beforeCount=0;
		int plusCount = beforeCount+1;
		try {
			conn = DriverManager.getConnection(getproperties.get("url"),getproperties.get("user"),getproperties.get("password"));
			StringBuffer sql = new StringBuffer();
			sql.append(getproperties.get("selectCount"));
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, foodName);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				beforeCount = (int)rs.getLong(1);
				System.out.print(rs.getLong(1)+" ");
				System.out.println(beforeCount);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(NullPointerException e1) {
			e1.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
//			if(conn != null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
		}
		return plusCount;
	}
}
