<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
    <head>
        <title>Add Book</title>
    </head>
    <body>
    <div><BR><BR></div>
        <c:if test="${addBookSuccess}">
            <div align="center">Successfully added ${savedBook.title} to the archive.</div>
            <BR><BR>
        </c:if>
        <c:if test="${bookExists}">
            <div align="center">You already have a copy of ${savedBook.title}</div>
            <BR><BR>
        </c:if>

        <c:url var="add_book_url" value="/archive/addBook"/>
        <form:form action="${add_book_url}" method="post" modelAttribute="book" align="center">
            <form:label path="title">Title: </form:label> <form:input type="text" id="title" path="title"/>
            <form:label path="author">Author Name: </form:label> <form:input path="author"/>
            <form:label path="type">Genre: </form:label> <form:input path="genre"/>
            <input id = "submit" type="submit" value="submit"/>
        </form:form>
        <div><BR><BR></div>
    </body>
</html>