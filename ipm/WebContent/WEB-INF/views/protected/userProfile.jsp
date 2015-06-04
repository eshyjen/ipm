

	<%
		response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1
		response.setHeader("Pragma", "no-cache"); //HTTP 1.0
		response.setDateHeader("Expires", 0); //prevents caching at the proxy server
	%>


	<%@include file="/WEB-INF/views/public/taglib.jsp"%>
	<fmt:setBundle basename="messages" />
<html>
<head>

<title> joining form </title>
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

		<h2 style="text-align: center" font-face="Verdana">
			<b>User Details :</b>
		</h2>
		<br>
			<div class="row">



				<form:form name="userDetailsForm" method="POST" action="updateUserDetails.html" modelAttribute="userProfileDTO">
					<table align="center" font-face="Arial">
						<tr>
							<td align="left">First Name:</td>
							<td width="300px">
								 <form:input path="userFristName" id="userFristName" value="${userProfile.userFristName}" style="border:1px solid #A0A0A0 ;
			border-radius:10px;
			height: 22px;
			width: 150px;"/>   <font
								color="red"><span id="msg"></span></font>
							</td>
							<td width="300px" align="left">Last Name:</td>
							<td>
								<form:input path="userLastName" id="userLastName"  value="${userProfile.userLastName}" style="border:1px solid #A0A0A0 ;
			border-radius:10px;
			height: 22px;
			width: 150px;" />  <font
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
							<td align="left">Cost Center:</td>
							<td>
								<form:input path="costCenter"  id="costCenter"  value="${userProfile.costCenter}" style="border:1px solid #A0A0A0 ;
			border-radius:10px;
			height: 22px;
			width: 150px;" />   <font
								color="red"><span id="msg"></span></font>
							</td>
							<td align="left">Role:</td>
							<%-- <td>
								 <form:input path="role"   id="role"  value="${userProfile.role}" style="border:1px solid #A0A0A0 ;
			border-radius:10px;
			height: 22px;
			width: 150px;" />  <font color="red"><span
									id="msg"></span></font>
							</td> --%>
						</tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>


						<tr>
							<%-- <td align="left">D.O.J In Media Account:</td>
							<td>
								 <form:input path="dateOfJoinInMediaAccount" size="12" value="${userProfile.dateOfJoinInMediaAccount}"
								 id="dateOfJoinInMediaAccount"  style="border:1px solid #A0A0A0 ;
			border-radius:10px;
			height: 22px;
			width: 150px;"/>
								<font color="red"><span id="msg"></span></font>
							</td> --%>
							<td align="left">Current Line Manager:</td>
							<td>
								 <form:input path="currentLineManager"  id="currentLineManager"  value="${userProfile.currentLineManager}" style="border:1px solid #A0A0A0 ;
			border-radius:10px;
			height: 22px;
			width: 150px;" />  <font
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
							<td align="left">Educational Qualification:</td>
							<td>
								 <form:input path="educationalQualification" id="educationalQualification"  value="${userProfile.educationalQualification}" style="border:1px solid #A0A0A0 ;
			border-radius:10px;
			height: 22px;
			width: 150px;"/>  <font
								color="red"><span id="msg"></span></font>
							</td>
							<td align="left">Email-Id:</td>
							<td>
								 <form:input path="emailId" id="emailId"  value="${userProfile.emailId}" style="border:1px solid #A0A0A0 ;
			border-radius:10px;
			height: 22px;
			width: 150px;"  />
							</td>
						</tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>


						<tr>
							<td align="left">Employee-ID:</td>
							<td>
								 <form:input path="employeeId" id="employeeId"  value="${userProfile.employeeId}" style="border:1px solid #A0A0A0 ;
			border-radius:10px;
			height: 22px;
			width: 150px;" />  <font
								color="red"><span id="msg"></span></font>
							</td>
							<td align="left">Job Role:</td>
							<td>
								 <form:input path="jobRole" id="jobRole"  value="${userProfile.jobRole}" style="border:1px solid #A0A0A0 ;
			border-radius:10px;
			height: 22px;
			width: 150px;" />  <font color="red"><span
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
							<td align="left">Job Stage:</td>
							<td>
								 <form:input path="jobStage" id="jobStage"  value="${userProfile.jobStage}" style="border:1px solid #A0A0A0 ;
			border-radius:10px;
			height: 22px;
			width: 150px;" />  <font color="red"><span
									id="msg"></span></font>
							</td>
							<td align="left">Last Year IPM Rating:</td>
							<td>
								 <form:input path="lastYearIPMRating" id="lastYearIPMRating"  value="${userProfile.lastYearIPMRating}" style="border:1px solid #A0A0A0 ;
			border-radius:10px;
			height: 22px;
			width: 150px;" />  <font
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
							<td align="left">Man Hour Rate:</td>
							<td>
								 <form:input path="manHourRate" id="manHourRate"  value="${userProfile.manHourRate}" style="border:1px solid #A0A0A0 ;
			border-radius:10px;
			height: 22px;
			width: 150px;" />  <font
								color="red"><span id="msg"></span></font>
							</td>
							<%-- <td align="left">Last Modified Date:</td>
							<td>
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
							<td align="left">Previous Line Manager:</td>
							<td>
								 <form:input path="previousLineManeger" id="previousLineManeger"  value="${userProfile.previousLineManeger}" style="border:1px solid #A0A0A0 ;
			border-radius:10px;
			height: 22px;
			width: 150px;"/>  <font
								color="red"><span id="msg"></span></font>
							</td>
							<td align="left">Previous Organisation:</td>
							<td>
								<form:input path="previousOrganisation" id="previousOrganisation"  value="${userProfile.previousOrganisation}" style="border:1px solid #A0A0A0 ;
			border-radius:10px;
			height: 22px;
			width: 150px;"/>  <font
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
							<td align="left">Signum-ID:</td>
							<td>
								  <form:input path="signunId" id="signunId"  value="${userProfile.signunId}" style="border:1px solid #A0A0A0 ;
			border-radius:10px;
			height: 22px;
			width: 150px;"/>  <font color="red"><span
									id="msg"></span></font>
							</td>
							<td align="left">Total Ericsson Experience In Months:</td>
							<td>
								 <form:input path="totalEricssonExperienceInMonths" id="totalEricssonExperienceInMonths"  value="${userProfile.totalEricssonExperienceInMonths}" style="border:1px solid #A0A0A0 ;
			border-radius:10px;
			height: 22px;
			width: 150px;" />  <font color="red"><span
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
							<td align="left">Total IT Experience:</td>
							<td>
								 <form:input path="totalITExperience" id="totalITExperience"  value="${userProfile.totalITExperience}" style="border:1px solid #A0A0A0 ;
			border-radius:10px;
			height: 22px;
			width: 150px;" />  <font
								color="red"><span id="msg"></span></font>
							</td>
							<td align="left">Total Years Of Experience:</td>
							<td>
								 <form:input path="totalYearsOfExperience" id="totalYearsOfExperience"  value="${userProfile.totalYearsOfExperience}" style="border:1px solid #A0A0A0 ;
			border-radius:10px;
			height: 22px;
			width: 150px;" />   <font
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
							<td align="left">Year Of IPM:</td>
							<td>
								 <form:input path="yearOfIPM" id="yearOfIPM"  value="${userProfile.yearOfIPM}"  style="border:1px solid #A0A0A0 ;
			border-radius:10px;
			height: 22px;
			width: 150px;"/>  <font color="red"><span
									id="msg"></span></font>
							</td>
							<td align="left">Year Of Last Promotion:</td>
							<td>
								 <form:input path="yearOfLastPromotion" id="yearOfLastPromotion"  value="${userProfile.yearOfLastPromotion}" style="border:1px solid #A0A0A0 ;
			border-radius:10px;
			height: 22px;
			width: 150px;"/>   <font
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

						<tr>
							<td>&nbsp; &nbsp;</td>
							<td><input type="submit" class="styled-button-5"
								value="submit" ></td>
							<td><input type="reset" class="styled-button-5"
								value="reset"></td>
							<td>&nbsp; &nbsp; &nbsp;</td> </tr>
					</table>
				</form:form>
			</div>
	</font>
</body>
</html>

