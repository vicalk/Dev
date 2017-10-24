<#import "/spring.ftl" as spring/>

<head>
  <title> Vehicle Edit Form</title>
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

<#if (success??) >
 <div class="alert alert-success">
      <strong>Success!</strong> Vehicle has been edited.
 </div>
</#if>

<#if (error??) >
 <div class="alert alert-danger">
      <strong>Error!</strong> Could not edit vehicle.
 </div>
</#if>


 <form class="form-horizontal" action="/admin/vehicleSearch/{id}/edit" method="post" id="vehicleRegisterForm" name="vehicleRegisterForm">

    <fieldset>

<!-- Form Name -->
<legend>Edit existing vehicle:</legend>


<!-- plateNo input-->
<div class="form-group">
  	<@spring.bind "vehicleRegisterForm.plateNo"/>
  	<label class="col-sm-2 control-label">Plate Number:</label>
  	<div class="col-sm-10">
   		 <input  name="plateNo" id="plateNo" value="${vehicleRegisterForm.plateNo!""}"  placeholder="Plate Number.." class="form-control"  type="text">
   		    		    <#list spring.status.errorMessages as error>
                         <span> <h5 style="color:red;">${error}</h5> </span>
                      </#list>
  	</div>
</div>



<!-- carModel input-->
<div class="form-group">
  	<@spring.bind "vehicleRegisterForm.carModel"/>
  	<label class="col-sm-2 control-label">Car Model:</label>
  	<div class="col-sm-10">
   		 <input  name="carModel" id="carModel" value="${vehicleRegisterForm.carModel!""}"  placeholder="Car Model..." class="form-control"  type="text">
   		    		    <#list spring.status.errorMessages as error>
                         <span> <h5 style="color:red;">${error}</h5> </span>
                      </#list>

  	</div>

</div>

<!-- year input-->
<div class="form-group">
  	<@spring.bind "vehicleRegisterForm.year"/>
  	<label class="col-sm-2 control-label">Car year:</label>
  	<div class="col-sm-10">
   		 <input  name="year" id="year" value="${vehicleRegisterForm.year!""}"  placeholder="Car year..." class="form-control"  type="text">
   		    		    <#list spring.status.errorMessages as error>
                         <span> <h5 style="color:red;">${error}</h5> </span>
                      </#list>

  	</div>

</div>

<!-- color input-->
<div class="form-group">
  	<@spring.bind "vehicleRegisterForm.color"/>
  	<label class="col-sm-2 control-label">Color:</label>
  	<div class="col-sm-10">
   		 <input name="color" id="color" value="${vehicleRegisterForm.color!""}"  placeholder="Car color..."  class="form-control"  type="text"/>
   		    		    <#list spring.status.errorMessages as error>
                         <span> <h5 style="color:red;">${error}</h5> </span>
                      </#list>

  	</div>

</div>

<!-- Submit-->

  <div class="form-group">
              <div class="col-md-12 text-right">
                <button type="submit" class="btn btn-primary btn-lg">Register vehicle
              </div>


                </fieldset>
 </form>


        </div>


</body>
