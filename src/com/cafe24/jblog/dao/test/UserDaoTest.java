package com.cafe24.jblog.dao.test;

import java.util.List;

import com.cafe24.jblog.dao.UserDao;
import com.cafe24.jblog.vo.UserVo;

public class UserDaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		insert("둘리", "dooly", "1234");
		insert("마이콜", "mycall", "9876");
		getListTest();
	}

	public static void getListTest() {
		UserDao dao = new UserDao();
		List<UserVo> list = dao.getList();
		for (UserVo vo : list) {
			System.out.println(vo);
		}

	}

	public static void insert(String name, String id, String password) {
		UserDao dao = new UserDao();
		UserVo vo = new UserVo();
		vo.setName(name);
		vo.setId(id);
		vo.setPassword(password);
		dao.insert(vo);
	}

}
