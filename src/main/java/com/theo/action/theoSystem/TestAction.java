package com.theo.action.theoSystem;

import java.io.Serializable;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.theo.action.common.BaseAction;
import com.theo.service.TestLoginI;
import com.theo.service.impl.TestLoginImpl;

@Namespace("/theoSystem")
@Action(value="testAction",results={
		@Result(name="testLogin",location="/webpage/login/testSubmit.jsp")})
public class TestAction extends BaseAction implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5733922529741089996L;

	@Resource
	private TestLoginI testLoginMethod;
	
	public TestLoginI getTestLoginMethod() {
		return testLoginMethod;
	}

	public void setTestLoginMethod(TestLoginI testLoginMethod) {
		this.testLoginMethod = testLoginMethod;
	}

	//获得登录人的姓名和密码
	private String username;
	private String password;

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String testOutput(){
		System.out.println(testLoginMethod.getUserEmail(username, password));
		return "testLogin";
	}
}
