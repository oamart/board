package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class BoardDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public void getConnection() {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String pw = "1234";      
	      
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
	         
			// 오라클 서버에 접속된 객체를 반환 받음
			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("데이터베이스 연결 성공~~!");
		} catch (Exception e) {
			e.printStackTrace();
		}   
	}
	
	public void dbClose() {
	    try {
	        if(rs !=null) rs.close();
	        if(ps !=null) ps.close();
	        if(conn !=null) conn.close();
	    } catch (Exception e) {
		    e.printStackTrace();
		}
	}

	public void write(String writer, String title, String content) {
		// TODO Auto-generated method stub
		String sql = "insert into board values(bbs_seq.nextVal, ?, ?, ?, sysdate, 0, 0, 0, 0)";
		
		getConnection();
		
		if (conn != null) {
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, title);
				ps.setString(2, writer);
				ps.setString(3, content);
				
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				dbClose();
			}
		}
	}

	public ArrayList<BoardDTO> list() {
		// TODO Auto-generated method stub
		ArrayList<BoardDTO> lst = new ArrayList<>();
		getConnection();
		if (conn != null) {
			String sql = "select * from board";
			try {
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery(sql);
				while(rs.next()) {
					int bid = rs.getInt("bid");
					String title = rs.getString("title");
					String writer = rs.getString("writer");
					String content = rs.getString("content");
					Timestamp regdate = rs.getTimestamp("reg_date");
					int hit = rs.getInt("hit");
					int bgroup = rs.getInt("bgroup");
					int bstep = rs.getInt("bstep");
					int bindent = rs.getInt("bindent");
					lst.add(new BoardDTO(bid, title, writer, content, regdate, hit, bgroup, bstep, bindent));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				dbClose();
			}
		}
		return lst;
	}

	public BoardDTO getRow(String id) {
		updateHit(id);
		
		getConnection();
		BoardDTO dto = null;
		if (conn != null) {
			String sql = "select * from board where bid=?";
			
			int nBid = Integer.parseInt(id);
			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1, nBid);
				rs = ps.executeQuery();
				if (rs.next()) {
					int bid = rs.getInt("bid");
					String title = rs.getString("title");
					String writer = rs.getString("writer");
					String content = rs.getString("content");
					Timestamp regdate = rs.getTimestamp("reg_date");
					int hit = rs.getInt("hit");
					int bgroup = rs.getInt("bgroup");
					int bstep = rs.getInt("bstep");
					int bindent = rs.getInt("bindent");
					dto = new BoardDTO(bid, title, writer, content, regdate, hit, bgroup, bstep, bindent);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				dbClose();
			}
		}
		return dto;
	}

	public int delete(String bid) {
		int nBid = Integer.parseInt(bid);
		String sql = "delete from board where bid=?";
		getConnection();
		int result = 0;
		if (conn != null) {
			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1, nBid);
				result = ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				dbClose();
			}
		}
		return result;
	}

	public int update(HttpServletRequest request) {
		int nBid = Integer.parseInt(request.getParameter("bid"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");

		String sql = "update board set title=?, writer=?, content=? where bid=?";
		getConnection();
		int result = 0;
		if (conn != null) {
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, title);
				ps.setString(2, writer);
				ps.setString(3, content);
				ps.setInt(4, nBid);
				result = ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				dbClose();
			}
		}
		return result;
	}	
	
	public int updateHit(String bid) {
		int nBid = Integer.parseInt(bid);

		String sql = "update board set hit=hit+1 where bid=?";
		getConnection();
		int result = 0;
		if (conn != null) {
			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1, nBid);
				result = ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				dbClose();
			}
		}
		return result;
	}
}
