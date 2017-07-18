package com.lai.storm.dao;

import org.apache.ibatis.annotations.Param;

import com.lai.storm.entity.Appointment;

public interface AppointmentDao {

	int insertAppointment(@Param("bookid") long bookid,@Param("studentid") long studentid);
	
	Appointment queryByKey(@Param("bookid") long bookid,@Param("studentid") long studentid);
}
