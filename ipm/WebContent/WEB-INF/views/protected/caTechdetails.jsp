<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		pageEncoding="ISO-8859-1"%>
	<%
		response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1
		response.setHeader("Pragma", "no-cache"); //HTTP 1.0
		response.setDateHeader("Expires", 0); //prevents caching at the proxy server
	%>
	
	<%@include file="/WEB-INF/views/public/taglib.jsp"%>
	<%@include file="/WEB-INF/views/public/include_header.jsp" %>
	<fmt:setBundle basename="messages" />
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
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
		<title>Technology Skill</title>
		<style type='text/css'>

	    fieldset { padding:0; border:0; margin-top:25px; }

	    div#users-contain { width: 350px; margin: 20px 0; }
	    div#users-contain table { margin: 1em 0; border-collapse: collapse; width: 100%; }
	    div#users-contain table td, div#users-contain table th { border: 1px solid #eee; padding: .6em 10px; text-align: left; }
	    .ui-dialog .ui-state-error { padding: .3em; }
	    .validateTips { border: 1px solid transparent; padding: 0.3em; }

	            #loginbox {
	      width: 550px;
	      height: 730px;

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
	      font-wei
    height: 1000px;
	      ght: 300;
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
		<div class='logintitle ericssonfont'>Technology Skill</div>

		<div class='separator'></div>


		<div align='center'>
	<form action="saveCADetails.html" method="POST">
	
	<table >
			<c:forEach items="${CADTOs.list}" var="cadto">
            <tr>
                <td style="padding-left: 30px;">
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
                <td style="padding-right: 30px;">
                 ${cadto.CARequiredValue}
                </td>
            </tr>
            </c:forEach>
    </table><br>
	<input type="submit" name="submit" value="submit" style="width: 120px;">
	
	<input type="hidden" id="doid" name="doid" value="${CADTOs.caDomainId}">
	<input type="hidden" id="scid" name="scid" value="${CADTOs.caSkillId}">
	
	</form>
	</div></font></div></div>
	</body>
</html>
