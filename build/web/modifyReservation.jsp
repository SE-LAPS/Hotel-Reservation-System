<%@ page import="java.sql.Connection, java.sql.PreparedStatement, java.sql.ResultSet, java.sql.SQLException" %>
<%@ page import="Classes.DBConnector" %>
<%@ page import="Classes.Reservation" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Modify Reservation</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
         <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">
            <img src="https://img.jakpost.net/c/2020/06/24/2020_06_24_98632_1592993564._large.jpg" alt="Hotel Logo" width="160" height="100" class="d-inline-block align-text-top">
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link text-light" href="booking.jsp">Bookings</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-light" href="reservationManagement.jsp">Reservation Management</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-light" href="roomTypes.jsp">Room Types</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-light" href="logout.jsp">Logout</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

        <div class="container mt-5">
            <h1 class="mb-4">Modify Reservation</h1>
            <%
                int reservationId = Integer.parseInt(request.getParameter("reservationId"));
                Connection con = DBConnector.getConnection();
                Reservation reservation = new Reservation();
                reservation.setResId(reservationId);
                reservation.getAReservation(con);
                if (reservation != null) {
            %>
            <form action="updateReservation.jsp" method="POST">
                <input type="hidden" name="reservationId" value="<%= reservation.getResId()%>"/>
                <input type="hidden" name="status" value="<%= reservation.getStatus()%>"/>

                <div class="mb-3">
                    <label for="room" class="form-label">Room</label>
                    <input type="number" class="form-control" id="room" name="room" value="<%= reservation.getRoom()%>" required>
                </div>
                <div class="mb-3">
                    <label for="checkInDate" class="form-label">Check-in Date</label>
                    <input type="date" class="form-control" id="checkInDate" name="checkInDate" value="<%= reservation.getCheckInDate()%>" required>
                </div>
                <div class="mb-3">
                    <label for="checkOutDate" class="form-label">Check-out Date</label>
                    <input type="date" class="form-control" id="checkOutDate" name="checkOutDate" value="<%= reservation.getCheckOutDate()%>" required>
                </div>
                <div class="mb-3">
                    <label for="numGuests" class="form-label">Number of Guests</label>
                    <input type="number" class="form-control" id="numGuests" name="numGuests" value="<%= reservation.getNum_guests()%>" required>
                </div>
                <div class="mb-4">
                    <label for="specialRequests" class="form-label">Special Requests</label>
                    <textarea class="form-control" id="specialRequests" name="specialRequests" rows="3" required><%= reservation.getSpecial_requests()%></textarea>
                </div>
                <button type="submit" class="btn btn-primary">Update Reservation</button>
            </form>
            <%
                } else {
                    out.println("<div class='alert alert-danger'>Reservation not found.</div>");
                }
            %>
        </div>
         <%@ include file="footer.jsp" %>
    </body>
</html>
