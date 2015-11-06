package kr.pb.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class DBManager {
	
	private DBManager(){
		System.out.println("Connection");
	}
	
	public static Connection getConnection(){
		//jdbc ����̹� �θ���, connection ��ü ���ؼ� �ҷ�����
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://202.30.23.51:3306/SOCIAL_APP_PROJECT_B","sap15B","sap15B!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static void close(Connection con, PreparedStatement pstmt){
		
		try{
			if(pstmt!=null){
			pstmt.close();
			}
			if(con!=null){
				con.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	
		System.out.println("close");
	}
	
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs){
		try{
			if(rs!=null){
				rs.close();
			}
			if(pstmt!=null){
				pstmt.close();
				}
				if(con!=null){
					con.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		System.out.println("close");
	}

}
