	package com.edwin.BirtFilter;
	
	import java.io.IOException;
	import java.util.HashMap;
	import java.util.Map;
	import java.util.Set;
	import javax.servlet.Filter;
	import javax.servlet.FilterChain;
	import javax.servlet.FilterConfig;
	import javax.servlet.RequestDispatcher;
	import javax.servlet.ServletContext;
	import javax.servlet.ServletException;
	import javax.servlet.ServletRequest;
	import javax.servlet.ServletResponse;
	import javax.servlet.http.HttpServletRequest;
	
	public class BirtFilter implements Filter {
		// 用来封装birt相关功能的uri和所对应的Servlet名键值对
		Map<String, String> map = new HashMap<String, String>();
		ServletContext context;
		// debug开关
		static boolean debug = false;
	
		public void destroy() {
			map = null;
		}
	
		/**
		 * 过滤birt请求，转发到对应的servlet，以绕过其他的过滤器，struts2
		 * 
		 */
		public void doFilter(ServletRequest request, ServletResponse response,
				FilterChain chain) throws IOException, ServletException {
			HttpServletRequest req = (HttpServletRequest) request;
			String uri = req.getRequestURI();
			if (debug) {
				System.out.println(">>>Requesting " + uri + "?"
						+ req.getQueryString());
			}
			Set<String> keys = map.keySet();
			for (String key : keys) {
				if (uri.contains(key)) {
					RequestDispatcher rd = this.context.getNamedDispatcher(map
							.get(key));
					if (rd != null) {
						if (debug) {
							System.out.println(">>>Redirect successfully executed");
						}
						// 跳过其他的过滤器
						rd.forward(request, response);
					} else {
						if (debug) {
							System.out
									.println(">>>Redirect unsuccessfully executed");
						}
					}
					return;
				}
			}
			chain.doFilter(request, response);
		}
	
		public void init(FilterConfig filterConfig) throws ServletException {
			this.context = filterConfig.getServletContext();
			map.put("frameset", "ViewerServlet");
			map.put("preview", "EngineServlet");
		}
	}