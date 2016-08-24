package com.aaa.util;

import java.util.List;
import java.util.Map;

import com.aaa.action.UserAction;
import com.aaa.model.Guashi;
import com.aaa.service.IUserService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 用于验证即将登录的用户是否已经被挂失的类
 */
public class GuashiInterceptor extends AbstractInterceptor{
	private IUserService userService;

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	/**
	 * 用于验证即将登录的用户是否已经被挂失的方法
	 */
	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		UserAction userAction = (com.aaa.action.UserAction) arg0.getAction();
		//获得页面即将登录的登录者的username
		String userName = userAction.getUser().getUsername();
		List<Guashi> guashiList = userService.getGuashi(); 
		for(int i =0; i< guashiList.size(); i++) {
			if(((Guashi)guashiList.get(i)).getUser().getUsername().equals(userName)) {
System.out.println("username=" + ((Guashi)guashiList.get(i)).getUser().getUsername());
				Map request = (Map) ActionContext.getContext().get("request");
				request.put("message", "对不起，您的账号已挂失。");
				return Action.ERROR;
			}
		}
		//顺着拦截器下面的action继续执行的命令
		return arg0.invoke();
	}

}
