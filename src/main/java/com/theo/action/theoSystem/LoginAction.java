package com.theo.action.theoSystem;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ModelDriven;
import com.theo.action.common.BaseAction;
import com.theo.annotation.LogAnnotation;
import com.theo.constant.Constant;
import com.theo.model.system.TSUser;
import com.theo.service.SystemServiceI;
import com.theo.vo.common.Json;
import com.theo.vo.common.SessionInfo;
import com.theo.vo.system.PageUser;

@Namespace("/theoSystem")
@Action(value="loginAction",results={
		@Result(name="main",location="/webpage/login/main.jsp"),
		@Result(name="left",location="/webpage/login/left.jsp"),
		@Result(name="login",location="/webpage/login/login.jsp")})
public class LoginAction extends BaseAction implements ModelDriven<PageUser>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5056447183252957186L;
	
	private static final Logger logger = Logger.getLogger(LoginAction.class);
	
	@Resource
	private SystemServiceI systemService;

	public SystemServiceI getSystemService() {
		return systemService;
	}

	public void setSystemService(SystemServiceI systemService) {
		this.systemService = systemService;
	}
	
	private PageUser pageUser=new PageUser();	
	
	@Override
	public PageUser getModel() {
		// TODO Auto-generated method stub
		return pageUser;
	}
	
	//用户登录
	public String login(){
		TSUser user = this.getSessionUserName();
		if (user != null) {
			getRequest().setAttribute("userName", user.getRealname());
			return "main";
		} else {
			return "login";
		}
	}
	
	//用户验证
	@LogAnnotation(event="用户登录",tablename="t_s_user")
	public void checkuser(){
		Json j = new Json();
		TSUser u = systemService.checkUserExits(pageUser);
		if (u != null) {
			SessionInfo sessionInfo = new SessionInfo();
			sessionInfo.setUser(u);
			getSession().setMaxInactiveInterval(60 * 40);
			getSession().setAttribute(Constant.USER_SESSION, sessionInfo);
			j.setMsg("用户: " + u.getUsername() + "登录成功");
			j.setSuccess(true);
		} else {
			setOperstatus(1);
			j.setMsg("用户名或密码错误!");
			j.setSuccess(false);
		}
		writeJson(j);
	}

}
