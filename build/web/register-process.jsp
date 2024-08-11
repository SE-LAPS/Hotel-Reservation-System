<%@ page import="java.sql.*, Classes.User, Classes.DBConnector" %>
<%@ page import="javax.servlet.http.*, javax.servlet.*" %>
<%@page import="Classes.MD5"%>
<%
    // Retrieve form parameters
    String firstName = request.getParameter("firstname");
    String lastName = request.getParameter("lastname");
    String email = request.getParameter("email");
    String password = MD5.getMd5(request.getParameter("password"));
    String confirmPassword = MD5.getMd5(request.getParameter("confirmpassword"));

    // Check if password and confirm password match
    if (!password.equals(confirmPassword)) {
        out.println("<div class='alert alert-danger' role='alert'>Passwords do not match. Please try again.</div>");
        out.println("<a href='register.jsp' class='btn btn-primary'>Go Back</a>");
    } else {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            // Establish connection to the database
            conn = DBConnector.getConnection();

            // Create a User object to register
            User user = new User(0, firstName + " " + lastName, password, email, "USER"); // Default role is USER

            // Register the user
            boolean success = user.register(firstName, lastName, email, password, "USER");

            if (success) {
                // Registration successful
                response.sendRedirect("login.jsp");
            } else {
                // Registration failed
                out.println("<div class='alert alert-danger' role='alert'>Registration failed. Please try again later.</div>");
            }
        } catch (Exception e) {
            // Handle SQL exceptions
            e.printStackTrace();
            out.println("<div class='alert alert-danger' role='alert'>An error occurred. Please try again later.</div>");
        } finally {
            // Close resources
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
%>