<%-- 
    Document   : logout
    Created on : Aug 9, 2024, 6:15:59 PM
    Author     : Dharani
--%>

<%
    session.invalidate();
    Cookie userIDCookie = new Cookie("userID", "");
    Cookie userNameCookie = new Cookie("userName", "");
    Cookie userEmailCookie = new Cookie("userEmail", "");
    Cookie authTokenCookie = new Cookie("authToken", "");

    userIDCookie.setMaxAge(0);
    userNameCookie.setMaxAge(0);
    userEmailCookie.setMaxAge(0);
    authTokenCookie.setMaxAge(0);

    response.addCookie(userIDCookie);
    response.addCookie(userNameCookie);
    response.addCookie(userEmailCookie);
    response.addCookie(authTokenCookie);

response.sendRedirect("login.jsp");

%>