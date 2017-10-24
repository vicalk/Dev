<#import "/spring.ftl" as spring/>

<head>
  <title> Vehicle Search Form</title>
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
       <h1>Admin</h1>
       <div class="row">
         <form  class="form-inline" action="/admin/vehicleSearch" method="post" name="vehicleSearchForm id=name="vehicleSearchForm">
           <div class="col-sm-4 col-sm-offset-7">
           <div class="form-group">
              <@spring.bind "vehicleSearchForm.SearchText"/>
             <input type="text" class="form-control" name="SearchText" id="SearchText" placeholder="Search by Tax id or Email...">
             <span style="display: inline;" class="input-group-btn">
               <button class="btn btn-default btn-primary" type="submit">Search</button>
             </span>
           </div>
              </div>
            </div>
    <p>&nbsp;</p>

           <!-- /input-group -->

          <div class="col-sm-4 col-sm-offset-7">
           <div class="form-group ">
             <@spring.bind "vehicleSearchForm.SearchType"/>
             <label class="col-sm- control-label">Search by:</label>
 				<label class="radio-inline">
                   <input type="radio" name="SearchType" id="SearchType" value="AFM" />Tax Id
 				</label>
                <label class="radio-inline">
                   <input type="radio" checked="checked" name="SearchType" id="SearchType" value="PLATENO" />Plate number
 				</label> <br />
 			</div>
 		  </div>
 		  </form>



       <p>&nbsp;</p>
       <p>&nbsp;</p>


<#if (vehicleList??) && (vehicleList?size > 0 )>

       <table id="vehicleTable" class="table" >
         <thead>
           <tr>
             <th>#ID</th>
             <th>Plate Number</th>
             <th>Owner Tax Id</th>
             <th>Car Model</th>
             <th>Year</th>
             <th>Color</th>


           </tr>
         </thead>
         <tbody>

          <#list vehicleList as vehicle>


           <tr>
             <th scope="row">${vehicle?counter}</th>
             <td>${vehicle.plateNo}</td>
             <td>${vehicle.afm}</td>
             <td>${vehicle.carModel!""}</td>
             <td>${vehicle.year!""}</td>
             <td>${vehicle.color!""}</td>
             <td><form action="/admin/vehicleSearch/${vehicle.vehicleId}/delete" method="post">
                       <input class="btn btn-xs btn-danger" type="submit" value="Delete"/>
                 </form>
                 <form action="/admin/vehicleSearch/${vehicle.vehicleId}/edit" method="post">
                                        <input class="btn btn-xs btn-default" type="submit" value="Edit"/>
                                  </form>


           </tr>
          </#list>
           </tbody>
         </table>
           <#else>
                    <div class="alert alert-danger">
             <strong>Error!</strong> No vehicles found.
                    </div>
           </#if>
   </div>
 </body>


