<%-- 
    Document   : register
    Created on : Aug 7, 2024, 12:28:57 PM
    Author     : Dharani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
        <title>Register - Hotel del Luna</title>
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
                    <a class="nav-link text-light" href="logout.jsp">Logout</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
    <body class="d-flex flex-column min-vh-100" style="background-color: #f0f0f0;">
        <main class="flex-grow-1 py-5">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-12 col-sm-10 col-md-8 col-lg-6 col-xl-5">
                        <div class="card border-dark rounded-4 shadow">
                            <div class="card-body p-4 p-sm-5">
                                <h1 class="text-center mb-4">Create Your Account</h1>
                                <p class="text-center mb-4">Already have an account? <a href="login.jsp">Log in</a></p>
                                <form action="register-process.jsp" method="post">
                                    <div class="row mb-3">
                                        <div class="col-md-6 mb-3 mb-md-0">
                                            <label for="firstname" class="form-label"><strong>First name</strong><span class="text-danger">*</span></label>
                                            <input type="text" class="form-control" id="firstname" name="firstname" placeholder="John" required>
                                        </div>
                                        <div class="col-md-6">
                                            <label for="lastname" class="form-label"><strong>Last name</strong><span class="text-danger">*</span></label>
                                            <input type="text" class="form-control" id="lastname" name="lastname" placeholder="Doe" required>
                                        </div>
                                    </div>
                                    <div class="mb-3">
                                        <label for="email" class="form-label"><strong>Email</strong><span class="text-danger">*</span></label>
                                        <input type="email" class="form-control" id="email" name="email" placeholder="example@someone.com" required>
                                    </div>
                                    <div class="mb-3">
                                        <label for="password" class="form-label"><strong>Password</strong><span class="text-danger">*</span></label>
                                        <div class="input-group">
                                            <input type="password" class="form-control" id="password" name="password" required>
                                            <button class="btn btn-outline-secondary" type="button" onclick="togglePasswordVisibility('password', 'toggleIcon')">
                                                <i class="bi bi-eye" id="toggleIcon"></i>
                                            </button>
                                        </div>
                                    </div>
                                    <div class="mb-4">
                                        <label for="confirmpassword" class="form-label"><strong>Confirm Password</strong><span class="text-danger">*</span></label>
                                        <div class="input-group">
                                            <input type="password" class="form-control" id="confirmpassword" name="confirmpassword" required>
                                            <button class="btn btn-outline-secondary" type="button" onclick="togglePasswordVisibility('confirmpassword', 'toggleIcon1')">
                                                <i class="bi bi-eye" id="toggleIcon1"></i>
                                            </button>
                                        </div>
                                    </div>
                                    <div class="d-grid">
                                        <button class="btn btn-primary btn-lg" type="submit">Register</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
        <%@ include file="footer.jsp" %>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
                crossorigin="anonymous"></script>
        <script>
            function togglePasswordVisibility(inputId, iconId) {
                var passwordInput = document.getElementById(inputId);
                var toggleIcon = document.getElementById(iconId);
                if (passwordInput.type === 'password') {
                    passwordInput.type = 'text';
                    toggleIcon.classList.remove('bi-eye');
                    toggleIcon.classList.add('bi-eye-slash');
                } else {
                    passwordInput.type = 'password';
                    toggleIcon.classList.remove('bi-eye-slash');
                    toggleIcon.classList.add('bi-eye');
                }
            }
        </script>
    </body>
</html>