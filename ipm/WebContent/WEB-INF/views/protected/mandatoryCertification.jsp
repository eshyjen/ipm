<html>
	<head>
	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		pageEncoding="ISO-8859-1"%>
	<%
		response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1
		response.setHeader("Pragma", "no-cache"); //HTTP 1.0
		response.setDateHeader("Expires", 0); //prevents caching at the proxy server
	%>

	<%@page import="com.ericsson.v1.util.Constants"%>
	<%@include file="/WEB-INF/views/public/taglib.jsp"%>
	<%@include file="/WEB-INF/views/public/include_header.jsp" %>
	<fmt:setBundle basename="messages" />



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

<script src="http://code.jquery.com/jquery-migrate-1.0.0.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="http://eriteamtracker.egi.ericsson.com/img/favicon.ico">
	<link rel="shortcut icon" type="image/png" href="http://eriteamtracker.egi.ericsson.com/img/favicon.png">
	<link rel="stylesheet" href="http://eriteamtracker.egi.ericsson.com/css/style.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/common_style.css" />


		<title>Mandatory Training</title>


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


		<script type="text/javascript">
		var datefield = document.createElement("input")
		datefield.setAttribute("type", "date")
		if (datefield.type != "date") { //if browser doesn't support input type="date", load files for jQuery UI Date Picker
			document
					.write('<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />\n')
			document
					.write('<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"><\/script>\n')
			document
					.write('<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"><\/script>\n')
		}
	</script>
	<script type="text/javascript">
		if (datefield.type != "date") { //if browser doesn't support input type="date", initialize date picker widget:
			jQuery(function($) { //on document.ready
				$('#dqiDate').datepicker();
			})
		}
	</script>




</head>


<body>

<div class="container" align='center'>
<div id='loginbox' ><font color="#0B2F3A" size="4">
<div class='logintitle ericssonfont'> Mandatory Training</div>

<div class='separator'></div>


<div align='center'>
<form:form  name="myForm" method="post" action="saveMandatoryCertification.html" modelAttribute="mandatoryCertificationDTO" enctype="multipart/form-data">



 <font style="float:left; margin-left:20%;"> Training Name:</font>
 <font style="float:right;margin-right:20% "><form:input path="trainingName" id="field" style="width:200px;" required="required"/> </font><br><BR>



  <font style="float:left; margin-left:20%">Date/WK Planned:</font>
  <font style="float:right;margin-right:20%"><form:input path="dateWeekPlanned"  style="width:200px;"  type="date" required="required" /></font><br><br>


  <font style="float:left; margin-left:20%">Date Attended    :</font>
  <font style="float:right;margin-right:20%"><form:input  path="dateAttended" style="width:200px;" type="date"  size="12" required="required" /></font> <br><BR >

 <font style="float:left; margin-left:20%">Attach Certificate:</font>

 <font style="float:right;margin-right:20%"><input type="file" name="uploadedFile" size="40"/></font>
 <br><BR>

  <font style="float:left; margin-left:20%">Completion Status:</font>
  <font style="float:right;margin-right:35%"> <form:radiobutton path="completionStatus" name="option" value="Yes"   />Yes
<form:radiobutton path="completionStatus" name="option" value="No"  />No  </font><br><br>

<input style="width: 100px;" type="submit" class="styled-button-5" value="submit"></input>
<form:hidden path="id" id="id"></form:hidden>

</form:form>
</div>
</div>


</html>