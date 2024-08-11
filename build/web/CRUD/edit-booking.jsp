<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ page import="Classes.DBConnector" %>
<%
    // Check if admin is logged in
    if (session.getAttribute("adminID") == null) {
        response.sendRedirect("../login.jsp");
        return;
    }

    int bookingID = Integer.parseInt(request.getParameter("id"));
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
        conn = DBConnector.getConnection();
        
        // Fetch booking details
        String bookingSql = "SELECT * FROM bookings WHERE bookingID = ?";
        pstmt = conn.prepareStatement(bookingSql);
        pstmt.setInt(1, bookingID);
        rs = pstmt.executeQuery();
        
        if (!rs.next()) {
            response.sendRedirect("../manage-bookings.jsp");
            return;
        }
        
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
    <title>Edit Booking - Hotel del Luna</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1>Edit Booking</h1>
        <form action="process-edit-booking.jsp" method="post">
            <input type="hidden" name="bookingID" value="<%= rs.getInt("bookingID") %>">
            <div class="mb-3">
                <label for="userID" class="form-label">User</label>
                <select class="form-select" id="userID" name="userID" required>
                    <% while (userRs.next()) { %>
                        <option value="<%= userRs.getInt("userID") %>" <%= (userRs.getInt("userID") == rs.getInt("userID")) ? "selected" : "" %>><%= userRs.getString("userName") %></option>
                    <% } %>
                </select>
            </div>
            <div class="mb-3">
                <label for="roomID" class="form-label">Room</label>
                <select class="form-select" id="roomID" name="roomID" required>
                    <% while (roomRs.next()) { %>
                        <option value="<%= roomRs.getInt("roomID") %>" <%= (roomRs.getInt("roomID") == rs.getInt("roomID")) ? "selected" : "" %>><%= roomRs.getString("roomNumber") %></option>
                    <% } %>
                </select>
            </div>
            <div class="mb-3">
                <label for="checkInDate" class="form-label">Check-in Date</label>
                <input type="date" class="form-control" id="checkInDate" name="checkInDate" value="<%= rs.getDate("checkInDate") %>" required>
            </div>
            <div class="mb-3">
                <label for="checkOutDate" class="form-label">Check-out Date</label>
                <input type="date" class="form-control" id="checkOutDate" name="checkOutDate" value="<%= rs.getDate("checkOutDate") %>" required>
            </div>
            <div class="mb-3">
                <label for="totalPrice" class="form-label">Total Price</label>
                <input type="number" step="0.01" class="form-control" id="totalPrice" name="totalPrice" value="<%= rs.getBigDecimal("totalPrice") %>" required>
            </div>
            <div class="mb-3">
                <label for="status" class="form-label">Status</label>
                <select class="form-select" id="status" name="status" required>
                    <option value="Confirmed" <%= rs.getString("status").equals("Confirmed") ? "selected" : "" %>>Confirmed</option>
                    <option value="Pending" <%= rs.getString("status").equals("Pending") ? "selected" : "" %>>Pending</option>
                    <option value="Cancelled" <%= rs.getString("status").equals("Cancelled") ? "selected" : "" %>>Cancelled</option>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Update Booking</button>
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