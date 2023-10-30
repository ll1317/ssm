package com.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.apache.ibatis.io.Resources;
import com.pojo.BookBean;
import com.config.SpringConfig;
import com.mapper.BookMapper;

@WebServlet("/ShowBookServlet1")
public class ShowBookServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ShowBookServlet1() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
       HttpSession session=request.getSession();
//		InputStream is=Resources.getResourceAsStream("mybatis-config.xml");
//		SqlSessionFactory fac=new SqlSessionFactoryBuilder().build(is);
//		SqlSession sqlSession=null;
       
        ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringConfig.class);
        BookMapper s= (BookMapper) ctx.getBean("BookMapper");
//        ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
//        BookMapper m= (BookMapper) ac.getBean("BookMapper");
//		try {
//			 sqlSession=fac.openSession();
//			 BookMapper brandMapper=sqlSession.getMapper(BookMapper.class);
			
			 List<BookBean> bookBean = s.selectAll();
//        List<BookBean> bookBean= m.selectAll();
			 
			 session.setAttribute("boo",bookBean);
			
//			 sqlSession.commit();
//			 }
//			 catch (Exception e) {
//				e.printStackTrace();
//			}
//			 finally {
////				sqlSession.close();
////				is.close();
//			}
		request.getRequestDispatcher("book.jsp").forward(request, response);
		doGet(request, response);
	}

}
