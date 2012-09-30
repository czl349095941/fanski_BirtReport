package com.edwin.login.action;

import com.edwin.login.module.Person;
import com.opensymphony.xwork2.ActionSupport;

public class PersonAction extends ActionSupport {

	private Person p;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub

		p = new Person();
		return SUCCESS;
	}

}
