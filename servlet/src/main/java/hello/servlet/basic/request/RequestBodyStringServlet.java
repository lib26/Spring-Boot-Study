package hello.servlet.basic.request;

import org.springframework.util.StreamUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyStringServlet", urlPatterns = "/request-bodystring")
public class RequestBodyStringServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletInputStream inputStream = request.getInputStream(); // 메시지 바디를 바이트코드로 받는다
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8); // StreamUtils은 스프링 제공. 무조건 바이트를 문자로 바꿀 때는 인코딩을 무엇으로 할지 명시해야함
        System.out.println("messageBody = " + messageBody);
        response.getWriter().write("ok");
    }
}