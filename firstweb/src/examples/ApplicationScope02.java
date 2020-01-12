package examples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ApplicationScope02")
public class ApplicationScope02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		
		ServletContext application = getServletContext();
		PrintWriter writer = response.getWriter();
		try {
			int value = (int)application.getAttribute("value");
			application.setAttribute("value", ++value);

			
			writer.print("<h1> value : " + value + "</h1>");
		} catch (NullPointerException e) {
			writer.print("value 값이 설정되지 않았습니다.");
		}
		
	}

}
