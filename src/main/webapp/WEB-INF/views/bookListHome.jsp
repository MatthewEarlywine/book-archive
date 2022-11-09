<!DOCTYPE html>
<html>
<head>
	<title>Book Archive</title>
</head>

<body>
<div align="center">
	<h2>Complete Book List</h2><BR>
	<p> This is a test String: ${test} </p>
	<table border="1">
		<tr>
			<th>Book Id</th>
			<th>Title</th>
			<th>Author</th>
			<th>Genre</th>
			<th>Rialto</th>
		</tr>
		<c:forEach items="books" var="books">
			<tr>
				<td><c:out value="${book.id}"/></td>
				<td><c:out value="${book.id}"/></td>
				<td><c:out value="${book.id}"/></td>
				<td><c:out value="${book.id}"/></td>
				<td>Rialto</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>