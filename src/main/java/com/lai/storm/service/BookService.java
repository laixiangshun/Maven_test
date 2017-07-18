package com.lai.storm.service;

import java.util.List;

import com.lai.storm.entity.Book;
import com.lai.storm.util.AppointExecution;

public interface BookService {

	/**
     * 查询一本图书
     * 
     * @param bookId
     * @return
     */
    Book getById(long bookId);
 
    /**
     * 查询所有图书
     * 
     * @return
     */
    List<Book> getList();
 
    /**
     * 预约图书
     * 
     * @param bookId
     * @param studentId
     * @return
     */
    AppointExecution appoint(long bookid,long studentid);
}
