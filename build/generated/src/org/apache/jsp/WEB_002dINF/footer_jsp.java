package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class footer_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>Hotel del Luna</title>\n");
      out.write("    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <h1>hello</h1>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <footer class=\"bg-dark text-light py-4 mt-4\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-md-4\">\n");
      out.write("                    <h5>Hotel del Luna</h5>\n");
      out.write("                    <p>Experience luxury and mystery at our otherworldly hotel.</p>\n");
      out.write("                    <p>123 Moonlight Avenue<br>NuwaraEliya, Sri Lanka</p>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-4\">\n");
      out.write("                    <h5>Contact Us</h5>\n");
      out.write("                    <p>Phone: +82 2 1234 5678<br>\n");
      out.write("                    Email: info@hoteldelluna.com</p>\n");
      out.write("                    <p>Open 24/7 for supernatural guests</p>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-4\">\n");
      out.write("                    <img src=\"https://img.jakpost.net/c/2020/06/24/2020_06_24_98632_1592993564._large.jpg\" alt=\"Hotel del Luna\" class=\"img-fluid rounded\" style=\"max-height: 150px;\">\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"row mt-3\">\n");
      out.write("                <div class=\"col-12 text-center\">\n");
      out.write("                    <small>&copy; 2024 Hotel del Luna. All rights reserved.</small>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </footer>\n");
      out.write("\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("</body>\n");
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
