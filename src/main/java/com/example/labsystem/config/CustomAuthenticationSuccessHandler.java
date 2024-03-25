//package com.example.labsystem.config;
//
//import java.io.IOException;
//import java.util.Set;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.web.WebAttributes;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
//
//    @Override
//    public void onAuthenticationSuccess(
//            HttpServletRequest request,
//            HttpServletResponse response,
//            Authentication authentication
//    ) throws IOException, ServletException {
//        handle(request, response, authentication);
//        clearAuthenticationAttributes(request);
//    }
//
//    protected void handle(
//            HttpServletRequest request,
//            HttpServletResponse response,
//            Authentication authentication
//    ) throws IOException {
//        String targetUrl = determineTargetUrl(authentication);
//
//        if (response.isCommitted()) {
//            return;
//        }
//
//        response.sendRedirect(targetUrl);
//    }
//
//    protected String determineTargetUrl(final Authentication authentication) {
//        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
//
//        if (roles.contains("ROLE_ADMIN")) {
//            return "/admindashboard";
//        } else {
//            return "/userdashboard";
//        }
//    }
//
//    protected void clearAuthenticationAttributes(HttpServletRequest request) {
//        HttpSession session = request.getSession(false);
//        if (session == null) {
//            return;
//        }
//        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
//    }
//
//	
//}