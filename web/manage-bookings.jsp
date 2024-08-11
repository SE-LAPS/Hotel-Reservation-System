<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ page import="Classes.DBConnector" %>
<%
    // Check if admin is logged in
    if (session.getAttribute("adminID") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
        conn = DBConnector.getConnection();
        String sql = "SELECT b.*, u.userName, r.roomNumber FROM bookings b " +
                     "JOIN users u ON b.userID = u.userID " +
                     "JOIN rooms r ON b.roomID = r.roomID";
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Bookings - Hotel del Luna</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <style>
        .back-button {
            position: absolute;
            top: 10px;
            right: 10px;
        }
    </style>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container">
            <a class="navbar-brand" href="admin-panel.jsp">Hotel del Luna Admin</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="logout.jsp">Logout</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="container mt-5">
        <a href="admin-panel.jsp" class="btn btn-primary back-button">Back Admin Panel</a>
        <h1>MANAGE BOOKINGS</h1>
        <a href="./CRUD/add-booking.jsp" class="btn btn-primary mb-3">ADD NEW BOOKING</a>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Booking ID</th>
                    <th>User</th>
                    <th>Room</th>
                    <th>Check-in Date</th>
                    <th>Check-out Date</th>
                    <th>Total Price</th>
                    <th>Status</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <% while (rs.next()) { %>
                    <tr>
                        <td><%= rs.getInt("bookingID") %></td>
                        <td><%= rs.getString("userName") %></td>
                        <td><%= rs.getString("roomNumber") %></td>
                        <td><%= rs.getDate("checkInDate") %></td>
                        <td><%= rs.getDate("checkOutDate") %></td>
                        <td>$<%= rs.getBigDecimal("totalPrice") %></td>
                        <td><%= rs.getString("status") %></td>
                        <td>
                            <a href="./CRUD/edit-booking.jsp?id=<%= rs.getInt("bookingID") %>" class="btn btn-sm btn-primary">Edit</a>
                            <a href="./CRUD/delete-booking.jsp?id=<%= rs.getInt("bookingID") %>" class="btn btn-sm btn-danger" onclick="return confirm('Are you sure you want to delete this booking?')">Delete</a>
                        </td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
<%
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Close resources
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
%>