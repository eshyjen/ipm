

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		pageEncoding="ISO-8859-1"%>
	<%
		response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1
		response.setHeader("Pragma", "no-cache"); //HTTP 1.0
		response.setDateHeader("Expires", 0); //prevents caching at the proxy server
	%>
	
	<%@page import="com.ericsson.v1.util.Constants"%>
	<%@include file="/WEB-INF/views/public/taglib.jsp"%>

	<fmt:setBundle basename="messages" />
<html>
	<head>
	
	
	<link href="${pageContext.request.contextPath }/resources/css/common_style.css" rel="stylesheet" type="text/css" />
	
	<link href="${pageContext.request.contextPath }/resources/css/style1.css" rel="stylesheet" type="text/css" />
		
	<link href="${pageContext.request.contextPath }/resources/css/commonStyle.css" rel="stylesheet" type="text/css" />
		
		
		<title>Login</title>
			<!-- <link href="${rootURL}/resources/bootstrap/css/bootstrap.css"
				media="screen" rel="stylesheet" type="text/css" />
				<link rel="stylesheet" href="${pageContext.request.contextPath }/css/layout.css" type="text/css" />
				<link href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet" type="text/css" />
			<script type="text/javascript"
				src="${rootURL}/resources/jquery/jquery-1.10.2.js"></script>
			<script type="text/javascript"
				src="${rootURL}/resources/bootstrap/js/bootstrap.js"></script>
			<script type="text/javascript" src="${rootURL}/resources/js/app.js"></script> -->
		
		
		<style type='text/css'>


	 
    fieldset { padding:0; border:0; margin-top:25px; }
   
    div#users-contain { width: 350px; margin: 20px 0; }
    div#users-contain table { margin: 1em 0; border-collapse: collapse; width: 100%; }
    div#users-contain table td, div#users-contain table th { border: 1px solid #eee; padding: .6em 10px; text-align: left; }
    .ui-dialog .ui-state-error { padding: .3em; }
    .validateTips { border: 1px solid transparent; padding: 0.3em; }







            #loginbox {
      width: 800px;
      height: 325px;

      background-color: #7B68F2;
      background: linear-gradient(to bottom, #CFCFCF, #FFFFFF);
      background:-webkit-linear-gradient(top, #CFCFCF, #FFFFFF);
      background:-moz-linear-gradient(top, #CFCFCF, #FFFFFF);
      background-clip: padding-box;
      border-radius: 12px 12px 12px 12px;

      box-shadow:10px 10px 15px #272727;
    }

    .box_text_style {
      color: #FFFFFF;
      text-shadow: 1px 1px 3px #888888;
    }

    .logintitle {
      font-size: 20px;
      font-weight: 300;
      height: 60px;
      line-height: 60px;
      width: 100%;
      text-align: center;
    }

    .separator {
       border-bottom: 1px solid #FFFFFF;
       width:90%;
       margin:auto;
       clear:both;
    }

        </style>
		
<title>Login</title>
<link href="${rootURL}/resources/bootstrap/css/bootstrap.css" media="screen" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${rootURL}/resources/jquery/jquery-1.10.2.js"></script>
<script type="text/javascript" src="${rootURL}/resources/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="${rootURL}/resources/js/app.js"></script>		
		
		



</head>


<body>

<div class="container" align='center'>
<div id='loginbox' ><font color="#0B2F3A" size="4">
<div class='logintitle ericssonfont'> LOGIN</div>

<div class='separator'></div>











		
		<div class="col-md-6 col-md-offset-2">	
		<c:if test="${param.error != null}">
             <div class="alert alert-danger">
                 Invalid UserName and Password.
             </div>
         </c:if>
         <c:if test="${param.logout != null}">
             <div class="alert alert-success">
                 You have been logged out.
             </div>
         </c:if>	
         </div>  
            
     <div class="row">
     <BR> <BR>
		<div class="col-md-6 col-md-offset-2">	
			
			<form:form id="loginForm" method="post" action="${rootURL}/j_spring_security_check" 
			class="form-horizontal" role="form" cssStyle="width: 800px; margin: 0 auto;">
		  <div class="form-group">
		    <label for="username" class="col-sm-2 control-label">UserName*</label>
		    <div class="col-sm-4">
		      <input type="text" id="j_username" name="j_username" class="form-control" placeholder="UserName" />
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="password" class="col-sm-2 control-label">Password*</label>
		    <div class="col-sm-4">
		      <input type="password" id="j_password" name="j_password" class="form-control" placeholder="Password" value="password"/>
		    </div>
		  </div>
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-4">
		      <input type="submit" class="btn btn-primary" value="Login">
		    </div>
		  </div>
		  
		</form:form>
		
		<br> Current Locale : ${pageContext.response.locale} <br> <a
				href="<c:url value="/v1/public/registration.html" />"><spring:message
					code="label.form.loginSignUp"></spring:message></a>
			&nbsp;
            <a href="<c:url value="/forgetPassword.html" />"><spring:message
              code="message.resetPassword"></spring:message></a>
              &nbsp;
            <a href="<c:url value="/v1/public/employeeRegistration.jsp" />"><spring:message
              code="message.employeeRegistration"></spring:message></a>
		
	</div>
</div>

	<jsp:include page="/WEB-INF/views/public/include_footer.jsp" />
</body>
</html>
