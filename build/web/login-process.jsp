<%@page import="Classes.User"%>
<%@page import="Classes.MD5"%> 
<%
    String email = request.getParameter("email");
    String password = MD5.getMd5(request.getParameter("password"));
    String rm = request.getParameter("rememberme");

    User user = new User(0, "", "", "", "USER");
//    // Perform login
    boolean isAuthenticated = user.login(email, password);

//out.println(password);
//
    if (isAuthenticated) {
        // Create cookies to store user information

        Cookie userIDCookie = new Cookie("userID", String.valueOf(user.getUserID()));
        Cookie userNameCookie = new Cookie("userName", user.getUserName());
        Cookie userEmailCookie = new Cookie("userEmail", user.getEmail());
        Cookie authTokenCookie = new Cookie("authToken", user.getToken());
        if (rm == "on") {
            // Set cookie attributes
            userIDCookie.setMaxAge(60 * 60 * 24 * 30); // 30 day
            userNameCookie.setMaxAge(60 * 60 * 24 * 30);
            userEmailCookie.setMaxAge(60 * 60 * 24 * 30);
            authTokenCookie.setMaxAge(60 * 60 * 24 * 30);
        } else {
            userIDCookie.setMaxAge(60 * 60); // 1 hour
            userNameCookie.setMaxAge(60 * 60);
            userEmailCookie.setMaxAge(60 * 60);
            authTokenCookie.setMaxAge(60 * 60);
        }
        // Add cookies to response
        response.addCookie(userIDCookie);
        response.addCookie(userNameCookie);
        response.addCookie(userEmailCookie);
        response.addCookie(authTokenCookie);

        // Redirect to home page or user dashboard
        if (user.getRole() == "ADMIN") {

            response.sendRedirect("admin.jsp"); // Modify this as needed
        } else {

            response.sendRedirect("booking.jsp"); // Modify this as needed
        }
    } else {
        // Authentication failed, redirect to login page with error
        response.sendRedirect("login.jsp?error=invalid"); // Modify this as needed
    }
%>