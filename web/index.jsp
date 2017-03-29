<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Login</title>
    <link rel="stylesheet" href="resources/style/bootstrap.min.css">

    <script src="resources/script/jquery.min.js"></script>
    <script src="resources/script/bootstrap.min.js"></script>
    <script src="resources/script/script.js"></script>
  </head>
  <body>
  <div class="container">
    <div class="col-md-6 col-md-offset-3 login_form">
      <form action="/khanh" method="post" class="form-horizontal" role="form">
        <%
          if (request.getAttribute("login") == "error") {
        %>
        <div class="alert alert-danger">
          <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
          <strong>ERROR!</strong> Username or password wrong
        </div>
        <%
          }
        %>
        <div class="panel-group" style="margin-top: 100px;">
          <div class="form-group">
            <label class="col-sm-2 control-label">Username</label>
            <div class="col-sm-10">
              <input type="text" class="form-control" id="username" placeholder="" name="username">
            </div>
          </div>

          <div class="form-group">
            <label class="col-sm-2 control-label">Password</label>
            <div class="col-sm-10">
              <input type="password" class="form-control" id="password" placeholder="" name="password">
            </div>
          </div>

          <div class="form-group">
            <div class="col-sm-10 col-sm-offset-2">
              <button type="submit" class="btn btn-primary">Submit</button>
            </div>
          </div>
        </div>
      </form>
    </div>
  </div>
  </body>
</html>
