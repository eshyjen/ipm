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
<html>
	<head>

<link rel="shortcut icon" type="image/x-icon" href="http://eriteamtracker.egi.ericsson.com/img/favicon.ico">
	<link rel="shortcut icon" type="image/png" href="http://eriteamtracker.egi.ericsson.com/img/favicon.png">
	<link rel="stylesheet" href="http://eriteamtracker.egi.ericsson.com/css/style.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/common_style.css" />
	<script src="http://eriteamtracker.egi.ericsson.com/js/jquery-1.2.6.min.js" type="text/javascript"></script>

		<title>Asset Details</title>


		<style type='text/css'>



    fieldset { padding:0; border:0; margin-top:25px; }

    div#users-contain { width: 350px; margin: 20px 0; }
    div#users-contain table { margin: 1em 0; border-collapse: collapse; width: 100%; }
    div#users-contain table td, div#users-contain table th { border: 1px solid #eee; padding: .6em 10px; text-align: left; }
    .ui-dialog .ui-state-error { padding: .3em; }
    .validateTips { border: 1px solid transparent; padding: 0.3em; }







            #loginbox {
      width: 500px;
      height: 500px;

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


		<div class="container" align="center">
		<div id="loginbox">

        <div class='logintitle ericssonfont'> Asset Details</div>
        <div class='separator'></div>
 <form:form method="post" action="saveAssetDetails.html" modelAttribute="assetDTO" name="updateAssetDetailForm">
	<label for="login_name" class='ericssonfont'>Asset Name*:</label>

	<form:input path="assetName" style="width:140px;" id="assetName" required="required"/>
	<%-- <br><br>
	<label for="login_name" class='ericssonfont'>Asset ID *:</label>
	<!-- <font face="THE TIMES NEW ROMAN"color="#0B2F3A" size="5">Project Type*: </font> -->
	<form:input path="id" style="width:140px;" id="id" required="required"/> --%>
	<br><br>
	<label for="login_name" class='ericssonfont'>Project name</label>
	<!-- <font face="THE TIMES NEW ROMAN"color="#0B2F3A" size="5">DQI Score*:</font> -->
	<form:input path="projectName" style="width:140px;" id="projectName" required="required"/>
	<br><br>
	<label for="login_name" class='ericssonfont'>Reused in Other Projects Name*:</label>
	<!-- <font face="THE TIMES NEW ROMAN"color="#0B2F3A" size="5">DPI Score*: </font> -->
	<form:input path="reusedInOtherProjectsName" style="width:140px;" id="reusedInOtherProjectsName" required="required"/>
	<br><br>
	<label for="login_name" class='ericssonfont'>Asset Description*:</label>
	<!-- <font face="THE TIMES NEW ROMAN"color="#0B2F3A" size="5">Date*: </font> -->
	<form:input path="assetShortDescription"  style="width:140px;" id="assetShortDescription" required="required"/>
	<br><br>
	<label for="login_name" class='ericssonfont'>Effort Save*:</label>
	<!-- <font face="THE TIMES NEW ROMAN"color="#0B2F3A" size="5">PM/SPM Name*: </font> -->
	<form:input path="effortSave" style="width:140px;" id="effortSave" required="required"/>
	<br><br>
	<label for="login_name" class='ericssonfont'>Registered In Asset Portal*:</label>
	<!-- <font face="THE TIMES NEW ROMAN"color="#0B2F3A" size="5">TL name*: </font> -->
	<form:input path="registeredInAssetPortal" style="width:140px;" id="registeredInAssetPortal" required="required"/>
	<br><br>
	<label for="login_name" class='ericssonfont'>Approval Status*:</label>
	<!-- <font face="THE TIMES NEW ROMAN"color="#0B2F3A" size="5">TL name*: </font> -->
	<form:input path="approvalStatus" style="width:140px;" id="approvalStatus" required="required"/>
	<br><br>
	<form:hidden path="id" style="width:140px;" id="id"/>
	<input type="submit" style="width:100px;" value="Save/Update" />
</form:form>

</body>
</html>