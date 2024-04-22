package com.booker.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.sql.*;

import com.booker.database.*;
import com.booker.database.impl.UserMapperImpl;
import com.booker.domain.*;

@WebServlet(name = "registerServlet", urlPatterns = { "/registerServlet" })
public class RegisterServlet extends HttpServlet {
    private UserMapperImpl userMapper = new UserMapperImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String full_name = request.getParameter("full_name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Basic validation
        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            request.setAttribute("error", "Invalid input");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;
        }
        // Hashing the password - using a simple hashing for demonstration
        String hashedPassword = Integer.toString(password.hashCode());

        Customer newUser = new Customer(full_name);
        newUser.setUsername(username);
        newUser.setPassword(hashedPassword);
        try {
            userMapper.addUser(newUser);
            response.sendRedirect("index.jsp"); // Redirect to login page after successful registration
        } catch (Exception e) {
            request.setAttribute("error", "Database error: " + e.getMessage());
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }
    }
}
