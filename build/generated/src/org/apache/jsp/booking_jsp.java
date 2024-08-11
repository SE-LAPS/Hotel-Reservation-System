package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class booking_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("    <title>Hotel Room Booking</title>\n");
      out.write("    <link href=\"https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("</head>\n");
      out.write("<body class=\"d-flex flex-column min-vh-100\">\n");
      out.write("    <nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("            <a class=\"navbar-brand\" href=\"#\">\n");
      out.write("                <img src=\"https://img.jakpost.net/c/2020/06/24/2020_06_24_98632_1592993564._large.jpg\" alt=\"Hotel Logo\" width=\"160\" height=\"100\" class=\"d-inline-block align-text-top\">\n");
      out.write("            </a>\n");
      out.write("            <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarNav\" aria-controls=\"navbarNav\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("            </button>\n");
      out.write("            <div class=\"collapse navbar-collapse justify-content-end\" id=\"navbarNav\">\n");
      out.write("                <ul class=\"navbar-nav\">\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"nav-link text-light\" href=\"roomTypes.jsp\">Room Types</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"nav-link text-light\" href=\"reservationManagement.jsp\">Reservation Management</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"nav-link text-light\" href=\"logout.jsp\">Logout</a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </nav>\n");
      out.write("    <main class=\"flex-grow-1\">\n");
      out.write("        <div class=\"container py-4 py-md-5\">\n");
      out.write("            <div class=\"row justify-content-center\">\n");
      out.write("                <div class=\"col-12 col-md-10 col-lg-8 col-xl-6\">\n");
      out.write("                    <div class=\"card border-dark rounded-4 shadow\">\n");
      out.write("                        <div class=\"card-body p-4 p-md-5\">\n");
      out.write("                            <h1 class=\"card-title text-center mb-4\">Hotel Room Booking</h1>\n");
      out.write("                            <form action=\"process-booking.jsp\" method=\"post\">\n");
      out.write("                                <div class=\"mb-3\">\n");
      out.write("                                    <label for=\"roomType\" class=\"form-label\">Room Types</label>\n");
      out.write("                                    <select class=\"form-select\" id=\"roomType\" name=\"room\" required>\n");
      out.write("                                        <option value=\"\">Select a Room Type</option>\n");
      out.write("                                        <option value=\"1\">Single Room</option>\n");
      out.write("                                        <option value=\"2\">Twin Room</option>\n");
      out.write("                                        <option value=\"3\">Double Room</option>\n");
      out.write("                                        <option value=\"4\">Triple Room</option>\n");
      out.write("                                        <option value=\"5\">Deluxe Room</option>\n");
      out.write("                                        <option value=\"6\">Suite</option>\n");
      out.write("                                    </select>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"row mb-3\">\n");
      out.write("                                    <div class=\"col-md-6 mb-3 mb-md-0\">\n");
      out.write("                                        <label for=\"checkInDate\" class=\"form-label\">Check-in Date</label>\n");
      out.write("                                        <input type=\"date\" class=\"form-control\" id=\"checkInDate\" name=\"checkInDate\" required>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-md-6\">\n");
      out.write("                                        <label for=\"checkOutDate\" class=\"form-label\">Check-out Date</label>\n");
      out.write("                                        <input type=\"date\" class=\"form-control\" id=\"checkOutDate\" name=\"checkOutDate\" required>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"mb-3\">\n");
      out.write("                                    <label for=\"numGuests\" class=\"form-label\">Number of Guests</label>\n");
      out.write("                                    <input type=\"number\" class=\"form-control\" id=\"numGuests\" name=\"num_guests\" min=\"1\" required>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"mb-4\">\n");
      out.write("                                    <label for=\"specialRequests\" class=\"form-label\">Special Requests</label>\n");
      out.write("                                    <textarea class=\"form-control\" id=\"specialRequests\" name=\"special_requests\" rows=\"3\"></textarea>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"d-grid\">\n");
      out.write("                                    <button type=\"submit\" class=\"btn btn-primary btn-lg\">Book Room</button>\n");
      out.write("                                </div>\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </main>\n");
      out.write("    ");
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
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("</body>\n");
      out.write("</html>\n");
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
