<!DOCTYPE html>
<html>
<head>
<title>Create Employee</title>
</head>
<body>
	<div style="padding-left:100px;font-family: monospace;">
		<h2>Create Employee</h2>
		<form action="rest/animals" method="POST">
			<div style="width: 200px; text-align: left;">
				<div style="padding:10px;">
					Animal ID: <input name="id" />
				</div>
				<div style="padding:10px;">
					Animal Name: <input name="animalname" />
				</div>
				<div style="padding:10px;">
					Animal Type: <input name="animaltype" />
				</div>
				<div style="padding:10px;text-align:center">
					<input type="submit" value="Submit" />
				</div>
			</div>
		</form>
	</div>
</body>
</html>