package com.example.springsession;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet("/hello-session")
public class HelloSessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = null;
        if (request.getSession(false) == null) { //false: session이 없으면 null, ture: session이 없으면 새로 생성
            System.out.println("세션을 생성합니다.");
            session = request.getSession(true);
            Long randomSessionId = new Random().nextLong();
            session.setAttribute("sId", randomSessionId);
        }else {
            System.out.println("이미 생성된 세션이 존재합니다.");
            session = request.getSession(false);
        }

        Long sessionId = (Long) session.getAttribute("sId");

        System.out.println("현재 세션 아이디 = " + sessionId);
    }
}
