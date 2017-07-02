package com.atos.zad2;
import java.util.Arrays;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "employees") public final class Users {
	@JacksonXmlElementWrapper(localName = "User", useWrapping = false)
	private User[] user;

	public Users(){
	}

	public Users(User[] user){
		this.user = user;
	}

	public User[] getUser(){
		return user;
	}

	public void setUser(User[] user){
		this.user = user;
	}
	@Override public String toString(){
		return "Users{" +
				"users=" + Arrays.toString(user) +
				"}";
	}


}
