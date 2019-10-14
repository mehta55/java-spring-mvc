<html>
	<head>
		<style type="text/css">
.container {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
}

input[type=submit] {
	background-color: #1E90FF;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=submit]:hover {
  background-color: #4169E1;
}

input[type=text], input[type = password] {
   width: 100%; 
  padding: 12px; 
  border: 1px solid #ccc; 
  border-radius: 4px; 
  margin-top: 3px; 
  margin-bottom: 3px; 
}

</style>
		<title> Flight Searcher </title>
	</head>
		<div align = "center" class = "container">
			<div >
			<form action="SignIn" method = "post"> <br>
				<table>
					<tr>
						<td>User ID  :</td>
						<td><input type = "text" name = "uId" ></td>
					</tr>
					<tr>
						<td>Password :</td>
						<td><input type = "password" name = "uPswd"> <br></td>
					</tr>
					<tr>
						<th></th>
						<td align = "right"><input type = "submit" value = "Sign In" align = "right"></td>
				</table>
			</form>
		</div>
		<br>
		<br>
			<div >
			<form action="SignUp" method = "post"> <br>
			<table >
					<tr>
						<td>Set User ID  :</td>
						<td><input type = "text" name = "uId"></td>
					</tr>
					<tr>
						<td>Set Password :</td>
						<td><input type = "password" name = "uPswd"> <br></td>
					</tr>
					<tr>
						<td>Confirm Password :</td>
						<td><input type = "password" name = "cuPswd"> <br></td>
					</tr>
					<tr>
						<td></td>
						<td align = "right"><input type = "submit" value = "Sign Up" align = "right"></td>
				</table>
		</form>
		</div>
		</div>
	</body>
</html>
