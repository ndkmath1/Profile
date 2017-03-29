<%@ page import="model.UserInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Info</title>
    <link rel="stylesheet" href="resources/style/bootstrap.min.css">
    <link rel="stylesheet" href="resources/style/style.css">

    <script src="resources/script/jquery.min.js"></script>
    <script src="resources/script/bootstrap.min.js"></script>
    <script src="resources/script/script.js"></script>
</head>
<body>
<%
    UserInfo userInfo = (UserInfo)session.getAttribute("currentUser");
%>
<div class="container">
    <form action="/update" method="post" class="form-horizontal" role="form">

        <div class="form-group">
            <legend>Cập Nhật Thông Tin</legend>
        </div>
        <%
            if(request.getAttribute("update")=="error"){
        %>
        <div class="alert alert-danger">
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
            <strong>Lỗi!</strong> Cập nhật thất bại ...
        </div>

        <%
            }
        %>
        <div class="form-group">
            <label class="col-sm-2 control-label">Họ và tên: </label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="fullname" placeholder="" name="fullname" value="<%=userInfo.getFullName()%>">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">Ngày sinh: </label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="birthday" placeholder="" name="birthday" value="<%= userInfo.getBirthday()%>">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">Địa Chỉ: </label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="address" placeholder="" name="address" value="<%= userInfo.getAddress()%>">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">Sở Thích: </label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="hobie" placeholder="" name="hobie" value="<%=userInfo.getHobie()%>">
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label">Số Điện Thoại: </label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="phone" placeholder="" name="phone" value="<%=userInfo.getPhone()%>">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">Mô tả: </label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="description" placeholder="" name="description" value="<%=userInfo.getDescription()%>">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-10 col-sm-offset-2">
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
