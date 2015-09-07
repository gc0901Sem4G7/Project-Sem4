/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Thuan VD
 */
@WebFilter(filterName = "AdminLoginFilter", urlPatterns = {"/*"})
public class AdminLoginFilter implements Filter {

    
    public AdminLoginFilter() {
    }    
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        
        String url = httpServletRequest.getRequestURL() + "";
        if (url.contains("Truyen_Hinh_Vien_Thong/admin") && !url.endsWith("Truyen_Hinh_Vien_Thong/admin/index.jsp") && url.endsWith(".jsp")) {
            HttpSession httpSession = httpServletRequest.getSession();
            if (httpSession.getAttribute("admin") == null || (httpSession.getAttribute("admin") + "").equals("")) {
                httpServletResponse.sendRedirect("index.jsp");
            }
        } else {
            chain.doFilter(request, response);
        }
        
    }

    @Override
    public void destroy() {        
    }

    @Override
    public void init(FilterConfig filterConfig) {        
        
    }

}
