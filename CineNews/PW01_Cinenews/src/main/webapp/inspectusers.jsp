<%@page import="com.mycompany.pw01_cinews.utils.TypeClass"%>
<%@page import="com.mycompany.pw01_cinews.models.UserModel"%>
<%@page import="java.util.List"%>
<% String user = (String) session.getAttribute("name_user_session");
   List<UserModel> users = (List<UserModel>) request.getAttribute("Users");
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

            <div class="container-fluid">
                <table class="table">
                    <thead class="thead-dark">
                      <tr>
                        <th scope="col">#</th>
                        <th scope="col">Name</th>
                        <th scope="col">User type</th>
                        <th scope="col">Email</th>
                        <th scope="col">Actions</th>
                      </tr>
                    </thead>
                    <tbody>
                       <% for(UserModel element : users){%>
                        <tr>
                        <th scope="row"id="id"><%= element.getIduser() %></th>
                        <td><%= element.getUser_name() %></td>
                        <% String typeUs = TypeClass.GetUserType(element.getUser_type()); %>
                        <td id="ut"><%= typeUs %></td>
                        <td><%= element.getEmail() %></td>
                        <td><button type="submit" class="btn btn-success" id="ascend">Ascend</button>
                            <button type="submit" class="btn btn-danger" id="descend">Descend</button></td>
                      </tr>
                      <%}%>
                  </table>
            </div>
        </div>
    </div>
    <!-- Menu Toggle Script -->
    <script src="assets/js/menu-toggle.js"></script>
    <script src="assets/js/getInfoTable.js"></script>
</body>

</html>
