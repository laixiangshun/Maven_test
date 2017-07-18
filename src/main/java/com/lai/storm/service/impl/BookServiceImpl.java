package com.lai.storm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lai.storm.dao.AppointmentDao;
import com.lai.storm.dao.BookDao;
import com.lai.storm.entity.Appointment;
import com.lai.storm.entity.Book;
import com.lai.storm.enums.AppointStateEnum;
import com.lai.storm.service.BookService;
import com.lai.storm.util.AppointExecution;

@Service("BookServiceImpl")
public class BookServiceImpl implements BookService{

	private Logger logger=LoggerFactory.getLogger(this.getClass());
	@Autowired
	private BookDao bookDao;
	@Autowired
	private AppointmentDao appointmentDao;
	@Override
	public Book getById(long bookId) {
		try {
			Book book=this.bookDao.queryById(bookId);
			if(book!=null)
				return book;
			else return null;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
		
	}

	@Override
	public List<Book> getList() {
		try {
			List<Book> books=this.bookDao.queryAll(0, 4);
			if(books!=null && books.size()>0)
				return books;
			else
				return null;
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		return null;
	}

	@Override
	@Transactional
	public AppointExecution appoint(long bookid, long studentid) {
		try {
			int update=bookDao.reduceNumber(bookid);
			if(update<=0){
				return new AppointExecution(bookid,AppointStateEnum.NO_NUMBER);
			}else{
				int insert=appointmentDao.insertAppointment(bookid, studentid);
				if(insert<=0){
					return new AppointExecution(bookid,AppointStateEnum.REPEAT_APPOINT);
				}
				else{
					Appointment appointment=appointmentDao.queryByKey(bookid, studentid);
					return new AppointExecution(bookid,AppointStateEnum.SUCCESS,appointment);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage(),e);
			return new AppointExecution(bookid,AppointStateEnum.INSERT_ERROR);
		}
	}

}
