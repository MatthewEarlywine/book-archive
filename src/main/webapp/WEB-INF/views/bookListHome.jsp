<html>
<head>
	<title>My Favorite Books</title>
</head>

<body>
<div align="center">
	<h2>Complete Book List</h2><BR>
	<table border="1">
		<tr>
			<th>Book Id</th>
			<th>Title</th>
			<th>Author</th>
			<th>Genre</th>
		</tr>
		<c:forEach items="${books}" var="book">
			<tr>
				<td>${book.id}</td>
				<td>${book.title}</td>
				<td>${book.author}</td>
				<td>${book.genre}</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>