
<!--------------------------------------------------------- FIRST NAVBAR --------------------------------------------------------->
    <link rel="stylesheet" href="assets/css/navstyle.css">
    <script src="assets/js/verPerfil.js"></script>
    <nav class="navbar navbar-expand-lg navbar-dark main-nav-bar" style="background-color: #aa66cc;">
        <%String us = request.getParameter("userSession");%>
        <a href="Home" class="navbar-brand">CineNews
            <i class="material-icons" style="font-size:18px;color:rgb(255, 255, 255)">movie_filter</i>
        </a>

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation" style="margin-top: 6px;">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse text-center" id="navbarNav">
            <input type="search" class="form-control form-inline mr-auto ml-auto col-sm-6" placeholder="Search...">

            <ul class="navbar-nav">
                <li class="nav-item dropdown">
                    <a href="#" class="nav-link dropdown-toggle" id="navbarDropdown" role="button"
                       <%if(us == null){%>
                        data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Account <i class='far fa-user-circle' style='font-size:17px;color:rgba(255, 255, 255, 0.432)'></i>  </a>
                        <%}else{%>
                        data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><%= us %></a>
                        <%}%>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        
                        <%  
                            if(us == null){
                        %>
                        <a href="Login" class="dropdown-item">Login</a>
                        <a href="Register" class="dropdown-item">Register</a>
                        <%}else{
                            Integer id = (Integer) session.getAttribute("id_user_session");
                        %>
                        <a href="Porfile?user=<%= id %>" class="dropdown-item">My profile</a>
                        <a href="MySettings" class="dropdown-item">Settings</a>
                        <a href="Logout" class="dropdown-item">Logout</a>
                        <%}%>
                    </div>
                </li>
            </ul>

        </div>
    </nav>
    <!--------------------------------------------------------- SECOND NAVBAR --------------------------------------------------------->
    <nav class="navbar navbar-expand-lg navbar-light secondary-nav-bar sticky-top" style="background-color: white;">

        <div class="collapse navbar-collapse text-left" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a href="Home" class="nav-link">Home</a>
                </li>
                <li class="nav-item">
                    <a href="#" class="nav-link">Movies</a>
                </li>
                <li class="nav-item">
                    <a href="#" class="nav-link">Series</a>
                </li>
                <li class="nav-item">
                    <a href="#" class="nav-link">Premieres</a>
                </li>
                <li class="nav-item">
                    <a href="#" class="nav-link">Reviews</a>
                </li>
            </ul>

        </div>
    </nav>
