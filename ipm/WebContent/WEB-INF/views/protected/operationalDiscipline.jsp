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

	<FONT face="Calibri" size="2">
				<h3 align="center">Delivery Quality Page</h3>
			</FONT>


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
      width: 800px;
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

        <div class='logintitle ericssonfont'> Delivery Quality List</div>
        <div class='separator'></div>
<div id="dataview" >
			<form:form name="myform" id="myform">

			<a id="add" href="operationalDiscipline.html">
				<img src="<%=request.getContextPath()%>/resources/images/add_button.gif" />
			</a>

				<div id="tablediv">

					 <display:table id="usertable" name="<%=Constants.OPERATIONAL_DISCIPLINE_LIST %>" class="list" sort="page" pagesize="5"
					 export="true" requestURI="operationalDisciplineList.html"  >

				   	 <display:column title="Edit/Delete"  paramProperty="id" paramId="id" >
				   	 <a href="operationalDisciplineForUpdate.html?id=${usertable.id}">
				   	 <img src="<%=request.getContextPath()%>/resources/images/edit_icon.gif" title="Edit" border="0">
				   	 </a><img src="<%=request.getContextPath()%>/resources/images/spacer.gif" width="4" height="1">
				   			<a href="javascript:checkDelete(${usertable_rowNum});">
				   			<img src="<%=request.getContextPath()%>/resources/images/remove_icon.gif" title="Remove" border="0"></a>
				   	 </display:column>
					 <display:column class='ericssonfont' property="id" sortable="true" title="OpdId"/>
				     <display:column class='ericssonfont' property="operationalDisciplineName" title="Operational Discipline Name" sortable="true" sortProperty="operationalDisciplineName"/>
				     <display:column class='ericssonfont' property="frequency" title="Frequency" sortable="true" />
				     <display:column class='ericssonfont' property="quarter" title="Quarter" sortable="true" />
				     <display:column class='ericssonfont' property="nonCompliance" title="non-Compliance" sortable="true" />
				     </display:table>


				</div>

			</form:form>>

		</div>




</body>
</html>