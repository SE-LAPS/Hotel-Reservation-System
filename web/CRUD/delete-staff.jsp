<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ page import="Classes.DBConnector" %>
<%
    // Check if admin is logged in
    if (session.getAttribute("adminID") == null) {
        response.sendRedirect("../login.jsp");
        return;
    }

    int staffID = Integer.parseInt(request.getParameter("id"));
    Connection conn = null;
    PreparedStatement pstmt = null;

    try {
        conn = DBConnector.getConnection();
        String sql = "DELETE FROM staff WHERE staffID=?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, staffID);

        int result = pstmt.executeUpdate();
        if (result > 0) {
            response.sendRedirect("../manage-staff.jsp");
        } else {
            out.println("Failed to delete staff member. <a href='../manage-staff.jsp'>Go back</a>");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        out.println("An error occurred while deleting the staff member. <a href='../manage-staff.jsp'>Go back</a>");
    } finally {
        if (pstmt != null) pstmt.close();
        if (conn != null) conn.close();
    }
%>