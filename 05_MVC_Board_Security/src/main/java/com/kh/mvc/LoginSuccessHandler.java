package com.kh.mvc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class LoginSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		List<String> roleList = new ArrayList();
		
		// 인증과 관련된 정보를 가지고 있음
		authentication.getAuthorities().forEach(auth -> {
			System.out.println("auth : " + auth); // ROLE_MEMBER (권한 그 자체를 가지고 옴)
			roleList.add(auth.getAuthority());
		});
		
		if(roleList.contains("ROLE_MEMBER")) {
			response.sendRedirect("/member");
			return;
		}
		
		response.sendRedirect("board/list");
		
	}

}
