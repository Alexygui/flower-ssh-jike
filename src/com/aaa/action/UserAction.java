package com.aaa.action;

import java.util.Map;

import org.hibernate.Session;

import com.aaa.model.User;
import com.aaa.model.Userdetail;
import com.aaa.service.IUserService;
import com.aaa.service.impl.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 执行struts.xml中的userAction的类
 */
public class UserAction extends ActionSupport{
	/**
	 * 声明UserService类，由spring注入
	 * 声明User，Userdetail类，表单中提交的数据也交由spring注入
	 * 声明pwd1，pwd2变量，和jsp文件中变量同名，也由spring注入
	 */
	private User user;
	private Userdetail userdetail;
	private IUserService userService;
	
	private String pwd1;
	private String pwd2;
	
	
	
	public String getPwd1() {
		return pwd1;
	}
	public void setPwd1(String pwd1) {
		this.pwd1 = pwd1;
	}
	public String getPwd2() {
		return pwd2;
	}
	public void setPwd2(String pwd2) {
		this.pwd2 = pwd2;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public Userdetail getUserdetail() {
		return userdetail;
	}
	public void setUserdetail(Userdetail userdetail) {
		this.userdetail = userdetail;
	}
	public IUserService getUserService() {
		return userService;
	}
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	/**
	 * 实现添加User和Userdetail的方法
	 */
	public String addUser() {
		Map session = ActionContext.getContext().getSession();
		User user2 = new User();
		Userdetail userdetail2 = new Userdetail();
		user2.setUsername(user.getUsername());
		user2.setPassword(user.getPassword());
		user2.setRole(user.getRole());
		userdetail2.setTruename(userdetail.getTruename());
		userdetail2.setAddress(userdetail.getAddress());
		userdetail2.setCsrq(userdetail.getCsrq());
		userdetail2.setEmail(userdetail.getEmail());
		userdetail2.setPhone(userdetail.getPhone());
		userdetail2.setXb(userdetail.getXb());
		userdetail2.setUser(user2);
		user2.setUserdetail(userdetail2);
		if(userService.addOrUpdateUser(user2)) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	/**
	 * 检查登录的用户是否已经注册过 
	 */
	public String checkUser() {
		Map session = ActionContext.getContext().getSession();
		User user2 = userService.checkUser(user);
		if(user2 != null) {
			//登录用户不为空，是注册用户，返回用户的信息，由jsp页面决定跳转的用户页面类型
			session.put("user", user2);
			return SUCCESS;
		} else {
			//检查登录用户为空，即没有注册过，则根据用户登录的角色返回各自的用户角色，由jsp文件决定跳转的登录页面类型
			session.put("role", user.getRole());
			return ERROR;
		}
	}
	
	/**
	 * 注销用户 
	 */
	public String logOut() {
		Map session = ActionContext.getContext().getSession();
		session.remove("user");
		return SUCCESS;
	}
	
	/**
	 * 更新用户的Userdetail数据
	 */
	public String updateUserDetail() {
		Map session = ActionContext.getContext().getSession();
		//获得session中保存的已登录的User的对象
		User user2 = (User) session.get("user");
		Userdetail userdetail2 = user2.getUserdetail();
		userdetail2.setAddress(userdetail.getAddress());
		userdetail2.setCsrq(userdetail.getCsrq());
		userdetail2.setEmail(userdetail.getEmail());
		userdetail2.setPhone(userdetail.getPhone());
		userdetail2.setTruename(userdetail.getPhone());
		userdetail2.setXb(userdetail.getXb());
		if(userService.addOrUpdateUser(user2)) {
			session.put("user", user2);
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	/**
	 * 修改用户密码
	 */
	public String updateUserPassword() {
		Map session = ActionContext.getContext().getSession();
		User user2 = (User) session.get("user");
		if(user2.getPassword().equals(pwd1)) {
			user2.setPassword(pwd2);
			//更新数据库，将新密码写入数据库
			userService.addOrUpdateUser(user2);
			//将用户从session注销，让用户重新用新密码登录
			session.remove(user2);
			return SUCCESS;
		} else {
			Map request = (Map) ActionContext.getContext().get("request");
			request.put("msg", "旧密码有误");
			return ERROR;
		}
	}
}