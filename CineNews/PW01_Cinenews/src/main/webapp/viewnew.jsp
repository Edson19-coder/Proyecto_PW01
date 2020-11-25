<%@page import="com.mycompany.pw01_cinews.models.AnswerModel"%>
<%@page import="com.mycompany.pw01_cinews.dao.UserDAO"%>
<%@page import="com.mycompany.pw01_cinews.models.CommentaryModel"%>
<%@page import="com.mycompany.pw01_cinews.models.MediaModel"%>
<%@page import="com.mycompany.pw01_cinews.models.NewsModel"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.pw01_cinews.models.UserModel"%>
<% String user = (String) session.getAttribute("name_user_session");%>
<% NewsModel newSelect = (NewsModel) request.getAttribute("News");
    List<MediaModel> medias = (List<MediaModel>) request.getAttribute("Medias");
    UserModel author = (UserModel) request.getAttribute("User");
    List<CommentaryModel> comments = (List<CommentaryModel>) request.getAttribute("Comments");
    List<AnswerModel> answers = (List<AnswerModel>) request.getAttribute("Answers");
%>
<jsp:include page="head.jsp">
    <jsp:param name="nameSecc" value="News"/>
</jsp:include>
<% if (user != null) {%>
<jsp:include page="navbar.jsp">
    <jsp:param name="userSession" value="<%=user%>" />
</jsp:include>
<%} else {%>
<%@include file= "navbar.jsp" %> 
<%}%>

<!--------------------------------------------------------- CONTENT --------------------------------------------------------->
<link rel="stylesheet" href="assets/css/viewnew.css">
    <div class="container text-center">
        <hr>
            <div class="titulo text-center">
                <div class="card-title  text-center">   
                    <%if(author.getPathImage() != null){ %>
                    <img  src="<%= author.getPathImage()%>"
                          class="img text-center " alt="..."/>
                    <%}else{ %>
                    <img  src="https://www.softzone.es/app/uploads/2018/04/guest.png"
                          class="img text-center " alt="..."/>
                    <%}%>
                        <a href="Porfile?user=<%= author.getIduser() %>" style="text-decoration: none; color: black;"><h5 class="card-title text-center "><%=author.getUser_name()%></h5></a>
                </div>

                <p class="card-text  text-center"><small class="text-muted"><%=newSelect.getNewDate()%></small>

                    <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-calendar2" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                        <path fill-rule="evenodd" d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5zM2 2a1 1 0 0 0-1 1v11a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V3a1 1 0 0 0-1-1H2z"/>
                        <path d="M2.5 4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5H3a.5.5 0 0 1-.5-.5V4z"/>
                    </svg>
                </p>
                <h1><%=newSelect.getNewsTitle()%></h1>
            </div>
            <hr>

                <div class="contenido-notica text-center">
                    <p><%=newSelect.getNewsDescription()%></p>

                    <!--------------------------------------------------------- CAROUSEL --------------------------------------------------------->
                    <div id="carouselCaptionid" class="carousel slide" data-ride="carousel">
                        <ol class="carousel-indicators">
                            <li data-target="#carouselCaptionid" data-slide-to="0" class="active"></li>
                            <li data-target="#carouselCaptionid" data-slide-to="1"></li>
                            <li data-target="#carouselCaptionid" data-slide-to="2"></li>
                        </ol>
                        <div class="carousel-inner">
                            <%
                                int i = 0;
                                for (MediaModel media : medias) {
                                    if (i == 0) {
                                        i++;
                            %>
                            <div class="carousel-item active">
                                <img src="<%= media.getMediaUrl()%>"
                                     class="d-block w-100" alt="...">
                            </div>
                            <%} else {%>
                            <div class="carousel-item">
                                <img src="<%= media.getMediaUrl()%>"
                                     class="d-block w-100" alt="...">
                            </div>
                            <%}
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

                    <p><%=newSelect.getNewsContent()%></p>
                    <div class = "boton text-right">
                        <button type="button" div class="btn btn-danger">
                            <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-heart-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                <path fill-rule="evenodd" d="M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314z"/>
                            </svg>  

                        </button>
                        <button type="button" class="btn btn-danger"> 
                            <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-heart" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                <path fill-rule="evenodd" d="M8 2.748l-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z"/>
                            </svg>
                        </button>
                    </div>
                </div>
                </div>




                <!-- Comentarios Principal -->
                <div class="comments-container">
                    <h1>Comentarios</h1>

                    <% if (comments != null) {
                            for (CommentaryModel commentary : comments) {%>
                    <ul id="comments-list" class="comments-list">
                        <li>

                            <form method="POST" action="./ViewNew">
                                <% UserModel comUser = UserDAO.UserSelectById(commentary.getCommentaryUser());%>
                                <div class="comment-main-level">
                                    <!-- Avatar -->
                                    <% String pic = comUser.getPathImage();
                                        if (pic != null) {%>
                                    <div class="comment-avatar"><img src="<%= pic%>" alt=""></div>
                                    <%} else {%>
                                    <div class="comment-avatar"><img src="https://www.softzone.es/app/uploads/2018/04/guest.png" alt=""></div>    
                                    <%}%>
                                    <!-- Contenedor del Comentario -->
                                    <div class="comment-box">
                                        <div class="comment-head">
                                            <h6 class="comment-name by-author"><a href="Porfile?user=<%= comUser.getIduser() %>"><%= comUser.getUser_name()%></a></h6>
                                            <span><%= commentary.getCommentaryDate()%></span>  
                                            <div class = "boton-corazon text-right">
                                                <button type="submit" div class="btn btn-danger" name="heart">
                                                    <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-heart-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                                        <path fill-rule="evenodd" d="M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314z"/>
                                                    </svg>  
                                                </button>
                                            </div>
                                        </div>
                                        <div class="comment-content"><%= commentary.getCommentaryContent()%></div>
                                    </div>
                                </div>
                            </form>
                            <!-- Respuestas de los comentarios -->
                            <%for (AnswerModel answer : answers) {
                                if (answers != null && answer.getAnswerCommentary() == commentary.getIdcommentary()) {%>
                            <ul class="comments-list reply-list">
                                <% UserModel ansUser = UserDAO.UserSelectById(answer.getAnswerUser());%>
                                <li>
                                    <!-- Avatar -->
                                    <% String pic2 = ansUser.getPathImage();
                                        if (pic2 != null) {%>
                                    <div class="comment-avatar"><img src="<%= pic%>" alt=""></div>
                                    <%} else {%>
                                    <div class="comment-avatar"><img src="https://www.softzone.es/app/uploads/2018/04/guest.png" alt=""></div>    
                                    <%}%>
                                    <!-- Contenedor del Comentario -->
                                    <div class="comment-box">
                                        <div class="comment-head">
                                            <h6 class="comment-name"><a href="Porfile?user=<%= ansUser.getIduser() %>"><%= ansUser.getUser_name()%></a></h6>
                                            <span><%=answer.getAnswerDate()%>   </span>
                                            <div class = "boton text-right">
                                                <button type="button" div class="btn btn-danger">
                                                    <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-heart-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                                        <path fill-rule="evenodd" d="M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314z"/>
                                                    </svg>  

                                                </button>
                                            </div>



                                        </div>
                                        <div class="comment-content"><%=answer.getAnswerContent()%></div>
                                    </div>
                                </li>
                            </ul>
                            <%}}%>
                        </li>
                            <form method="POST" action="./ViewNew">
                                <div class="form-group">
                                    <textarea name="content" id="description" class="form-control" style="margin-top: 5px;" ></textarea>
                                    <div class="text-right">
                                        <input name="comentario" type="text" value="<%= commentary.getIdcommentary()%>" style="display: none;" />
                                        <button id="btn-comment" type="submit" class="btn btn-primary" name="accion" value="Responder" style="margin-top: 5px;">Responder</button>
                                    </div>
                                </div>
                            </form>
                    </ul> 
                    <%}}%>

                    <form method="POST" action="./ViewNew">
                        <div class="form-group">
                            <textarea name="content" id="description" class="form-control" style="margin-top: 5px;"></textarea>
                            <div class="text-right">
                                <button id="btn-comment" type="submit" class="btn btn-primary" name="accion" value="Comentar" style="margin-top: 5px;">Comentar</button>
                            </div>
                        </div>
                    </form>
                </div

                <footer class="text-muted">
                    <div class="container">
                        <p class="float-right">
                            <a href="#">Back to top</a>
                        </p>
                    </div>
                </footer> 


                </body>
                </html>
