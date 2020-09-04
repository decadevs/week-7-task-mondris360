<%--
  Created by IntelliJ IDEA.
  User: Mondris
  Date: 8/30/2020
  Time: 10:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome To DashBoard</title>
    <!-- CSS only -->
    <style type="text/css">
        <%@include file="./css/dashboard.css" %>
    </style>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
        <a class="navbar-brand" href="#"><img src="https://www.freeiconspng.com/uploads/facebook-f-logo-white-background-21.jpg" width="40"  height="30" alt="facebook f logo white background" /></a>

        <form id="searchBar"class="form-inline my-2 my-lg-0">
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
                <a class="nav-link " href="#" tabindex="-1" >My Profile</a>
            </li>
            <li class="nav-item">
                <a class="nav-link " href="#" tabindex="-1" >Friends</a>
            </li>
        </ul>
    </div>
</nav>

<div id="myfriends-right-hand"class="card" style="width: 18rem;">
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
        </ul>    </div>

</div>

<div id="postSection">

        <div class="form-group shadow-textarea">
                <form action="./dashboard" method="POST">
                <label for="exampleFormControlTextarea6">Create a Post</label>
                <textarea class="form-control z-depth-1" id="exampleFormControlTextarea6" rows="3" name="postMessage" placeholder="Whats On Your Mind?"></textarea>
                <button type="submit" class="btn btn-secondary btn-sm">Post</button>
            </form>
        </div>

<%--    <div class="media">--%>
<%--        <img class="d-flex rounded-circle avatar z-depth-1-half mr-3" src="https://mdbootstrap.com/img/Photos/Avatars/avatar-5.jpg"--%>
<%--             alt="Avatar">--%>
<%--        <div class="media-body">--%>
<%--            <h5 class="mt-0 font-weight-bold blue-text">Anna Smith</h5>--%>
<%--            Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus--%>
<%--            odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate--%>
<%--            fringilla. Donec lacinia congue felis in faucibus.--%>

<%--            <div class="media mt-3 shadow-textarea">--%>
<%--                <img class="d-flex rounded-circle avatar z-depth-1-half mr-3" src="https://mdbootstrap.com/img/Photos/Avatars/avatar-8.jpg"--%>
<%--                     alt="Generic placeholder image">--%>
<%--                <div class="media-body">--%>
<%--                    <h5 class="mt-0 font-weight-bold blue-text">Danny Tatuum</h5>--%>
<%--                    <div class="form-group basic-textarea rounded-corners">--%>
<%--                        <textarea class="form-control z-depth-1" id="exampleFormControlTextarea345" rows="3" placeholder="Write your comment..."></textarea>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--    <div class="media">--%>
<%--        <img class="d-flex rounded-circle avatar z-depth-1-half mr-3" src="https://mdbootstrap.com/img/Photos/Avatars/avatar-10.jpg"--%>
<%--             alt="Avatar">--%>
<%--        <div class="media-body">--%>
<%--            <h5 class="mt-0 font-weight-bold blue-text">Caroline Horwitz</h5>--%>
<%--            Lorem ipsum dolor sit amet, consectetur adipisicing elit. Corporis odit minima eaque dignissimos recusandae--%>
<%--            officiis commodi nulla est, tempore atque voluptas non quod maxime, iusto, debitis aliquid? Iure ipsum,--%>
<%--            itaque.--%>
<%--        </div>--%>
<%--    </div>--%>

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
</body>
</html>
