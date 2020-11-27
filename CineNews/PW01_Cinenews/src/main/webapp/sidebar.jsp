<% Integer userType = (Integer) session.getAttribute("userType_user_session"); %>       
        <div class="bg-light border-right" id="sidebar-wrapper">
            <div class="list-group list-group-flush">
                <a href="MySettings" class="list-group-item list-group-item-action">
                    <i class='fas fa-tools' style='font-size:18px;color: black'></i>
                    My settings</a>
                <a href="#" class="list-group-item list-group-item-action">
                    <i class='far fa-save' style='font-size:18px;color: black'></i>
                    Saved news
                </a>
                <a href="#" class="list-group-item list-group-item-action">
                    <i class='far fa-hand-point-up' style='font-size:18px;color: black'></i>
                    Interactions
                </a>
                <a href="#" class="list-group-item list-group-item-action">
                    <i class='fas fa-exclamation-triangle' style='font-size:18px;color: black'></i>
                    Warnings
                </a>
                <% if(userType >= 2){ %>
                <a href="CreateNew" class="list-group-item list-group-item-action">
                    <i class='far fa-edit' style='font-size:18px;color: black'></i>
                    Create news
                </a>
                <a href="Drafts" class="list-group-item list-group-item-action">
                    <i class='fas fa-pencil-alt' style='font-size:18px;color: black'></i>
                    Drafts
                </a>
                <a href="MyPost" class="list-group-item list-group-item-action">
                    <i class='far fa-folder-open' style='font-size:18px;color: black'></i>
                    My posts
                </a>
                <a href="Reviews" class="list-group-item list-group-item-action">
                    <i class='far fa-eye' style='font-size:18px;color: black'></i>
                    Reviews
                </a>
                <a href="InspectUsers" class="list-group-item list-group-item-action">
                    <i class='fas fa-users' style='font-size:18px;color: black'></i>
                    Inspect users
                </a>
                <%}%>
            </div>
        </div>
