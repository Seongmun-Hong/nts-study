package examples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/next")
public class NextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter writer = response.getWriter();

		writer.println("<html>");
		writer.println("<head><title>form</title></head>");
		writer.println("<body>");

		int dice = (Integer)request.getAttribute("dice");
		writer.println("dice : " + dice);
		for (int i = 0; i < dice; i++) {
			writer.print("<br/>hello");
		}

		writer.println("</body>");
		writer.println("</html>");

	}

}
