package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.Cookie;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/footer.jsp");
  }

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
      response.setContentType("text/html;charset=UTF-8");
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

    // Retrieve all cookies from the request
    Cookie[] cookies = request.getCookies();
    String userID = null;
    String userName = null;
    String userEmail = null;
    String authToken = null;

    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if ("userID".equals(cookie.getName())) {
                userID = cookie.getValue();
            } else if ("userName".equals(cookie.getName())) {
                userName = cookie.getValue();
            } else if ("userEmail".equals(cookie.getName())) {
                userEmail = cookie.getValue();
            } else if ("authToken".equals(cookie.getName())) {
                authToken = cookie.getValue();
            }
        }
    }

    // Check if the user is already logged in by verifying the cookies
    if (userID != null && userName != null && userEmail != null && authToken != null) {
        // User is already logged in, redirect to the appropriate page
        // (e.g., dashboard or booking page based on user role)
        response.sendRedirect("logout.jsp");
    }

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\n");
      out.write("              integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\" crossorigin=\"anonymous\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css\">\n");
      out.write("        <title>Login - Hotel del Luna</title>\n");
      out.write("    </head>\n");
      out.write("    <nav class=\"navbar navbar-expand-lg bg-dark text-light\">\n");
      out.write("    <div class=\"container-fluid\">\n");
      out.write("        <a class=\"navbar-brand\" href=\"#\">\n");
      out.write("            <img src=\"https://img.jakpost.net/c/2020/06/24/2020_06_24_98632_1592993564._large.jpg\" alt=\"Hotel Logo\" width=\"160\" height=\"100\" class=\"d-inline-block align-text-top\">\n");
      out.write("        </a>\n");
      out.write("        <button class=\"navbar-toggler custom-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarNav\" aria-controls=\"navbarNav\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("            <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("        </button>\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("</nav>\n");
      out.write("    <body class=\"d-flex flex-column min-vh-100\" style=\"background-color: #f0f0f0;\">   \n");
      out.write("        <main class=\"flex-grow-1 d-flex align-items-center\">\n");
      out.write("            <div class=\"container py-5\">\n");
      out.write("                <div class=\"row justify-content-center\">\n");
      out.write("                    <div class=\"col-12 col-sm-10 col-md-8 col-lg-6 col-xl-5 col-xxl-4\">\n");
      out.write("                        <div class=\"card border-dark rounded-4 shadow\">\n");
      out.write("                            <div class=\"card-body p-4 p-sm-5\">\n");
      out.write("                                <h1 class=\"text-center mb-4\">Welcome!</h1>\n");
      out.write("                                <p class=\"text-center mb-4\">Please enter your credentials</p>\n");
      out.write("                                <form action=\"login-process.jsp\" method=\"post\">\n");
      out.write("                                    <div class=\"mb-3\">\n");
      out.write("                                        <label for=\"email\" class=\"form-label\"><strong>Email</strong> <span class=\"text-danger\">*</span></label>\n");
      out.write("                                        <input type=\"email\" class=\"form-control\" id=\"email\" name=\"email\" placeholder=\"example@someone.com\" required>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"mb-3\">\n");
      out.write("                                        <label for=\"password\" class=\"form-label\"><strong>Password</strong> <span class=\"text-danger\">*</span></label>\n");
      out.write("                                        <div class=\"input-group\">\n");
      out.write("                                            <input type=\"password\" class=\"form-control\" id=\"password\" name=\"password\" required>\n");
      out.write("                                            <button class=\"btn btn-outline-secondary\" type=\"button\" onclick=\"togglePasswordVisibility()\">\n");
      out.write("                                                <i class=\"bi bi-eye\" id=\"toggleIcon\"></i>\n");
      out.write("                                            </button>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"mb-4 form-check\">\n");
      out.write("                                        <input type=\"checkbox\" class=\"form-check-input\" id=\"remember\" name=\"rememberme\">\n");
      out.write("                                        <label class=\"form-check-label\" for=\"remember\">Remember me</label>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"d-grid gap-2\">\n");
      out.write("                                        <button class=\"btn btn-primary btn-lg\" type=\"submit\">Log in</button>\n");
      out.write("                                    </div>\n");
      out.write("                                </form>\n");
      out.write("                                <p class=\"text-center mt-4 mb-0\">Don't have an account? <a href=\"register.jsp\">Sign up</a></p>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </main>\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <title>Hotel del Luna</title>\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("        </div>\n");
      out.write("     <footer class=\"bg-dark text-light py-4 mt-4\">\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-md-3\">  \n");
      out.write("                <img src=\"https://img.jakpost.net/c/2020/06/24/2020_06_24_98632_1592993564._large.jpg\" alt=\"Hotel del Luna\" class=\"img-fluid rounded\" style=\"max-height: 150px;\">\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-md-4\">\n");
      out.write("                <h5>Contact Us</h5>\n");
      out.write("                <p>Phone: +82 2 1234 5678<br>\n");
      out.write("                Email: info@hoteldelluna.com</p>\n");
      out.write("                <p>Open 24/7 for supernatural guests</p>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-md-5\">\n");
      out.write("                <h5>Hotel del Luna</h5>\n");
      out.write("                <p>Experience luxury and mystery at our otherworldly hotel.</p>\n");
      out.write("                <p>123 Moonlight Avenue<br>NuwaraEliya, Sri Lanka</p>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"row mt-3\">\n");
      out.write("            <div class=\"col-12 text-center\">\n");
      out.write("                <small>&copy; 2024 Hotel del Luna. All rights reserved.</small>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</footer>\n");
      out.write("      <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>");
      out.write("\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js\"\n");
      out.write("                integrity=\"sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz\"\n");
      out.write("                crossorigin=\"anonymous\"></script>\n");
      out.write("        <script>\n");
      out.write("            function togglePasswordVisibility() {\n");
      out.write("                var passwordInput = document.getElementById('password');\n");
      out.write("                var toggleIcon = document.getElementById('toggleIcon');\n");
      out.write("                if (passwordInput.type === 'password') {\n");
      out.write("                    passwordInput.type = 'text';\n");
      out.write("                    toggleIcon.classList.remove('bi-eye');\n");
      out.write("                    toggleIcon.classList.add('bi-eye-slash');\n");
      out.write("                } else {\n");
      out.write("                    passwordInput.type = 'password';\n");
      out.write("                    toggleIcon.classList.remove('bi-eye-slash');\n");
      out.write("                    toggleIcon.classList.add('bi-eye');\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>");
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
