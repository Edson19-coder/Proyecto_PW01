<%@page import="com.mycompany.pw01_cinews.models.NewsModel"%>
<%@page import="com.mycompany.pw01_cinews.models.MediaModel"%>
<%@page import="java.util.List"%>
<%List<NewsModel> news = (List<NewsModel>) request.getAttribute("News");
    List<NewsModel> MostLike = (List<NewsModel>) request.getAttribute("MostLike");
    List<MediaModel> medias = (List<MediaModel>) request.getAttribute("Medias"); %>
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
<link rel="stylesheet" href="assets/css/home.css">
<!--------------------------------------------------------- CONTENT --------------------------------------------------------->
<div class="container text-center">
    <!--------------------------------------------------------- CAROUSEL --------------------------------------------------------->
    <div id="carouselCaptionid" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
            <li data-target="#carouselCaptionid" data-slide-to="0" class="active"></li>
            <li data-target="#carouselCaptionid" data-slide-to="1"></li>
            <li data-target="#carouselCaptionid" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
            <%if (MostLike != null) {
                    int i = 0;
                    for (NewsModel ml : MostLike) {
                        if (ml.getNewsStatus() == 2) {
                            if (i == 0) {
                                i++;
            %>
            <div class="carousel-item active">
                <a href="ViewNew?Noticia=<%= ml.getIdnews()%>">
                    <%for (MediaModel media : medias) {
                            if (media.getMediNoticia() == ml.getIdnews()) {%>
                    <img src="<%= media.getMediaUrl()%>"
                         class="d-block w-100" alt="...">
                    <%}
                        }%>
                    <div class="carousel-caption d-none d-md-block">
                        <h5><%= ml.getNewsTitle()%></h5>
                        <p><%= ml.getNewsDescription()%></p>
                    </div>
                </a>
            </div>
            <%} else {%>
            <div class="carousel-item">
                <a href="ViewNew?Noticia=<%= ml.getIdnews()%>">
                    <%for (MediaModel media : medias) {
                        if (media.getMediNoticia() == ml.getIdnews()) {%>
                    <img src="<%= media.getMediaUrl()%>"
                         class="d-block w-100" alt="...">
                    <%}
                    }%>
                    <div class="carousel-caption d-none d-md-block">
                        <h5><%= ml.getNewsTitle()%></h5>
                        <p><%= ml.getNewsDescription()%></p>
                    </div>
                </a>
            </div>
            <%}
                        }
                    }
                }%>
        </div>
        <a class="carousel-control-prev" href="#carouselCaptionid" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselCaptionid" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
    <!--------------------------------------------------------- RECENT NEWS --------------------------------------------------------->
    <hr>
    <h1>RECENT NEWS</h1>
    <hr>
    <div class="recent-news">
        <%  if (news != null) {
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
            }%>
    </div>
</div>
<footer class="my-5 pt-5 text-muted text-center text-small">
    <p class="mb-1">&copy; 2020 CineNews</p>
    <ul class="list-inline">
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
