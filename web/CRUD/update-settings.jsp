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

    try {
        conn = DBConnector.getConnection();
        String sql = "UPDATE hotel_settings SET settingValue = ?, lastUpdated = NOW() WHERE settingName = ?";
        pstmt = conn.prepareStatement(sql);

        // Get all parameter names
        java.util.Enumeration<String> parameterNames = request.getParameterNames();

        // Iterate through all parameters and update the database
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            String paramValue = request.getParameter(paramName);

            pstmt.setString(1, paramValue);
            pstmt.setString(2, paramName);
            pstmt.executeUpdate();
        }

        // Redirect back to the hotel settings page with a success message
        response.sendRedirect("hotel-settings.jsp?success=true");
    } catch (SQLException e) {
        e.printStackTrace();
        // Redirect back to the hotel settings page with an error message
        response.sendRedirect("hotel-settings.jsp?error=true");
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