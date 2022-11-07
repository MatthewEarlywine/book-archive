<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Archive</title>
</head>
<body class="text-center">
	<form action="login" method="POST">
		<div align="center">
			<h2>Book Archive</h2><br>
			<p>User Name:</p>
			<input type="text" name="username"><br>
			<p>Password:</p>
			<input type="password" name ="password"><br><br>
			<input type="submit">
			<p style="color: red">${error}</p>
		</div>
	</form>		
</body>
</html>