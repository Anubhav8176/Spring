<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Customer</title>
</head>
<body>
	<h1>CRM - Customer Relationshp Management</h1>
	<h2>Save Customer</h2>
	<div>
		<form action="addUser" method="post">
			<table>
				<tbody>
					<tr>
						<td><label for="c_id">Customer id:</label></td>
						<td><input type="number" id="c_id" name="c_id" value="${idU}" required></input>
					</tr>
					<tr>
						<td><label for="name">Full name:</label></td>
						<td><input type="text" id="name" name="name" value="${nameU}" required></input>
					</tr>
					<tr>
						<td><label for="email">Email:</label></td>
						<td><input type="text" id="email" name="email" value="${emailU}" required></input>
					</tr>
					<tr>
						<td></td>
						<td><button type="submit" value="submit">Save</button></td>
					</tr>
				</tbody>
			</table>
		</form>

	</div>
</body>
</html>