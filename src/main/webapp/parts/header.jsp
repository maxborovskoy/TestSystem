<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="site-content bg-light">
    <header class="bg-dark">
            <%@ include file="lang.jsp" %>
            <div class="container">
                <div class="row">

                    <div class="col-md-9 py-4">
                        <h4 class="text-white">${headerTitle}</h4>
                        <p class="text-muted">${headerDesc}</p>
                    </div>

                    <c:choose>
                    <c:when test="${sessionScope.user.getTutor()}">

                        <div class="btn-group">
                            <div><a href="/editor.jsp" class="btn btn-primary">Create test</a></div>
                            <div><a href="/userListServlet" class="btn btn-primary">Users</a></div>
                            <div><a href="/logoutServlet" class="btn btn-primary">Log out</a></div>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="btn-group">
                           <div><a href="/profileServlet" class="btn btn-primary">Result page</a></div>
                           <div><a href="/logoutServlet" class="btn btn-primary">Log out</a></div>
                        </div>
                     </c:otherwise>
                    </c:choose>

                </div>
            </div>
    </header>

    <div class="container">