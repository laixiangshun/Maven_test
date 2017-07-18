package com.lai.storm.util;

import com.lai.storm.entity.Appointment;
import com.lai.storm.enums.AppointStateEnum;

public class AppointExecution {

	private long bookId;
	private int state;
	private String stateInfo;
	private Appointment appointment;
	public AppointExecution(){}
	
	public AppointExecution(long bookid,AppointStateEnum stateEnum){
		this.bookId=bookid;
		this.state=stateEnum.getState();
		this.stateInfo=stateEnum.getStateInfo();
	}
	public AppointExecution(long bookid,AppointStateEnum stateEnum,Appointment appointment){
		this.bookId=bookid;
		this.state=stateEnum.getState();
		this.stateInfo=stateEnum.getStateInfo();
		this.appointment=appointment;
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	@Override
	public String toString() {
		return "AppointExecution [bookId=" + bookId + ", state=" + state
				+ ", stateInfo=" + stateInfo + ", appointment=" + appointment
				+ "]";
	}
	
}
