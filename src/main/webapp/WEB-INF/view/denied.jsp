<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Senior Developer Challenge</title>
</head>
	<body>
		<h1>Senior Developer Challenge</h1>  
		<h4>Author: Fidel C. Garbajosa. February 2016</h4><br />	
		<h1 id="banner">Unauthorized Access !!</h1>
	
		<hr />
	
		<c:if test="${not empty error}">
			<div style="color:red">				
				${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
			</div>
		</c:if>
	
		<p class="message">Access denied!</p>
		<a href="/Spring3HibernateIntegration/login">Go back to login page</a> 
	</body>
</html>