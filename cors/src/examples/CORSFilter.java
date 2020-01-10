package examples;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class CORSFilter
 */
@WebFilter(dispatcherTypes = {
	DispatcherType.REQUEST,
	DispatcherType.FORWARD,
	DispatcherType.INCLUDE,
	DispatcherType.ERROR
}, urlPatterns = {"/"})
public class CORSFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
		throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest)request; // class casting
		HttpServletResponse httpResponse = (HttpServletResponse)response; // class casting

		//		httpResponse.setHeader("Access-Control-Allow-Origin", "*");
		//		httpResponse.setHeader("Access-Control-Allow-Headers", "*");
		//		System.out.println("filter before");
		chain.doFilter(request, response);
		//		System.out.println("filter after");
	}

	@Override
	public void destroy() {
		//		System.out.println("filter destroy");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//		System.out.println("filter init");
	}

}
