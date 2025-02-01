package org.example.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList; // Updated import statement
import java.util.List;

import org.example.models.Comment;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/feedback")
public class FeedBackServlet extends HttpServlet {
    // Post Servlet code
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String email = req.getParameter("email"), phone = req.getParameter("phone"), comment = req.getParameter("comment");
        if (email == null || phone == null || comment == null) {
            res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Missing required fields..!");
            return;
        }
        if (!phone.matches("\\d{10}")) {
            res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Invalid phone number..!");
            return;
        }
        try (Connection conn = DBUtil.getConnection()) {
            System.out.println("Database connected...");
            String sql = "INSERT INTO comment (email, phone, comment) VALUES (?, ?, ?)";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, email);
                statement.setString(2, phone);
                statement.setString(3, comment);
                int dataInserted = statement.executeUpdate();
                if (dataInserted > 0) System.out.println("Data sent successfully...");
                else System.out.println("Error sending data..!");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error..!");
            }
        } catch (SQLException | IOException e) {
            System.out.println(e.getMessage());
            res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database Error");
        }
        doGet(req, res);
    }
    // Get Servlet code
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        List<Comment> comments = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection()) {
            System.out.println("Database connected...");
            String sql = "SELECT * FROM comment";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String email = resultSet.getString("email");
                    String phone = resultSet.getString("phone");
                    String commentText = resultSet.getString("comment");
                    Comment comment = new Comment(id, email, phone, commentText);
                    comments.add(comment);
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error..!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error..!");
        }
        req.setAttribute("comments", comments);
        try {
            req.getRequestDispatcher("index.jsp").forward(req, res);
        } catch (ServletException | IOException e) {
            System.out.println(e.getMessage());
            res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error displaying data..!");
        }
    }
    // Update Servlet code

    // Delete Servlet code
    protected void doDelete(HttpServletRequest req, HttpServletResponse res) {
        try (Connection conn = DBUtil.getConnection()) {
            System.out.println("Database connected...");
            PreparedStatement statement = conn.prepareStatement("delete from comment where id=?");
            statement.setInt(1, Integer.parseInt(req.getParameter("id")));
            statement.executeUpdate();
            statement.close();
            conn.close();
            doGet(req, res);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}