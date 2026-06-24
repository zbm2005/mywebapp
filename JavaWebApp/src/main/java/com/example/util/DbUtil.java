package com.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DbUtil {

    private static final String DEFAULT_URL = "jdbc:mysql://localhost:3306/java_webapp?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String DEFAULT_USER = "root";
    private static final String DEFAULT_PASSWORD = "";

    private DbUtil() {
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(getUrl(), getUser(), getPassword());
    }

    private static String getUrl() {
        return value("DB_URL", "db.url", DEFAULT_URL);
    }

    private static String getUser() {
        return value("DB_USER", "db.user", DEFAULT_USER);
    }

    private static String getPassword() {
        return value("DB_PASSWORD", "db.password", DEFAULT_PASSWORD);
    }

    private static String value(String envName, String propertyName, String defaultValue) {
        String propertyValue = System.getProperty(propertyName);
        if (propertyValue != null && !propertyValue.trim().isEmpty()) {
            return propertyValue.trim();
        }

        String envValue = System.getenv(envName);
        if (envValue != null && !envValue.trim().isEmpty()) {
            return envValue.trim();
        }

        return defaultValue;
    }
}
