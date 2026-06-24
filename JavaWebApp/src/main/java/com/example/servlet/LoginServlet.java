package com.example.servlet;

import com.example.dao.UserDao;
import com.example.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private final UserDao userDao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String username = trim(request.getParameter("username"));
        String password = request.getParameter("password");

        if (username.isEmpty() || password == null || password.trim().isEmpty()) {
            forwardResult(request, response, false, "Username and password are required.", "");
            return;
        }

        try {
            User user = userDao.authenticate(username, password);
            if (user == null) {
                forwardResult(request, response, false, "Invalid username or password.", "");
                return;
            }

            HttpSession session = request.getSession(true);
            session.setAttribute("loggedInUser", user.getUsername());
            session.setAttribute("loggedInEmail", user.getEmail());

            forwardResult(request, response, true, "Login successful.", "Welcome back, " + user.getUsername() + ".");
        } catch (Exception ex) {
            throw new ServletException("Unable to authenticate user", ex);
        }
    }

    private void forwardResult(HttpServletRequest request, HttpServletResponse response, boolean success, String message, String details)
            throws ServletException, IOException {
        request.setAttribute("success", success);
        request.setAttribute("message", message);
        request.setAttribute("details", details);
        request.setAttribute("backUrl", request.getContextPath() + "/login");
        request.setAttribute("backText", "Back to login");
        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }

    private String trim(String value) {
        return value == null ? "" : value.trim();
    }
}
