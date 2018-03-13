package com.cafe24.jblog.dao.test;

import java.util.List;

import com.cafe24.jblog.dao.BlogDao;
import com.cafe24.jblog.vo.BlogVo;
import com.cafe24.jblog.vo.UserVo;

public class BlogDaoTest {

	public static void main(String[] args) {
		// insert("dooly"); // 회원 아이디 입력
		// insert("mycall");
		getListTest("dooly");
	}

	public static void getListTest(String id) {
		BlogDao dao = new BlogDao();
		List<BlogVo> list = dao.getList(id);
		for (BlogVo vo : list) {
			System.out.println(vo);
		}

	}

	public static void insert(String id) {
		BlogDao dao = new BlogDao();
		UserVo vo = new UserVo();
		vo.setId(id);
		dao.insert(vo);
	}

}
