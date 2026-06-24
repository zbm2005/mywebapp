# Java Web Application with Servlets

A complete dynamic Java web application built with Apache Maven, featuring servlet-based request handling and web.xml configuration.

## 📋 Project Overview

This project demonstrates:
- ✅ Dynamic servlet development
- ✅ JSP views for home, registration, login, and result pages
- ✅ MySQL-backed user registration and login
- ✅ Web deployment descriptor (web.xml)
- ✅ Request/Response handling
- ✅ Session management
- ✅ Form processing
- ✅ Maven build automation
- ✅ Proper project structure

## 📁 Project Structure

```
JavaWebApp/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/example/servlet/
│       │       ├── HelloServlet.java          # Simple servlet with parameters
│       │       └── UserServlet.java           # Form handling & sessions
│       └── webapp/
│           ├── WEB-INF/
│           │   └── web.xml                    # Deployment descriptor
│           ├── index.jsp                      # Homepage
│           ├── register.jsp                   # Registration form
│           ├── login.jsp                      # Login form
│           ├── result.jsp                     # Success/error result page
│           └── error.html                     # Error page
├── pom.xml                                    # Maven configuration
└── README.md                                  # This file
```

## 🔧 Prerequisites

Make sure you have installed:
- **Java Development Kit (JDK)** - Version 11 or higher
  - [Download JDK](https://www.oracle.com/java/technologies/javase-downloads.html)
  
- **Apache Maven** - Version 3.6 or higher
  - [Download Maven](https://maven.apache.org/download.cgi)
  
- **Apache Tomcat** - Version 9.0 or higher (for deployment)
  - [Download Tomcat](https://tomcat.apache.org/download-90.cgi)

- **VS Code** with Java extension
  - Install "Extension Pack for Java" from Microsoft in VS Code

## ⚙️ Setup Instructions

### 1. Verify Prerequisites
```bash
java -version
mvn -version
```

### 2. Clone or Extract Project
```bash
# Navigate to your project directory
cd JavaWebApp
```

### 3. Compile Project
```bash
mvn clean compile
```

### 4. Build WAR File
```bash
mvn clean package
```
This creates `target/app.war` ready for deployment.

## 🚀 Running the Application

### Option 1: Using Tomcat Maven Plugin (Easiest)

Run locally without needing to install Tomcat separately:

```bash
mvn tomcat7:run
```

The application will be available at:
- **Home Page:** http://localhost:8080/
- **Hello Servlet:** http://localhost:8080/hello
- **User Form:** http://localhost:8080/user

### Option 2: Deploy to Tomcat Server

1. **Copy WAR file to Tomcat:**
   ```bash
   cp target/app.war $CATALINA_HOME/webapps/
   ```

2. **Start Tomcat:**
   ```bash
   $CATALINA_HOME/bin/startup.sh    # Linux/Mac
   # or
   %CATALINA_HOME%\bin\startup.bat  # Windows
   ```

3. **Access the application:**
   - http://localhost:8080/app/

## 📝 Web.xml Configuration

The `web.xml` file configures:

```xml
<!-- Servlet Declaration -->
<servlet>
    <servlet-name>HelloServlet</servlet-name>
    <servlet-class>com.example.servlet.HelloServlet</servlet-class>
</servlet>

<!-- URL Mapping -->
<servlet-mapping>
    <servlet-name>HelloServlet</servlet-name>
    <url-pattern>/hello</url-pattern>
</servlet-mapping>
```

Key configurations:
- **Welcome files:** index.html
- **Error pages:** Custom 404 and 500 error handlers
- **Session tracking:** Cookie-based HTTP sessions
- **Load on startup:** Servlets initialized when app starts

## 🔌 Servlets Overview

### HelloServlet
- **URL:** `/hello`
- **Features:**
  - GET request handling
  - Query parameter processing (`?name=John`)
  - Request information display
  - Dynamic HTML generation
  - Init parameter usage from web.xml

### UserServlet
- **URL:** `/register`
- **Features:**
  - GET (displays JSP form)
  - POST (processes form data)
  - MySQL persistence
  - Registration validation

### LoginServlet
- **URL:** `/login`
- **Features:**
  - GET (displays JSP form)
  - POST (authenticates against MySQL)
  - Session management

## 📖 Usage Examples

### 1. Visit Hello Servlet
```
http://localhost:8080/hello
http://localhost:8080/hello?name=Alice
```

### 2. Register User
```
GET  http://localhost:8080/user          (Show form)
POST http://localhost:8080/user          (Submit form)
```

### 3. View Error Page
```
http://localhost:8080/nonexistent        (404 error)
```

## 🛠️ Building in VS Code

1. **Open Folder in VS Code:**
   - File → Open Folder → Select JavaWebApp

2. **Install Extensions:**
   - Extension Pack for Java (Microsoft)
   - Maven for Java (Microsoft)

3. **Build from Terminal:**
   ```bash
   Ctrl+Shift+` to open terminal
   mvn clean package
   ```

4. **Run Application:**
   ```bash
   mvn tomcat7:run
   ```

5. **Access http://localhost:8080/**

## 📦 Maven Dependencies

```xml
<!-- Servlet API (provided by Tomcat) -->
javax.servlet:javax.servlet-api:4.0.1

<!-- Unit Testing -->
junit:junit:4.13.2
```

## 🔍 Common Issues & Solutions

### Issue: "Java not found"
**Solution:** Install JDK and set JAVA_HOME environment variable
```bash
# Linux/Mac
export JAVA_HOME=/path/to/jdk
echo $JAVA_HOME
```

### Issue: "Maven command not found"
**Solution:** Install Maven and set M2_HOME environment variable
```bash
# Linux/Mac
export M2_HOME=/path/to/maven
export PATH=$M2_HOME/bin:$PATH
```

### Issue: "Port 8080 already in use"
**Solution:** Change port in pom.xml or kill process using port 8080
```bash
# Linux/Mac - Find and kill process
lsof -ti:8080 | xargs kill -9

# Windows
netstat -ano | findstr :8080
taskkill /PID <PID> /F
```

### Issue: 404 Error on servlet URL
**Solution:** Check web.xml servlet mappings match your access URLs

## 🚀 Next Steps

### 1. Add Database Support
```xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.28</version>
</dependency>
```

### 2. Add JSP Support
- Use the existing `.jsp` files in `src/main/webapp/`
- Keep servlet logic in `src/main/java/` and render results in JSP views

### 3. Implement Filters
```java
public class LoggingFilter implements Filter {
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) {
        // Log requests
        chain.doFilter(req, res);
    }
}
```

### 4. Add Dependency Injection
```xml
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>5.3.0</version>
</dependency>
```

## 📚 Learning Resources

- [Servlet API Documentation](https://docs.oracle.com/javaee/7/api/javax/servlet/Servlet.html)
- [Maven Official Guide](https://maven.apache.org/guides/)
- [Tomcat Documentation](https://tomcat.apache.org/tomcat-9.0-doc/)
- [Java Servlet Tutorial](https://www.oracle.com/java/technologies/serv-jsp.html)

## 📄 License

This project is open source and available for educational purposes.

## 💡 Tips

- Always validate user input to prevent XSS attacks
- Use HTTPS in production environments
- Keep sensitive data in environment variables, not hardcoded
- Test all servlet methods (GET, POST, PUT, DELETE)
- Use session timeout for security
- Implement proper error handling and logging

---

**Happy coding!** 🎉
