<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Registration</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f5f5f5;
            margin: 0;
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            padding: 20px;
        }
        .container {
            background: white;
            padding: 32px;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.12);
            max-width: 520px;
            width: 100%;
        }
        .form-group { margin-bottom: 16px; }
        label { display: block; margin-bottom: 6px; font-weight: 700; color: #333; }
        input {
            width: 100%;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 6px;
        }
        button, a.button {
            display: inline-block;
            width: 100%;
            padding: 12px;
            border: 0;
            border-radius: 6px;
            text-align: center;
            text-decoration: none;
            color: white;
            font-weight: 700;
            cursor: pointer;
            box-sizing: border-box;
        }
        button { background: #4CAF50; }
        .links { margin-top: 16px; display: grid; gap: 10px; }
        .link { background: #505580; }
        .note {
            margin-bottom: 16px;
            padding: 12px;
            border-radius: 6px;
            background: #e6e6f2;
            color: #020526;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Register</h1>
    <div class="note">Create a login account that will be saved in MySQL.</div>
    <form method="post" action="${pageContext.request.contextPath}/register">
        <div class="form-group">
            <label for="username">Username</label>
            <input type="text" id="username" name="username" required>
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" id="email" name="email" required>
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" id="password" name="password" required>
        </div>
        <div class="form-group">
            <label for="confirmPassword">Confirm Password</label>
            <input type="password" id="confirmPassword" name="confirmPassword" required>
        </div>
        <button type="submit">Create Account</button>
    </form>
    <div class="links">
        <a class="button link" href="${pageContext.request.contextPath}/login">Already have an account? Login</a>
        <a class="button link" href="${pageContext.request.contextPath}/">Home</a>
    </div>
</div>
</body>
</html>
