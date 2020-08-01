package cn.maxcj.servlet;

import cn.maxcj.bean.User;
import cn.maxcj.service.UserService;
import cn.maxcj.util.ResponseUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author maxcj
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private static UserService userService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        try {
            User user = userService.login(email, password);
            request.getSession().setAttribute("email", user.getEmail());
            request.getSession().setAttribute("role", user.getRoleList());
            response.sendRedirect("allIndex.jsp");
        } catch (Exception e) {
            ResponseUtil.response(response, e.getMessage(), "login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
