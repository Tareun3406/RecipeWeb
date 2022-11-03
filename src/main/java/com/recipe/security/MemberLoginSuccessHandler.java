package com.recipe.security;

import com.recipe.vo.AuthDTO;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MemberLoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response
            , Authentication authentication) throws IOException, ServletException {

        List<String> authNames = new ArrayList<>();

        authentication.getAuthorities().forEach(authority -> {
            authNames.add(authority.getAuthority());
        });

        if(authNames.contains(AuthDTO.AUTH_ADMIN)){
            response.sendRedirect("/admin");
        }
        else{
            response.sendRedirect("/");
        }
    }
}
