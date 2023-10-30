package com.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.pojo.BookBean;
@Component("BookMapper")
public interface BookMapper {
	BookBean selectById(String id);
	List<BookBean> selectAll();
	int update(BookBean bookBean);
	void add(BookBean bookBean);
	List<BookBean> selectShoppingCar();
}
