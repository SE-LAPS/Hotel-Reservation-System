<%@page import="java.sql.Connection"%>
<%@page import="javax.servlet.http.Cookie"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpServletResponse"%>
<%@page import="java.util.List"%>
<%@page import="Classes.Reservation"%>
<%@page import="Classes.DBConnector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Reservation Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
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
        <h1 class="mb-4">Reservation Management</h1>
        <%
            String userIdStr = null;
            for (Cookie cookie : request.getCookies()) {
                if (cookie.getName().equals("userID")) {
                    userIdStr = cookie.getValue();
                    break;
                }
            }

            int userId = (userIdStr != null) ? Integer.parseInt(userIdStr) : 0;

            if(request.getParameter("m") != null && request.getParameter("e") != null) {
                out.print("<div class='alert alert-success alert-dismissible fade show' role='alert'>");
                out.print(request.getParameter("m"));
                out.print("</div>");
            }
            %>
        <%
            Connection con = DBConnector.getConnection();
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
        %>
       <div class="table-responsive">
    <table class="table table-striped">
        <thead>
            <tr>
                <th>Reservation ID</th>
                <th>Room</th>
                <th>Check-in Date</th>
                <th>Check-out Date</th>
                <th>Status</th>
                <th>Number of Guests</th>
                <th>Special Requests</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <% for (Reservation r : reservations) { %>
            <tr>
                <td><%= r.getResId() %></td>
                <td><%= r.getRoom() %></td>
                <td><%= r.getCheckInDate() %></td>
                <td><%= r.getCheckOutDate() %></td>
                <td><%= r.getStatus() %></td>
                <td><%= r.getNum_guests() %></td>
                <td><%= r.getSpecial_requests() %></td>
                <td>
                    <form action="modifyReservation.jsp" method="POST" style="display:inline;">
                        <input type="hidden" name="reservationId" value="<%= r.getResId() %>"/>
                        <button type="submit" class="btn btn-primary"><i class="far fa-edit"></i></button>
                    </form>
                    <form action="cancelReservation.jsp" method="POST" style="display:inline;">
                        <input type="hidden" name="reservationId" value="<%= r.getResId() %>"/>
                        <button type="submit" class="btn btn-danger"><i class="fas fa-trash"></i></button>
                    </form>
                </td>
            </tr>
            <% } %>
        </tbody>
    </table>
</div>

    </div>
    <%@ include file="footer.jsp" %>
</body>
</html>
