package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class roomTypes_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <title>Hotel Room Types</title>\n");
      out.write("       <link href=\"https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <style>\n");
      out.write("            .card-img-top {\n");
      out.write("                height: 200px;\n");
      out.write("                object-fit: cover;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("            <nav class=\"navbar navbar-expand-lg bg-dark text-light\">\n");
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
      out.write("                    <a class=\"nav-link text-light\" href=\"booking.jsp\">Bookings</a>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a class=\"nav-link text-light\" href=\"reservationManagement.jsp\">Reservation Management</a>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a class=\"nav-link text-light\" href=\"login.jsp\">Logout</a>\n");
      out.write("                </li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</nav>\n");
      out.write("    <body>\n");
      out.write("         <script src=\"https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("        <div class=\"d-flex justify-content-center align-items-center \">\n");
      out.write("            <div class=\"container text-center ml-3\">\n");
      out.write("                <h1 class=\"text-center mb-4 mt-5\">Hotel Room Types</h1>\n");
      out.write("                <div class=\"row justify-content-center\">\n");
      out.write("                    <div class=\"col-md-4 mb-4\">\n");
      out.write("                        <div class=\"card shadow-sm\">\n");
      out.write("                            <h2 class=\"card-title\">Single Room</h2>\n");
      out.write("                            <p class=\"card-text\">Accommodates 1 person.</p> \n");
      out.write("                            <p>A comfortable room for solo travelers, featuring modern amenities and a cozy ambiance.</p>\n");
      out.write("                            <img src=\"https://www.hotelmonterey.co.jp/upload_file/monhtyo/stay/sng_600_001.jpg\" class=\"card-img-top\" alt=\"Single Room\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("                    <div class=\"col-md-4 mb-4\">\n");
      out.write("                        <div class=\"card shadow-sm\">\n");
      out.write("                            <h2 class=\"card-title\">Twin Room</h2>\n");
      out.write("                            <p class=\"card-text\">Accommodates 2 people.</p>\n");
      out.write("                            <p>Features two single beds, ideal for friends or colleagues sharing a room.</p>\n");
      out.write("                            <img src=\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRhG4lXR2davEwBLgwfHdKu7tCyTIcUJP25Pg&s\" class=\"card-img-top\" alt=\"Twin Room\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"col-md-4 mb-4\">\n");
      out.write("                        <div class=\"card shadow-sm\">\n");
      out.write("                            <h2 class=\"card-title\">Double Room</h2>\n");
      out.write("                            <p class=\"card-text\">Accommodates 2 people.</p>\n");
      out.write("                            <p>A room with a double bed, perfect for couples or a small family.</p>                 \n");
      out.write("                            <img src=\"https://www.collinsdictionary.com/images/full/doubleroom_564885484_1000.jpg\" class=\"card-img-top\" alt=\"Double Room\">       \n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"col-md-4 mb-4\">\n");
      out.write("                        <div class=\"card shadow-sm\">\n");
      out.write("                            <h2 class=\"card-title\">Triple Room</h2>\n");
      out.write("                            <p class=\"card-text\">Accommodates 3 people.</p>\n");
      out.write("                            <p>Includes three beds or a combination of a double bed and a single bed.</p>\n");
      out.write("                            <img src=\"https://www.granviakyoto.com/rooms/assets_c/2020/03/t_01-thumb-960xauto-1093.jpg\" class=\"card-img-top\" alt=\"Triple Room\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"col-md-4 mb-4\">\n");
      out.write("                        <div class=\"card shadow-sm\">\n");
      out.write("                            <h2 class=\"card-title\">Deluxe Room</h2>\n");
      out.write("                            <p class=\"card-text\">Accommodates 2 people.</p>\n");
      out.write("                            <p>A luxurious room with upscale amenities and extra space for comfort.</p>                     \n");
      out.write("                            <img src=\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSQzGTijzYYXZFz9M6K4dh4p5flFe4tM1f8vQ&s\" class=\"card-img-top\" alt=\"Deluxe Room\">                         \n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"col-md-4 mb-4\">\n");
      out.write("                        <div class=\"card shadow-sm\">\n");
      out.write("                            <h2 class=\"card-title\">Suite</h2>\n");
      out.write("                            <p class=\"card-text\">Accommodates 4 people.</p>\n");
      out.write("                            <p>A spacious and elegant suite with separate living and sleeping areas.</p>                     \n");
      out.write("                            <img src=\"https://www.suriyaresorts.com/wp-content/uploads/2022/03/suviteroom1-1-1170x680.jpg\" class=\"card-img-top\" alt=\"Suite\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-rbsA+U0PpS51K9GTTOaXhR0kK9KsZwZ63ebA/8LX16XT7kjFvHPGBwHJxGOSVTEz\" crossorigin=\"anonymous\"></script>\n");
      out.write("     ");
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
