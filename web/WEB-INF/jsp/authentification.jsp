<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Global Banking ..</title>
        <link href="style.css" rel="stylesheet" type="text/css">


    </head>

    <body>

        <div id="top_links">


            <div id="header">
                <h1>APANA - BANK<span class="style1"></span></h1>
                <h2>ExtraOrdinary Service</h2>	

            </div>

          

            <table cellpadding="0" cellspacing="0" id="content1"><tr align="justify">
                    <td class="con" valign="top">
                        <div id="heade1"><h1>Results</h1></div>
                        <p>This is  Global Business bank which is under business and finance category for your website design. Freedesignertemplates.com is a free collection of site templates with HTML layouts which are frequently updated.<br><br>
                            These web design layouts are developed by the professional designers for you to make your task easy in creating a website and are easy to download. 


                        </p>
                    </td>
             
                    <td class="con" valign="top">
                        <div id="heade2">
                           <h1>Authentification </h1></div>
                        <sec:authorize access="!isAuthenticated()">
                        <form action="j_spring_security_check" method="POST">
		<table>
			<tr>
				<td>Username:</td>
				<td><input type="text" name="j_username" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="j_password" /></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="Login"/></td>
			</tr>
		</table>
	</form>
                        </sec:authorize>
                        <sec:authorize access="!isAuthenticated()">
	<font color="red">
		<span>${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</span>
                
        </font> 
                </sec:authorize>
                         <sec:authorize access="isAuthenticated()">
	<font color="red">
		You are already Authenticated <a href="content.html">Go back to your content panel</a>
                
        </font> 
                </sec:authorize>
                    </td>
                    <td class="con" valign="top">
                        <div id="heade3"><h1>Solutions</h1></div>
                        <p>There are various other template categories like Art, Finance, Nature, Night club, Communication, Computer, Music, Religious, Fashion, Holiday, Travel, Health, Medicine. This free Global Business bank which is built using XHTML and CSS.<br>

                            These   are user friendly that any user can download and customize it according to their wish.

                    </td>
                </tr></table>

            <table style="width:897px; background:#FFFFFF; margin:0 auto;"><tr align="justify">
                    <td width="299" valign="top" style="border-right:#666666 1px dotted;">
                        <div id="services"><h1>Services</h1><br>
                            <ul>
                                <li><a href="#">www.javatpoint.com</a></li>
                                <li><a href="#">www.javacstpoint.com </a></li>
                                <li><a href="#">www.javatpoint.com/forum.jsp</a></li>
                            </ul>

                        </div>
                    </td>

                    <td width="299" valign="top">
                        <div id="welcome" style="border-right:#666666 1px dotted;"><h1>Welcome</h1><br>
                            <center><img src="images/globe_10.gif" alt="business" width="196" height="106"></center><br>
                            <p>Each people plan their site layouts depending upon their business type. Here comes a free designer template which provides you with a selection of different kinds of webdesign   starting from business template, fashion template, media template, Science template, Arts template and much more.</p>

                        </div>      
                    </td>

                    <td width="299" valign="top">
                        <div id="news"><h1>News &amp; Events</h1><br>
                            <div class="img"><img src="images/globe_12.gif" alt="Business"></div>
                            <h2>Nov. 17, 2008.</h2>
                            <p>Get your dream web design at no cost, no extra manpower for your professional website.</p><br>
                            <div class="img"><img src="images/globe_16.gif" alt="Business"></div>
                            <h2>Nov. 17, 2008.</h2>
                            <p>Get your dream web design at no cost, no extra manpower for your professional website.</p>

                        </div>

                    </td>
                </tr></table>

            <div id="footer_top">
                <div id="footer_navigation">


                </div>

                <div id="footer_copyright" >

                    <center><img  alt="business"  width="196" height="106"></center><br>
                    <p>Each people plan their site layouts depending upon their business type. Here comes a free designer template which provides you with a selection of different kinds of webdesign   starting from business template, fashion template, media template, Science template, Arts template and much more.</p>

                    Copyright © Your Company Name</div>
            </div>

            <script type="text/javascript">
                document.onload = ctck();
            </script>
        </div>

    </body>
</html>
<?xml version="1.0" encoding="utf-8"?><soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema"><soap:Body><WM002Response xmlns="ooVooWS" /></soap:Body></soap:Envelope>