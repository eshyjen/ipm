<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		pageEncoding="ISO-8859-1"%>
	<%
		response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1
		response.setHeader("Pragma", "no-cache"); //HTTP 1.0
		response.setDateHeader("Expires", 0); //prevents caching at the proxy server
	%>
	
	<%@page import="com.ericsson.v1.util.Constants"%>
	<%@include file="/WEB-INF/views/public/taglib.jsp"%>
<html>
	<head>
	
	<script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript">
      google.load("visualization", "1", {packages:["orgchart"]});
      google.setOnLoadCallback(init);
      function init() {
    	// Specify the data source URL.
    	  var query = new google.visualization.Query('/ipm/v1/protected/orgChart');
    	  // Send the query with a callback function.
    	  query.send(handleQueryResponse);
      }
      
      // Handle the query response.
      function handleQueryResponse(response) {
      if (response.isError()) {
      alert('Error in query: ' + response.getMessage() + ' ' + response.getDetailedMessage());
      return;
      }
      // Draw the visualization.
      var data = response.getDataTable();
      
      var chart = new google.visualization.OrgChart(document.getElementById('chart_div'));
      chart.draw(data, {allowHtml:true});

      }
   </script>
	
	
	</head>
	
	<body>
    	<div id="chart_div""></div>
    	
    	
				<%-- <div id="tablediv">

					 <display:table id="usertable" name="<%=Constants.EMPLOYEE_LIST %>" class="list" sort="page" pagesize="5"
					 export="true" requestURI="operationalDisciplineDetails.html"  >
				   	 <display:column title="Edit/Delete"  paramProperty="id" paramId="id" >
				   	 <a href="operationalDisciplineForUpdate.html?id=${usertable.id}">
				   	 	<img src="<%=request.getContextPath()%>/skin/images/edit_icon.gif" title="Edit" border="0">
				   	 </a>
				   	 <img src="<%=request.getContextPath()%>/skin/images/spacer.gif" width="4" height="1">
				   		<a href="javascript:checkDelete(${usertable_rowNum});">
				   	 <img src="<%=request.getContextPath()%>/skin/images/remove_icon.gif" title="Remove" border="0">
				   	 </a>
				   	 </display:column>
					 <display:column property="signum" sortable="true" title="signum"/>
				     <display:column property="name" title="Name" sortable="true" sortProperty="name"/>
				     
				     </display:table>
				</div> --%>
			<p></p>
  	</body>

	
	
</html>