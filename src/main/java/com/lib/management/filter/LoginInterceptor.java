package com.lib.management.filter;

import com.lib.management.filter.annotation.LoginRequire;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(handler instanceof HandlerMethod){
            //尝试获取方法注解
            HandlerMethod handlerMethod = (HandlerMethod)handler;
            Method method = handlerMethod.getMethod();
            LoginRequire loginRequire = method.getAnnotation(LoginRequire.class);
            if(loginRequire == null){
                loginRequire = method.getDeclaringClass().getAnnotation(LoginRequire.class);
            }
            if(loginRequire != null && !loginRequire.value().equals("")){
                HttpSession session = request.getSession();
                if(session.getAttribute("auth") != null && session.getAttribute("auth").toString().equals(loginRequire.value())){
                    return true;
                }else{
                    response.setContentType("application/json;charset=UTF-8");
                    response.getWriter().write("{\"errCode\":-1,\"msg\":\"auth refuse\"}");
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
