package com.offcn.Intercept;

import com.offcn.pojo.Employee;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author songmu
 * @create 2019-07-04 14:47
 */
public class Logininterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();
        System.out.println("请求的Url为：：：："+url);
        if(url.indexOf("login")>=0){
            return true;
        }
        HttpSession session = request.getSession();
        Employee employee = (Employee)session.getAttribute("employee");
        if(employee!=null){
            return true;
        }
        response.sendRedirect(request.getServletContext().getContextPath()+"/login.jsp");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
