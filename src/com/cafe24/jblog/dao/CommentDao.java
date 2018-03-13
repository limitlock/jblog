package com.cafe24.jblog.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cafe24.jblog.vo.CommentVo;

public class CommentDao {

	public List<CommentVo> getList(Long postNo) {

		List<CommentVo> list = new ArrayList<CommentVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; // 결과값이 여러개일 경우

		try {
			conn = getConnection();
			String sql = "select  a.id, a.content, a.cur_date, a.post_no from comment a, post b where a.no = b.no and a.post_no = ?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setLong(1, postNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				String id = rs.getString(1);
				String content = rs.getString(2);
				String curDate = rs.getString(3);
				Long outPostNo = rs.getLong(4);

				CommentVo vo = new CommentVo();
				vo.setId(id);
				vo.setContent(content);
				vo.setCurDate(curDate);
				vo.setPostNo(outPostNo);

				list.add(vo); // DB에서 가져온 결과(Vo)를 list에 삽입
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return list;
	}

	public boolean insert(CommentVo vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();
			// insert into comment values(1, null, 'mycall', '퍼가겠습니다~', '12313');
			String sql = "insert into comment values(null, ?, ?, ?, ?);";
			pstmt = conn.prepareStatement(sql);

			// 등록시간
			SimpleDateFormat format = new SimpleDateFormat("YYYY:MM:DD:HH:mm:ss");
			String data = format.format(new Date());

			// 바인딩
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, data);
			pstmt.setLong(4, vo.getPostNo());
			// 실행
			int count = pstmt.executeUpdate();

			result = (count == 1);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost/jblog";
			conn = DriverManager.getConnection(url, "jblog", "jblog");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패" + e);
		}
		return conn;
	}
}
