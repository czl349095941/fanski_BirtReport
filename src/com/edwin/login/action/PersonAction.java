package com.edwin.login.action;

import com.edwin.login.module.Person;
import com.opensymphony.xwork2.ActionSupport;

public class PersonAction extends ActionSupport {

	private Person Person = new Person();

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub

		// p = new Person();
		// System.out.println(p.toString());
		return SUCCESS;
	}

	public Person getPerson() {
		return Person;
	}

	public void setPerson(Person pPerson) {
		Person = pPerson;
	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub
		// super.validate();

		if (Person.getUserName().equals("")
				|| Person.getUserName().equals("用户名错误")) {

			addFieldError("用户编号：", "用户编号不可空白");
		}

	}

}
