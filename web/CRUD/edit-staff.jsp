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
    ResultSet rs = null;

    if ("POST".equalsIgnoreCase(request.getMethod())) {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String position = request.getParameter("position");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String hireDate = request.getParameter("hireDate");

        try {
            conn = DBConnector.getConnection();
            String sql = "UPDATE staff SET firstName=?, lastName=?, position=?, email=?, phoneNumber=?, hireDate=? WHERE staffID=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, position);
            pstmt.setString(4, email);
            pstmt.setString(5, phoneNumber);
            pstmt.setDate(6, java.sql.Date.valueOf(hireDate));
            pstmt.setInt(7, staffID);

            int result = pstmt.executeUpdate();
            if (result > 0) {
                response.sendRedirect("../manage-staff.jsp");
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
            String sql = "SELECT * FROM staff WHERE staffID=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, staffID);
            rs = pstmt.executeQuery();

            if (rs.next()) {
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Staff Member - Hotel del Luna</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1>Edit Staff Member</h1>
        <form action="edit-staff.jsp" method="post">
            <input type="hidden" name="id" value="<%= staffID %>">
            <div class="mb-3">
                <label for="firstName" class="form-label">First Name</label>
                <input type="text" class="form-control" id="firstName" name="firstName" value="<%= rs.getString("firstName") %>" required>
            </div>
            <div class="mb-3">
                <label for="lastName" class="form-label">Last Name</label>
                <input type="text" class="form-control" id="lastName" name="lastName" value="<%= rs.getString("lastName") %>" required>
            </div>
            <div class="mb-3">
                <label for="position" class="form-label">Position</label>
                <input type="text" class="form-control" id="position" name="position" value="<%= rs.getString("position") %>" required>
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="email" class="form-control" id="email" name="email" value="<%= rs.getString("email") %>" required>
            </div>
            <div class="mb-3">
                <label for="phoneNumber" class="form-label">Phone Number</label>
                <input type="tel" class="form-control" id="phoneNumber" name="phoneNumber" value="<%= rs.getString("phoneNumber") %>" required>
            </div>
            <div class="mb-3">
                <label for="hireDate" class="form-label">Hire Date</label>
                <input type="date" class="form-control" id="hireDate" name="hireDate" value="<%= rs.getDate("hireDate") %>" required>
            </div>
            <button type="submit" class="btn btn-primary">Update Staff Member</button>
            <a href="../manage-staff.jsp" class="btn btn-secondary">Cancel</a>
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