<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Global Banking ..</title>
<link href="../style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
function ctck()
{
var sds = document.getElementById("dum");

}
</script>

</head>

<body>

<div id="top_links">
  

<div id="header">
	<h1>APANA - BANK<span class="style1"></span></h1>
    <h2>ExtraOrdinary Service</h2>
    <A href="../index.html"><IMG SRC="../images/home1.gif"></IMG></A>	
</div>

<div id="navigation">
    <ul>
    <li><a href="../admin/createuser.html">NEW USER</a></li>
    <li><a href="../admin/search.html">Search</a></li>
    <li><a href="../logout">LOG OUT "<sec:authentication property="principal.username" />"</a></li>
    </ul>
</div>



<table style="width:897px; background:#FFFFFF; margin:0 auto;">
<tr >
    
    <td width="1200" valign="top">
   
<table>
    <table align='left'  cellspacing='5' cellpadding='5'>
        <tr><th>ID</th><th>FIRST NAME</th><th>LAST NAME</th><th>CIN</th><th>DATE OF BIRTH</th><th>ADRESS</th><th>PROFESSION</th><th>TELEPHONE</th><th>LOGIN</th><th>PASS</th><th>ROLE</th></tr>
			
				<td>${user.id}</td>
                                <td>${user.nom}</td>
                                <td>${user.pernom}</td>
                                <td>${user.cin}</td>
                                <td>${user.dateNaissance}</td>
                                <td>${user.adresse}</td>
                                <td>${user.profession}</td>
                                <td>${user.telephone}</td>
                                <td>${user.login}</td>
                                <td>${user.pass}</td>
                                <td>${user.role}</td>
                              
				
			
				</tr>
			    
			</table>

    	
 