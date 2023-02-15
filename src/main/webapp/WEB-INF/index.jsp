<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Burger</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/main.css" />
    <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script>
    <!-- change to match your file/naming structure -->
  </head>
  <body>
    <div class="container">
      <div class="card">
        <div class="card-body">
          <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
          <%@ page isErrorPage="true" %>    
          <h1>New Burger</h1>
          <form:form action="/burgers" method="post" modelAttribute="burger">
              <p>
                  <form:label path="name">Name</form:label>
                  <form:errors path="name"/>
                  <form:input path="name"/>
              </p>
              <p>
                  <form:label path="restaurant">Restaurant</form:label>
                  <form:errors path="restaurant"/>
                  <form:textarea path="restaurant"/>
              </p>
              <p>
                  <form:label path="notes">Notes</form:label>
                  <form:errors path="notes"/>
                  <form:input path="notes"/>
              </p>
              <p>
                  <form:label path="rating">Rating</form:label>
                  <form:errors path="rating"/>     
                  <form:input type="number" path="rating"/>
              </p>    
              <input type="submit" value="Submit"/>
          </form:form>
          
        </div>
      </div>
    </div>

    <div class="container">
      <div class="card">
        <div class="card-body">
          <table class="table">
            <thead>
              <tr>
                <th>Name</th>
                <th>Restaurant</th>
                <th>Notes</th>
                <th>Rating</th>
                <th>Action</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach var="bur" items="${burgers}">
                <tr>
                  <td><c:out value="${bur.id}"></c:out></td>
                  <td><a href="/burgers/${bur.id}"><c:out value="${bur.name}"></c:out></a></td>
                  <td><c:out value="${bur.restaurant}"></c:out></td>
                  <td><c:out value="${bur.rating}"></c:out></td>
                  <td>
                    <a href="burgers/edit/${bur.id}">Edit</a>
                  </td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </body>
</html>
