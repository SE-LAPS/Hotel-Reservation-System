<%@page import="javax.servlet.http.Cookie"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpServletResponse"%>
<%@page import="Classes.Reservation"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String userIdStr = null;
    for (Cookie cookie : request.getCookies()) {
        if (cookie.getName().equals("userID")) {
            userIdStr = cookie.getValue();
            break;
        }
    }

    int userId = (userIdStr != null) ? Integer.parseInt(userIdStr) : 0;

    int roomType = Integer.parseInt(request.getParameter("room"));
    String checkInDate = request.getParameter("checkInDate");
    String checkOutDate = request.getParameter("checkOutDate");
    int numGuests = Integer.parseInt(request.getParameter("num_guests"));
    String specialRequests = request.getParameter("special_requests");

    Reservation res = new Reservation(roomType, checkInDate, checkOutDate, "PENDING", numGuests, specialRequests, userId);
    boolean result = res.saveReservation();
    if (result) {
        response.sendRedirect("reservationManagement.jsp?m=Booking Saved&e=false");
    } else {
        response.sendRedirect("reservationManagement.jsp?m=Error while booking&e=true");
    }
%>
