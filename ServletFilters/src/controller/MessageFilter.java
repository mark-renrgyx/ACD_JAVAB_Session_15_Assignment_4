package controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class MessageFilter
 */
@WebFilter("/MessageFilter")
public class MessageFilter implements Filter {
	
	/**
	 * Default constructor.
	 */
	public MessageFilter() {
	}
	
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}
	
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// place your code here
		String message = request.getParameter("message");
		
		System.out.println("Original Message: " + message);
		
		message = message.replace("generic", "super-awesome");
		System.out.println("New message: " + message);
		
		request.setAttribute("message", message);
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
		System.out.println("Awesomeness applied.");
	}
	
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}
}
