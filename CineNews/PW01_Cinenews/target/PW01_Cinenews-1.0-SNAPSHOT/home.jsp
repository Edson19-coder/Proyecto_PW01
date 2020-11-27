<%@page import="com.mycompany.pw01_cinews.models.NewsModel"%>
<%@page import="com.mycompany.pw01_cinews.models.MediaModel"%>
<%@page import="java.util.List"%>
<%List<NewsModel> news = (List<NewsModel>) request.getAttribute("News");
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
            <div class="carousel-item active">
                <img src="https://imagenes.milenio.com/n2I2cv7hdQAVYm28Oh8s759UMss=/958x596/smart/https://www.milenio.com/uploads/media/2019/12/10/peliculas-que-tendran-su-estreno_0_20_958_596.jpg"
                     class="d-block w-100" alt="...">
                <div class="carousel-caption d-none d-md-block">
                    <h5>First slide label</h5>
                    <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
                </div>
            </div>
            <div class="carousel-item">
                <img src="https://de10.com.mx/sites/default/files/2020/01/12/estrenos_mas_esperados_2020_p.jpg"
                     class="d-block w-100" alt="...">
                <div class="carousel-caption d-none d-md-block">
                    <h5>Second slide label</h5>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                </div>
            </div>
            <div class="carousel-item">
                <img src="https://static.vix.com/es/sites/default/files/20-mejores-peliculas-2020-collage-1411201937_0.jpg"
                     class="d-block w-100" alt="...">
                <div class="carousel-caption d-none d-md-block">
                    <h5>Third slide label</h5>
                    <p>Praesent commodo cursus magna, vel scelerisque nisl consectetur.</p>
                </div>
            </div>
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
        <a href="ViewNew?Noticia=<%= n.getIdnews() %>" style="text-decoration: none; color: black;">
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
