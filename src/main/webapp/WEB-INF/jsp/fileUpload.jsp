<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page import="java.net.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script>  
function changecolor(){
	var ip = document.getElementById("ip").value; 
	//alert("ip::"+ip);
	//alert(ip)
	document.body.style.backgroundColor =ip;
	
}  
</script>  
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h3 align="center">Please upload files for sorting</h3>
	<table align="center">

		<form:form action="/fileUploadProcess" method="post"
			modelAttribute="fileBeanDTO" enctype="multipart/form-data"> 
			<tr>
			<tr>
				<td>Select a file to upload for springboot</td>
			</tr>
			<tr>
				<td><form:input type="file" path="multipartFile" name="multipartFile"/></td>
			    <td><form:input  path="fileSerach"/>String to search in file</td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</form:form>
	</table>
	<%
	String s = "https://www.google.com";

	InetAddress ip = InetAddress.getByName(new URL(s).getHost());
	String[] test= ip.getHostAddress().split("\\.");
	
	//test[3]="#DEAA"+test[3];
	test[3]="#DEFB"+Integer.toHexString(new Integer(test[3]));
	%>
	<p name="color" id="color">
	<H2>IP Address is::<%=ip.getHostAddress() %></H2>
	
	</p>
	<table align="center" id="ipc"> click on button to change the color
	 <tr>IP</tr>
	 <input hidden  type="text" id="ip" value ="<%=test[3]%>"/>
	</table>
	<button type="button"  value="IP" onclick="changecolor()">click to change color</button>
	
</body>
</html>