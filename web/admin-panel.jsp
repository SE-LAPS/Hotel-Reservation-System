<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="Classes.Administrator" %>
<%
    // Check if admin is logged in
    if (session.getAttribute("adminID") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Panel - Hotel del Luna</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .card {
            transition: transform 0.3s;
            height: 100%;
            display: flex;
            flex-direction: column;
        }
        .card:hover {
            transform: translateY(-5px);
        }
        .card-body {
            flex-grow: 1;
            display: flex;
            flex-direction: column;
        }
        .btn-custom {
            background:linear-gradient(69.66deg, #7f00fe 19.39%, #daf0ff 96.69%);
            border-color: #007bff;
            color: white;
            width: 100%;
            margin-top: auto;
        }
        .btn-custom:hover {
            background-color: #0056b3;
            border-color: #0056b3;
            color: white;
        }
        .card-row {
            margin-bottom: 5rem;
        }
        .welcome-heading {
            margin-bottom: 23rem;
        }
    </style>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container">
            <a class="navbar-brand" href="#">Hotel del Luna Admin</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="logout.jsp">Logout</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="container mt-5">
        <h1 class="text-center mb-5 welcome-heading">Welcome, <%= session.getAttribute("adminName") %></h1>
        <br><br><br><br>
        <div class="row row-cols-1 row-cols-md-3 g-4 justify-content-center card-row">
            <div class="col">
                <div class="card shadow">
                    <div class="card-body">
                        <h5 class="card-title">MANAGE USERS</h5>
                        <p class="card-text">Add, edit, or delete user accounts.</p>
                        <a href="manage-users.jsp" class="btn btn-custom">Go to Users</a>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="card shadow">
                    <div class="card-body">
                        <h5 class="card-title">MANAGE ROOMS</h5>
                        <p class="card-text">Add, edit, or delete room information.</p>
                        <a href="manage-rooms.jsp" class="btn btn-custom">Go to Rooms</a>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="card shadow">
                    <div class="card-body">
                        <h5 class="card-title">MANAGE BOOKINGS</h5>
                        <p class="card-text">View and manage hotel bookings.</p>
                        <a href="manage-bookings.jsp" class="btn btn-custom">Go to Bookings</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="row row-cols-1 row-cols-md-3 g-4 justify-content-center">
            <div class="col">
                <div class="card shadow">
                    <div class="card-body">
                        <h5 class="card-title">MANAGE STAFF</h5>
                        <p class="card-text">Add, edit, or delete staff information.</p>
                        <a href="manage-staff.jsp" class="btn btn-custom">Go to Staff</a>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="card shadow">
                    <div class="card-body">
                        <h5 class="card-title">REVENUE REPORTS</h5>
                        <p class="card-text">View and generate revenue reports.</p>
                        <a href="revenue-reports.jsp" class="btn btn-custom">Go to Reports</a>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="card shadow">
                    <div class="card-body">
                        <h5 class="card-title">HOTEL SETTINGS</h5>
                        <p class="card-text">Manage hotel settings and configurations.</p>
                        <a href="hotel-settings.jsp" class="btn btn-custom">Go to Settings</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>