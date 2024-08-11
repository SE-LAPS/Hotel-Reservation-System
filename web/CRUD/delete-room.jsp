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

    try {
        conn = DBConnector.getConnection();
        String sql = "DELETE FROM rooms WHERE roomID=?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, roomID);

        int result = pstmt.executeUpdate();
        if (result > 0) {
            response.sendRedirect("../manage-rooms.jsp");
        } else {
            out.println("Failed to delete room. <a href='../manage-rooms.jsp'>Go back</a>");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        out.println("An error occurred while deleting the room. <a href='../manage-rooms.jsp'>Go back</a>");
    } finally {
        if (pstmt != null) pstmt.close();
        if (conn != null) conn.close();
    }
%>