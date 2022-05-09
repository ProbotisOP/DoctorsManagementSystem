<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<title>Doctors List </title>
</head>
<body>
    <h1 align="center">Doctors List</h1>
    <br/>
    <table border="1" cellpadding="10" class="table table-striped">
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>last name</th>
            <th>specialization</th>
        </tr>
    
        <tr>
            <td>${doctorbyid.id}</td>
            <td>${doctorbyid.firstName}</td>
            <td>${doctorbyid.secondName}</td>
            <td>${doctorbyid.specialization}</td>
        </tr>    
      
    </table>
</body>
</html>