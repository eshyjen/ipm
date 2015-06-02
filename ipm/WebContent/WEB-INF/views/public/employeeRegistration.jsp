
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1
	response.setHeader("Pragma", "no-cache"); //HTTP 1.0
	response.setDateHeader("Expires", 0); //prevents caching at the proxy server
%>

<%@include file="taglib.jsp" %>
<fmt:setBundle basename="messages" />
<html>
<head>
<title>Login</title>
<link href="${rootURL}/resources/bootstrap/css/bootstrap.css" media="screen" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${rootURL}/resources/jquery/jquery-1.10.2.js"></script>
<script type="text/javascript" src="${rootURL}/resources/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="${rootURL}/resources/js/app.js"></script>
</head>
<body>
		
	
            
     <div class="row">
		<div class="col-md-6 col-md-offset-2">	
			<h2>Employee Registration</h2>
			<form id="loginForm" method="post" action="${rootURL}/v1/public/employeeRegistration.html" 
			class="form-horizontal" role="form" cssStyle="width: 800px; margin: 0 auto;">
		  <div class="form-group">
		    <label for="username" class="col-sm-2 control-label">UserName*</label>
		    <div class="col-sm-4">
		      <input type="text" id="j_username" name="j_username" class="form-control" placeholder="UserName" />
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-4">
		      <input type="submit" class="btn btn-primary" value="Login">
		    </div>
		  </div>
		  
		</form>
		
		<br> Current Locale : ${pageContext.response.locale} <br> <a
				href="<c:url value="/v1/public/registration.html" />"><spring:message
					code="label.form.loginSignUp"></spring:message></a>
			<br><br><br>
            <a href="<c:url value="/forgetPassword.html" />"><spring:message
              code="message.resetPassword"></spring:message></a>
		
	</div>
</div>

	<jsp:include page="/WEB-INF/views/public/include_footer.jsp" />
</body>
</html>