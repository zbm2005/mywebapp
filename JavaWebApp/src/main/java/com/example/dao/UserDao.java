package com.example.dao;

import com.example.model.User;
import com.example.util.DbUtil;
import com.example.util.PasswordUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class UserDao {

    public User createUser(String username, String email, String rawPassword) throws SQLException {
        String salt = PasswordUtil.newSalt();
        String passwordHash = PasswordUtil.hashPassword(rawPassword, salt);

        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO users (username, email, password_hash, salt) VALUES (?, ?, ?, ?)")) {
            statement.setString(1, username);
            statement.setString(2, email);
            statement.setString(3, passwordHash);
            statement.setString(4, salt);
            statement.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException ex) {
            throw new IllegalStateException("Username or email already exists.", ex);
        }

        return findByUsername(username);
    }

    public User authenticate(String username, String rawPassword) throws SQLException {
        User user = findByUsername(username);
        if (user == null) {
            return null;
        }

        if (!PasswordUtil.matches(rawPassword, user.getSalt(), user.getPasswordHash())) {
            return null;
        }

        return user;
    }

    public User findByUsername(String username) throws SQLException {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT id, username, email, password_hash, salt, created_at FROM users WHERE username = ?")) {
            statement.setString(1, username);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (!resultSet.next()) {
                    return null;
                }

                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setUsername(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                user.setPasswordHash(resultSet.getString("password_hash"));
                user.setSalt(resultSet.getString("salt"));
                user.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());
                return user;
            }
        }
    }
}
