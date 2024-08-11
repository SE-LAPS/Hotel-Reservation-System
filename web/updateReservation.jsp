<%-- 
    Document   : updateReservation
    Created on : Aug 6, 2024, 8:37:54 PM
    Author     : Chethana
--%>

<%@page import="Classes.Reservation"%>
<%@page import="Classes.DBConnector"%>
<%@page import="java.sql.Connection"%>
<%
    int reservationId = Integer.parseInt(request.getParameter("reservationId"));
    int room = Integer.parseInt(request.getParameter("room"));
    String checkInDate = request.getParameter("checkInDate");
    String checkOutDate = request.getParameter("checkOutDate");
    String status = request.getParameter("status");

    Connection con = DBConnector.getConnection();
    Reservation reservation = new Reservation();
    reservation.setResId(reservationId);
    reservation.setRoom(room);
    reservation.setCheckInDate(checkInDate);
    reservation.setCheckOutDate(checkOutDate);
    reservation.setStatus(status);

    if (reservation.updateReservation(con)) {
        response.sendRedirect("./reservationManagement.jsp?edit=1");
    } else {
        response.sendRedirect("./reservationManagement.jsp?edit=2");
    }
%>