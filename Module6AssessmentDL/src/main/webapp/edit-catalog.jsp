<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit An Existing Movie Catalog</title>
</head>
<body>
    <form action="EditCatalogDetailsServlet" method="post">
        <input type="hidden" name="id" value="${listToEdit.id}">
        Catalog Name: <input type="text" name="listName" value="${listToEdit.listName}">
        <br>
        Author: 
        <input type="text" name="userName" value="${listToEdit.user.userName}">
        <br>
        Movies:
        <br>
        <select name="allItemsToAdd" multiple size="6">
        <c:forEach items="${requestScope.allItems}" var="currentMovie">
          <option value="${currentMovie.id}"> ${currentMovie.title} | ${currentMovie.director} | ${currentMovie.genre}</option>
        </c:forEach>
        </select>
        <br />
        <input type="submit" value="Edit Catalog and Add Movie(s)">
    </form>
    <a href="index.html">Add new movies instead.</a>
</body>
</html>