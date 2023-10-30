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



@WebServlet("/ShowBookDetailServlet1")
public class ShowBookDetailServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ShowBookDetailServlet1() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
		 String a=request.getParameter("num");
		 HttpSession session=request.getSession();
		 session.setAttribute("bookid", a);
//		 InputStream is=Resources.getResourceAsStream("mybatis-config.xml");
//		 SqlSessionFactory fac=new SqlSessionFactoryBuilder().build(is);
//		 SqlSession sqlSession=null;
//		
//		
//		 try {
//		 sqlSession=fac.openSession();
//		 BookMapper brandMapper= sqlSession.getMapper(BookMapper.class);
//		 BookBean bookBean = brandMapper.selectById(a);
//		 request.setAttribute("bookd",bookBean);
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
	     BookBean bookBean = s.selectById(a);
	     request.setAttribute("bookd",bookBean);
		 request.getRequestDispatcher("detail.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
