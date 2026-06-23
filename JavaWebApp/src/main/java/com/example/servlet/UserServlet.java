package com.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * UserServlet - Demonstrates form handling and session management
 * Access via: http://localhost:8080/user
 */
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("    <meta charset='UTF-8'>");
            out.println("    <title>User Registration</title>");
            out.println("    <style>");
            out.println("        body { font-family: Arial, sans-serif; margin: 40px; background-color: #f5f5f5; }");
            out.println("        .container { background-color: white; padding: 30px; border-radius: 8px; box-shadow: 0 2px 10px rgba(0,0,0,0.1); max-width: 500px; margin: 0 auto; }");
            out.println("        h1 { color: #333; text-align: center; }");
            out.println("        .form-group { margin-bottom: 20px; }");
            out.println("        label { display: block; margin-bottom: 5px; color: #555; font-weight: bold; }");
            out.println("        input, textarea { width: 100%; padding: 10px; border: 1px solid #ddd; border-radius: 4px; box-sizing: border-box; font-family: Arial, sans-serif; }");
            out.println("        input:focus, textarea:focus { outline: none; border-color: #4CAF50; box-shadow: 0 0 5px rgba(76, 175, 80, 0.3); }");
            out.println("        button { background-color: #4CAF50; color: white; padding: 12px 20px; border: none; border-radius: 4px; cursor: pointer; font-size: 16px; width: 100%; }");
            out.println("        button:hover { background-color: #45a049; }");
            out.println("        .back-link { text-align: center; margin-top: 20px; }");
            out.println("        a { color: #4CAF50; text-decoration: none; }");
            out.println("        a:hover { text-decoration: underline; }");
            out.println("    </style>");
            out.println("</head>");
            out.println("<body>");
            out.println("    <div class='container'>");
            out.println("        <h1>User Registration Form</h1>");
            out.println("        <form method='POST' action='/user'>");
            out.println("            <div class='form-group'>");
            out.println("                <label for='firstName'>First Name:</label>");
            out.println("                <input type='text' id='firstName' name='firstName' required>");
            out.println("            </div>");
            out.println("            <div class='form-group'>");
            out.println("                <label for='lastName'>Last Name:</label>");
            out.println("                <input type='text' id='lastName' name='lastName' required>");
            out.println("            </div>");
            out.println("            <div class='form-group'>");
            out.println("                <label for='email'>Email:</label>");
            out.println("                <input type='email' id='email' name='email' required>");
            out.println("            </div>");
            out.println("            <div class='form-group'>");
            out.println("                <label for='message'>Message:</label>");
            out.println("                <textarea id='message' name='message' rows='4'></textarea>");
            out.println("            </div>");
            out.println("            <button type='submit'>Submit</button>");
            out.println("        </form>");
            out.println("        <div class='back-link'>");
            out.println("            <a href='/'>Back to Home</a>");
            out.println("        </div>");
            out.println("    </div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Get form parameters
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String message = request.getParameter("message");

        // Store in session
        HttpSession session = request.getSession(true);
        session.setAttribute("firstName", firstName);
        session.setAttribute("lastName", lastName);
        session.setAttribute("email", email);

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("    <meta charset='UTF-8'>");
            out.println("    <title>Registration Confirmation</title>");
            out.println("    <style>");
            out.println("        body { font-family: Arial, sans-serif; margin: 40px; background-color: #f5f5f5; }");
            out.println("        .container { background-color: white; padding: 30px; border-radius: 8px; box-shadow: 0 2px 10px rgba(0,0,0,0.1); max-width: 500px; margin: 0 auto; }");
            out.println("        .success { background-color: #d4edda; border: 1px solid #c3e6cb; color: #155724; padding: 15px; border-radius: 4px; }");
            out.println("        h1 { color: #155724; }");
            out.println("        .info { margin-top: 20px; }");
            out.println("        .info p { margin: 10px 0; }");
            out.println("        strong { color: #333; }");
            out.println("        a { color: #007bff; text-decoration: none; }");
            out.println("        a:hover { text-decoration: underline; }");
            out.println("    </style>");
            out.println("</head>");
            out.println("<body>");
            out.println("    <div class='container'>");
            out.println("        <div class='success'>");
            out.println("            <h1>✓ Registration Successful!</h1>");
            out.println("            <p>Thank you for registering with us.</p>");
            out.println("        </div>");
            out.println("        <div class='info'>");
            out.println("            <h2>Your Information:</h2>");
            out.println("            <p><strong>Name:</strong> " + escapeHtml(firstName) + " " + escapeHtml(lastName) + "</p>");
            out.println("            <p><strong>Email:</strong> " + escapeHtml(email) + "</p>");
            out.println("            <p><strong>Message:</strong> " + escapeHtml(message) + "</p>");
            out.println("            <p><strong>Session ID:</strong> " + session.getId() + "</p>");
            out.println("        </div>");
            out.println("        <p style='text-align: center; margin-top: 30px;'>");
            out.println("            <a href='/user'>Back to Form</a> | ");
            out.println("            <a href='/'>Home</a>");
            out.println("        </p>");
            out.println("    </div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Escape HTML characters to prevent XSS attacks
     */
    private String escapeHtml(String text) {
        if (text == null) return "";
        return text.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#39;");
    }
}
