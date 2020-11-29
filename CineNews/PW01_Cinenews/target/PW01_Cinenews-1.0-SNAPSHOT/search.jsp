<%@page import="com.mycompany.pw01_cinews.models.NewsModel"%>
<%@page import="com.mycompany.pw01_cinews.models.MediaModel"%>
<%@page import="java.util.List"%>
<%List<NewsModel> news = (List<NewsModel>) request.getAttribute("News");
    List<MediaModel> medias = (List<MediaModel>) request.getAttribute("Medias");
    String search = request.getParameter("search"); %>
<% String user = (String) session.getAttribute("name_user_session");%>
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
<link rel="stylesheet" href="assets/css/search.css">
<hr>
<div class="titulo text-center">
    <h2>Resultados de la búsqueda:</h2> <h1>"<%= search %>"</h1>
</div>
<hr>
<div class="container">

    <%  if (news != null && !news.isEmpty()) {
            for (NewsModel n : news) {
                if (n.getNewsStatus() == 2) {
    %>
    <a href="ViewNew?Noticia=<%= n.getIdnews()%>" style="text-decoration: none; color: black;">
        <div class="card mb-3 body-card">
            <div class="row no-gutters">

                <div class="col-md-4">
                    <%for (MediaModel media : medias) {
                                if (media.getMediNoticia() == n.getIdnews()) {%>
                    <img src="<%= media.getMediaUrl()%>"
                         class="card-img" alt="...">
                    <%}
                            }%>
                </div>
                <div class="col-md-8">
                    <div class="card-body">
                        <h5 class="card-title"><%= n.getNewsTitle()%></h5>
                        <p class="card-text"><%= n.getNewsDescription()%></p>

                        <p class="card-text"><small class="text-muted"><%= n.getNewDate()%></small>
                            <i class='far fa-calendar' style='font-size:18px'></i>
                        </p>
                    </div>
                </div>
            </div>              
        </div>
    </a>
    <%}
            }
        } else{%>
    <h2 style="text-align: center;">No se han encontrado resultados</h2>
    <%}%>
</div>

<footer class="my-5 pt-5 text-muted text-center text-small">
    <p class="mb-1">&copy; 2020 CineNews</p>
    <ul class="list-inline">
        <!---    <li class="list-inline-item"><a href="#">Privacy</a></li>
            <li class="list-inline-item"><a href="#">Terms</a></li>
            <li class="list-inline-item"><a href="#">Support</a>
          
          </li>-->

        <footer class="text-muted">
            <div class="container">
                <p class="float-right">
                    <a href="#">Back to top</a>
                </p>
            </div>
        </footer>
    </ul>
</footer>

</body>
</html>
