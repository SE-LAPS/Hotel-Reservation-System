<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Hotel Room Booking</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="d-flex flex-column min-vh-100">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">
                <img src="https://img.jakpost.net/c/2020/06/24/2020_06_24_98632_1592993564._large.jpg" alt="Hotel Logo" width="160" height="100" class="d-inline-block align-text-top">
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link text-light" href="roomTypes.jsp">Room Types</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-light" href="reservationManagement.jsp">Reservation Management</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-light" href="logout.jsp">Logout</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <main class="flex-grow-1">
        <div class="container py-4 py-md-5">
            <div class="row justify-content-center">
                <div class="col-12 col-md-10 col-lg-8 col-xl-6">
                    <div class="card border-dark rounded-4 shadow">
                        <div class="card-body p-4 p-md-5">
                            <h1 class="card-title text-center mb-4">Hotel Room Booking</h1>
                            <form action="process-booking.jsp" method="post">
                                <div class="mb-3">
                                    <label for="roomType" class="form-label">Room Types</label>
                                    <select class="form-select" id="roomType" name="room" required>
                                        <option value="">Select a Room Type</option>
                                        <option value="1">Single Room</option>
                                        <option value="2">Twin Room</option>
                                        <option value="3">Double Room</option>
                                        <option value="4">Triple Room</option>
                                        <option value="5">Deluxe Room</option>
                                        <option value="6">Suite</option>
                                    </select>
                                </div>
                                <div class="row mb-3">
                                    <div class="col-md-6 mb-3 mb-md-0">
                                        <label for="checkInDate" class="form-label">Check-in Date</label>
                                        <input type="date" class="form-control" id="checkInDate" name="checkInDate" required>
                                    </div>
                                    <div class="col-md-6">
                                        <label for="checkOutDate" class="form-label">Check-out Date</label>
                                        <input type="date" class="form-control" id="checkOutDate" name="checkOutDate" required>
                                    </div>
                                </div>
                                <div class="mb-3">
                                    <label for="numGuests" class="form-label">Number of Guests</label>
                                    <input type="number" class="form-control" id="numGuests" name="num_guests" min="1" required>
                                </div>
                                <div class="mb-4">
                                    <label for="specialRequests" class="form-label">Special Requests</label>
                                    <textarea class="form-control" id="specialRequests" name="special_requests" rows="3"></textarea>
                                </div>
                                <div class="d-grid">
                                    <button type="submit" class="btn btn-primary btn-lg">Book Room</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
    <%@ include file="footer.jsp" %>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
</body>
</html>
