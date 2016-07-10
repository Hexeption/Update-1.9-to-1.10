package me.hexeption.Cryton.events;

import com.darkmagician6.eventapi.events.Event;

public class EventKeyBoard implements Event{
	
	public int key;
	
	public EventKeyBoard(final int key) {
		this.key = key;
	}
	
	public int getKey(){
		return key;
	}

}
