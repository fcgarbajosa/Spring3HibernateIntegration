<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" 
           uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Senior Developer Challenge</title>
</head>
<body>
 		<h1>Senior Developer Challenge</h1>  
		<h4>Author: Fidel C. Garbajosa. February 2016</h4>
<h2>CURRENCY HOME</h2>
 <h6><a href="<c:url value='j_spring_security_logout'/>">Click here to logout</a></h6>
<form:form method="post" action="add" commandName="employee">
 
    <table>
    <tr>
        <td colspan="2">
            <input type="submit" value="<spring:message code="label.add"/>"/>
        </td>
    </tr>
</table> 
</form:form>
     
<h3>CURRENT HISTORIES</h3>
<c:if  test="${!empty user_currenciesList}">
<table class="data">
<tr>
    <th>EUR</th>
    <th>GBP</th>
    <th>JPY</th>
    <th>DATE</th>
    <th></th>
</tr>
<c:forEach items="${user_currenciesList}" var="user_c">
    <tr>
        <td>${user_c.euro} </td>
        <td>${user_c.sp}</td>
        <td>${user_c.yen}</td>
        <td>
        	<fmt:formatDate pattern="dd/MM/yyyy, HH:mm:ss" value="${user_c.time_created}" var="dateconverted"/>
        	<c:out value="${dateconverted}"/></td>
        <td><a href="delete/${user_c.id}">delete</a></td>
    </tr>
</c:forEach>
</table>
</c:if>
 
</body>
</html>