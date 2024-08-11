<%-- 
    Document   : cancelReservation
    Created on : Aug 6, 2024, 8:59:25 PM
    Author     : Chethana
--%>

<%@page import="Classes.Reservation"%>
<%@page import="Classes.DBConnector"%>
<%@page import="java.sql.Connection"%>
<%
    int reservationId = Integer.parseInt(request.getParameter("reservationId"));

    Connection con = DBConnector.getConnection();
    Reservation reservation = new Reservation();
    reservation.setResId(reservationId);

    if (reservation.deleteReservation(con)) {
        response.sendRedirect("./reservationManagement.jsp?delete=1");
    } else {
        response.sendRedirect("./reservationManagement.jsp?delete=1");
    }
%>