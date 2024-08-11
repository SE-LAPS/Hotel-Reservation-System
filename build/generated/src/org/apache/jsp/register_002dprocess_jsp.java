package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import Classes.User;
import Classes.DBConnector;
import javax.servlet.http.*;
import javax.servlet.*;
import Classes.MD5;

public final class register_002dprocess_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");

    // Retrieve form parameters
    String firstName = request.getParameter("firstname");
    String lastName = request.getParameter("lastname");
    String email = request.getParameter("email");
    String password = MD5.getMd5(request.getParameter("password"));
    String confirmPassword = MD5.getMd5(request.getParameter("confirmpassword"));

    // Check if password and confirm password match
    if (!password.equals(confirmPassword)) {
        out.println("<div class='alert alert-danger' role='alert'>Passwords do not match. Please try again.</div>");
        out.println("<a href='register.jsp' class='btn btn-primary'>Go Back</a>");
    } else {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            // Establish connection to the database
            conn = DBConnector.getConnection();

            // Create a User object to register
            User user = new User(0, firstName + " " + lastName, password, email, "USER"); // Default role is USER

            // Register the user
            boolean success = user.register(firstName, lastName, email, password, "USER");

            if (success) {
                // Registration successful
                response.sendRedirect("login.jsp");
            } else {
                // Registration failed
                out.println("<div class='alert alert-danger' role='alert'>Registration failed. Please try again later.</div>");
            }
        } catch (Exception e) {
            // Handle SQL exceptions
            e.printStackTrace();
            out.println("<div class='alert alert-danger' role='alert'>An error occurred. Please try again later.</div>");
        } finally {
            // Close resources
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
