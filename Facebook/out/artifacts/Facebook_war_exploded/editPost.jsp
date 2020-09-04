<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="Model.Post" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.Comment" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: Mondris
  Date: 8/30/2020
  Time: 10:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Map<Post, List<Comment>>posts = (Map<Post, List<Comment>>) request.getAttribute("userPosts");
    pageContext.setAttribute("posts", posts);
%>
<html>
<head>
    <title>Welcome To DashBoard - Edit-Post</title>
    <!-- CSS only -->
    <style type="text/css">
        <%@include file="./css/dashboard.css" %>
    </style>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.min.css">

</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01"
            aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
        <a class="navbar-brand" href="#"><img
                src="https://www.freeiconspng.com/uploads/facebook-f-logo-white-background-21.jpg" width="40"
                height="30" alt="facebook f logo white background"/></a>

        <form id="searchBar" class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <li class="nav-item active">
                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Messages</a>
            </li>
            <li class="nav-item">
                <a class="nav-link " href="#" tabindex="-1">My Profile</a>
            </li>
            <li class="nav-item">
                <a class="nav-link " href="#" tabindex="-1">Friends</a>
            </li>
        </ul>
    </div>
</nav>

<div id="myfriends-right-hand" class="card" style="width: 18rem;">
    <img src="..." class="card-img-top" alt="...">
    <div class="card-body">
        <h5 class="card-title">My Friends</h5>
        <ul class="list-group list-group-flush">
            <li class="list-group-item">Cras justo odio <a href="#">view</a></li>
            <li class="list-group-item">Dapibus ac facilisis in <a href="#">view</a></li>
            <li class="list-group-item">Vestibulum at eros <a href="#">view</a></li>
            <li class="list-group-item">Cras justo odio <a href="#">view</a></li>
            <li class="list-group-item">Dapibus ac facilisis in <a href="#">view</a></li>
            <li class="list-group-item">Vestibulum at eros <a href="#">view</a></li>
            <li class="list-group-item">Cras justo odio <a href="#">view</a></li>
            <li class="list-group-item">Dapibus ac facilisis in <a href="#">view</a></li>
            <li class="list-group-item">Vestibulum at eros <a href="#">view</a></li>
        </ul>
    </div>

</div>
<%Post postToEdit = (Post) request.getAttribute("postToEdit");%>
<div id="postSection">
    <div class="form-group shadow-textarea">
        <form action="./edit?postID=<%= postToEdit.getPostID()%>" method="POST">
            <label for="exampleFormControlTextarea6">Edit Post</label>
            <textarea class="form-control z-depth-1" id="exampleFormControlTextarea6" rows="3" name="postMessage"
                      placeholder="Whats On Your Mind?"><%= postToEdit.getMessage()%></textarea>
            <input type="hidden"  name="postID" value="<%= postToEdit.getPostID()%>">
            <button type="submit" class="btn btn-secondary btn-sm">Update</button>
        </form>
    </div>
</div>

<div class="container">
    <%--for loop to display use posts--%>
    <%----%>
    <c:forEach var="post" items="${posts}">
        <div class="row">

            <div class="col-md-12">
                <div id="content" class="content content-full-width">
                    <div class="profile-content">
                        <!-- begin tab-content -->
                        <div class="tab-content p-0">
                            <!-- begin #profile-post tab -->
                            <!-- begin timeline -->
                            <ul class="timeline">
                                <div class="timeline-body">
                                    <div class="timeline-header">
                                            <span class="userimage"><img
                                                    src="https://bootdey.com/img/Content/avatar/avatar3.png"
                                                    alt=""></span>
                                        <span class="username"><a
                                                href="javascript:;">Sean Ngu</a> <small></small></span>
                                        <span class="pull-right text-muted">Date: ${ post.key.date}</span>
                                    </div>
                                    <div class="timeline-content">
                                        <p>
                                                ${post.key.message}
                                        </p>
                                    </div>
                                    <div class="timeline-likes">
                                        <div class="stats">
                                        <span class="fa-stack fa-fw stats-icon">
                                        <i class="fa fa-circle fa-stack-2x text-danger"></i>
                                        <i class="fa fa-heart fa-stack-1x fa-inverse t-plus-1"></i>
                                        </span>
                                            <span class="fa-stack fa-fw stats-icon">
                                        <i class="fa fa-circle fa-stack-2x text-primary"></i>
                                        <i class="fa fa-thumbs-up fa-stack-1x fa-inverse"></i>
                                        </span>
                                            <span class="stats-total">${post.key.totalLikes}</span>
                                        </div>
                                    </div>
                                    <div class="timeline-footer">
                                        <a href="javascript:;" class="m-r-15 text-inverse-lighter"><i
                                                class="fa fa-thumbs-up fa-fw fa-lg m-r-3"></i> <a href="./like?postID=${post.key.postID}">Like</a></a>
                                        <a href="javascript:;" class="m-r-15 text-inverse-lighter"><i
                                                class="fa fa-comments fa-fw fa-lg m-r-3"></i><a href="#comment">Comment</a></a>
                                        <a href="javascript:;" class="m-r-15 text-inverse-lighter">
                                            <i class=" iconbtn fa fa-pencil-square-o" aria-hidden="true"></i><a href="./edit?postID=${post.key.postID}"> Edit </a>

                                            <a href="javascript:;" class="m-r-15 text-inverse-lighter">
                                                <i class=" iconbtn fa fa-pencil-square-o" aria-hidden="true"></i><a href="./delete?postID=${post.key.postID}"> Delete </a>
                                    </div>
                                    <div class="timeline-comment-box">
                                        <div class="user"><img src="https://bootdey.com/img/Content/avatar/avatar3.png">
                                        </div>
                                        <div class="input">
                                            <form action="./comment?postID=${post.key.postID}" method="POST">

                                                <div class="input-group">
                                                    <input name="comment" type="text" class="form-control rounded-corner"
                                                           placeholder="Write a comment...">
                                                    <span class="input-group-btn p-l-10">
                                              <button class="btn btn-primary f-s-12 rounded-corner"
                                                      type="submit">Comment</button>
                                              </span>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>

                                <c:forEach var ="comment" items="${post.value}">

                                <div id="comment" class="card">
                                    <div class="card-header">
                                        Comment
                                        <h6>Date:${comment.date}</h6>
                                    </div>
                                    <div class="card-body">
                                        <blockquote class="blockquote mb-0">
                                            <p>${comment.comment}</p>
                                            <footer class="blockquote-footer">Powered By  <cite title="Source Title">Mondris</cite></footer>
                                        </blockquote>
                                    </div>
                                </div>
                                </c:forEach>
                                <!-- end timeline-body -->
                                <!-- end #profile-post tab -->
                        </div>
                        <!-- end tab-content -->
                    </div>
                    <!-- end profile-content -->
                </div>
            </div>
        </div>

    </c:forEach>
    <br>
    <br>
    <%--show posts and comment section--%>

</div>


<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
        integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
        crossorigin="anonymous"></script>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">

<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="http://netdna.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>

</body>
</html>
