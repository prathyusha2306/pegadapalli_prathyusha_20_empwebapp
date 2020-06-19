<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Management</title>
</head>
<body>
	<fieldset>
		<legend> add employee</legend>
		<form action="/addEmp" method="post">
			<table>
				<tr>
					<td>Employee Id</td>
					<td>:</td>
					<td><input type="number" name="empId" required>></td>
				</tr>
				<tr>
					<td>Employee Name</td>
					<td>:</td>
					<td><input type="text" name="empName" required>></td>
				</tr>
				<tr>
					<td>Employee Designation</td>
					<td>:</td>
					<td><input type="text" name="empDesignation" required>></td>
				</tr>



			</table>

		</form>
	</fieldset>


</body>
</html>