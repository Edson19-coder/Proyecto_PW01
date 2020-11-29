<%@page import="com.mycompany.pw01_cinews.models.LikeDislikeNewsModel"%>
<%@page import="com.mycompany.pw01_cinews.models.LikeAnswerModel"%>
<%@page import="com.mycompany.pw01_cinews.models.LikeCommentaryModel"%>
<%@page import="com.mycompany.pw01_cinews.models.FavoriteModel"%>
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
    List<LikeCommentaryModel> likelist = (List<LikeCommentaryModel>) request.getAttribute("likeNews");
    List<LikeAnswerModel> likelistAnswer = (List<LikeAnswerModel>) request.getAttribute("likeAnswerNews");
    List<LikeDislikeNewsModel> listLikeDislike = (List<LikeDislikeNewsModel>) request.getAttribute("listLikeDislike");
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
                    <div class="bote text-right">
                        <%if (session.getAttribute("id_user_session") != null) {
                            Boolean isFavNew = (Boolean) request.getAttribute("isFavNew");
                            if (isFavNew == false) {%>
                        <a href="SaveNew?user=<%= (Integer) session.getAttribute("id_user_session")%>&news=<%= newSelect.getIdnews()%>&acc=add" class="">
                            <i class='far fa-bookmark' style='font-size:24px'></i>
                        </a>
                        <%} else if (isFavNew == true) {%>
                        <a href="SaveNew?user=<%= (Integer) session.getAttribute("id_user_session")%>&news=<%= newSelect.getIdnews()%>&acc=delete" class="">
                            <i class='fas fa-bookmark' style='font-size:24px'></i>
                        </a>
                        <%}}%>
                    </div>
                    <%if (author.getPathImage() != null) {%>
                    <img  src="<%= author.getPathImage()%>"
                          class="img text-center " alt="..."/>
                    <%} else { %>
                    <img  src="https://www.softzone.es/app/uploads/2018/04/guest.png"
                          class="img text-center " alt="..."/>
                    <%}%>
                    <a href="Porfile?user=<%= author.getIduser()%>" style="text-decoration: none; color: black;"><h5 class="card-title text-center "><%=author.getUser_name()%></h5></a>
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


                <div class=" corto">
                    <p><%=newSelect.getNewsDescription()%></p>
                </div>

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

                <div class=" descrip">
                    <p>
                        <h5><%=newSelect.getNewsContent()%></h5>
                    </p>
                </div>
                <div>
                    <% if (session.getAttribute("id_user_session") != null){
                        if (listLikeDislike.isEmpty() != true) {
                            int isLike = 0;
                            for (LikeDislikeNewsModel like : listLikeDislike) {
                                if (like.getPlikedislikenewsIdUser() == (Integer) session.getAttribute("id_user_session") && (like.getPlikedislikenewsType() == 1) && (like.getPlikedislikenewsIdNew() == newSelect.getIdnews())) {
                                    isLike = 1;
                    %>
                    <a href="LikesNew?acc=likeNew&not=<%= newSelect.getIdnews()%>" class=""  >
                        <i class='fas fa-heart' style='font-size:24px; padding: 5px; color: red;'><%= newSelect.getNewsLikeCount()%></i>
                    </a>
                    <%}
                        }
                        if (isLike == 0) {%>
                    <a href="LikesNew?acc=likeNew&not=<%= newSelect.getIdnews()%>" class="">
                        <i class='fas fa-heart' style='font-size:24px; padding: 5px;'><%= newSelect.getNewsLikeCount()%></i>
                    </a>
                    <%}
                    } else {%>
                    <a href="LikesNew?acc=likeNew&not=<%= newSelect.getIdnews()%>" class="">
                        <i class='fas fa-heart' style='font-size:24px; padding: 5px;'><%= newSelect.getNewsLikeCount()%></i>
                    </a>
                    <%}%>
                    <% if (listLikeDislike.isEmpty() != true) {
                            int isLike = 0;
                            for (LikeDislikeNewsModel like : listLikeDislike) {
                                if (like.getPlikedislikenewsIdUser() == (Integer) session.getAttribute("id_user_session") && (like.getPlikedislikenewsType() == 2) && (like.getPlikedislikenewsIdNew() == newSelect.getIdnews())) {
                                    isLike = 1;
                    %>
                    <a href="LikesNew?acc=dislikeNew&not=<%= newSelect.getIdnews()%>" class=""  >
                        <i class='fas fa-heart-broken' style='font-size:24px; padding: 5px; color: red;'><%= newSelect.getNewsDislikeCount()%></i>
                    </a>
                    <%}
                        }
                        if (isLike == 0) {%>
                    <a href="LikesNew?acc=dislikeNew&not=<%= newSelect.getIdnews()%>" class="">
                        <i class='fas fa-heart-broken' style='font-size:24px; padding: 5px;'><%= newSelect.getNewsDislikeCount()%></i>
                    </a>
                    <%}
                    } else {%>
                    <a href="LikesNew?acc=dislikeNew&not=<%= newSelect.getIdnews()%>" class="">
                        <i class='fas fa-heart-broken' style='font-size:24px; padding: 5px;'><%= newSelect.getNewsDislikeCount()%></i>
                    </a>
                    <%}}%>
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
                                            <h6 class="comment-name by-author"><a href="Porfile?user=<%= comUser.getIduser()%>"><%= comUser.getUser_name()%></a></h6>
                                            <span><%= commentary.getCommentaryDate()%></span>  
                                            <div class="boton-corazon text-right">
                                                <% if (likelist.isEmpty() != true) {
                                                        int isLike = 0;
                                                        for (LikeCommentaryModel like : likelist) {
                                                            if ((like.getPlikecommentsCommentary() == commentary.getIdcommentary()) && ((Integer) session.getAttribute("id_user_session") == like.getPlikecommentsUser())) {
                                                                isLike = 1;
                                                %>
                                                <a href="Commentary?comid=<%= commentary.getIdcommentary()%>&acc=deleteLike&not=<%= newSelect.getIdnews()%>&likeid=<%= like.getPidlikecomments()%>" class="">
                                                    <i class='fas fa-heart' style='font-size:24px'><%= commentary.getCommentaryCountLikes()%></i>
                                                </a>
                                                <%}
                                                    }
                                                    if (isLike == 0) {%>
                                                <a href="Commentary?comid=<%= commentary.getIdcommentary()%>&acc=likeCom&not=<%= newSelect.getIdnews()%>" class="">
                                                    <i class='far fa-heart' style='font-size:24px'><%= commentary.getCommentaryCountLikes()%></i>
                                                </a>
                                                <%}
                                                } else {%>
                                                <a href="Commentary?comid=<%= commentary.getIdcommentary()%>&acc=likeCom&not=<%= newSelect.getIdnews()%>" class="">
                                                    <i class='far fa-heart' style='font-size:24px'><%= commentary.getCommentaryCountLikes()%></i>
                                                </a>
                                                <%}%>
                                                <%Integer userType =(Integer) session.getAttribute("userType_user_session");
                                                    if(userType != null && (userType == 2 || userType == 4)){%>
                                                <a data-toggle="modal" data-target="#exampleModal" class=""> 
                                                    <i class='far fa-trash-alt' style='font-size:24px'></i>
                                                </a>
                                                <%}%>
                                            </div>
                                            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                <div class="modal-dialog">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <h5 class="modal-title" id="exampleModalLabel">New message</h5>
                                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                                <span aria-hidden="true">&times;</span>
                                                            </button>
                                                        </div>
                                                        <div class="modal-body">
                                                            <form action="./Sancionar" method="POST"  >
                                                                <div class="form-group">
                                                                    <label for="sancion">Sancion</label>
                                                                    <select name="sancion" id="sancion" class="form-control">
                                                                        <option value="1">Temporal</option>
                                                                        <option value="2">Permanente</option>
                                                                    </select>
                                                                    |<input type="hidden" name="idUser" value="<%= commentary.getCommentaryUser()%>">
                                                                    <input type="hidden" name="idCom" value="<%= commentary.getIdcommentary() %>">
                                                                    <input type="hidden" name="idNew" value="<%= commentary.getCommentaryNews()%>">
                                                                </div>
                                                            </form>
                                                        </div>
                                                        <div class="modal-footer">
                                                            <a type="button" class="btn btn-secondary" data-dismiss="modal">Borrar Comentario</a>
                                                            <input type="submit" class="btn btn-primary">Borrar Comentario y Sancionar</input>
                                                        </div>
                                                    </div>
                                                </div>
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
                                    <div class="comment-avatar"><img src="<%= pic2%>" alt=""></div>
                                    <%} else {%>
                                    <div class="comment-avatar"><img src="https://www.softzone.es/app/uploads/2018/04/guest.png" alt=""></div>    
                                    <%}%>
                                    <!-- Contenedor del Comentario -->
                                    <div class="comment-box">
                                        <div class="comment-head">
                                            <h6 class="comment-name"><a href="Porfile?user=<%= ansUser.getIduser()%>"><%= ansUser.getUser_name()%></a></h6>
                                            <span><%=answer.getAnswerDate()%>   </span>
                                            <div class="boton text-right">
                                                <% if (likelistAnswer.isEmpty() != true) {
                                                        int isLike = 0;
                                                        for (LikeAnswerModel like : likelistAnswer) {
                                                            if ((like.getLikeanswerAnswer() == answer.getIdanswer()) && ((Integer) session.getAttribute("id_user_session") == like.getLikeanswerUser())) {
                                                                isLike = 1;
                                                %>
                                                <a href="Commentary?ansid=<%= answer.getIdanswer()%>&acc=deleteLikeAns&not=<%= newSelect.getIdnews()%>&likeid=<%= like.getIdlikeanswer()%>" class="">
                                                    <i class='fas fa-heart' style='font-size:24px'><%= answer.getAnswerCountLike()%></i>
                                                </a>
                                                <%}
                                                    }
                                                    if (isLike == 0) {%>
                                                <a href="Commentary?ansid=<%= answer.getIdanswer()%>&acc=likeAns&not=<%= newSelect.getIdnews()%>" class="">
                                                    <i class='far fa-heart' style='font-size:24px'><%= answer.getAnswerCountLike()%></i>
                                                </a>
                                                <%}
                                                } else {%>
                                                <a href="Commentary?ansid=<%= answer.getIdanswer()%>&acc=likeAns&not=<%= newSelect.getIdnews()%>" class="">
                                                    <i class='far fa-heart' style='font-size:24px'><%= answer.getAnswerCountLike()%></i>
                                                </a>
                                                <%}%>
                                                <a href="Commentary?ansid=<%= answer.getIdanswer()%>&acc=deleteAns&not=<%= newSelect.getIdnews()%>" class="">
                                                    <i class='far fa-trash-alt' style='font-size:24px'></i>
                                                </a>
                                            </div>
                                        </div>
                                        <div class="comment-content"><%=answer.getAnswerContent()%></div>
                                    </div>
                                </li>
                            </ul>
                            <%}
                                }%>
                        </li>
                        <form method="POST" action="./ViewNew">
                            <div class="form-group comment-box" style="margin-top: -30px" >
                                <textarea name="content" id="description" class="form-control" style="margin-top: 5px;" ></textarea>
                                <div class="text-right">
                                    <input name="comentario" type="text" value="<%= commentary.getIdcommentary()%>" style="display: none;" />
                                    <button id="btn-comment" type="submit" class="btn btn-primary" name="accion" value="Responder" style="margin-top: 5px;">Responder</button>
                                </div>
                            </div>
                        </form>
                    </ul> 
                    <%}
                        }%>

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
