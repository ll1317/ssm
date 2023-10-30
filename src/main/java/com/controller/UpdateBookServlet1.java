package com.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.config.SpringConfig;
import com.mapper.BookMapper;
import com.pojo.BookBean;


@WebServlet("/UpdateBookServlet1")
public class UpdateBookServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public UpdateBookServlet1() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
		HttpSession session=request.getSession();
		String bookid= (String) session.getAttribute("bookid");
		String a=request.getParameter("num");
		String b=request.getParameter("price");
		Integer m=Integer.parseInt(a);
		Double n=Double.parseDouble(b);
		BookBean bookBean=new BookBean();
		bookBean.setBookId(bookid);
		bookBean.setPrice(n);
		bookBean.setNum(m);
		
//		InputStream is=Resources.getResourceAsStream("mybatis-config.xml");
//		SqlSessionFactory fac=new SqlSessionFactoryBuilder().build(is);
//		SqlSession sqlSession=null;
//
//		 try {
//		 sqlSession=fac.openSession();
//		 BookMapper brandMapper= sqlSession.getMapper(BookMapper.class);
//		 int x=brandMapper.update(bookBean);
//		
//		 sqlSession.commit();
//		 }
//		 catch (Exception e) {
//			e.printStackTrace();
//		}
//		 finally {
//			sqlSession.close();
//		}
		 ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringConfig.class);
	     BookMapper s= (BookMapper) ctx.getBean("BookMapper");
	     s.update(bookBean);
		
		 doGet(request, response);
		 request.getRequestDispatcher("book.jsp").forward(request, response);
	}
		
	

}
