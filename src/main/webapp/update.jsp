<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Students</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
</head>
<body>
<div class="container d-flex justify-content-center min-vh-100 align-items-center">
        <form action="UpdateServlet" method="post" style="border-radius: 15px;" class="px-2 card ">
            <h2 class="text-center mt-2 mb-3">Manage Student</h2>
            
             <div class="form-group mb-3">
                <label for="name">ID</label>
                <input type="text" name="id" id="id" class="form-control mt-1" value="${res.id}${bean.id}" readonly="readonly">
                <span style="color: red;" class="ml-5">${error}</span>
            </div>
                
            <div class="form-group mb-3">
                <label for="name">Enter Name</label>
                <input type="text" name="name" id="name" class="form-control mt-1" value="${res.stuName}${bean.stuName}">
                <span style="color: red;" class="ml-5">${error}</span>
            </div>

            <div class="form-group mb-3">
                <label for="email">Enter email address</label>
                <input type="email" name="email" id="email" class="mt-1 form-control" value="${res.stuEmail}${bean.stuEmail}">
                <span style="color: red;" class="ml-5">${error}</span>
            </div>
        
            <div class="form-group mb-3">
                <label for="age">Enter Age</label>
                <input type="text" name="age" id="age" class="form-control mt-1" value="${res.stuAge}${bean.stuAge}">
                <span style="color: red;" class="ml-5">${error}</span>
            </div>

            <div class="form-group mb-3">
                <label for="address">Enter Address</label>
                <input type="text" name="address" id="address" class="form-control mt-1" value="${res.stuAddress}${bean.stuAddress}">
                <span style="color: red;" class="ml-5">${error}</span>
            </div>
        
            <div class="form-group mb-3">
                <label for="phno">Enter Phone Number</label>
                <input type="text" name="phno" id="phno" class="form-control mt-1" value="${res.stuPh}${bean.stuPh}">
                <span style="color: red;" class="ml-5">${error}</span>           
            </div>
        
            <div class="col text-center mb-3">
                <button type="submit" class="btn btn-primary btn-block">Update</button>
            </div> 
        </form>
</div>
</body>
</html>