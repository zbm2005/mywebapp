# 🚀 Quick Start Guide - Java Web Application

## 5-Minute Setup

### Step 1: Prerequisites Check ✅
```bash
java -version          # Should be Java 11+
mvn -version           # Should be Maven 3.6+
```

If not installed, download from:
- JDK: https://www.oracle.com/java/technologies/javase-downloads.html
- Maven: https://maven.apache.org/download.cgi

### Step 2: Open in VS Code 💻
1. Launch VS Code
2. File → Open Folder → Select `JavaWebApp` folder
3. Install "Extension Pack for Java" (if not installed)

### Step 3: Build Project 🔨
```bash
# Open Terminal in VS Code (Ctrl+Shift+`)
mvn clean package
```

### Step 4: Run Application 🎯
```bash
mvn tomcat7:run
```

You'll see:
```
[INFO] Starting Tomcat v7.0.37...
[INFO] Started Tomcat v7.0.37
```

### Step 5: Access Application 🌐
Open browser and visit:
- **Home:** http://localhost:8080/
- **Hello Servlet:** http://localhost:8080/hello
- **User Form:** http://localhost:8080/user

## Project Contents

### Files You Have:

```
JavaWebApp/
├── pom.xml                      ← Maven config (dependencies, build settings)
├── README.md                    ← Full documentation
├── .gitignore                   ← Git ignore file
└── src/
    └── main/
        ├── java/
        │   └── com/example/servlet/
        │       ├── HelloServlet.java     ← Simple servlet (GET request)
        │       └── UserServlet.java      ← Advanced servlet (POST, sessions)
        └── webapp/
            ├── WEB-INF/
            │   └── web.xml              ← Servlet mappings & config
            ├── index.html               ← Homepage
            └── error.html               ← Error page
```

## Key Files Explained

### web.xml (Deployment Descriptor)
Configures:
- Servlet declarations
- URL mappings (/hello, /user)
- Error pages (404, 500)
- Session settings
- Welcome files

### HelloServlet.java
- URL: `/hello`
- Handles: GET requests with optional name parameter
- Shows: Request details, timestamp, server info
- Example: `/hello?name=John`

### UserServlet.java
- URL: `/user`
- GET: Shows registration form
- POST: Processes form, stores in session
- Shows: Confirmation page with submitted data

## Useful Commands

### Build & Run
```bash
mvn clean compile        # Compile only
mvn clean package        # Build WAR file (creates target/app.war)
mvn tomcat7:run         # Run with embedded Tomcat
```

### Test Servlets
```bash
# Basic request
curl http://localhost:8080/

# With parameter
curl http://localhost:8080/hello?name=Alice

# POST request
curl -X POST -d "firstName=John&lastName=Doe&email=john@example.com" \
  http://localhost:8080/user
```

### Clean Up
```bash
mvn clean               # Remove target/ folder
```

## Troubleshooting

### Port 8080 In Use?
```bash
# Kill process using port 8080
lsof -ti:8080 | xargs kill -9      # Mac/Linux
netstat -ano | findstr :8080       # Windows (then taskkill)
```

### Maven Not Found?
Set PATH to Maven bin directory or install via:
```bash
# Mac
brew install maven

# Ubuntu/Debian
sudo apt-get install maven

# Windows (use installer or chocolatey)
choco install maven
```

### Java Not Found?
Set JAVA_HOME environment variable:
```bash
# Mac/Linux
export JAVA_HOME=/path/to/jdk
# Add to ~/.bash_profile or ~/.zshrc for permanent

# Windows
setx JAVA_HOME "C:\Program Files\Java\jdk11"  # Permanent
```

## Common Errors

**Error:** "web.xml is missing"
- **Fix:** Ensure `src/main/webapp/WEB-INF/web.xml` exists

**Error:** "Servlet mapping not found"
- **Fix:** Check web.xml has matching `<url-pattern>`

**Error:** "Class not found"
- **Fix:** Run `mvn clean compile` before `mvn tomcat7:run`

## Next Steps

1. **Modify Servlets:** Edit HelloServlet.java or UserServlet.java
2. **Add Pages:** Create new .html files in `src/main/webapp/`
3. **Add Database:** Add MySQL/PostgreSQL dependency to pom.xml
4. **Deploy to Production:** Build WAR and deploy to Tomcat server

## Resources

- [Servlet Tutorial](https://www.oracle.com/java/technologies/serv-jsp.html)
- [Maven Guide](https://maven.apache.org/guides/)
- [Tomcat Docs](https://tomcat.apache.org/)
- [Java Docs](https://docs.oracle.com/javase/11/)

---

**Need help?** Check the full README.md file for detailed documentation!
