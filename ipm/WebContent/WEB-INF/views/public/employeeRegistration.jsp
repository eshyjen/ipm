
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
<link href="bootstrap.css" media="screen" rel="stylesheet" type="text/css" />
<link href="commonStyle.css" media="screen" rel="stylesheet" type="text/css" />
<link href="common_style.css" media="screen" rel="stylesheet" type="text/css" />
<link href="style1.css" media="screen" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="jquery-1.10.2.js"></script>
<script type="text/javascript" src="bootstrap.js"></script>
<script type="text/javascript" src="app.js"></script>





	<link href="${rootURL}/resources/bootstrap/css/bootstrap.css"
				media="screen" rel="stylesheet" type="text/css" />
				<link rel="stylesheet" href="${pageContext.request.contextPath }/css/layout.css" type="text/css" />
				<link href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet" type="text/css" />
			<script type="text/javascript"
				src="${rootURL}/resources/jquery/jquery-1.10.2.js"></script>
			<script type="text/javascript"
				src="${rootURL}/resources/bootstrap/js/bootstrap.js"></script>
			<script type="text/javascript" src="${rootURL}/resources/js/app.js"></script>

<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript" src="http://code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<script type="text/javascript" src="../resources/js/jquery.autocomplete.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.0.0.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="http://eriteamtracker.egi.ericsson.com/img/favicon.ico">
	<link rel="shortcut icon" type="image/png" href="http://eriteamtracker.egi.ericsson.com/img/favicon.png">
	<link rel="stylesheet" href="http://eriteamtracker.egi.ericsson.com/css/style.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/common_style.css" />


<style type='text/css'>

    fieldset { padding:0; border:0; margin-top:25px; }

    div#users-contain { width: 350px; margin: 20px 0; }
    div#users-contain table { margin: 1em 0; border-collapse: collapse; width: 100%; }
    div#users-contain table td, div#users-contain table th { border: 1px solid #eee; padding: .6em 10px; text-align: left; }
    .ui-dialog .ui-state-error { padding: .3em; }
    .validateTips { border: 1px solid transparent; padding: 0.3em; }







            #loginbox {
      width: 650px;
      height: 350px;

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
      font-size: 18px;
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





<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript" src="http://code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<script type="text/javascript" src="../resources/js/jquery.autocomplete.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.0.0.js"></script>


</head>
<body>

<div class="container" align="center">
		<div id="loginbox">

        <div class='logintitle ericssonfont'>Employee Registration Page</div>
        <div class='separator'></div>




     <div class="row">
		<div class="col-md-6 col-md-offset-2">

			<form id="loginForm" method="post" action="${rootURL}/v1/public/employeeRegistration.html"
			class="form-horizontal" role="form" cssStyle="width: 800px; margin: 0 auto;" style="width:600px;">
		  <div class="form-group">

		    <label for="username" class="col-sm-2 control-label">UserName:</label>
		    <div class="col-sm-4">
		      <input type="text" id="j_username" name="j_username" class="form-control"placeholder="UserName"style="marginleft:50%;width:200px;" />
		    </div>
		  </div>

		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-4">
		      <input type="submit" class="btn btn-primary" value="Login" style="margin-left:8%; width:200px;"/>
		    </div>
		  </div>

		</form>

		<br> &nbsp;&nbsp;&nbsp;&nbsp;Current Locale : ${pageContext.response.locale} <br> <a
				href="<c:url value="/v1/public/registration.html" />"><spring:message
					code="label.form.loginSignUp"></spring:message></a>
			<br><br><br>

	</div>
</div>

	<jsp:include page="/WEB-INF/views/public/include_footer.jsp" />

</body>
</html>