package pe.edu.utec.lab.laboratorio03.config;

import jakarta.servlet.http.*;
import org.springframework.web.servlet.HandlerInterceptor;

public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
        String uri = req.getRequestURI();
        if (uri.startsWith("/login") || uri.startsWith("/css") || uri.startsWith("/js") || uri.startsWith("/images") || uri.equals("/error")) {
            return true;
        }
        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("usuarioActual") != null) return true;
        res.sendRedirect("/login");
        return false;
    }
}
