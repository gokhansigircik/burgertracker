<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Edit Burger</title>
</head>
<body>
    <div class="container">
        <div class="card">
            <div class="card-header">
                <h1>Edit Burger</h1>
            </div>
            <div class="card-body">
                <div class="card-body">
                    <form:form action="/burgers/${burger.id }" method="post" modelAttribute="burger">
                    <input type="hidden" name="_method" value="put">
                        <p>
                            <form:label path="name" class="form-label">Burger Name</form:label>
                            <form:errors path="name" class="text-danger" />
                            <form:input path="name" class="form-control form-control"/>
                        </p>
                        <p>
                            <form:label path="restaurant" class="form-label">Restaurant Name</form:label>
                            <form:errors path="restaurant" class="text-danger" />
                            <form:input path="restaurant" class="form-control form-control"/>
                        </p>
                        <p>
                            <form:label path="rating">Rating (Out of 5)</form:label>
                            <form:errors path="rating" class="text-danger" />
                            <form:input type="number" path="rating" class="form-control form-control"/>
                        </p>
                        <p>
                            <form:label path="notes" class="form-label">Notes</form:label>
                            <form:errors path="notes" class="text-danger" />
                            <form:input path="notes" class="form-control form-control"/>
                        </p> 
                        <div class="d-flex justify-content-end">
                            <button type="submit" class="btn btn-primary">
                                Submit
                            </button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>