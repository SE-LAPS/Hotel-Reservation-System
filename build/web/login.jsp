<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.Cookie" %>
<%
    // Retrieve all cookies from the request
    Cookie[] cookies = request.getCookies();
    String userID = null;
    String userName = null;
    String userEmail = null;
    String authToken = null;

    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if ("userID".equals(cookie.getName())) {
                userID = cookie.getValue();
            } else if ("userName".equals(cookie.getName())) {
                userName = cookie.getValue();
            } else if ("userEmail".equals(cookie.getName())) {
                userEmail = cookie.getValue();
            } else if ("authToken".equals(cookie.getName())) {
                authToken = cookie.getValue();
            }
        }
    }

    // Check if the user is already logged in by verifying the cookies
    if (userID != null && userName != null && userEmail != null && authToken != null) {
        // User is already logged in, redirect to the appropriate page
        response.sendRedirect("booking.jsp");
    }
%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
        <title>Login - Hotel del Luna</title>
    </head>
    <body class="d-flex flex-column min-vh-100" style="background-color: #f0f0f0;">
        <nav class="navbar navbar-expand-lg bg-dark text-light">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">
                    <img src="https://img.jakpost.net/c/2020/06/24/2020_06_24_98632_1592993564._large.jpg" alt="Hotel Logo" width="160" height="100" class="d-inline-block align-text-top">
                </a>
                <button class="navbar-toggler custom-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
            </div>
        </nav>
        <main class="flex-grow-1 d-flex align-items-center">
            <div class="container py-5">
                <div class="row justify-content-center">
                    <div class="col-12 col-sm-10 col-md-8 col-lg-6 col-xl-5 col-xxl-4">
                        <div class="card border-dark rounded-4 shadow">
                            <div class="card-body p-4 p-sm-5">
                                <h1 class="text-center mb-4">Welcome!</h1>
                                <p class="text-center mb-4">Please enter your credentials</p>
                                <form id="loginForm" method="post">
                                    <div class="mb-3">
                                        <label for="email" class="form-label"><strong>Email</strong> <span class="text-danger">*</span></label>
                                        <input type="email" class="form-control" id="email" name="email" placeholder="example@someone.com" required>
                                    </div>
                                    <div class="mb-3">
                                        <label for="password" class="form-label"><strong>Password</strong> <span class="text-danger">*</span></label>
                                        <div class="input-group">
                                            <input type="password" class="form-control" id="password" name="password" required>
                                            <button class="btn btn-outline-secondary" type="button" onclick="togglePasswordVisibility()">
                                                <i class="bi bi-eye" id="toggleIcon"></i>
                                            </button>
                                        </div>
                                    </div>
                                    <div class="mb-3 form-check">
                                        <input type="checkbox" class="form-check-input" id="remember" name="rememberme">
                                        <label class="form-check-label" for="remember">Remember me</label>
                                    </div>
                                    <div class="mb-3 form-check">
                                        <input type="checkbox" class="form-check-input" id="adminLogin" name="adminLogin">
                                        <label class="form-check-label" for="adminLogin">Login as Admin</label>
                                    </div>
                                    <div class="d-grid gap-2">
                                        <button class="btn btn-primary btn-lg" type="submit">Log in</button>
                                    </div>
                                </form>
                                <p class="text-center mt-4 mb-0">Don't have an account? <a href="register.jsp">Sign up</a></p>
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
            function togglePasswordVisibility() {
                var passwordInput = document.getElementById('password');
                var toggleIcon = document.getElementById('toggleIcon');
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

            document.getElementById('loginForm').addEventListener('submit', function(e) {
                e.preventDefault();
                var form = this;
                if (document.getElementById('adminLogin').checked) {
                    form.action = 'admin-login-process.jsp';
                } else {
                    form.action = 'login-process.jsp';
                }
                form.submit();
            });
        </script>
    </body>
</html>