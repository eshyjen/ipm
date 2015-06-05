

	<%
		response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1
		response.setHeader("Pragma", "no-cache"); //HTTP 1.0
		response.setDateHeader("Expires", 0); //prevents caching at the proxy server
	%>

	<%@include file="/WEB-INF/views/public/include_header.jsp" %>
	<%@include file="/WEB-INF/views/public/taglib.jsp"%>
	<fmt:setBundle basename="messages" />
<html>
<head>
			<link href="${rootURL}/resources/bootstrap/css/bootstrap.css" media="screen" rel="stylesheet" type="text/css" />
		

	<link rel="stylesheet" href="http://eriteamtracker.egi.ericsson.com/css/style.css">
	
	<link href="${pageContext.request.contextPath }/resources/css/common_style.css" rel="stylesheet" type="text/css" />
	
	<link href="${pageContext.request.contextPath }/resources/css/style1.css" rel="stylesheet" type="text/css" />
		
	<link href="${pageContext.request.contextPath }/resources/css/commonStyle.css" rel="stylesheet" type="text/css" />
		
<title> User Profile </title>
<style type="text/css">
.styled-button-5 {
	background-color:#404040 ;
	color:#fff;
	font-family:'Helvetica Neue',sans-serif;
	font-size:18px;
	line-height:30px;
	border-radius:20px;
	-webkit-border-radius:20px;
	-moz-border-radius:20px;
	border:0;
	text-shadow:#000000 0 -1px 0;
	width:120px;
	height:32px
}
input{ align:center; }
</style>

<style type='text/css'>



    fieldset { padding:0; border:0; margin-top:25px; }

    div#users-contain { width: 350px; margin: 20px 0; }
    div#users-contain table { margin: 1em 0; border-collapse: collapse; width: 100%; }
    div#users-contain table td, div#users-contain table th { border: 1px solid #eee; padding: .6em 10px; text-align: left; }
    .ui-dialog .ui-state-error { padding: .3em; }
    .validateTips { border: 1px solid transparent; padding: 0.3em; }







            #loginbox {
      width: 1000px;
      height: 495px;

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
    .newspaper {
    -webkit-column-count: 4px;
    -moz-column-count: 4px;
    column-count: 4px;
}

        </style>

<!-- <link rel="stylesheet" type="text/css" media="all" href="jsDatePick_ltr.min.css" />
<script type="text/javascript" src="jsDatePick.min.1.3.js"></script> -->
<!-- <script type="text/javascript">
	window.onload = function(){
		new JsDatePick({
			useMode:2,
			target:"dateOfJoinInMediaAccount",
			dateFormat:"%d-%M-%Y"
		});
	};


function validateEmail() {
   var x = document.forms["myForm"]["emailId"].value;

 var re = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
    if(!re.test(x))
{
 alert("enter valid email");
return false;
}
else
return true;
}

function validateForm1() {

	var x = document.forms["myForm"]["field"].value;

    if (x == null || x == "") {
        alert("Required fields must be filled out");
        return false;
    }
	else
	{
		if(!(/^[a-zA-Z]+$/.test(x)))
		{
			document.getElementById('msg').innerHTML="*";
		document.getElementById('ttt').innerHTML="*";
		//alert('Enter letters only');

			return false;
		}
		return true;
	}

}


</script> -->

<script type="text/javascript">
				function IsValid() {
					if (isEmpty()) {
						document.userDetailsForm.submit();
					}
				}

				function isEmpty() {

					var id;

					var formfield = "";
					var str = document.getElementById("userFristName").value;
					if (document.getElementById("userFristName").value == "") {
						formfield = "Asset Name";
					}
					if (document.getElementById("userLastName").value == "") {
						formfield = formfield + "\n" + "Asset Short Description";
					}
					if (document.getElementById("emailId").value == "")
						formfield = formfield + "\n" + "Project Name";
					if (document.getElementById("costCenter").value == "")
						formfield = formfield + "\n" + "Registered In AssetPortal";
					if (document.getElementById("role").value == "")
						formfield = formfield + "\n" + "Effort Save";
					if (document.getElementById("currentLineManager").value == "")
						formfield = formfield + "\n" + "Effort Save";
					if (document.getElementById("dateOfJoinInMediaAccount").value == "")
						formfield = formfield + "\n" + "Effort Save";
					if (document.getElementById("educationalQualification").value == "")
						formfield = formfield + "\n" + "Effort Save";
					if (document.getElementById("employeeId").value == "")
						formfield = formfield + "\n" + "Effort Save";
					if (document.getElementById("jobRole").value == "")
						formfield = formfield + "\n" + "Effort Save";
					if (document.getElementById("jobStage").value == "")
						formfield = formfield + "\n" + "Effort Save";
					if (document.getElementById("lastYearIPMRating").value == "")
						formfield = formfield + "\n" + "Effort Save";
					if (document.getElementById("manHourRate").value == "")
						formfield = formfield + "\n" + "Effort Save";
					if (document.getElementById("previousLineManeger").value == "")
						formfield = formfield + "\n" + "Effort Save";
					if (document.getElementById("previousOrganisation").value == "")
						formfield = formfield + "\n" + "Effort Save";
					if (document.getElementById("signunId").value == "")
						formfield = formfield + "\n" + "Effort Save";
					if (document.getElementById("totalEricssonExperienceInMonths").value == "")
						formfield = formfield + "\n" + "Effort Save";
					if (document.getElementById("totalITExperience").value == "")
						formfield = formfield + "\n" + "Effort Save";
					if (document.getElementById("totalYearsOfExperience").value == "")
						formfield = formfield + "\n" + "Effort Save";
					if (document.getElementById("yearOfIPM").value == "")
						formfield = formfield + "\n" + "Effort Save";
					if (document.getElementById("yearOfLastPromotion").value == "")
						formfield = formfield + "\n" + "Effort Save";
					if (formfield == "") {
						return true;
					} else {
						alert("Required Fields :  \n" + formfield);
						return false;
					}
				}
			</script>


</head>
<body align="center" bgcolor="">
	<font weight=900 face="Arial" color="#001D55">
<div class="container" align="center">
		<div id="loginbox">

        <div class='logintitle ericssonfont'> User Details</div>
        <div class='separator'></div>
		
		<br>
			<div class="row">



				<form:form name="userDetailsForm" method="POST" action="updateUserDetails.html" modelAttribute="userProfileDTO">
					<table align="center" font-face="Arial" style="width:1000px; align:center;">
						<tr>
							<td align="right"  width="250px"  >First Name:</td>
							<td align="center"  width="250px"   >
								 <form:input path="userFristName" id="userFristName" value="${userProfile.userFristName}" />   <font
								color="red"><span id="msg"></span></font>
							</td>
							<td align="right"  width="250px" >Last Name:</td>
							<td align="center"  width="250px">
								<form:input path="userLastName" id="userLastName"  value="${userProfile.userLastName}"  />  <font
								color="red"><span id="ttt"></span></font>
							</td>
						</tr>

						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>

						<tr>
							<td align="right"  width="250px">Cost Center:</td>
							<td align="center"  width="250px"  >
								<form:input path="costCenter"  id="costCenter"  value="${userProfile.costCenter}"  />   <font
								color="red"><span id="msg"></span></font>
							</td>
							<td align="right"  width="250px">Email-Id:</td>
							<td align="center"  width="250px" >
								 <form:input path="emailId" id="emailId"  value="${userProfile.emailId}"  />
							</td>
						</tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>


						<tr>
						<td align="right"  width="250px">Job Role:</td>
							<td align="center"  width="250px" >
								 <form:input path="jobRole" id="jobRole"  value="${userProfile.jobRole}"  /> 
							<%-- <td align="center"  width="250px"  width="250px"   align="left">D.O.J In Media Account:</td>
							<td align="center"  width="250px"  width="250px"  >
								 <form:input path="dateOfJoinInMediaAccount" size="12" value="${userProfile.dateOfJoinInMediaAccount}"
								 id="dateOfJoinInMediaAccount"  style="border:1px solid #A0A0A0 ;
			border-radius:10px;
			height: 22px;
			width: 150px;"/>
								<font color="red"><span id="msg"></span></font>
							</td> --%>
							<td align="right"  width="250px">Current Line Manager:</td>
							<td align="center"  width="250px" >
								 <form:input path="currentLineManager"  id="currentLineManager"  value="${userProfile.currentLineManager}"  />  <font
								color="red"><span id="msg"></span></font>
							</td>
						</tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>


						<tr>
							<td align="right"  width="250px" >Educational Qualification:</td>
							<td align="center"  width="250px" >
								 <form:input path="educationalQualification" id="educationalQualification"  value="${userProfile.educationalQualification}" />  <font
								color="red"><span id="msg"></span></font>
							</td>
							<td align="right"  width="250px">Last Year IPM Rating:</td>
							<td align="center"  width="250px" >
								 <form:input path="lastYearIPMRating" id="lastYearIPMRating"  value="${userProfile.lastYearIPMRating}"  /> 
							</td>
						</tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>


						<tr>
							<td align="right"  width="250px" >Employee-ID:</td>
							<td align="center"  width="250px" >
								 <form:input path="employeeId" id="employeeId"  value="${userProfile.employeeId}"  />  <font
								color="red"><span id="msg"></span></font>
							</td>
							<td align="right"  width="250px" >Year Of IPM:</td>
							<td align="center"  width="250px">
								 <form:input path="yearOfIPM" id="yearOfIPM"  value="${userProfile.yearOfIPM}"  />   <font color="red"><span
									id="msg"></span></font>
							</td>
						</tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>



						<tr>
							<td align="right"  width="250px" >Job Stage:</td>
							<td align="center"  width="250px" >
								 <form:input path="jobStage" id="jobStage"  value="${userProfile.jobStage}"  />  <font color="red"><span
									id="msg"></span></font>
							</td>
							<td align="right"  width="250px" >Previous Organisation:</td>
							<td align="center"  width="250px" >
								<form:input path="previousOrganisation" id="previousOrganisation"  value="${userProfile.previousOrganisation}" />   <font
								color="red"><span id="msg"></span></font>
							</td>
						</tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>


						<tr>
							<td align="right"  width="250px">Man Hour Rate:</td>
							<td align="center"  width="250px" >
								 <form:input path="manHourRate" id="manHourRate"  value="${userProfile.manHourRate}"  />  <font
								color="red"><span id="msg"></span></font>
							</td><td align="right"  width="250px" >Total Ericsson Experience In Months:</td>
							<td align="center"  width="250px">
								 <form:input path="totalEricssonExperienceInMonths" id="totalEricssonExperienceInMonths"  value="${userProfile.totalEricssonExperienceInMonths}" /> 
							<%-- <td align="center"  width="250px"  width="250px"   align="left">Last Modified Date:</td>
							<td align="center"  width="250px"  width="250px"  >
								 <form:input path="modifiedDate" id="modifiedDate"  value="${userProfile.modifiedDate}" style="border:1px solid #A0A0A0 ;
			border-radius:10px;
			height: 22px;
			width: 150px;" />  <font
								color="red"><span id="msg"></span></font>
							</td> --%>
						</tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>

						<tr>
							<td align="right"  width="250px">Previous Line Manager:</td>
							<td align="center"  width="250px" >
								 <form:input path="previousLineManeger" id="previousLineManeger"  value="${userProfile.previousLineManeger}" />  <font
								color="red"><span id="msg"></span></font>
							</td>
							<td align="right"  width="250px">Total Years Of Experience:</td>
							<td align="center"  width="250px">
								 <form:input path="totalYearsOfExperience" id="totalYearsOfExperience"  value="${userProfile.totalYearsOfExperience}"  />  <font
								color="red"><span id="msg"></span></font>
							</td>
						</tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>

						<tr>
							<td align="right"  width="250px">Signum-ID:</td>
							<td align="center"  width="250px" >
								  <form:input path="signunId" id="signunId"  value="${userProfile.signunId}" />  <font color="red"><span
									id="msg"></span></font>
							</td>
							<td align="right"  width="250px">Year Of Last Promotion:</td>
							<td align="center"  width="250px" >
								 <form:input path="yearOfLastPromotion" id="yearOfLastPromotion"  value="${userProfile.yearOfLastPromotion}" />  <font color="red"><span
									id="msg"></span></font>
							</td>
						</tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>


						<tr>
							<td align="right"  width="250px">Total IT Experience:</td>
							<td align="center"  width="250px">
								 <form:input path="totalITExperience" id="totalITExperience"  value="${userProfile.totalITExperience}" />  <font
								color="red"><span id="msg"></span></font>
							</td>
							
							
						</tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>

					
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>

						<tr>
							<td align="center"  width="250px">&nbsp; &nbsp;</td>
							<td align="center"  width="250px"><input type="submit"  style="width:100px;" value="Save" /></td>
							<td align="center"  width="250px" ><input type="submit" style="width:100px;" value="Reset" /></td>
							<td align="center"  width="250px" >&nbsp; &nbsp; &nbsp;</td> </tr>
					</table>
				</form:form>
			</div>
	</font>
</body>
</html>
