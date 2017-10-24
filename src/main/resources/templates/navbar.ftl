

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/admin">CAR REPAIR webApp</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="/admin">Home</a></li>
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">OWNER
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="/admin/userCreate">CREATE</a></li>
          <li><a href="/admin/userSearch">SEARCH</a></li>
          <li><a href="/admin/userUpdate">UPDATE</a></li>
        </ul>
      </li>
      <li class="dropdown">
              <a class="dropdown-toggle" data-toggle="dropdown" href="#">VEHICLE
              <span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="/admin/vehicleCreate">CREATE</a></li>
                <li><a href="/admin/vehicleSearch">SEARCH</a></li>
                </ul>

      <li class="dropdown">
              <a class="dropdown-toggle" data-toggle="dropdown" href="#">SERVICE
              <span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="/admin/ServiceCreate">CREATE</a></li>
                <li><a href="/admin/ServiceSearch">SEARCH</a></li>
               </ul>
                </li>
                </ul>
               <ul class="nav navbar-nav navbar-right">
                    <li><a href="login.ftl"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
                </ul>

  </div>
</nav>
