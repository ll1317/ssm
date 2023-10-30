package com.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

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
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.config.SpringConfig;
import com.mapper.BookMapper;
import com.pojo.BookBean;

@WebServlet("/ShoppingServlet1")
public class ShoppingServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ShoppingServlet1() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
		String bookid=request.getParameter("num");
		HttpSession session=request.getSession();
		BookBean bookBean=new BookBean();
		bookBean.setBookId(bookid);
		bookBean.setShoppingId(bookid);
		bookBean.setNumber(0);
//		InputStream is=Resources.getResourceAsStream("mybatis-config.xml");
//		SqlSessionFactory fac=new SqlSessionFactoryBuilder().build(is);
//		SqlSession sqlSession=null;
//
//		 try {
//		 sqlSession=fac.openSession();
//		 BookMapper brandMapper= sqlSession.getMapper(BookMapper.class);
//		 brandMapper.add(bookBean);
//		 List<BookBean> bookBeans =brandMapper.selectShoppingCar();
//		 session.setAttribute("booshopping", bookBeans);
//		 sqlSession.commit();
//		 }
//		 catch (Exception e) {
//			e.printStackTrace();
//		
//		}
//		 finally {
//			sqlSession.close();
//		}
		ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringConfig.class);
	    BookMapper s= (BookMapper) ctx.getBean("BookMapper");
	    s.add(bookBean);
	    List<BookBean> bookBeans =s.selectShoppingCar();
	    session.setAttribute("booshopping",bookBeans);
	    
		 PrintWriter out=response.getWriter();
		 out.print("<a href='book.jsp'>返回继续添加</a>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
