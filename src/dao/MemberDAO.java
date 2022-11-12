package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.MemberVO;

// CRUD 작업( create read update delete) 
public class MemberDAO {
	String driver = DbProperties.getDriverJdbc();
	String url = DbProperties.getUrlJdbc();
	String user = DbProperties.getUserJdbc();
	String password = DbProperties.getPasswordJdbc();
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	StringBuffer sb = new StringBuffer();
	
	public MemberDAO() {
		try {
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("conn : "+ conn);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB 연결 실패");
			e.printStackTrace();
		}
	}
	
	// 모두 조회
	public ArrayList<MemberVO> selectAll(){
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		
		sb.setLength(0);
		sb.append("SELECT id, ename,pw, gender, motive FROM member ");
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("ename");
				String pw = rs.getString("pw");
				String gender = rs.getString("gender");
				String motive = rs.getString("motive");
				
				MemberVO vo = new MemberVO(id , name, pw, gender, motive);
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	} // selectAll() end
	// 1건 조회
	public MemberVO selectOne(String id) {
		sb.setLength(0);
		sb.append("SELECT id, ename,pw, gender, motive FROM member ");
		sb.append("WHERE id = ?");
		
		MemberVO vo = null;
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String pw = rs.getString("pw");
				String name = rs.getString("ename");
				String gender = rs.getString("gender");
				String motive = rs.getString("motive");
				vo = new MemberVO(id,name,pw,gender,motive);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
	} // selectOne() end
	// 추가
	public void insertOne(MemberVO vo) {
		sb.setLength(0);
		sb.append("INSERT INTO member ");
		sb.append("VALUES (?,?,?,?,?)");
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getEname());
			pstmt.setString(3, vo.getPw());
			pstmt.setString(4, vo.getGender());
			pstmt.setString(5, vo.getMotive());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// 변경
	public void updateOne() {
		
	}
	// 삭제
	public void deleteOne(String id) {
		sb.setLength(0);
		sb.append("DELETE FROM member ");
		sb.append("WHERE id = ?");
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	// 자원반납
	public void close() {
		try {
			if(rs != null)rs.close();
			if(pstmt != null)pstmt.close();
			if(conn != null)conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
