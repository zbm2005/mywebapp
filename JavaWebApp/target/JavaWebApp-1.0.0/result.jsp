<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Boolean success = (Boolean) request.getAttribute("success");
    String message = (String) request.getAttribute("message");
    String details = (String) request.getAttribute("details");
    String backUrl = (String) request.getAttribute("backUrl");
    String backText = (String) request.getAttribute("backText");
    if (message == null) {
        message = "Status";
    }
    if (details == null || details.trim().isEmpty()) {
        details = "Done.";
    }
    if (backUrl == null || backUrl.trim().isEmpty()) {
        backUrl = request.getContextPath() + "/";
    }
    if (backText == null || backText.trim().isEmpty()) {
        backText = "Continue";
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Result</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg, #020526 0%, #272c5c 100%);
            margin: 0;
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            padding: 20px;
        }
        .container {
            background: white;
            border-radius: 10px;
            box-shadow: 0 10px 40px rgba(0,0,0,0.22);
            padding: 32px;
            max-width: 560px;
            width: 100%;
            text-align: center;
        }
        .success { color: #155724; }
        .error { color: #b00020; }
        .panel {
            margin-top: 20px;
            padding: 16px;
            border-radius: 8px;
            background: #f5f5f7;
            color: #333;
            text-align: left;
            white-space: pre-wrap;
        }
        a {
            display: inline-block;
            margin-top: 18px;
            padding: 12px 20px;
            border-radius: 6px;
            text-decoration: none;
            color: white;
            background: #1225cc;
            font-weight: 700;
        }
    </style>
</head>
<body>
<div class="container">
    <h1 class="<%= Boolean.TRUE.equals(success) ? "success" : "error" %>"><%= message %></h1>
    <div class="panel"><%= details %></div>
    <a href="<%= backUrl %>"><%= backText %></a>
</div>
</body>
</html>
