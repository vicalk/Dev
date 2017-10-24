<form class="form-horizontal">
<fieldset>

<!-- Form Name -->
<legend>Create new user:</legend>

<!-- afm input-->
<div class="form-group">
  	<@spring.bind "userRegisterForm.afm"/>
  	<label class="col-sm-2 control-label">Tax ID:</label>
  	<div class="col-sm-10">
   		 <input  name="afm" id="afm"  placeholder="Tax id..." class="form-control"  type="number">
  	</div>
  	<#list spring.status.errorMessages as error>
                    <span>${error}</span>
     </#list>
</div>

<!-- lastname input-->
<div class="form-group">
  	<@spring.bind "userRegisterForm.lastname"/>
  	<label class="col-sm-2 control-label">Last Name:</label>
  	<div class="col-sm-10">
   		 <input  name="lastname" id="lastname"  placeholder="Last name..." class="form-control"  type="text">
  	</div>
  	<#list spring.status.errorMessages as error>
                    <span>${error}</span>
     </#list>
</div>

<!-- firstname input-->
<div class="form-group">
  	<@spring.bind "userRegisterForm.firstname"/>
  	<label class="col-sm-2 control-label">First Name:</label>
  	<div class="col-sm-10">
   		 <input  name="firstname" id="firstname"  placeholder="first name..." class="form-control"  type="text">
  	</div>
  	<#list spring.status.errorMessages as error>
                    <span>${error}</span>
     </#list>
</div>

<!-- Address input-->
<div class="form-group">
  	<@spring.bind "userRegisterForm.address"/>
  	<label class="col-sm-2 control-label">Address:</label>
  	<div class="col-sm-10">
   		 <inputss="form-control" name="address" id="address"  placeholder="Address..."  class="form-control"  type="text"/>
  	</div>
  	<#list spring.status.errorMessages as error>
                    <span>${error}</span>
     </#list>
</div>

<!-- email input-->
<div class="form-group">
  	<@spring.bind "userRegisterForm.email"/>
  	<label class="col-sm-2 control-label">Email:</label>
  	<div class="col-sm-10">
   		 <input  name="email" id="email"  placeholder="Email..." class="form-control"  type="email">
  	</div>
  	<#list spring.status.errorMessages as error>
                    <span>${error}</span>
     </#list>
</div>

<!-- password input-->
<div class="form-group">
  	<@spring.bind "userRegisterForm.password"/>
  	<label class="col-sm-2 control-label">Password:</label>
  	<div class="col-sm-10">
   		 <input  name="password" id="password"  placeholder="Password..." class="form-control"  type="text"/
  	</div>
  	<#list spring.status.errorMessages as error>
                    <span>${error}</span>
     </#list>
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
                                  <input type="radio" name="userType" id="userType" value="SIMPLE" /> User
				</label> <br />
			</div>
		  </div>

  <div class="form-group">
              <div class="col-md-12 text-right">
                <button type="submit" class="btn btn-primary btn-lg">Create User
              </div>


 </ieldset>
 </form>

