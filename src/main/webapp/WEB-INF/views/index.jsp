<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Archive</title>
</head>
<body class="text-center">
	<form action="login" method="POST">
		<div align="center">
			<h2>GameRate</h2><br>
			<p>Username:</p>
			<input type="text" name="username"><br>
			<p>Password:</p>
			<input type="password" name ="password"><br><br>
			<input type="submit">
			<p style="color: red">${error}</p>
		</div>
	</form>		
</body>
</html>