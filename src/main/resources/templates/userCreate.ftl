<#import "/spring.ftl" as spring/>

<head>
  <title> User Registration Form</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   <link rel="stylesheet" type="text/css" href="stylesear.css">
</head>

<body>


<#include "/navbar.ftl">

 <div class="container">
 <form class="form-horizontal" action="/admin/userCreate" method="post" id="userRegisterForm" name="userRegisterForm">

<fieldset>

<!-- Form Name -->
<legend>Create new user:</legend>

<!-- afm input-->
<div class="form-group">
  	<@spring.bind "userRegisterForm.afm"/>
  	<label class="col-sm-2 control-label">Tax ID:</label>
  	<div class="col-sm-10">
   		 <input  name="afm" id="afm"  placeholder="Tax id..." class="form-control"  type="number">
   		    		    <#list spring.status.errorMessages as error>
                         <span> <h5 style="color:red;">${error}</h5> </span>
                      </#list>

  	</div>

</div>

<!-- lastname input-->
<div class="form-group">
  	<@spring.bind "userRegisterForm.lastname"/>
  	<label class="col-sm-2 control-label">Last Name:</label>
  	<div class="col-sm-10">
   		 <input  name="lastname" id="lastname"  placeholder="Last name..." class="form-control"  type="text">
   		    		    <#list spring.status.errorMessages as error>
                         <span> <h5 style="color:red;">${error}</h5> </span>
                      </#list>

  	</div>

</div>

<!-- firstname input-->
<div class="form-group">
  	<@spring.bind "userRegisterForm.firstname"/>
  	<label class="col-sm-2 control-label">First Name:</label>
  	<div class="col-sm-10">
   		 <input  name="firstname" id="firstname"  placeholder="first name..." class="form-control"  type="text">
   		    		    <#list spring.status.errorMessages as error>
                         <span> <h5 style="color:red;">${error}</h5> </span>
                      </#list>

  	</div>

</div>

<!-- Address input-->
<div class="form-group">
  	<@spring.bind "userRegisterForm.address"/>
  	<label class="col-sm-2 control-label">Address:</label>
  	<div class="col-sm-10">
   		 <input name="address" id="address"  placeholder="Address..."  class="form-control"  type="text"/>
   		    		    <#list spring.status.errorMessages as error>
                         <span> <h5 style="color:red;">${error}</h5> </span>
                      </#list>

  	</div>

</div>

<!-- email input-->
<div class="form-group">
  	<@spring.bind "userRegisterForm.email"/>
  	<label class="col-sm-2 control-label">Email:</label>
  	<div class="col-sm-10">
   		 <input  name="email" id="email"  placeholder="Email..." class="form-control"  type="email">
   		    		    <#list spring.status.errorMessages as error>
                         <span> <h5 style="color:red;">${error}</h5> </span>
                      </#list>

  	</div>

</div>

<!-- password input-->
<div class="form-group">
  	<@spring.bind "userRegisterForm.password"/>
  	<label class="col-sm-2 control-label">Password:</label>
  	<div class="col-sm-10">
   		 <input  name="password" id="password"  placeholder="Password..." class="form-control"  type="text">
   		    		    <#list spring.status.errorMessages as error>
                         <span> <h5 style="color:red;">${error}</h5> </span>
                      </#list>

  	</div>

</div>

<!--userType input -->

		  <div class="form-group ">
            <@spring.bind "userRegisterForm.userType"/>
			<label class="col-sm-2 control-label">User Type:</label>
			<div class="col-sm-10">
				<label class="radio-inline">
                                  <input type="radio" name="userType" id="userType" value="ADMIN" />Admin
				</label>
                                <label class="radio-inline">
                                  <input type="radio" checked="checked" name="userType" id="userType" value="SIMPLE" />User
				</label> <br />
			</div>
		  </div>

  <div class="form-group">
              <div class="col-md-12 text-right">
                <button type="submit" class="btn btn-primary btn-lg">Create User
              </div>


                </fieldset>
 </form>


        </div>


</body>
