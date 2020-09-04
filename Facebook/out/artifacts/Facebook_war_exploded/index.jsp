<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Facebook login - or sign up</title>
    <!-- CSS only -->
  <style type="text/css">
    <%@include file="./css/index.css" %>
  </style>
<%--    <%--%>
<%--       String errorMessage1 = (String) request.getAttribute("errorMessage");--%>

<%--            out.println(request.getAttribute("errorMessage"));--%>

<%--    %>--%>
<%--    get the error message--%>
<%--    <% String errorMessage = (String) request.getAttribute("errorMessage");--%>
<%--    %>--%>

  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<main role="main" class="flex-shrink-0" id="left">
    <div class="container">
        <h1 class="mt-5"><img src="https://static.xx.fbcdn.net/rsrc.php/y8/r/dF5SId3UHWd.svg"></h1>
        <p class="lead">Facebook helps you connect and share<br> with the people in your life.</p>
    </div>

</main>
<div class="card">
    <div class="card-body">
        <form action="./login" method="POST">
            <c:set var="message" value="${errorMessage}"/>
<%--            <c:if test="${not empty message}" >--%>
                    <h6 id="errorMessage"><c:out value="${message}"/> </h6>
<%--            </c:if>--%>
            <div class="form-group">
                <input name="email" type="email" class="form-control" id="exampleInputEmail1"
                       aria-describedby="emailHelp" placeholder="Email address or phone number">
            </div>
            <div class="form-group">
                <input name="password" type="password" class="form-control" id="exampleInputPassword1"
                       placeholder="Password">
            </div>

            <button type="submit" class="submitbtn">Login</button>
            <br><br>
            <center><a href="/forgetPass">Forgotten account?</a></center>
            <hr>
            <center>
                <button type="button" class="createAccountBtn" data-toggle="modal" data-target="#exampleModal"
                        class="signupBtn">Create New Account
                </button>
            </center>
            <br><br>
        </form>
    </div>
</div>

<!-- Button trigger modal -->
<%--  <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo">Open modal for @mdo</button>--%>

<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">SignUP</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form action="./signup" method="post">
                    <!-- Grid row -->
                    <div class="form-row">
                        <!-- Default input -->
                        <div class="form-group col-md-6">
                            <input type="text" class="form-control" id="inputEmail4" placeholder="firstName"
                                   name="firstName" required>
                        </div>
                        <!-- Default input -->
                        <div class="form-group col-md-6">
                            <input type="text" class="form-control" id="inputPassword4" placeholder="Surname"
                                   name="lastName" required>
                        </div>
                    </div>
                    <!-- Grid row -->

                    <!-- Default input -->
                    <div class="form-group">
                        <input type="text" class="form-control" id="inputAddress"
                               placeholder="Email address" name="email" required>
                    </div>
                    <!-- Default input -->
                    <div class="form-group">
                        <input type="password" class="form-control" id="inputAddress2" placeholder="New password"
                               name="password" required>
                    </div>
                    <!-- Grid row -->
                    <label> Date of Birth</label>
                    <div class="form-row">
                        <!-- Default input -->
                        <select aria-label="Day" name="birthday_day" id="day" title="Day" class="dob"
                                aria-describedby="js_5">
                            <option value="0">Day</option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6</option>
                            <option value="7">7</option>
                            <option value="8">8</option>
                            <option value="9">9</option>
                            <option value="10">10</option>
                            <option value="11">11</option>
                            <option value="12">12</option>
                            <option value="13">13</option>
                            <option value="14">14</option>
                            <option value="15">15</option>
                            <option value="16">16</option>
                            <option value="17">17</option>
                            <option value="18">18</option>
                            <option value="19">19</option>
                            <option value="20">20</option>
                            <option value="21">21</option>
                            <option value="22">22</option>
                            <option value="23">23</option>
                            <option value="24">24</option>
                            <option value="25">25</option>
                            <option value="26">26</option>
                            <option value="27">27</option>
                            <option value="28">28</option>
                            <option value="29">29</option>
                            <option value="30">30</option>
                            <option value="31" selected="1">31</option>
                        </select> <br><br>
                        <select aria-label="Month" name="birthday_month" id="month" title="Month" class="dob">
                            <option value="0">Month</option>
                            <option value="1">Jan</option>
                            <option value="2">Feb</option>
                            <option value="3">Mar</option>
                            <option value="4">Apr</option>
                            <option value="5">May</option>
                            <option value="6">Jun</option>
                            <option value="7">Jul</option>
                            <option value="8" selected="1">Aug</option>
                            <option value="9">Sep</option>
                            <option value="10">Oct</option>
                            <option value="11">Nov</option>
                            <option value="12">Dec</option>
                        </select>
                        <select aria-label="Year" name="birthday_year" id="year" title="Year" class="dob">
                            <option value="0">Year</option>
                            <option value="2020" selected="1">2020</option>
                            <option value="2019">2019</option>
                            <option value="2018">2018</option>
                            <option value="2017">2017</option>
                            <option value="2016">2016</option>
                            <option value="2015">2015</option>
                            <option value="2014">2014</option>
                            <option value="2013">2013</option>
                            <option value="2012">2012</option>
                            <option value="2011">2011</option>
                            <option value="2010">2010</option>
                            <option value="2009">2009</option>
                            <option value="2008">2008</option>
                            <option value="2007">2007</option>
                            <option value="2006">2006</option>
                            <option value="2005">2005</option>
                            <option value="2004">2004</option>
                            <option value="2003">2003</option>
                            <option value="2002">2002</option>

                        </select>
                    </div>
                    <label>Gender</label>
                    <div class="form-row">
                        <!-- Grid row -->
                        <div id="gender">
                            <span class="_5k_3" data-type="radio" data-name="gender"></span>
                          <span class="_5k_2 _5dba"><label class="_58mt">Male</label><input type="radio" class="_8esa" name="gender" value="Male"></span>
                            <span class="_5k_3" data-type="radio" data-name="gender"></span>
                          <span class="_5k_2 _5dba"><label class="_58mt">Female</label><input type="radio" class="_8esa"
                                                                                              name="gender"
                                                                                              value="Female"></span><br>
                            <span id="terms">By clicking Sign Up, you agree to our Terms, Data Policy and Cookie Policy. You may receive SMS notifications from us and can opt out at any time.</span><br>
                            <div style="text-align: center;">
                                <button type="submit" class="signup" class="btn btn-primary btn-md">Sign Up</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
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
