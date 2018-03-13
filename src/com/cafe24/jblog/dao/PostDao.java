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

import com.cafe24.jblog.vo.PostVo;

public class PostDao {

	public List<PostVo> getList(Long categoryNo) {

		List<PostVo> list = new ArrayList<PostVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; // 결과값이 여러개일 경우

		try {
			conn = getConnection();
			String sql = "select b.no, b.title, b.content, a.title, c.name, b.cur_date "
					+ "from blog a, post b, category c " + "where a.no = b.blog_no " + "and b.category_no = c.no "
					+ "and b.category_no = ?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setLong(1, categoryNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				Long no = rs.getLong(1);
				String postTitle = rs.getString(2);
				String content = rs.getString(3);
				String blogTitle = rs.getString(4);
				String category = rs.getString(5);
				String curDate = rs.getString(6);

				PostVo vo = new PostVo();
				vo.setNo(no);
				vo.setTitle(postTitle);
				vo.setContent(content);
				vo.setBlogTitle(blogTitle);
				vo.setCategoryName(category);
				vo.setCurDate(curDate);

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

	public boolean insert(PostVo vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();
			// insert into post values(null, '포르투칼 사진', '포르토가 참 좋았다.', '20130310', 1, 1);
			String sql = "insert into post values(null, ?, ?, ?,?,?)";
			pstmt = conn.prepareStatement(sql);

			// 등록시간
			SimpleDateFormat format = new SimpleDateFormat("YYYY:MM:DD:HH:mm:ss");
			String data = format.format(new Date());

			// 바인딩
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, data);
			pstmt.setLong(4, vo.getBlogNo());
			pstmt.setLong(5, vo.getCategoryNo());
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
