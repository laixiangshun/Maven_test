package com.lai.storm.service;

import java.util.List;

import com.lai.storm.entity.Book;
import com.lai.storm.util.AppointExecution;

public interface BookService {

	/**
     * ��ѯһ��ͼ��
     * 
     * @param bookId
     * @return
     */
    Book getById(long bookId);
 
    /**
     * ��ѯ����ͼ��
     * 
     * @return
     */
    List<Book> getList();
 
    /**
     * ԤԼͼ��
     * 
     * @param bookId
     * @param studentId
     * @return
     */
    AppointExecution appoint(long bookid,long studentid);
}
