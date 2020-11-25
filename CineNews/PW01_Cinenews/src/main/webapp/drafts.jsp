<%@page import="com.mycompany.pw01_cinews.utils.TypeClass"%>
<%@page import="com.mycompany.pw01_cinews.models.MediaModel"%>
<%@page import="com.mycompany.pw01_cinews.models.NewsModel"%>
<%@page import="java.util.List"%>
<% String user = (String) session.getAttribute("name_user_session");
    List<NewsModel> newsUser = (List<NewsModel>) request.getAttribute("NewsUser");
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
                if (news.getNewsStatus() == 0) {
        %>
        <div class="col-md-4" style=" padding: 10px; ">
            <%for (MediaModel media : medias) {
                    if (media.getMediNoticia() == news.getIdnews()) {
                        if (media.getMediaUrl() != null) {%>
            <img src="<%= media.getMediaUrl()%>"
                 class="card-img" alt="...">
            <%} else {%>
            <img src="https://www.pequenomundo.cl/wp-content/themes/childcare/images/default.png"
                 class="card-img" alt="...">
            <%}
                        }
                    }%>
            <div class="card mb-4 shadow-sm">
                <div class="card-body">
                    <h5 class="card-title"><%= news.getNewsTitle()%></h5>
                    <p class="card-text"><%= news.getNewsDescription()%></p>
                    <div class="d-flex justify-content-between align-items-center">
                        <div class="btn-group">
                            <button type="button" class="btn btn-sm btn-outline-secondary" id="menu-toggle" style = "background-color:  #aa66cc; border: #aa66cc; color: white;">Edit</button>
                        </div>
                        <small class="text-muted">Last updated <%= news.getNewDate()%><i class='far fa-calendar' style='font-size:18px; color: #aa66cc;'></i>
                        </small>
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
