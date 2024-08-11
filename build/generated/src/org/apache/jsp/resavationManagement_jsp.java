package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import Classes.Reservation;
import Classes.DBConnector;
import java.sql.Connection;

public final class resavationManagement_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/navbar.jsp");
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <title>Reservation Management</title>\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("        <link href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css\" rel=\"stylesheet\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("</head>\n");
      out.write("<nav class=\"navbar navbar-expand-lg bg-dark text-light\">\n");
      out.write("    <div class=\"container-fluid\">\n");
      out.write("        <a class=\"navbar-brand\" href=\"#\">\n");
      out.write("            <img src=\"https://img.jakpost.net/c/2020/06/24/2020_06_24_98632_1592993564._large.jpg\" alt=\"Hotel Logo\" width=\"160\" height=\"100\" class=\"d-inline-block align-text-top\">\n");
      out.write("        </a>\n");
      out.write("        <button class=\"navbar-toggler custom-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarNav\" aria-controls=\"navbarNav\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("            <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("        </button>\n");
      out.write("        <div class=\"collapse navbar-collapse\" id=\"navbarNav\">\n");
      out.write("            <ul class=\"navbar-nav ms-auto\">\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a class=\"nav-link text-light\" href=\"#\">Room types</a>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a class=\"nav-link text-light\" href=\"#\">Reservation Management</a>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a class=\"nav-link text-light\" href=\"#\">Logout</a>\n");
      out.write("                </li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</nav>\n");
      out.write("\n");
      out.write("</html>");
      out.write("\n");
      out.write("        <div class=\"container mt-5\">\n");
      out.write("            <h1 class=\"mb-4\">Reservation Management</h1>\n");
      out.write("            ");

                Connection con = DBConnector.getConnection();
//                int userId = Integer.parseInt(String.valueOf(session.getAttribute("UserID")));
                int userId = 1;
                Reservation reservation = new Reservation();
                List<Reservation> reservations = reservation.getUserReservations(con, userId);
                if (request.getParameter("edit") != null) {
                    String edit = request.getParameter("edit");
                    if (edit.equals("1")) {
                        out.print("<div class='alert alert-success alert-dismissible fade show' role='alert'>");
                        out.print("<strong>Booking Edited Successfully.</strong>");
                        out.print("<button type='button' class='btn-close' data-bs-dismiss='alert' aria-label='Close'></button>");
                        out.print("</div>");
                    } else if (edit.equals("2")) {
                        out.print("<div class='alert alert-danger alert-dismissible fade show' role='alert'>");
                        out.print("<strong>Booking Edit Failed.</strong>");
                        out.print("<button type='button' class='btn-close' data-bs-dismiss='alert' aria-label='Close'></button>");
                        out.print("</div>");
                    }
                }
                
                if (request.getParameter("delete") != null) {
                    String delete = request.getParameter("delete");
                    if (delete.equals("1")) {
                        out.print("<div class='alert alert-success alert-dismissible fade show' role='alert'>");
                        out.print("<strong>Booking Deleted Successfully.</strong>");
                        out.print("<button type='button' class='btn-close' data-bs-dismiss='alert' aria-label='Close'></button>");
                        out.print("</div>");
                    } else if (delete.equals("2")) {
                        out.print("<div class='alert alert-danger alert-dismissible fade show' role='alert'>");
                        out.print("<strong>Booking Deletion Failed.</strong>");
                        out.print("<button type='button' class='btn-close' data-bs-dismiss='alert' aria-label='Close'></button>");
                        out.print("</div>");
                    }
                }
            
      out.write("\n");
      out.write("            <table class=\"table table-striped\">\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th>Reservation ID</th>\n");
      out.write("                        <th>Room</th>\n");
      out.write("                        <th>Check-in Date</th>\n");
      out.write("                        <th>Check-out Date</th>\n");
      out.write("                        <th>Status</th>\n");
      out.write("                        <th>Actions</th>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                    ");
 for (Reservation r : reservations) {
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td>");
      out.print( r.getResId());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( r.getRoom());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( r.getCheckInDate());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( r.getCheckOutDate());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( r.getStatus());
      out.write("</td>\n");
      out.write("                        <td>\n");
      out.write("                            <form action=\"modifyReservation.jsp\" method=\"POST\" style=\"display:inline;\">\n");
      out.write("                                <input type=\"hidden\" name=\"reservationId\" value=\"");
      out.print( r.getResId());
      out.write("\"/>\n");
      out.write("                                <button type=\"submit\" class=\"btn btn-primary\"><i class=\"far fa-edit\"></i></button>\n");
      out.write("                            </form>\n");
      out.write("                            <form action=\"cancelReservation.jsp\" method=\"POST\" style=\"display:inline;\">\n");
      out.write("                                <input type=\"hidden\" name=\"reservationId\" value=\"");
      out.print( r.getResId());
      out.write("\"/>\n");
      out.write("                                <button type=\"submit\" class=\"btn btn-danger\"><i class=\"fas fa-trash\"></i></button>\n");
      out.write("                            </form>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    ");
 }
      out.write("\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("                ");
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
      out.write("    </body>\n");
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
