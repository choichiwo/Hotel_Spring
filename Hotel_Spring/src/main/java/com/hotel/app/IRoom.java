package com.hotel.app;

import java.util.ArrayList;

public interface IRoom {
	ArrayList<Roominfo> getRoomList();
	ArrayList<Roomtype> getRoomType();
	void doDeleteRoom(int roomcode);
	void doAddRoom(String roomname,String roomtype,int howmany,int howmuch);
}
