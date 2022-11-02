package com.recipe.security;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MemberAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response
            , AccessDeniedException accessDeniedException) throws IOException, ServletException {

        HttpSession session = request.getSession();
        session.invalidate();

        deleteRememberMe(request,response);

        response.sendRedirect("/member/login");
    }

    private void deleteRememberMe(HttpServletRequest request, HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        for (Cookie ck:cookies) {
            if(ck.getName().equals("remember-me")){
                ck.setMaxAge(0);
                response.addCookie(ck);
                break;
            }
        }
    }
}
