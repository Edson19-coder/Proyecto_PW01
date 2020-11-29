<%@page import="com.mycompany.pw01_cinews.models.NewsModel"%>
<%@page import="com.mycompany.pw01_cinews.models.CategoryModel"%>
<%@page import="java.util.List"%>
<% String user = (String) session.getAttribute("name_user_session");
    List<CategoryModel> categories = (List<CategoryModel>) request.getAttribute("Categories");
    String acc = (String) request.getAttribute("acc");
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
<link rel="stylesheet" href="assets/css/createnew.css">
<!--------------------------------------------------------- CONTENT --------------------------------------------------------->
<div class="d-flex" id="wrapper">

    <!-- Sidebar -->
    <%@include file= "sidebar.jsp" %> 
    <% if (acc.equals("crear")) { %>
    <!-- Page Content -->
    <div id="page-content-wrapper">

        <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
            <button class="btn btn-primary" id="menu-toggle">Menu</button>
        </nav>

        <div class="container-fluid text-center">
            <form action="./CreateNew" method="POST" enctype="multipart/form-data" class="" style="padding-top: 20px;">
                <div class="form-group">
                    <input type="text" name="title" titulo="" tit="" placeholder="Título" class="form-control">
                </div>
                <div class="form-group">
                    <input type="text" name="description" descripcion="" desc="" placeholder="Descripción" class="form-control">
                </div> 
                <div class="form-group">
                    <textarea name="content" name="content" id="description" class="form-control" placeholder="Cuerpo de la Noticia"></textarea>
                </div>
                <input type="hidden" name="acc" placeholder="Descripción" class="form-control" value="crear">
                <div class="form-group">
                    <label for="category">Categoria</label>
                    <select name="category" id="category" class="form-control">
                        <option value="-1">Categoria</option>
                        <%
                            for (CategoryModel category : categories) {
                        %>
                        <option value="<%= category.getIdcategory()%>"><%= category.getName()%></option>
                        <%
                            }
                        %>
                    </select>
                </div>
                <div class="form-group" >
                    <label for="exampleFormControlFile1">Example file input</label>
                    <input type="file" name="image" class="form-control-file" id="exampleFormControlFile1">
                    <input type="file" name="image2" class="form-control-file" id="exampleFormControlFile1">
                    <input type="file" name="image3" class="form-control-file" id="exampleFormControlFile1">
                    <small id="emailHelp" class="form-text text-muted">El tamaño maximo de archivo es 5 Mb</small>
                </div>
                <button id="btn-login-id" type="submit" class="btn btn-primary col-3">Create</button>
            </form>
        </div> 
    </div>
</div>
<%} else if (acc.equals("editar")) {
    NewsModel draft = (NewsModel) request.getAttribute("new");
%>
<!-- Page Content -->
<div id="page-content-wrapper">

    <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
        <button class="btn btn-primary" id="menu-toggle">Menu</button>
    </nav>
    <h1 style="text-align: center;" >Draft</h1>
    <div class="container-fluid text-center">
        <form action="" method="POST" enctype="multipart/form-data" class="" style="padding-top: 20px;">
            <div class="form-group">
                <input type="text" name="title" titulo="" tit="" placeholder="Título" class="form-control" value="<%= draft.getNewsTitle()%>">
            </div>
            <div class="form-group">
                <input type="text" name="description" descripcion="" desc="" placeholder="Descripción" class="form-control" value="<%= draft.getNewsDescription()%>">
            </div> 
            <div class="form-group">
                <textarea name="content" name="content" id="description" class="form-control" placeholder="Cuerpo de la Noticia"><%= draft.getNewsContent()%></textarea>
            </div>
            <input type="hidden" name="idNew" placeholder="Descripción" class="form-control" value="<%= draft.getIdnews() %>">
            <input type="hidden" name="acc" placeholder="Descripción" class="form-control" value="editar">
            <div class="form-group">
                <label for="category">Categoria</label>
                <select name="category" id="category" class="form-control">
                    <option value="-1">Categoria</option>
                    <%
                        for (CategoryModel category : categories) {
                            if (draft.getNewsCategory() == category.getIdcategory()) {
                    %>
                    <option selected="selected" value="<%= category.getIdcategory()%>"><%= category.getName()%></option>
                    <%} else {%>
                    <option value="<%= category.getIdcategory()%>"><%= category.getName()%></option>
                    <%
                            }
                        }
                    %>
                </select>
            </div>
            <div class="form-group" >
                <label for="exampleFormControlFile1">Selecciona las imagenes de las noticias (La primera imagen seleccionada sera la miniatura de la imagen)</label>
                <input type="file" name="image" class="form-control-file" id="exampleFormControlFile1">
                <input type="file" name="image2" class="form-control-file" id="exampleFormControlFile1">
                <input type="file" name="image3" class="form-control-file" id="exampleFormControlFile1">
                <small id="emailHelp" class="form-text text-muted">El tamaño maximo de archivo es 5 Mb</small>
            </div>
            <button id="btn-login-id" type="submit" class="btn btn-primary col-3">Crear</button>
        </form>
    </div> 
</div>
</div>
<%} else if (acc.equals("editarDeny")) {
    NewsModel draft = (NewsModel) request.getAttribute("new");
%>
    <div id="page-content-wrapper">

    <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
        <button class="btn btn-primary" id="menu-toggle">Menu</button>
    </nav>
    <h1 style="text-align: center;" >Edit New</h1>
    <div class="container-fluid text-center">
        <form action="" method="POST" enctype="multipart/form-data" class="" style="padding-top: 20px;">
            <div class="form-group">
                <input type="text" name="title" titulo="" tit="" placeholder="Título" class="form-control" value="<%= draft.getNewsTitle()%>">
            </div>
            <div class="form-group">
                <input type="text" name="description" descripcion="" desc="" placeholder="Descripción" class="form-control" value="<%= draft.getNewsDescription()%>">
            </div> 
            <div class="form-group">
                <textarea name="content" name="content" id="description" class="form-control" placeholder="Cuerpo de la Noticia"><%= draft.getNewsContent()%></textarea>
            </div>
            <input type="hidden" name="idNew" placeholder="Descripción" class="form-control" value="<%= draft.getIdnews() %>">
            <input type="hidden" name="acc" placeholder="Descripción" class="form-control" value="editar">
            <div class="form-group">
                <label for="category">Categoria</label>
                <select name="category" id="category" class="form-control">
                    <option value="-1">Categoria</option>
                    <%
                        for (CategoryModel category : categories) {
                            if (draft.getNewsCategory() == category.getIdcategory()) {
                    %>
                    <option selected="selected" value="<%= category.getIdcategory()%>"><%= category.getName()%></option>
                    <%} else {%>
                    <option value="<%= category.getIdcategory()%>"><%= category.getName()%></option>
                    <%
                            }
                        }
                    %>
                </select>
            </div>
            <button id="btn-login-id" type="submit" class="btn btn-primary col-3">Crear</button>
        </form>
    </div> 
</div>
</div>
<%}%>
<!-- Menu Toggle Script -->
<script src="assets/js/menu-toggle.js"></script>
</body>

</html>
