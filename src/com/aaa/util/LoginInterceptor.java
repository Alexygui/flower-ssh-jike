package com.aaa.util;

import java.util.Map;

import com.aaa.model.User;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		Map session = arg0.getInvocationContext().getSession();
		User user = (User) session.get("user");
		if(user == null) {
			return Action.LOGIN;
		}
		return arg0.invoke();
	}
}
