<% String user = (String) session.getAttribute("name_user_session");
    String email = (String) session.getAttribute("email_user_session");
    String pass = (String) session.getAttribute("password_user_session");
    String pathPhoto = (String) session.getAttribute("image_user_session");
    String facebook = (String) session.getAttribute("facebook_user_session");
    String instagram = (String) session.getAttribute("instagram_user_session");
    String descripcion = (String) session.getAttribute("descripcion_user_session");
%>
<jsp:include page="head.jsp">
    <jsp:param name="nameSecc" value="My Settings"/>
</jsp:include>
<% if (user != null) {%>
<jsp:include page="navbar.jsp">
    <jsp:param name="userSession" value="<%=user%>" />
</jsp:include>
<%} else {%>
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
            <button class="btn btn-primary" id="menu-toggle" style = "background-color:  #aa66cc; border: #aa66cc; color: white;">Menu</button>
        </nav>

        <div class="container-fluid right-container col-md-3 mx-auto">
            <div class="user-image">
                <%if (pathPhoto != null) {%>
                <a class="user-img">
                    <img class="imgOrbed" src="<%= pathPhoto%>" alt="" >
                </a>
                <%} else {%>
                <a class="user-img">
                    <img class="imgOrbed" src="https://www.softzone.es/app/uploads/2018/04/guest.png" alt="" >
                </a>
                <%}%>
            </div>

            <form action="./MySettings" method="POST" enctype="multipart/form-data">
                <input type="file" name="image" class="form-control-file" id="exampleFormControlFile1">
                <small id="emailHelp" class="form-text text-muted text-center" >El tamaño maximo de archivo es 5 Mb</small>
                <div class="form-group">
                    <label for="user-name-id">User name</label>
                    <input name="userName" type="text" class="form-control" id="user-name-id" value="<%=user%>">
                </div>
                <div class="form-group">
                    <label for="user-email-id">Email address</label>
                    <input name="userEmail" type="email" class="form-control" id="user-email-id" aria-describedby="emailHelp" value="<%=email%>">
                </div>
                <div class="form-group">
                    <label for="user-pass-id">Password</label>
                    <input name="userPass" type="password" class="form-control" id="user-pass-id" value="<%=pass%>">
                </div>
                <%if (facebook != null) {%>
                <div class="form-group">
                    <label for="user-facebook-id">Facebook</label>
                    <input name="userFace" type="text" class="form-control" id="user-facebook-id" value="<%=facebook%>">
                </div>
                <%} else {%>
                <div class="form-group">
                    <label for="user-facebook-id">Facebook</label>
                    <input name="userFace" type="text" class="form-control" id="user-facebook-id" placeholder="URL de tu perfil de Facebook" >
                </div>
                <%}%>
                <%if (instagram != null) {%>
                <div class="form-group">
                    <label for="user-instagram-id">Instagram</label>
                    <input name="userInsta" type="text" class="form-control" id="user-instagram-id" value="<%=instagram%>">
                </div>
                <%} else {%>
                <div class="form-group">
                    <label for="user-instagram-id">Facebook</label>
                    <input name="userInsta" type="text" class="form-control" id="user-instagram-id" placeholder="URL de tu perfil de Instagram" >
                </div>
                <%}%>
                <%if (descripcion != null) {%>
                <div class="form-group">
                    <label for="user-sobremi-id">Sobre mi</label>
                    <textarea name="content" name="content" id="user-sobremi-id" class="form-control" ><%=descripcion%></textarea>
                </div>
                <%} else {%>
                <div class="form-group">
                    <label for="user-sobremi-id">Sobre mi</label>
                    <textarea name="content" name="content" id="user-sobremi-id" class="form-control" placeholder="Sobre mi..."></textarea>
                </div>
                <%}%>
                <button type="submit" class="btnG btn-sm btn-outline-secondary" id="menu-toggle" style = "background-color:  #aa66cc; border: #aa66cc; color: white;">Guardar</button>
            </form>
        </div>
    </div>
</div>
<!-- Menu Toggle Script -->
<script src="assets/js/menu-toggle.js"></script>
</body>

</html>
