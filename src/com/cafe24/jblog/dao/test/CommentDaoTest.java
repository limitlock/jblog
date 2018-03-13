package com.cafe24.jblog.dao.test;

import java.util.List;

import com.cafe24.jblog.dao.CommentDao;
import com.cafe24.jblog.vo.CommentVo;

public class CommentDaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		insert(1L, "mycall", "퍼가겠습니다~");
//		insert(1L, "limit", "잘봤습니다.");
//
//		insert(3L, "rolypoly", "아스날은 우승못함");
//		insert(3L, "word", "할수 있음");
		
		getListTest(3L);
	}

	public static void getListTest(Long postNo) {
		CommentDao dao = new CommentDao();
		List<CommentVo> list = dao.getList(postNo);
		for (CommentVo vo : list) {
			System.out.println(vo);
		}

	}

	public static void insert(Long postNo, String id, String content) {
		CommentDao dao = new CommentDao();
		CommentVo vo = new CommentVo();
		vo.setPostNo(postNo);
		vo.setId(id);
		vo.setContent(content);

		dao.insert(vo);
	}

}
