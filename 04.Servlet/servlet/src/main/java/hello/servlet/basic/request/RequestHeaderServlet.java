package hello.servlet.basic.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("--- REQUEST-LINE - start ---");
		 System.out.println("request.getMethod() = " + request.getMethod()); //GET
		 System.out.println("request.getProtocal() = " + request.getProtocol()); //HTTP/1.1
		 System.out.println("request.getScheme() = " + request.getScheme()); //http
		 // http://localhost:8080/request-header
		 System.out.println("request.getRequestURL() = " + request.getRequestURL());
		 // /request-test
		 System.out.println("request.getRequestURI() = " + request.getRequestURI());
		 //username=hi
		 System.out.println("request.getQueryString() = " +
		request.getQueryString());
		 System.out.println("request.isSecure() = " + request.isSecure()); //https ��� ����
		 System.out.println("--- REQUEST-LINE - end ---");
		 System.out.println();
		
	}
}