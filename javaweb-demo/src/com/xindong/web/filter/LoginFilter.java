package com.xindong.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    private String excludedPaths;
    private String [] excludedPathArray;
    private String passUrl = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        passUrl = filterConfig.getInitParameter("passUrl");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        HttpSession session = httpServletRequest.getSession();
        Object username = session.getAttribute("username");
        String uri = httpServletRequest.getRequestURI();
        uri = uri.substring(httpServletRequest.getContextPath().length());

        if (username == null) {
            if (passUrl != null && passUrl.length() > 0) {
                String[] split = passUrl.split(";");
                for (String passUrlSingle : split) {
                    if (uri.equals(passUrlSingle)) {
                        filterChain.doFilter(servletRequest, servletResponse);
                        return;

                    }
                }
            }
            httpServletRequest.getRequestDispatcher("/login.jsp").forward(servletRequest, servletResponse);
            return;

        } else {
            filterChain.doFilter(servletRequest, servletResponse);
            return;

        }
    }

    @Override
    public void destroy() {
        passUrl = null;

    }
}
