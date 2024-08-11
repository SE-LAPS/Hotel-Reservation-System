<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ page import="Classes.DBConnector" %>
<%
    // Check if admin is logged in
    if (session.getAttribute("adminID") == null) {
        response.sendRedirect("../login.jsp");
        return;
    }

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
        conn = DBConnector.getConnection();
        
        // Fetch users
        String userSql = "SELECT userID, userName FROM users";
        pstmt = conn.prepareStatement(userSql);
        ResultSet userRs = pstmt.executeQuery();
        
        // Fetch rooms
        String roomSql = "SELECT roomID, roomNumber FROM rooms";
        pstmt = conn.prepareStatement(roomSql);
        ResultSet roomRs = pstmt.executeQuery();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Booking - Hotel del Luna</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1>Add New Booking</h1>
        <form action="process-add-booking.jsp" method="post">
            <div class="mb-3">
                <label for="userID" class="form-label">User</label>
                <select class="form-select" id="userID" name="userID" required>
                    <% while (userRs.next()) { %>
                        <option value="<%= userRs.getInt("userID") %>"><%= userRs.getString("userName") %></option>
                    <% } %>
                </select>
            </div>
            <div class="mb-3">
                <label for="roomID" class="form-label">Room</label>
                <select class="form-select" id="roomID" name="roomID" required>
                    <% while (roomRs.next()) { %>
                        <option value="<%= roomRs.getInt("roomID") %>"><%= roomRs.getString("roomNumber") %></option>
                    <% } %>
                </select>
            </div>
            <div class="mb-3">
                <label for="checkInDate" class="form-label">Check-in Date</label>
                <input type="date" class="form-control" id="checkInDate" name="checkInDate" required>
            </div>
            <div class="mb-3">
                <label for="checkOutDate" class="form-label">Check-out Date</label>
                <input type="date" class="form-control" id="checkOutDate" name="checkOutDate" required>
            </div>
            <div class="mb-3">
                <label for="totalPrice" class="form-label">Total Price</label>
                <input type="number" step="0.01" class="form-control" id="totalPrice" name="totalPrice" required>
            </div>
            <div class="mb-3">
                <label for="status" class="form-label">Status</label>
                <select class="form-select" id="status" name="status" required>
                    <option value="Confirmed">Confirmed</option>
                    <option value="Pending">Pending</option>
                    <option value="Cancelled">Cancelled</option>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Add Booking</button>
            <a href="../manage-bookings.jsp" class="btn btn-secondary">Cancel</a>
        </form>
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