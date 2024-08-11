<%@ page import="Classes.Administrator" %>
<%@ page import="Classes.MD5" %>
<%
    String email = request.getParameter("email");
    String password = MD5.getMd5(request.getParameter("password"));

    Administrator admin = Administrator.login(email, password);

    if (admin != null) {
        // Create session attributes
        session.setAttribute("adminID", admin.getAdminID());
        session.setAttribute("adminName", admin.getUserName());
        session.setAttribute("adminEmail", admin.getEmail());

        // Redirect to admin panel
        response.sendRedirect("admin-panel.jsp");
    } else {
        // Authentication failed, redirect to login page with error
        response.sendRedirect("login.jsp?error=invalid");
    }
%>