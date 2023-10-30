package com.controller;

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
import org.springframework.web.servlet.ModelAndView;

import com.config.SpringConfig;
import com.mapper.BookMapper;
import com.pojo.BookBean;
@Controller
public class BookCarController {
	 @RequestMapping("/ShoppingServlet")
     public void Shopping(HttpServletRequest request,HttpServletResponse response,
		   @RequestParam("num") String bookid) throws Exception{
 		   BookBean bookBean=new BookBean();
 		   HttpSession session=request.getSession();
 		   bookBean.setBookId(bookid);
 		   bookBean.setShoppingId(bookid);
 		   bookBean.setNumber(0);
 		   ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringConfig.class);
 		   BookMapper s= (BookMapper) ctx.getBean("BookMapper");
	       s.add(bookBean);
	       List<BookBean> bookBeans =s.selectShoppingCar();
	       session.setAttribute("booshopping",bookBeans);
	      // ModelAndView modelAndView=new ModelAndView();
		  PrintWriter out=response.getWriter();
		   out.print("<a href='book.jsp'>返回继续添加</a>");
        }
	   
	 
	   @RequestMapping("/ShowBookDetailServlet")
	   public ModelAndView ShowBookDetail(HttpServletRequest request,HttpServletResponse response,
			   @RequestParam("num") String a) {
		   HttpSession session=request.getSession();
		   session.setAttribute("bookid", a);
		   ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringConfig.class);
		    BookMapper s= (BookMapper) ctx.getBean("BookMapper");
		    BookBean bookBean = s.selectById(a);
		     request.setAttribute("bookd",bookBean);
		     ModelAndView mav=new ModelAndView();
		     mav.setViewName("detail.jsp");	
		     return mav;
	   }
	 
}
