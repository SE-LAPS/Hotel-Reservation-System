<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ page import="Classes.DBConnector" %>
<%
    // Check if admin is logged in
    if (session.getAttribute("adminID") == null) {
        response.sendRedirect("../login.jsp");
        return;
    }

    int roomID = Integer.parseInt(request.getParameter("id"));
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    if ("POST".equalsIgnoreCase(request.getMethod())) {
        String roomNumber = request.getParameter("roomNumber");
        String roomType = request.getParameter("roomType");
        int capacity = Integer.parseInt(request.getParameter("capacity"));
        double pricePerNight = Double.parseDouble(request.getParameter("pricePerNight"));
        boolean isAvailable = Boolean.parseBoolean(request.getParameter("isAvailable"));

        try {
            conn = DBConnector.getConnection();
            String sql = "UPDATE rooms SET roomNumber=?, roomType=?, capacity=?, pricePerNight=?, isAvailable=? WHERE roomID=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, roomNumber);
            pstmt.setString(2, roomType);
            pstmt.setInt(3, capacity);
            pstmt.setDouble(4, pricePerNight);
            pstmt.setBoolean(5, isAvailable);
            pstmt.setInt(6, roomID);

            int result = pstmt.executeUpdate();
            if (result > 0) {
                response.sendRedirect("../manage-rooms.jsp");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        }
    } else {
        try {
            conn = DBConnector.getConnection();
            String sql = "SELECT * FROM rooms WHERE roomID=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, roomID);
            rs = pstmt.executeQuery();

            if (rs.next()) {
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Room - Hotel del Luna</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1>Edit Room</h1>
        <form action="edit-room.jsp" method="post">
            <input type="hidden" name="id" value="<%= roomID %>">
            <div class="mb-3">
                <label for="roomNumber" class="form-label">Room Number</label>
                <input type="text" class="form-control" id="roomNumber" name="roomNumber" value="<%= rs.getString("roomNumber") %>" required>
            </div>
            <div class="mb-3">
                <label for="roomType" class="form-label">Room Type</label>
                <input type="text" class="form-control" id="roomType" name="roomType" value="<%= rs.getString("roomType") %>" required>
            </div>
            <div class="mb-3">
                <label for="capacity" class="form-label">Capacity</label>
                <input type="number" class="form-control" id="capacity" name="capacity" value="<%= rs.getInt("capacity") %>" required>
            </div>
            <div class="mb-3">
                <label for="pricePerNight" class="form-label">Price Per Night</label>
                <input type="number" step="0.01" class="form-control" id="pricePerNight" name="pricePerNight" value="<%= rs.getDouble("pricePerNight") %>" required>
            </div>
            <div class="mb-3 form-check">
                <input type="checkbox" class="form-check-input" id="isAvailable" name="isAvailable" value="true" <%= rs.getBoolean("isAvailable") ? "checked" : "" %>>
                <label class="form-check-label" for="isAvailable">Available</label>
            </div>
            <button type="submit" class="btn btn-primary">Update Room</button>
            <a href="../manage-rooms.jsp" class="btn btn-secondary">Cancel</a>
        </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
<%
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        }
    }
%>