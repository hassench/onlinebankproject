<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%-- 
    Document   : creation
    Created on : Jan 13, 2014, 11:40:11 PM
    Author     : abdallahghdiri
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
            function testHassen() {
                var a = 2;
            }
        </script>

    </head>

    <body>

        <div id="top_links">


            <div id="header">
                <h1>APANA - BANK<span class="style1"></span></h1>
                <h2>ExtraOrdinary Service</h2>
                <A href="../index.html"><IMG SRC="../images/home1.gif"></A>	
            </div>

            <div id="navigation">
                <ul>
                    <li><a href="../admin/createuser.html">NEW USER</a></li>
                    <li><a href="../admin/search.html">Search</a></li>
                    <li><a href="../logout">LOG OUT "<sec:authentication property="principal.username" />"</a></li>
                </ul>
            </div>



            <table style="background:#FFFFFF; margin:0 auto;">
                <tr >


                    <td width="1200" valign="top">
                        <div id="welcome" style="width: 550;border-right:#666666 1px dotted;"><h1>NEW USER FORM</h1><br>
                            <table  align="center" bgcolor="white">
                                <tr>

                                </tr>
                                <tr>
                                    <td>
                                        <form:form commandName="commandAddUser">
                                            <form:errors path="" />
                                            <table cellspacing="5" cellpadding="3">	

                                                <tr><td>FIRST NAME:</td><td> <form:input path="nom" name="nom" placeholder="your FIRST name is.."/></td></tr>
                                                <tr><td>LAST NAME:</td><td> <form:input path="pernom" name="pernom" placeholder="your LAST NAME is.."/></td></tr>
                                                <tr><td>CIN:</td><td> <form:input path="cin" name="cin" maxlength="8"/><form:errors path="cin" cssClass="error"  /></td></tr>
                                                <tr><td>DATE OF BIRTH:</td><td> <form:input path="dateNaissance" name="dateNaissance" type="date" placeholder="yyyy-mm-dd" maxlength="10"/><form:errors path="dateNaissance" cssClass="error" /></td></tr>
                                                <tr><td>ADDRESS:</td><td> <form:input path="adresse" name="adresse"/></td></tr>
                                                <tr><td>PROFESSION:</td><td> <form:input path="profession" name="profession"/></td></tr>
                                                <tr><td>PHONE:</td><td> <form:input path="telephone" name="telephone" maxlength="8"/><form:errors path="telephone" cssClass="error" /></td></tr>
                                                <tr><td>LOGIN:</td><td> <form:input path="login" name="login" required="required"/><form:errors path="login" cssClass="error" /></td></tr>
                                                <tr><td>PASSWORD:</td><td> <form:input path="pass"  type="password" name="pass" required="required"/><form:errors path="pass" cssClass="error" /></td></tr>
                                                <tr><td>ROLE:</td><td> <form:input path="role" name="role" placeholder="ADMIN/USER" required="required"/><form:errors path="role" cssClass="error" /></td></tr>
                                                <tr><td></td><td><input type="submit" value="Submit"/>

                                                        <INPUT TYPE=RESET VALUE="CLEAR"></td></tr>
                                            </table>
                                        </form:form>
                                    </td>
                                </tr>

                            </table>
                        </div>      
                    </td>

                    <td width="299" valign="top">
                        <div id="welcome" style="border-right:#666666 1px dotted;"><h1>Welcome</h1><br>
                            <center><img src="../images/globe_10.gif" alt="business" width="196" height="106"></center><br>
                            <p>Each people plan their site layouts depending upon their business type. Here comes a free designer template which provides you with a selection of different kinds of webdesign   starting from business template, fashion template, media template, Science template, Arts template and much more.</p>

                        </div>      
                    </td>


                </tr></table>

            <div id="footer_top">
                <div id="footer_navigation">


                </div>

                <div id="footer_copyright" >

                    <center><img  alt="business"  width="196" height="106"></center><br>
                    <p>Each people plan their site layouts depending upon their business type. Here comes a free designer template which provides you with a selection of different kinds of webdesign   starting from business template, fashion template, media template, Science template, Arts template and much more.</p>

                    Copyright © Ghdiri Abdallah & Charef Hassen</div>
            </div>

            <script type="text/javascript">
                document.onload = ctck();
            </script>
        </div>

    </body>
</html>


