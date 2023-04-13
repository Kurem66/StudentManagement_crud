<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student List</title>
<script src="https://kit.fontawesome.com/e3194c2c0d.js" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
</head>
<body>
        <div class="container">
            <h3 class="text-center mt-5">List of Students</h3>
            <table class="table table-responsive table-striped table-hover table-bordered mt-3">
                <thead>
                    <tr>
                        <th class="text-center">ID</th>
                        <th class="text-center">Student Name</th>
                        <th class="text-center">Email Address</th>
                        <th class="text-center">Age</th>
                        <th class="text-center">Address</th>
                        <th class="text-center">Phone</th>
                        <th class="text-center" colspan="2">Action</th>
                    </tr>
                </thead>
                <c:forEach var="data" items="${requestScope.list}">
                    <tr>
                        <td class="text-center">${data.id}</td>
                        <td class="text-center">${data.stuName }</td>
                        <td class="text-center">${data.stuEmail }</td>
                        <td class="text-center">${data.stuAge }</td>
                        <td class="text-center">${data.stuAddress }</td>
                        <td class="text-center">${data.stuPh }</td>
                        <td class="text-center">
                            <a href="UpdateServlet?id=${data.id}"><i class="fa-solid fa-user-pen"></i></a>
                        </td>
                        <td class="text-center">
                            <a href="DeleteServlet?id=${data.id}"><i class=" fa-solid fa-user-minus"></i></a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <div class="container text-right">
                <a href="register.jsp" class="btn btn-primary">Add Student</a>
            </div>
        </div>  
</body>
</html>