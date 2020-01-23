package com.naver.aboutme;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/aboutme/today")
public class TodayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter writer = response.getWriter();

		writer.print(getTodayPageHtmlCode());
	}

	private String getTodayPageHtmlCode() {
		StringBuilder htmlBuilder = new StringBuilder();

		htmlBuilder.append("<head><title>현재시간</title>");
		htmlBuilder.append("<link rel=\"stylesheet\" href=\"/css/today.css\"></head>");
		htmlBuilder.append("<body class=\"today_page\">");
		htmlBuilder.append("<a class=\"main_link\" href=\"/index.html\">메인화면</a>");
		htmlBuilder.append("<section class=\"time_wrap\">");
		htmlBuilder.append("<span class=\"time\">");
		htmlBuilder.append("현재시간 : " + getFormattedCurrentTime());
		htmlBuilder.append("</span></section>");

		return htmlBuilder.toString();
	}

	private String getFormattedCurrentTime() {
		return LocalDateTime.now().format(formatter);
	}

}
