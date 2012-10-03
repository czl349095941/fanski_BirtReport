/**
 * 
 */
package com.edwin.interceptors;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * @author edwin
 *
 */
public class LoginInterceptor implements Interceptor {
	
	private String passWord;
	
	public void setPassWord(String passWord) {
		
		this.passWord=passWord;
		
		
	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.interceptor.Interceptor#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.interceptor.Interceptor#init()
	 */
	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.interceptor.Interceptor#intercept(com.opensymphony.xwork2.ActionInvocation)
	 */
	@Override
	public String intercept(ActionInvocation pArg0) throws Exception {
		// TODO Auto-generated method stub
		
		
		HashMap map;
		
		
		System.out.println("before.....\n"+this.passWord);
		
		map=(HashMap)pArg0.getInvocationContext().getParameters();
		
		//System.out.println("actioncontext:"+map.toString());
		
		String result=pArg0.invoke();
		
		System.out.println("after.....\n"+this.passWord+"\n");
		
		
		return result;
		
		
		
	}

}
