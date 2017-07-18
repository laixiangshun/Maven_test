package com.lai.storm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lai.storm.entity.Book;

public interface BookDao {

	Book queryById(long id);
	
	List<Book> queryAll(@Param("offset") int offset,@Param("limit") int limit);
	
	int reduceNumber(long bookid);
}
