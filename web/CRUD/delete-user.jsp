<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ page import="Classes.DBConnector" %>
<%
    // Check if admin is logged in
    if (session.getAttribute("adminID") == null) {
        response.sendRedirect("../login.jsp");
        return;
    }

    int userID = Integer.parseInt(request.getParameter("id"));
    Connection conn = null;
    PreparedStatement pstmt = null;

    try {
        conn = DBConnector.getConnection();
        String sql = "DELETE FROM users WHERE userID=?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, userID);

        int result = pstmt.executeUpdate();
        if (result > 0) {
            response.sendRedirect("../manage-users.jsp");
        } else {
            out.println("Failed to delete user. <a href='../manage-users.jsp'>Go back</a>");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        out.println("An error occurred while deleting the user. <a href='../manage-users.jsp'>Go back</a>");
    } finally {
        if (pstmt != null) pstmt.close();
        if (conn != null) conn.close();
    }
%>