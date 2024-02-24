<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>Create a new list</title>
</head>
<body>
    <form action="CreateNewCatalogServlet" method="post">
        Catalog Name: <input type="text" name="listName">
        <br>
        Author: <input type="text" name="userName">
        <br>
        Movies:<br>
        <select name="allItemsToAdd" multiple size="6">
        <c:forEach items="${requestScope.allItems}" var="currentItem">
            <option value="${currentItem.id}">${currentItem.title} | ${currentItem.director} | ${currentItem.genre}</option>
        </c:forEach>
        </select>
        <br>
        <input type="submit" value="Create List and Add Items">
    </form>
    <a href="index.html">Add new items instead.</a>
</body>
</html>