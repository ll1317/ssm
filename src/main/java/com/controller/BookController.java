package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.sql.repository.SchemaRepository.MySqlConsoleSchemaVisitor;
import com.config.SpringConfig;
import com.mapper.BookMapper;
import com.pojo.BookBean;

@Controller
public class BookController {
	  
	   
	   @RequestMapping("/ShowBookServlet")
	   public ModelAndView ShowBook(HttpServletRequest request,HttpServletResponse response) {
		   ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringConfig.class);
	       BookMapper s= (BookMapper) ctx.getBean("BookMapper");
	       List<BookBean> bookBean = s.selectAll();
	       HttpSession session=request.getSession();
	       session.setAttribute("boo",bookBean);
	       ModelAndView mav=new ModelAndView();
	       mav.setViewName("book.jsp");
	       return mav;
	   }
	 
	   @RequestMapping("/UpdateBookServlet")
	   public ModelAndView UpdateBook(HttpServletRequest request,HttpServletResponse response,
			   @RequestParam("num") int a,@RequestParam("price") double b) {
		   HttpSession session=request.getSession();
			String bookid= (String) session.getAttribute("bookid");
			BookBean bookBean=new BookBean();
			bookBean.setBookId(bookid);
			bookBean.setPrice(b);
			bookBean.setNum(a);
			ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringConfig.class);
		    BookMapper s= (BookMapper) ctx.getBean("BookMapper");
		    s.update(bookBean);
		    ModelAndView mav=new ModelAndView();
		    mav.setViewName("book.jsp");
		    return mav;
	   }
	   
}
