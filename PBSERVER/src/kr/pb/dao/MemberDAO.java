package kr.pb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.pb.dto.Member;
import kr.pb.util.DBManager;



public class MemberDAO {
	
	static MemberDAO dao = new MemberDAO();
	
	private MemberDAO(){
		System.out.println("MemberDAO");
	}
	
	public static MemberDAO getMemberDAO(){
		return dao;
	}
	
	public int isMember(String email, String password){
		String sql = "select * from bipmember where email='"+email+"' and PASSWORD='"+password+"' ";
		Connection con = DBManager.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		
		try {
			pstmt = con.prepareStatement(sql);	
			rs = pstmt.executeQuery();
			
			if(rs.next()) {     
				
				return 1;
			}
	
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBManager.close(con, pstmt);
			
		}
		return 0;
	}
	
	//ȸ������
	public int insertMember(Member m){
		
		String sql = "insert into bipmember values(?, ?, ?, ?, ?, default)";
		Connection con = DBManager.getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		System.out.println(result);
		

		
		try {

			System.out.println(m.getEmail());
			System.out.println(m.getPw());
			System.out.println(m.getName());
			System.out.println(m.getAge());
			System.out.println(m.getGender());
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m.getEmail());
			pstmt.setString(2, m.getPw());
			pstmt.setString(3, m.getName());
			pstmt.setInt(4, m.getAge());
			pstmt.setString(5, m.getGender());
			result = pstmt.executeUpdate();
			System.out.println("ȸ�����Լ���!");
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBManager.close(con,pstmt);
		}
		return result;
	}
	
//	public List<Member> selectMember(){
//		
//		String sql = "select * from member";
//		Connection con = DBManager.getConnection();
//		PreparedStatement pstmt = null;
//		ResultSet rs =null;
//		List<Member> list = new ArrayList<Member>();
//		
//		try {
//			pstmt = con.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//						
//			while(rs.next()){
//				Member m = new Member();
//				
//				m.setId(rs.getString("ID"));
//				m.setName(rs.getString("NAME"));
//				m.setGender(rs.getString("GENDER"));
//				m.setAge(rs.getString("ADDR"));
//				m.setRdate(rs.getDate("REGDATE"));
//				list.add(m);
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			DBManager.close(con, pstmt);
//		}
//		return list;
//		
//	}
	
	public Member selectMemberByEandP(String email,String password) {
		
		String sql = "select * from member where ID=? and PASSWORD=? ";
		Connection con = DBManager.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member m = new Member();

		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {                                 // rs�� Į�� 0 ���� �ǹ��ϱ⶧���� rs.next �ʿ�!
				m.setEmail(rs.getString("ID"));
				m.setPw(rs.getString("PWD"));
				m.setName(rs.getString("NAME"));
				
			}
			else{
				return null;
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBManager.close(con, pstmt,rs);
			
		}
				
		return m;
	}
	
	public Member detailMember(String email, String password){
		String sql = "select * from bipmember where email='"+email+"' and PASSWORD='"+password+"' ";
		Connection con = DBManager.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member m= new Member();
		
		try {
			pstmt = con.prepareStatement(sql);	
			rs = pstmt.executeQuery();
			
			if(rs.next()) {     
				m.setEmail((String)rs.getString("email"));
				m.setPw((String)rs.getString("password"));
				m.setName((String)rs.getString("name"));
				m.setAge((int)rs.getInt("age"));
				
				return m;
			}
	
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBManager.close(con, pstmt,rs);
			
		}
		return null;
	}



public int ModifyPassword(String email,String password){
	
	String sql="update bipmember set PASSWORD= ? where email=? ";
	Connection con = DBManager.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {
		pstmt = con.prepareStatement(sql);	
		pstmt.setString(1, password);
		pstmt.setString(2, email);
		rs = pstmt.executeQuery();
		
		if(rs.next()) {     
			
			return 1;
		}

		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		DBManager.close(con, pstmt,rs);
		
	}
	return 0;


}


public int ModifyDetail(String email,String memail,String name,int age){
	
	String sql="update bipmember set EMAIL=?,  NAME=? , AGE=? where email=? ";
	Connection con = DBManager.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {
		pstmt = con.prepareStatement(sql);	
		pstmt.setString(1, memail);
		pstmt.setString(2, name);
		pstmt.setInt(3, age);
		pstmt.setString(4, email);
		rs = pstmt.executeQuery();
		
		if(rs.next()) {     
			
			return 1;
		}

		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		DBManager.close(con, pstmt);
		
	}
	return 0;


}








}
