package hello.servlet.web.frontcontroller.v2;

import hello.servlet.web.frontcontroller.MyView;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ControllerV2 {

    // MyView를 반환한다는 것이 포인트
    MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}