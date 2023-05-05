<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>This is manage page</h1>
	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Gender</th>
			<th>Password</th>
			<th>Image</th>
		</tr>
		<c:forEach var="st" items="${product}">
			<tr>
				<td><c:out value="${st.id}"/></td>
				<td>${st.productName}</td>
				<td>${st.productQuantity}</td>
				<td>${st.productPrice}</td>
				<td><img src="images/${st.productImagePath}" height="100px" width="100px"></td>
				<td><a href="${pageContext.request.contextPath}/editStudent?id=${st.id}">Edit</a> <a href="">Delete</a></td>
			</tr>	
		</c:forEach>
		
	</table>
</body>
</html>