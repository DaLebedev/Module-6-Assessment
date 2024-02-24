<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Movie Catalogs</title>
</head>
<body>
	<form method="post" action="CatalogNavigationServlet">
	<table>
    <c:forEach items="${requestScope.allCatalogs}" var="currentCatalog">
          <tr>
            <td><input type="radio" name="id" value="${currentCatalog.id}"></td>
            <td><h2>${currentCatalog.listName}</h2></td>
          </tr>
        <tr><td colspan="3">Catalog Author: ${currentCatalog.user.userName}</td></tr>
        <tr><td>Movies:</td></tr>
        <c:forEach var="catalogVal" items="${currentCatalog.listOfItems}">
          <tr>
            <td colspan="3">${catalogVal.title}, ${catalogVal.director}, ${catalogVal.genre}</td>
          </tr>
        </c:forEach>
    </c:forEach>
	</table>
	<input type="submit" value="edit" name="doThisToCatalog">
	<input type="submit" value="delete" name="doThisToCatalog">
	<input type="submit" value="add" name="doThisToCatalog">
	</form>
	<a href="index.html">Insert a new movie</a>
	<br>
	<a href="ViewAllMoviesServlet">View the complete list of movies</a> 
	<br>
	<a href="AddMoviesToCatalogServlet">Create a new movie</a>
</body>
</html>