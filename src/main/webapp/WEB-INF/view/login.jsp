<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html>
<head>
    <title>Senior Developer Challenge</title>
</head>
	<body>
		<h1>Senior Developer Challenge</h1>  
		<h4>Author: Fidel C. Garbajosa. February 2016</h4>
		<form name="f" action="<c:url value='j_spring_security_check'/>"
					method="POST">
			<table>
				<tr>
					<td>Username:</td>
					<td><input type='text' name='j_username' /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type='password' name='j_password'></td>
				</tr>
				<tr>
					<td colspan="2">&nbsp;</td>
				</tr>
				<tr>
					<td colspan='2'><input name="submit" type="submit" value="login">&nbsp;<input name="reset" type="reset" value="reset"></td>
				</tr>
			</table>
		</form>
		<h3><a href="register">don't have an account?? Register!</a></h3>
	</body>
</html>