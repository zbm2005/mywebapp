package com.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * HelloServlet - A simple servlet that demonstrates basic servlet functionality
 * Access via: http://localhost:8080/hello
 */
public class HelloServlet extends HttpServlet {

    private String greeting;

    @Override
    public void init() throws ServletException {
        super.init();
        // Get the greeting from web.xml init parameter
        greeting = getInitParameter("greeting");
        System.out.println("HelloServlet initialized: " + greeting);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set content type
        response.setContentType("text/html;charset=UTF-8");

        // Get request parameters
        String name = request.getParameter("name");
        if (name == null || name.trim().isEmpty()) {
            name = "Guest";
        }

        // Get current timestamp
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = now.format(formatter);

        // Write response
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("    <meta charset='UTF-8'>");
            out.println("    <title>Hello Servlet</title>");
            out.println("    <style>");
            out.println("        body { font-family: Arial, sans-serif; margin: 40px; background-color: #f0f0f0; }");
            out.println("        .container { background-color: white; padding: 30px; border-radius: 8px; box-shadow: 0 2px 4px rgba(0,0,0,0.1); }");
            out.println("        h1 { color: #333; }");
            out.println("        p { color: #666; line-height: 1.6; }");
            out.println("        .info { background-color: #e8f4f8; padding: 15px; border-left: 4px solid #0288d1; margin: 20px 0; }");
            out.println("        a { color: #0288d1; text-decoration: none; }");
            out.println("        a:hover { text-decoration: underline; }");
            out.println("    </style>");
            out.println("</head>");
            out.println("<body>");
            out.println("    <div class='container'>");
            out.println("        <h1>" + greeting + "</h1>");
            out.println("        <p>Hello, <strong>" + escapeHtml(name) + "</strong>!</p>");
            out.println("        <div class='info'>");
            out.println("            <p><strong>Request Information:</strong></p>");
            out.println("            <p>Timestamp: " + timestamp + "</p>");
            out.println("            <p>Request Method: " + request.getMethod() + "</p>");
            out.println("            <p>Request URI: " + request.getRequestURI() + "</p>");
            out.println("            <p>Server Name: " + request.getServerName() + "</p>");
            out.println("        </div>");
            String contextPath = request.getContextPath();
            out.println("        <p><a href='" + contextPath + "/hello?name=John'>Try with name parameter: John</a></p>");
            out.println("        <p><a href='" + contextPath + "/register'>Visit Registration Page</a></p>");
            out.println("        <p><a href='" + contextPath + "/login'>Visit Login Page</a></p>");
            out.println("        <p><a href='" + contextPath + "/'>Back to Home</a></p>");
            out.println("    </div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Handle POST requests
        doGet(request, response);
    }

    /**
     * Escape HTML characters to prevent XSS attacks
     */
    private String escapeHtml(String text) {
        return text.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#39;");
    }

    @Override
    public void destroy() {
        System.out.println("HelloServlet destroyed");
        super.destroy();
    }
}
