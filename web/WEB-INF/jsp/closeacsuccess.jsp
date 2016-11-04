0<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
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
    <li><a href="../user/createaccount.html">NEW ACCOUNT</a></li>
    <li><a href="../user/balance.html">BALANCE</a></li>
    <li><a href="../user/deposit.html">DEPOSIT</a></li>
    <li><a href="../user/withdraw.html">WITHDRAW</a></li>
    <li><a href="../user/transfer.html">TRANSFER</a></li>
    <li><a href="../user/closeac.html">CLOSE A/C</a></li>
    <li><a href="../logout">LOG OUT "<sec:authentication property="principal.username" />"</a></li>
    </ul>
</div>



<table style="width:897px; background:#FFFFFF; margin:0 auto;">
<tr >
	<td width="300" valign="top" style="border-right:#666666 1px dotted;">
    	<div id="services"><h1>Services</h1><br>
		    <ul>
        	<li><a href="#">www.javatpoint.com</a></li>
            <li><a href="#">www.javacstpoint.com </a></li>
            <li><a href="#">www.javatpoint.com/forum.jsp</a></li>
            </ul>
			
       </div>
	</td>
    
    <td width="1200" valign="top">
    	
    
<table border="2" align="center" width="60%"  bgcolor="white">
		<tr>
			<td align="center" valign="middle" bgcolor="red"><h4>Account Removed</h4></td>
		</tr>
		<tr>
			<td>
			 <sec:authentication property="principal.username" /> you have desactivate your accounts.
                         You have left ${somme} in all of your accounts. please contact us to receive this amount.
			</td>
		</tr>
	


    		</table><%
%>
    	
    	
		 </table>


 




	
</html>