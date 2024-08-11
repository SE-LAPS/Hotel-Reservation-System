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

    try {
        conn = DBConnector.getConnection();
        
        // Delete booking
        String sql = "DELETE FROM bookings WHERE bookingID = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, bookingID);
        int rowsAffected = pstmt.executeUpdate();
        
        if (rowsAffected > 0) {
            // Booking deleted successfully
            response.sendRedirect("../manage-bookings.jsp?message=Booking+deleted+successfully");
        } else {
            // Booking not found or couldn't be deleted
            response.sendRedirect("../manage-bookings.jsp?error=Failed+to+delete+booking");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        response.sendRedirect("../manage-bookings.jsp?error=Database+error");
    } finally {
        // Close resources
        try {
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
%>