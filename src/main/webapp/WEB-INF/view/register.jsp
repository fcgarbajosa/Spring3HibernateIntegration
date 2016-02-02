<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Senior Developer Challenge</title>
    <style>
    .error {
        color: #ff0000;
        font-weight: bold;
     }
    </style>    
</head>
<body>
<h1>Senior Developer Challenge</h1>  
<h4>Author: Fidel C. Garbajosa. February 2016</h4> 
<h2>Registration</h2>
<h5> Please enter your details below</h5>
<form:form method="post" action="add_register" commandName="employeeForm">
 
    <table>
    <tr>
        <td><form:label path="username">USER NAME</form:label></td>
        <td>(*)<form:input path="username" /></td>
        <td><form:errors path="username" cssClass="error" /></td>        
    </tr>
    <tr>
        <td><form:label path="password">PASSWORD</form:label></td>
        <td>(*)<form:password path="password"/></td>
        <td><form:errors path="password" cssClass="error" /></td>        
    </tr>    
    <tr>
        <td><form:label path="password">CONFIRM PASSWORD</form:label></td>
        <td>(*)<form:password path="passwordconf"/></td>
        <td><form:errors path="passwordconf" cssClass="error" /></td>        
    </tr>
    <tr>
        <td><br /></td>
        <td><br /></td>
    </tr>      
          
    <tr>
        <td><form:label path="firstname">FIRST NAME</form:label></td>
        <td>(*)<form:input path="firstname" /></td>
        <td><form:errors path="firstname" cssClass="error" /></td>
    </tr>
    <tr>
        <td><form:label path="lastname">LAST NAME</form:label></td>
        <td>(*)<form:input path="lastname"/></td>
        <td><form:errors path="lastname" cssClass="error" /></td>
    </tr>  
    <tr>
        <td><form:label path="birthdateday">BIRTH DATE (dd/mm/yyyy)</form:label></td>
        <td>(*)<form:input path="birthdateday" size="2" maxsize="2"/>/<form:input path="birthdatemonth" size="2" maxsize="2"/>/<form:input path="birthdateyear" size="4" maxsize="4"/></td>
        <td><form:errors path="birthdateday" cssClass="error" /><br /><form:errors path="birthdatemonth" cssClass="error" /><br /><form:errors path="birthdateyear" cssClass="error" /><br /> </td>        
    </tr>     
    <tr>
        <td><form:label path="address">ADDRESS (*)</form:label></td>
        <td>(*)<form:input path="address" /></td>
        <td><form:errors path="address" cssClass="error" /></td>        
    </tr>
    <tr>
        <td><form:label path="city">CITY</form:label></td>
        <td>(*)<form:input path="city" /></td>
        <td><form:errors path="city" cssClass="error" /></td>        
    </tr>
    <tr>
        <td><form:label path="zip">ZIP</form:label></td>
        <td>(*)<form:input path="zip" /></td>
        <td><form:errors path="zip" cssClass="error" /></td>
    </tr>
    <tr>
        <td><form:label path="telephone">TELEPHONE</form:label></td>
        <td>(*)<form:input path="telephone" /></td>
        <td><form:errors path="telephone" cssClass="error" /></td>
    </tr>
    <tr>
        <td><form:label path="email">EMAIL</form:label></td>
        <td>(*)<input type="email" name="email" /></td>
        <td><form:errors path="email" cssClass="error" /></td>
    </tr>    
    <tr>
        <td>COUNTRY (*)</td>
        <td><form:select path="country">
            <form:option value="1">Spain</form:option>
            <form:option value="2">Germany</form:option>
            <option value="3">UK</option>
        </form:select></td>
    </tr> 
    <tr>
        <td colspan="2">
            <input type="submit" value="<spring:message code="label.register"/>"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="login">Go back</a>
        </td>
    </tr>
</table> 
</form:form> 
</body>
</html>
