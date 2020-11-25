<%@page import="com.mycompany.pw01_cinews.models.MediaModel"%>
<%@page import="com.mycompany.pw01_cinews.models.NewsModel"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.pw01_cinews.models.UserModel"%>
<% String user = (String) session.getAttribute("name_user_session");  %>
<jsp:include page="head.jsp">
    <jsp:param name="nameSecc" value="Porfile"/>
</jsp:include>
<% if (user != null) {%>
<jsp:include page="navbar.jsp">
    <jsp:param name="userSession" value="<%=user%>" />
</jsp:include>
<%} else {%>
<%@include file= "navbar.jsp" %> 
<%}%>
<link rel="stylesheet" href="assets/css/porfile.css">
<!--------------------------------------------------------- CONTENT --------------------------------------------------------->
    <%UserModel userPorfile = (UserModel) request.getAttribute("UserPorfile");
      List<NewsModel> newsUser = (List<NewsModel>) request.getAttribute("NewsUser");
      List<MediaModel> medias = (List<MediaModel>) request.getAttribute("Medias");%>
<div class="content-profile-page">
    <div class="profile-user-page card">
        <div class="img-user-profile">
            <img class="profile-bgHome" src="https://cdnmundo3.img.sputniknews.com/img/106290/75/1062907509_0:185:1024:738_1000x541_80_0_0_e7a171cb66555c14c2cb282c9eb61f48.jpg" />
            <% if(userPorfile.getPathImage() != null) {%>
            <img class="avatar" src="<%=userPorfile.getPathImage()%>" alt="jofpin"/>
            <%}else{%>
            <img class="avatar" src="https://www.softzone.es/app/uploads/2018/04/guest.png" alt="jofpin"/>
            <%}%>
        </div>
        <div class="user-profile-data">
            <h1>
                <div class="comentar-news text-right ">

                    <div class="btn-group">

                        <button type="button" class="btn btn-sm btn-outline-secondary">Setting
                            <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-gear-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                <path fill-rule="evenodd" d="M9.405 1.05c-.413-1.4-2.397-1.4-2.81 0l-.1.34a1.464 1.464 0 0 1-2.105.872l-.31-.17c-1.283-.698-2.686.705-1.987 1.987l.169.311c.446.82.023 1.841-.872 2.105l-.34.1c-1.4.413-1.4 2.397 0 2.81l.34.1a1.464 1.464 0 0 1 .872 2.105l-.17.31c-.698 1.283.705 2.686 1.987 1.987l.311-.169a1.464 1.464 0 0 1 2.105.872l.1.34c.413 1.4 2.397 1.4 2.81 0l.1-.34a1.464 1.464 0 0 1 2.105-.872l.31.17c1.283.698 2.686-.705 1.987-1.987l-.169-.311a1.464 1.464 0 0 1 .872-2.105l.34-.1c1.4-.413 1.4-2.397 0-2.81l-.34-.1a1.464 1.464 0 0 1-.872-2.105l.17-.31c.698-1.283-.705-2.686-1.987-1.987l-.311.169a1.464 1.464 0 0 1-2.105-.872l-.1-.34zM8 10.93a2.929 2.929 0 1 0 0-5.86 2.929 2.929 0 0 0 0 5.858z"/>
                            </svg>
                    </div>
                </div> 
                <%= userPorfile.getUser_name() %>
            </h1>

            <p>#<%= userPorfile.getIduser() %></p>
        </div> 
        <div class="description-profile">Acerca de mi
        </div>


        <ul class="data-user">
            <li class = "seccion">
                <a href= "#noticia" class = "seccion">Mis noticias</a>
            </li>
            <li class = "seccion1">
                <a href= "#favoritos" class = "seccion1">Mis favoritos</a>
            </li>
        </ul>
    </div>
</div>



<div class="container text-center">
    <hr>  <h4>Mis noticias</h4> </hr>
    <section id = "noticia" class = "seccion">
        <% for(NewsModel news : newsUser){ 
            if(news.getNewsStatus() == 2){
        %>
        <a href="ViewNew?Noticia=<%= news.getIdnews() %>" style="text-decoration: none; color: black;" >
        <div class="recent-news ">
            <div class="card mb-3 body-card ">
                <div class="row no-gutters ">

                    <div class="col-md-4">
                        <%for (MediaModel media : medias){
                            if(media.getMediNoticia() == news.getIdnews()){%>
                            <img src="<%= media.getMediaUrl() %>"
                                class="card-img" alt="...">
                            <%}}%>
                    </div>
                    <div class="col-md-8">
                        <div class="card-body">
                            <h5 class="card-title"><%= news.getNewsTitle() %></h5>
                            <p class="card-text"><%= news.getNewsDescription() %></p>

                            <p class="card-text"><small class="text-muted"><%= news.getNewDate() %></small>

                                <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-calendar2" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                    <path fill-rule="evenodd" d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5zM2 2a1 1 0 0 0-1 1v11a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V3a1 1 0 0 0-1-1H2z"/>
                                    <path d="M2.5 4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5H3a.5.5 0 0 1-.5-.5V4z"/>

                                </svg>
                            </p>
                        </div>
                    </div>
                </div>              
            </div>
        </div>
        </a>
        <%}}%>
    </section>

    <hr>  <h4>Mis favoritos</h4> </hr>

    <section id = "favoritos" class = "seccion1">

        <div class="recent-news ">
            <div class="card mb-3 body-card ">
                <div class="row no-gutters ">

                    <div class="col-md-4">
                        <img src="http://es.web.img2.acsta.net/r_640_360/newsv7/20/09/25/15/18/0240144.jpg"
                             class="card-img" alt="...">
                    </div>
                    <div class="col-md-8">
                        <div class="card-body">
                            <h5 class="card-title">Titulo de la Noticia</h5>
                            <p class="card-text">Descripcion corta de la noticia Descripcion corta de la noticia
                                Descripcion corta de la noticia Descripcion corta de la noticia Descripcion corta de la
                                noticia.</p>

                            <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small>

                                <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-calendar2" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                    <path fill-rule="evenodd" d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5zM2 2a1 1 0 0 0-1 1v11a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V3a1 1 0 0 0-1-1H2z"/>
                                    <path d="M2.5 4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5H3a.5.5 0 0 1-.5-.5V4z"/>

                                </svg>
                            </p>



                        </div>
                    </div>
                </div>              
            </div>









        </div> 

       
    </section>

</div>

<footer class="text-muted">
    <div class="container">
        <p class="float-right">
            <a href="#">Back to top</a>
        </p>
    </div>
</footer>

</body>
</html>