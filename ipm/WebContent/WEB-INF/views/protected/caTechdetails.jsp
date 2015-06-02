
	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		pageEncoding="ISO-8859-1"%>
	<%
		response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1
		response.setHeader("Pragma", "no-cache"); //HTTP 1.0
		response.setDateHeader("Expires", 0); //prevents caching at the proxy server
	%>
	
	
	<%@include file="/WEB-INF/views/public/taglib.jsp"%>
	<fmt:setBundle basename="messages" />
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	
	</head>
	
	
	<body>
	
	<form action="saveCADetails.html" method="POST">
	
	<table>
			<c:forEach items="${CADTOs.list}" var="cadto">
            <tr>
                <td>
                ${cadto.CAName}
                </td>
                <td>
                <select name="${cadto.skillMasterId}" id="${cadto.skillMasterId}">
				<c:forEach items="${cadto.options}" var="var">
					<c:set var="isSelected" value="false" />
						<c:if test="${cadto.userSelected == var.id}">
							<c:set var="isSelected" value="true" />
						</c:if>
					<c:choose>
						<c:when test="${isSelected}">
							<option value="${var.id}" selected="selected">${var.name}</option>
						</c:when>
						<c:otherwise>
							<option value="${var.id}">${var.name}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select>
                </td>
                <td>
                 ${cadto.CARequiredValue}
                </td>
            </tr>
            </c:forEach>
    </table>
	<input type="submit" name="submit" value="submit">
	
	</form>
	
	</body>
</html>
