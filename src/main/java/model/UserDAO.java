package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	// DB에 연결한 접속객체(Connection)를 얻어오는 메소
	public Connection getConnection() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String pw = "1212";		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 오라클 서버에 접속된 객체를 반환 받음
			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("데이터베이스 연결 성공~~!");			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return conn;
		}
	}
	
	// 회원정보 저장
	public int userInsert(UserDTO dto) {		
		String sql = "INSERT INTO users "
				+ "VALUES(user_seq.nextVal,?,?,?,?,?,?)";
		
		conn = getConnection();
		int n = -1;
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPw());
			ps.setString(3, dto.getName());
			ps.setInt(4, dto.getAge());
			ps.setString(5, dto.getEmail());
			ps.setString(6, dto.getTel());
			
			n = ps.executeUpdate();
			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}		
		return n;
	}
	
	// 회원 리스트 조회
	public ArrayList<UserDTO> userList() {
		ArrayList<UserDTO> list = new ArrayList<>();
		
		String sql = "SELECT * FROM users";		
		conn = getConnection();		
		try {
			ps = conn.prepareStatement(sql);			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int uno = rs.getInt("uno");
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String email = rs.getString("email");
				String tel = rs.getString("tel");
				
				// dto로 묶기
				UserDTO dto = new UserDTO(uno, id, pw, name, age, email, tel);
				list.add(dto);
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}		
		return list;
	}

	public int deleteUser(int uno) {
		String sql = "DELETE FROM users WHERE uno = ?";
		getConnection();
		
		int n = -1;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, uno);
			n = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {			
				ps.close();
				conn.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}	
		
		return n;
	}

	public UserDTO userInfo(int uno) {
		UserDTO dto = null;
		
		String sql = "SELECT * FROM users WHERE uno = ?";		
		conn = getConnection();		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, uno);
			rs = ps.executeQuery();
			
			// 한명만 조회됨
			if(rs.next()) {
				// uno 재할당
				uno = rs.getInt("uno");
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String email = rs.getString("email");
				String tel = rs.getString("tel");
				
				// dto로 묶기
				dto = new UserDTO(uno, id, pw, name, age, email, tel);				
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
		return dto;
	}

	public int userUpdate(UserDTO dto) {
		String sql = "UPDATE users SET age=?"
				+ ", email=?, tel=? "
				+ "WHERE uno = ?";
		getConnection();
		int n = -1;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, dto.getAge());
			ps.setString(2, dto.getEmail());
			ps.setString(3, dto.getTel());
			ps.setInt(4, dto.getUno());
			
			n = ps.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {			
				ps.close();
				conn.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}	
		return n;
	}
}
