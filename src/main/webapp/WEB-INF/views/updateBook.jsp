<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Update Book</title>
    </head>
    <body>
    <div><BR><BR></div>
        <c:if test="${updateBookSuccess}">
            <div align="center">Successfully updated ${updatedBook.title}</div>
            <BR><BR>
        </c:if>
        
        <c:if test="${bookDoesNotExist}">
            <div align="center">You don't own ${updatedBook.title}</div>
            <BR><BR>
        </c:if>

        <c:url var="update_book_url" value="/archive/updateBook"/>
        <form:form action="${update_book_url}" method="post" modelAttribute="book" align="center">
			<form:label path="title">Title: </form:label> <form:input type="text" id="title" path="title"/>
            <form:label path="author">Author Name: </form:label> <form:input path="author"/>
            <form:label path="type">Genre: </form:label> <form:input path="genre"/>
            <input id = "submit" type="submit" value="submit"/>
        </form:form>
        <div><BR><BR></div>
    </body>
</html>