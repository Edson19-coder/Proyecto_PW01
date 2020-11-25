<%@page import="com.mycompany.pw01_cinews.models.MediaModel"%>
<%@page import="com.mycompany.pw01_cinews.models.NewsModel"%>
<%@page import="java.util.List"%>
<% String user = (String) session.getAttribute("name_user_session");
    List<NewsModel> newsUser = (List<NewsModel>) request.getAttribute("News");
    List<MediaModel> medias = (List<MediaModel>) request.getAttribute("Medias");
%>
<jsp:include page="head.jsp">
    <jsp:param name="nameSecc" value="Home"/>
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
                <button class="btn btn-primary" id="menu-toggle">Menu</button>
            </nav>
            <% for (NewsModel news : newsUser) {
                    if (news.getNewsStatus() == 1) {
            %>
            <div class="container-fluid">
                <div class="recent-news ">
                    <div class="card mb-3 body-card ">
                        <div class="row no-gutters ">
                            <div class="col-md-4">
                                <%for (MediaModel media : medias) {
                                        if (media.getMediNoticia() == news.getIdnews()) {%>
                                <img src="<%= media.getMediaUrl()%>"
                                     class="card-img" alt="...">
                                    <%}
                                        }%>
                            </div>
                            <div class="col-md-8">
                                <div class="card-body">
                                    <h5 class="card-title"><%= news.getNewsTitle()%></h5>
                                    <p class="card-text"><%= news.getNewsDescription()%></p>

                                    <p class="card-text"><small class="text-muted"><%= news.getNewDate()%></small>

                                        <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-calendar2" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                            <path fill-rule="evenodd" d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5zM2 2a1 1 0 0 0-1 1v11a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V3a1 1 0 0 0-1-1H2z"/>
                                            <path d="M2.5 4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5H3a.5.5 0 0 1-.5-.5V4z"/>

                                        </svg>
                                    </p>
                                    <form action="./Reviews" method="POST">
                                        <div class="co-md-12" >
                                            <textarea name="content" id="description" class="form-control" style="margin-top: 5px;" placeholder="Observaciones"></textarea>
                                        </div>
                                        <div class="co-md-12 text-right">
                                            <a href="ViewNew?Noticia=<%= news.getIdnews()%>" style="text-decoration: none; color: purple;">Ver más</a>
                                            <button type="submit" name="accion" value="aceptado" class="btn btn-success" style=" margin-top: 5px; margin-bottom: 0px;">Aceptada</button>
                                            <button type="submit" name="accion" value="rechazado" class="btn btn-danger" style=" margin-top: 5px; margin-bottom: 0px;">Denegada</button>
                                            <textarea type="submit" name="NewId" class="btn btn-danger" style=" display: none; "><%= news.getIdnews() %></textarea>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>              
                    </div>
                </div>
            </div>
            <%}
                }%>
        </div>
    </div>
    <!-- Menu Toggle Script -->
    <script src="assets/js/menu-toggle.js"></script>
</body>

</html>