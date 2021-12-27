<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% pageContext.setAttribute("forwardPath", request.getAttribute(RequestDispatcher.FORWARD_SERVLET_PATH));%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="${contextPath}"> EasyRecruit </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item ${forwardPath == '/ShowAllProducts' ? ' active' : ''}">
                <a class="nav-link" href="${contextPath}/ShowAllProducts">Products</a>
            </li>
            <c:choose>
                <c:when test="${pageContext.request.isUserInRole('ManageMyApplicationsRole')}">
                    <li class="nav-item ${forwardPath == '/Applications' ? ' active' : ''}">
                        <a class="nav-link" href="${contextPath}/Applications">My Applications</a>
                    </li>
                </c:when>    
                <c:otherwise>
                    <c:if test="${pageContext.request.isUserInRole('ReadAllApplicationsRole')}"> 
                        <li class="nav-item ${forwardPath == '/ApplicationsListAll' ? ' active' : ''}">
                            <a class="nav-link" href="${contextPath}/ApplicationsListAll">All Applications</a>
                        </li>
                    </c:if>
                </c:otherwise>
            </c:choose>
            <c:if test="${pageContext.request.isUserInRole('ManageUsersRole')}">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Manage Users</a>
                    <div class="dropdown-menu" aria-labelledby="dropdown01">
                        <a class="dropdown-item" href="${contextPath}/Users">List Users</a>
                        <a class="dropdown-item" href="${contextPath}/Users/Add">Add Users</a>
                        <a class="dropdown-item" href="${contextPath}/Users/ListEdit">Edit Users</a>
                        <a class="dropdown-item" href="${contextPath}/Users/Delete">Delete Users</a>
                    </div>
                </li>
            </c:if>
        </ul>
        <ul class="navbar-nav ml-auto">
            <c:if test="${pageContext.request.getRemoteUser() != null}">
                <li class="nav-item navbar-text">
                    Welcome back ${pageContext.request.getRemoteUser()}
                </li>
            </c:if> 
            <li class="nav-item">
                <c:choose>
                    <c:when test="${pageContext.request.getRemoteUser() == null}"> 
                        <a class="nav-link" href="${contextPath}/Login">Login</a>
                    </c:when>
                    <c:otherwise>
                        <a class="nav-link" href="${contextPath}/Logout">Logout</a>
                    </c:otherwise>
                </c:choose>
            </li>
        </ul>
    </div>
</nav>
