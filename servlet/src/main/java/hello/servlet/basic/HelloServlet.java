package hello.servlet.basic;

import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 서블릿 등록. 이름과 url은 겹치면 안된다.
 * 서블릿이 호출되면 service 메서드가 호출된다
 */
@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        // request의 쿼리 파라미터 가져오기
        String username = request.getParameter("username");
        System.out.println("username = " + username);

        // 응답 메시지 헤더
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");

        // http 메시지 바디에 데이터를 write
        response.getWriter().write("hello " + username);
    }
}