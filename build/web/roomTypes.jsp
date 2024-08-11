<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Hotel Room Types</title>
       <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet">
        <style>
            .card-img-top {
                height: 200px;
                object-fit: cover;
            }
        </style>
    </head>
            <nav class="navbar navbar-expand-lg bg-dark text-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">
            <img src="https://img.jakpost.net/c/2020/06/24/2020_06_24_98632_1592993564._large.jpg" alt="Hotel Logo" width="160" height="100" class="d-inline-block align-text-top">
        </a>
        <button class="navbar-toggler custom-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
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
                    <a class="nav-link text-light" href="logout.jsp">Logout</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
    <body>
         <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
        <div class="d-flex justify-content-center align-items-center ">
            <div class="container text-center ml-3">
                <h1 class="text-center mb-4 mt-5">Hotel Room Types</h1>
                <div class="row justify-content-center">
                    <div class="col-md-4 mb-4">
                        <div class="card shadow-sm">
                            <h2 class="card-title">Single Room</h2>
                            <p class="card-text">Accommodates 1 person.</p> 
                            <p>A comfortable room for solo travelers, featuring modern amenities and a cozy ambiance.</p>
                            <img src="https://www.hotelmonterey.co.jp/upload_file/monhtyo/stay/sng_600_001.jpg" class="card-img-top" alt="Single Room">
                        </div>
                    </div>
                    
                    <div class="col-md-4 mb-4">
                        <div class="card shadow-sm">
                            <h2 class="card-title">Twin Room</h2>
                            <p class="card-text">Accommodates 2 people.</p>
                            <p>Features two single beds, ideal for friends or colleagues sharing a room.</p>
                            <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRhG4lXR2davEwBLgwfHdKu7tCyTIcUJP25Pg&s" class="card-img-top" alt="Twin Room">
                        </div>
                    </div>

                    <div class="col-md-4 mb-4">
                        <div class="card shadow-sm">
                            <h2 class="card-title">Double Room</h2>
                            <p class="card-text">Accommodates 2 people.</p>
                            <p>A room with a double bed, perfect for couples or a small family.</p>                 
                            <img src="https://www.collinsdictionary.com/images/full/doubleroom_564885484_1000.jpg" class="card-img-top" alt="Double Room">       
                        </div>
                    </div>

                    <div class="col-md-4 mb-4">
                        <div class="card shadow-sm">
                            <h2 class="card-title">Triple Room</h2>
                            <p class="card-text">Accommodates 3 people.</p>
                            <p>Includes three beds or a combination of a double bed and a single bed.</p>
                            <img src="https://www.granviakyoto.com/rooms/assets_c/2020/03/t_01-thumb-960xauto-1093.jpg" class="card-img-top" alt="Triple Room">
                        </div>
                    </div>

                    <div class="col-md-4 mb-4">
                        <div class="card shadow-sm">
                            <h2 class="card-title">Deluxe Room</h2>
                            <p class="card-text">Accommodates 2 people.</p>
                            <p>A luxurious room with upscale amenities and extra space for comfort.</p>                     
                            <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSQzGTijzYYXZFz9M6K4dh4p5flFe4tM1f8vQ&s" class="card-img-top" alt="Deluxe Room">                         
                        </div>
                    </div>

                    <div class="col-md-4 mb-4">
                        <div class="card shadow-sm">
                            <h2 class="card-title">Suite</h2>
                            <p class="card-text">Accommodates 4 people.</p>
                            <p>A spacious and elegant suite with separate living and sleeping areas.</p>                     
                            <img src="https://www.suriyaresorts.com/wp-content/uploads/2022/03/suviteroom1-1-1170x680.jpg" class="card-img-top" alt="Suite">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-rbsA+U0PpS51K9GTTOaXhR0kK9KsZwZ63ebA/8LX16XT7kjFvHPGBwHJxGOSVTEz" crossorigin="anonymous"></script>
     <%@ include file="footer.jsp" %>
    </body>
</html>
