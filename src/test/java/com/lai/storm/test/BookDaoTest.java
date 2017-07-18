package com.lai.storm.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lai.storm.dao.BookDao;
import com.lai.storm.entity.Book;

public class BookDaoTest extends BaseTest{

	@Autowired
	private BookDao bookDao;
	
	@Test
	public void testQueryById() throws Exception{
		long bookid=1;
		Book book=bookDao.queryById(bookid);
		System.out.println(book);
	}
	@Test
	public void testQueryAll() throws Exception{
		List<Book> books=bookDao.queryAll(0, 4);
		for (Book book : books) {
			System.out.println(book);
		}
	}
	@Test
	public void testReduceNumber() throws Exception{
		long bookid=2;
		int update=bookDao.reduceNumber(bookid);
		System.out.println("update="+update);
	}
}
