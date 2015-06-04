

<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1
	response.setHeader("Pragma", "no-cache"); //HTTP 1.0
	response.setDateHeader("Expires", 0); //prevents caching at the proxy server
%>


<%@include file="taglib.jsp" %>
<%@ page session="false"%>
<<html>
<head>

<link href="${rootURL}/resources/bootstrap/css/bootstrap.css" media="screen" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title><spring:message code="label.form.title"></spring:message></title>
<link rel="shortcut icon" type="image/x-icon" href="http://eriteamtracker.egi.ericsson.com/img/favicon.ico">
	<link rel="shortcut icon" type="image/png" href="http://eriteamtracker.egi.ericsson.com/img/favicon.png">
	<link rel="stylesheet" href="http://eriteamtracker.egi.ericsson.com/css/style.css">
	<link rel="stylesheet" type="text/css" href="http://eriteamtracker.egi.ericsson.com/css/common_style.css" />
<style type='text/css'>


	 /* body { font-size: 62.5%; }
    label, input { display:block; }
    input.text { margin-bottom:12px; width:95%; padding: .4em; } */
    fieldset { padding:0; border:0; margin-top:25px; }
   /*  h1 { font-size: 1.2em; margin: .6em 0; } */
    div#users-contain { width: 350px; margin: 20px 0; }
    div#users-contain table { margin: 1em 0; border-collapse: collapse; width: 100%; }
    div#users-contain table td, div#users-contain table th { border: 1px solid #eee; padding: .6em 10px; text-align: left; }
    .ui-dialog .ui-state-error { padding: .3em; }
    .validateTips { border: 1px solid transparent; padding: 0.3em; }







            #loginbox {
      width: 600px;
      height: 440px;

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

<script>

function validateForm() {
  alert('in fname function');
var x = document.forms["myForm"]["fname"].value;
    if (x == null || x == "") {
        alert('First name must be filled out');
        return false;
    }
	else
	{
	if(!(/^[a-zA-Z]+$/).test(x))
	{
		alert('Enter letters only');
		return false;
	}
	return true;
}
}



function validate1Form() {
    	alert('in lname function');
	var x = document.forms["myForm"]["lname"].value;
    if (x == null || x == "") {
        alert('Last name must be filled out');
        return false;
    }
	else
	{
	if(!(/^[a-zA-Z]+$/).test(x))
	{
		alert('Enter letters only');
		return false;
	}
	return true;
}
}
function validateEmail() {
    var x = document.forms["myForm"]["email"].value;
	var re = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
     if(!(re.test(x)))
	{	alert('enter valid email id');
   		return false;
	}
     else
		return true;
}

</script>


</head>


<body>
<div class="container" align="center">
		<div id="loginbox">
        <div class='logintitle ericssonfont'> Registration Page</div>
        <div class='separator'></div>
	<%-- <spring:message code="label.form.title"></spring:message></font></h1> --%>

<form:form modelAttribute="registrationDTO" method="POST" action="registration.html" enctype="utf8" name="myForm" >


<ul>
  <li>
					<label class='ericssonfont'><spring:message code="label.user.firstName"></spring:message></label>
					<form:input path="userFirstName" value="" size="26"/>
					<form:errors path="userFirstName" cssClass="alert alert-error"/>
 </li>

		<li>
				<label class='ericssonfont'><spring:message code="label.user.lastName"></spring:message></label>
					<form:input path="userLastName" value="" size="26"/>
					<form:errors path="userLastName" cssClass="alert alert-error"/>
					 </li>
		<li>	<label class='ericssonfont'><spring:message code="label.user.email"></spring:message></label>
					<form:input path="emailId" value="" size="26"/>
					<form:errors path="emailId" cssClass="alert alert-error"/>
					</li>
					<li>
				<label class='ericssonfont'><spring:message code="label.form.loginRole" /></label>

		<form:select path="userSelectedRole">
				<c:forEach items="${roles}" var="rol">
					<option value="${rol.id}">${rol.name}</option>
				</c:forEach>
			</form:select>




			<form:errors path="userSelectedRole" cssClass="alert alert-error" />
				</li>
			<li>
		<label class='ericssonfont'>
		<spring:message code="label.user.password"></spring:message></label>
					<form:input path="password" value="" type="password" size="26"/>
					<form:errors path="password" cssClass="alert alert-error"/>
				<label class='ericssonfont'><spring:message code="label.user.confirmPass"></spring:message></label>
					<form:input path="matchingPassword" value="" type="password" size="26"/>
					<form:errors cssClass="alert alert-error" />
					</li>

					<%-- <li>
					<label class='ericssonfont'>
					<spring:message code="label.user.form.captchaCode"></spring:message>
					</label>
					 <label style="align:left">
					<img src='<%=request.getContextPath()%>/<c:url value="simpleCaptcha.png" />' />
					</label>
					</li>

					<li>
					<label><spring:message code="label.user.captchaCode"></spring:message></label>
					<form:input path="captchaCode" size="26"/>
					<form:errors path="captchaCode" cssClass="alert alert-error" />
					</li>
					--%>											<li>
				<button type="submit" class="btn btn-primary">
					<spring:message code="label.form.submit"></spring:message>
				</button>
				<button type="Reset" class="btn btn-primary">
					<spring:message code="label.form.reset"></spring:message>
				</button>
				</li>
				</ul>
			</form:form>

			<br> <a href="<c:url value="login.html" />"><spring:message code="label.form.loginLink"></spring:message></a>
		</div>
	</div>

</body>
</html>













