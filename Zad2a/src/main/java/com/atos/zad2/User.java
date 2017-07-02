package com.atos.zad2;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class User {
	@JacksonXmlProperty(localName ="Login", isAttribute = true)
	private String login;
	@JacksonXmlProperty(localName = "Password")
	private String password;

	public User(){
	}

	public User(String login, String password){
		this.login = login;
		this.password = password;
	}

	public String getLogin(){
		return login;
	}


	public String getPassword(){
		return password;
	}



	public void setPassword(String password){
		this.password = password;
	}
	@Override public String toString(){
		return "User{"+
				"login=" +login + " / " +
				"password=" +
				"}";
	}

}
