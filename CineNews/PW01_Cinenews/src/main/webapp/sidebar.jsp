<% Integer userType = (Integer) session.getAttribute("userType_user_session"); %>       
        <div class="bg-light border-right" id="sidebar-wrapper">
            <div class="list-group list-group-flush">
                <a href="MySettings" class="list-group-item list-group-item-action">My settings</a>
                <a href="#" class="list-group-item list-group-item-action">Saved news</a>
                <a href="#" class="list-group-item list-group-item-action">Interactions</a>
                <a href="#" class="list-group-item list-group-item-action">Warnings</a>
                <% if(userType >= 2){ %>
                <a href="CreateNew" class="list-group-item list-group-item-action">Create news</a>
                <a href="Drafts" class="list-group-item list-group-item-action">Drafts</a>
                <a href="MyPost" class="list-group-item list-group-item-action">My posts</a>
                <a href="Reviews" class="list-group-item list-group-item-action">Reviews</a>
                <a href="InspectUsers" class="list-group-item list-group-item-action">Inspect users</a>
                <%}%>
            </div>
        </div>
