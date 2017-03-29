<%@ page import="model.UserInfo" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Thông Tin Cá Nhân</title>
    <link href="resources/style/bootstrap.min.css" type="text/css" rel="stylesheet" media="all">
    <link href="resources/style/style.css" type="text/css" rel="stylesheet" media="all">
    <link href="resources/style/font-awesome.css" rel="stylesheet">

    <script src="resources/script/jquery.min.js"></script>
    <script src="resources/script/bootstrap.min.js"></script>
</head>
<body>
<%
    UserInfo userInfo = (UserInfo)session.getAttribute("currentUser");
%>
<div class="buttons-wrapper">
    <ul class="slider">
        <li class="agileits">
            <!-- banner -->
            <div class="banner">
                <div class="banner-w3lsinfo">
                    <h2 style="color: #122;">Thông Tin Cá Nhân</h2>
                    <div class="action_button">
                        <form action="/logout" method="post" style="float:left">
                            <button class="btn btn-primary" type="submit">Đăng Xuất</button>
                        </form>
                        <form action="/update" method="get">
                            <button class="btn btn-primary" type>Cập Nhật</button>
                        </form>
                    </div>
                    <div class="container">
                        <div class="col-md-4 header-w3left">
                            <img src="resources/images/avatar.jpg" alt=""/>
                            <div class="header-imgtext-w3ls">
                                <h1 style="color: #333;"><%= userInfo.getFullName()%></h1>
                            </div>
                        </div>
                        <div class="col-md-8 header-w3right">
                            <h3 class="agileits-title" style="color: #113;">About me</h3>
                            <div class="profile-agileinfo">
                                <p><%= userInfo.getDescription()%></p>
                                <div class="col-md-6 col-xs-6 profile-grids">
                                    <i class="fa fa-user"></i>
                                    <h5>Thông Tin Cá Nhân</h5>
                                    <ul class="">
                                        <li>
                                            <b>Ngày Sinh</b> : <%= userInfo.getBirthday()%>
                                        </li>
                                        <li>
                                            <b>Địa Chỉ</b> : <%= userInfo.getAddress()%>
                                        </li>
                                        <li>
                                            <b>Sở Thích</b> : <%= userInfo.getHobie()%>
                                        </li>
                                    </ul>
                                </div>
                                <div class="col-md-6 col-xs-6 profile-grids">
                                    <i class="fa fa-envelope"></i>
                                    <h5>Liên Hệ</h5>
                                    <ul class="">
                                        <li>
                                            <b>Điện Thoại</b> : <%= userInfo.getPhone()%>
                                        </li>
                                        <li>
                                            <b>Email</b> :  <%= userInfo.getAccount().getUsername()%>
                                        </li>
                                    </ul>
                                </div>
                                <div class="clearfix"> </div>
                            </div>
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                </div>
            </div>
            <!-- //banner -->
        </li>
    </ul>
</div>
</body>
</html>