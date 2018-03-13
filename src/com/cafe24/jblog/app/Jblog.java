package com.cafe24.jblog.app;

import com.cafe24.jblog.dao.test.BlogDaoTest;
import com.cafe24.jblog.dao.test.CategoryDaoTest;
import com.cafe24.jblog.dao.test.CommentDaoTest;
import com.cafe24.jblog.dao.test.PostDaoTest;
import com.cafe24.jblog.dao.test.UserDaoTest;

public class Jblog {

	public static void main(String[] args) {

		// 회원 생성 및 확인
		// UserDaoTest.main(args);
		System.out.println("================[1.회원 리스트 – 1명]=================");
		UserDaoTest.insert("둘리", "dooly", "1234");
		// UserDaoTest.insert("마이콜", "mycall", "9876");

		UserDaoTest.getListTest();
		System.out.println();

		// 블로그 생성 및 확인
		System.out.println("================[2. blog 리스트 – 1개]==============");
		BlogDaoTest.insert("dooly");
		// BlogDaoTest.insert("mycall");

		BlogDaoTest.getListTest("dooly"); // 회원 아이디 입력 (dooly or mycall)
		System.out.println();

		// 카테고리 생성 및 확인
		System.out.println("================[3. category – 3개]==============");
		CategoryDaoTest.insert("사진", "맛집과 일상생활", 2L, false);
		CategoryDaoTest.insert("축구", "축구 칼럼 및 관광", 2L, false);
		CategoryDaoTest.insert("프로그래밍", "JAVA/MySQL", 2L, false);

		CategoryDaoTest.getListTest();
		System.out.println();

		// 포스트 생성 및 확인
		System.out.println("================[4. post – 2개 (하나 카테고리)]=======");
		PostDaoTest.insert("포르투칼 사진", "포르투가 참 좋았다, 리스본은 아쉽다", 1L, 1L);
		PostDaoTest.insert("이탈리아 사진", "로마에는 유적지가 참 많다", 1L, 1L);
		PostDaoTest.insert("아스날에 관하여", "아스날은 과연 언제 우승할까? 리버풀보다 밑이다.", 1L, 2L);
		PostDaoTest.insert("챔스에 관하여", "이번 챔스 우승은 레알 마드리드가!", 1L, 2L);
		PostDaoTest.insert("MySQL", "DB모델링 어렵다", 1L, 3L);
		PostDaoTest.insert("Servlet/JSP", "열심히 해보자", 1L, 3L);

		PostDaoTest.getListTest(2L); // 카테고리 번호 입력 (1.사진, 2.축구, 3.프로그래밍)
		System.out.println();

		// 포스트 생성 및 확인
		System.out.println("================[5. comment – 2개( 2개 포스트 모두)]==");
		CommentDaoTest.insert(1L, "mycall", "퍼가겠습니다~");
		CommentDaoTest.insert(1L, "limit", "잘봤습니다.");
		CommentDaoTest.insert(3L, "rolypoly", "아스날은 우승못함");
		CommentDaoTest.insert(3L, "word", "할수 있음");

		CommentDaoTest.getListTest(3L); // 3번 포스트에 관한 코멘트 출력

	}

}
