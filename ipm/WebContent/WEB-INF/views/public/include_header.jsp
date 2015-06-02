<html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@include file="/WEB-INF/views/public/taglib.jsp"%>
<head>

<!-- <script type="text/javascript">
<%-- function back2PublicHome() {
	document.location.href = "<%=request.getContextPath()%>/index.action";
	return true;
} --%>
function back2ProtectedHome() {
	document.location.href = "<%=request.getContextPath()%>/protected/welcome.action";
	return true;
}

</script> -->

 <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/stylish.css">

   <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
   <script src="<%=request.getContextPath()%>/resources/js/script.js"></script>


<div>
<a href="http://www.ericsson.com" title="Ericsson" class="logo" target="_new">
   <img src="https://internal.egi.ericsson.com/sites/default/files/econ-white.jpg" alt="Home" style="float:right; margin-left: 4cm" /></a>
</div>


</head>


<body>

<div id='cssmenu'>
<ul>
   <li class='has-sub' style=" font-size: 15px;" ><a href="#"><span>Home  &#9662;</span></a>
      <ul>
         <li><a href='#'><span>Home</span></a></li>
         <li><a href='#'><span>Goals</span></a></li>
         <li><a href='#'><span>Performance</span></a></li>
         <li><a href='#'><span>Learning</span></a></li>
         <li><a href='#'><span>My Development Plan</span></a></li>
         <li><a href='#'><span>Career</span></a></li>
         <li><a href='#'><span>Recruiting</span></a></li>
         <li><a href='#'><span>Company Info</span></a></li>
         <li class='last'><a href='#'><span>Employer Profile</span></a></li>
      </ul>
   </li>
	<li style="float:right;" class='has-sub'><a href="#"> <span>Welcome   &#9662;</span></a>
<ul>
<li><a href='#'><span>Options</span></a></li>
<li><a href='#'><span>Logout</span></a></li>
</ul>
</li>
</ul>
</div>


</body>





</html>
