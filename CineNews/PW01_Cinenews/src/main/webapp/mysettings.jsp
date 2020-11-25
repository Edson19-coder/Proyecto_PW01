<% String user = (String) session.getAttribute("name_user_session");
   String email = (String) session.getAttribute("email_user_session");
   String pass = (String) session.getAttribute("password_user_session");
%>
<jsp:include page="head.jsp">
    <jsp:param name="nameSecc" value="Home"/>
</jsp:include>
<% if(user != null){ %>
    <jsp:include page="navbar.jsp">
        <jsp:param name="userSession" value="<%=user%>" />
    </jsp:include>
<%}else{%>
    <%@include file= "navbar.jsp" %> 
<%}%>
    <link rel="stylesheet" href="assets/css/mysettings.css">
<!--------------------------------------------------------- CONTENT --------------------------------------------------------->
    <div class="d-flex" id="wrapper">

        <!-- Sidebar -->
        <%@include file= "sidebar.jsp" %> 
        <!-- Page Content -->
        <div id="page-content-wrapper">

            <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
                <button class="btn btn-primary" id="menu-toggle">Menu</button>
            </nav>

            <div class="container-fluid right-container col-md-3 mx-auto">
                <div class="user-image">
                    <a href="" class="user-img">
                        <img class="imgOrbed" src="https://www.softzone.es/app/uploads/2018/04/guest.png" alt="" >
                        <h5 class="change-photo-id">Change Photo</h5>
                    </a>
                </div>

                <form>
                    <div class="form-group">
                      <label for="user-name-id">User name</label>
                      <input type="text" class="form-control" id="user-name-id" value="<%=user%>">
                    </div>
                    <div class="form-group">
                        <label for="user-email-id">Email address</label>
                        <input type="email" class="form-control" id="user-email-id" aria-describedby="emailHelp" value="<%=email%>">
                      </div>
                    <div class="form-group">
                      <label for="user-pass-id">Password</label>
                      <input type="password" class="form-control" id="user-pass-id" value="<%=pass%>">
                    </div>
                </form>
            </div>
        </div>
    </div>
    <!-- Menu Toggle Script -->
    <script src="assets/js/menu-toggle.js"></script>
</body>

</html>
