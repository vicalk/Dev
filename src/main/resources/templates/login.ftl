<head>
<#include "master.ftl"/>
  <title>Login</title>
</head>

<body>

<h2>${message!""}</h2>
<h2 style="color: red">${errorMessage!""}</h2>

<div class="container" style="margin-top:30px">
<div class="col-md-4">
<div class="panel panel-default">
  <div class="panel-heading"><h3 class="panel-title"><strong>Sign In </strong></h3></div>
  <div class="panel-body">

    <form role="form" action="/login" method="post" id="loginForm" name="loginForm">
     <div class="form-group">
        <label for="email">Email:</label>
        <input type="email" class="form-control" id="email" name="email" placeholder="Enter email">
      </div>

      <div class="form-group">
        <label for="password">Password:</label>
        <input type="password" class="form-control" id="password" name="password" placeholder="Password">
      </div>
      <button type="submit" class="btn btn-md btn-primary">Sign in</button>
    </form>

      </div>
    </div>
    </div>

</body>
