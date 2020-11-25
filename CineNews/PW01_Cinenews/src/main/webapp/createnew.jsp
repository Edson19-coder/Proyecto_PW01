<%@page import="com.mycompany.pw01_cinews.models.CategoryModel"%>
<%@page import="java.util.List"%>
<% String user = (String) session.getAttribute("name_user_session");
   List<CategoryModel> categories = (List<CategoryModel>) request.getAttribute("Categories");
%>
<jsp:include page="head.jsp">
    <jsp:param name="nameSecc" value="Home"/>
</jsp:include>
<% if(user != null){ %>
    <jsp:include page="navbar.jsp">
        <jsp:param name="userSession" value="<%=user%>" />
    </jsp:include>
<%}else{%>
    <%@include file= "navbar.jsp" %> 
<%}%>
    <link rel="stylesheet" href="assets/css/createnew.css">
<!--------------------------------------------------------- CONTENT --------------------------------------------------------->
    <div class="d-flex" id="wrapper">

        <!-- Sidebar -->
        <%@include file= "sidebar.jsp" %> 
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
    <!-- Menu Toggle Script -->
    <script src="assets/js/menu-toggle.js"></script>
</body>

</html>
