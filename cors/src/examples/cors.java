package examples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class cors extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String HTML_CODE = "<html><head></head><body>CORS TEST</body></html>";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		System.out.println("GET");
		response.setContentType("text/html");
		response.setHeader("Access-Control-Allow-Origin", "*");
		PrintWriter writer = response.getWriter();

		writer.print(HTML_CODE);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		System.out.println("POST");
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Origin", "*");

		PrintWriter writer = response.getWriter();

		writer.print("{ \r\n" +
			"\"apple\":1000\r\n" +
			"}");
	}

	@Override
	protected void doOptions(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		System.out.println("OPTIONS");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type");
	}

}
