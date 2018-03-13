package com.cafe24.jblog.dao.test;

import java.util.List;

import com.cafe24.jblog.dao.PostDao;
import com.cafe24.jblog.vo.PostVo;

public class PostDaoTest {

	public static void main(String[] args) {

		// insert("포르투칼 사진", "포르투가 참 좋았다, 리스본은 아쉽다", 1L, 1L);
		// insert("이탈리아 사진", "로마에는 유적지가 참 많다", 1L, 1L);
		// insert("아스날에 관하여", "아스날은 과연 언제 우승할까? 리버풀보다 밑이다.", 1L, 2L);
		// insert("챔스에 관하여", "이번 챔스 우승은 레알 마드리드가!", 1L, 2L);
		// insert("MySQL", "DB모델링 어렵다", 1L, 3L);
		// insert("Servlet/JSP", "열심히 해보자", 1L, 3L);
		getListTest(3L);
	}

	public static void getListTest(Long categoryNo) {
		PostDao dao = new PostDao();
		List<PostVo> list = dao.getList(categoryNo);
		for (PostVo vo : list) {
			System.out.println(vo);
		}
	}

	public static void insert(String title, String content, Long blogNo, Long categoryNo) {
		PostDao dao = new PostDao();
		PostVo vo = new PostVo();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setBlogNo(blogNo);
		vo.setCategoryNo(categoryNo);

		dao.insert(vo);
	}

}
