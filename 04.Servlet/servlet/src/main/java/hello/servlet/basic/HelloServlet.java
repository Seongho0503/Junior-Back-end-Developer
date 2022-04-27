package hello.servlet.basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.ClassPathResource;


@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hello");
		System.out.println("request"+ request);
		System.out.println("response"+ response);
		
		String username = request.getParameter("username");
		System.out.println("username = " +username);
		
		// 단순 문자로 보내기
		response.setContentType("text/plain"); // ContentType 헤더 정보에 들어감
		response.setCharacterEncoding("utf-8"); // ContentType 헤더 정보에 들어감
		
//		response.setContentType("text/html; charset=utf-8");  
		// 이건 왜 안되지??
		
		// response.getWriter() : http 메세지 body에 들어감
		response.getWriter().write("hello " + username);
		
		
	}
}
