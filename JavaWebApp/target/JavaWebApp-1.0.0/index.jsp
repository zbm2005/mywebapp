<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Java Web Application</title>
    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg, #020526 0%, #272c5c 100%);
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            padding: 20px;
        }
        .container {
            background: #f5f5f7;
            border-radius: 10px;
            box-shadow: 0 10px 40px rgba(2, 5, 38, 0.4);
            padding: 40px;
            max-width: 720px;
            width: 100%;
        }
        h1, h2 { color: #020526; text-align: center; }
        .buttons { display: grid; gap: 12px; margin-top: 24px; }
        a {
            display: block;
            padding: 14px 20px;
            border-radius: 6px;
            text-decoration: none;
            text-align: center;
            font-weight: 600;
            color: white;
        }
        .primary { background: #1225cc; }
        .secondary { background: #505580; }
        .panel {
            margin-top: 24px;
            padding: 18px;
            border-radius: 8px;
            background: #ededf0;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Java Web Application</h1>
    <h2>Servlet + JSP + MySQL Login</h2>
    <div class="buttons">
        <a class="primary" href="${pageContext.request.contextPath}/hello">Open Hello Servlet</a>
        <a class="secondary" href="${pageContext.request.contextPath}/register">Register New User</a>
        <a class="secondary" href="${pageContext.request.contextPath}/login">Login</a>
    </div>
    <div class="panel">
        Register and login pages now use JSP views, and user credentials are stored in MySQL through the servlet layer.
    </div>
</div>
</body>
</html>
