package com.cafe24.jblog.dao.test;

import java.util.List;

import com.cafe24.jblog.dao.CategoryDao;
import com.cafe24.jblog.vo.CategoryVo;

public class CategoryDaoTest {

	public static void main(String[] args) {

		// insert("사진", "맛집과 일상생활", 2L, false);
		// insert("축구", "축구 칼럼 및 관광", 2L, false);
		// insert("프로그래밍", "JAVA/MySQL", 2L, false);
		getListTest();
	}

	public static void getListTest() {
		CategoryDao dao = new CategoryDao();
		List<CategoryVo> list = dao.getList();
		for (CategoryVo vo : list) {
			System.out.println(vo);
		}

	}

	// insert into category values(null, '사진', '맛집, 일상생활 풍경 사진', 2, false);
	public static void insert(String name, String content, Long amount, boolean isDelete) {
		CategoryDao dao = new CategoryDao();
		CategoryVo vo = new CategoryVo();
		vo.setName(name);
		vo.setContent(content);
		vo.setAmount(amount);
		vo.setDelete(isDelete);
		dao.insert(vo);
	}

}
