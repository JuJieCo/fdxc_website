package com.jinyu.fdxc.model.utils;

import java.util.Map;

import com.jinyu.fdxc.struts.action.IndexAction;
import com.jinyu.fdxc.struts.action.IndexRkjsAction;
import com.jinyu.fdxc.struts.action.IndexWtlyAction;
import com.jinyu.fdxc.struts.action.IndexYlwsAction;
import com.jinyu.fdxc.struts.action.LoginAction;
//import com.jujie.oasm.struts.action.user.SysUserAction;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@SuppressWarnings("serial")
public class AuthorityInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		
		ActionContext ctx = actionInvocation.getInvocationContext();
		Map<String,Object> session = ctx.getSession();
		
		Action action = (Action) actionInvocation.getAction(); 
		//属于LoginAction的实例
		if (action instanceof LoginAction) {  
			 return actionInvocation.invoke();  
		 }
		 //登录用户session存在
		if(session.get("sessionLoginUser")!=null){
			return actionInvocation.invoke();
		}
		//属于index的实例IndexAction
		if(action instanceof IndexAction){
			return actionInvocation.invoke();
		}
		if(action instanceof IndexRkjsAction){
			return actionInvocation.invoke();
		}
		if(action instanceof IndexYlwsAction){
			return actionInvocation.invoke();
		}
		if(action instanceof IndexWtlyAction){
			return actionInvocation.invoke();
		}else{
			ctx.put("mesg", "登录时间以超时，请重新登录！");
			return Action.LOGIN;
		}

	} 

}
