package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Classes.User;
import Classes.MD5;

public final class login_002dprocess_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write(" \n");

    String email = request.getParameter("email");
    String password = MD5.getMd5(request.getParameter("password"));
    String rm = request.getParameter("rememberme");

    User user = new User(0, "", "", "", "USER");
//    // Perform login
    boolean isAuthenticated = user.login(email, password);

//out.println(password);
//
    if (isAuthenticated) {
        // Create cookies to store user information

        Cookie userIDCookie = new Cookie("userID", String.valueOf(user.getUserID()));
        Cookie userNameCookie = new Cookie("userName", user.getUserName());
        Cookie userEmailCookie = new Cookie("userEmail", user.getEmail());
        Cookie authTokenCookie = new Cookie("authToken", user.getToken());
        if (rm == "on") {
            // Set cookie attributes
            userIDCookie.setMaxAge(60 * 60 * 24 * 30); // 30 day
            userNameCookie.setMaxAge(60 * 60 * 24 * 30);
            userEmailCookie.setMaxAge(60 * 60 * 24 * 30);
            authTokenCookie.setMaxAge(60 * 60 * 24 * 30);
        } else {
            userIDCookie.setMaxAge(60 * 60); // 1 hour
            userNameCookie.setMaxAge(60 * 60);
            userEmailCookie.setMaxAge(60 * 60);
            authTokenCookie.setMaxAge(60 * 60);
        }
        // Add cookies to response
        response.addCookie(userIDCookie);
        response.addCookie(userNameCookie);
        response.addCookie(userEmailCookie);
        response.addCookie(authTokenCookie);

        // Redirect to home page or user dashboard
        if (user.getRole() == "ADMIN") {

            response.sendRedirect("admin.jsp"); // Modify this as needed
        } else {

            response.sendRedirect("booking.jsp"); // Modify this as needed
        }
    } else {
        // Authentication failed, redirect to login page with error
        response.sendRedirect("login.jsp?error=invalid"); // Modify this as needed
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
