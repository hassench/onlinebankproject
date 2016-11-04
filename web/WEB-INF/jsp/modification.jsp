<%-- 
    Document   : modification
    Created on : 22 janv. 2014, 05:52:22
    Author     : Hassen
--%>

<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Global Banking ..</title>
        <link href="../style.css" rel="stylesheet" type="text/css">

    </head>

    <body>

        <div id="top_links">


            <div id="header">
                <h1>AGCH - BANK<span class="style1"></span></h1>
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
                    <td width="300" valign="top" style="border-right:#666666 1px dotted;">
                        <form:form commandName="commandModification">
                            <form:errors path="*" />
                            <table cellspacing="5" cellpadding="3">	

                                <tr><td>ID</td><td> <form:input path="id" name="id" readonly="true"/></td></tr>
                                <tr><td>Nom</td><td> <form:input path="nom" name="nom"/></td></tr>
                                <tr><td>Pernom</td><td> <form:input path="pernom" name="pernom"/></td></tr>
                                <tr><td>CIN</td><td> <form:input path="cin" name="cin" maxlength="8"/><form:errors path="pass" cssClass="error" /></td></tr>
                                <tr><td>Date Naissance</td><td> <form:input path="dateNaissance" type="date" name="dateNaissance" min="1900-01-01" maxlength="10"/><form:errors path="dateNaissance" cssClass="error" /></td></tr>
                                <!-- Gender:<br/><br/>
                                Male<input type="radio" name="gender" value="male"> Female<input type="radio" name="gender" value="female"/><br/><br/> -->
                                <tr><td>Adresse</td><td> <form:input path="adresse" name="adresse"/></td></tr>
                                <tr><td>Tel</td><td> <form:input path="telephone" name="telephone" maxlength="8"/><form:errors path="telephone" cssClass="error" /></td></tr>
                                <tr><td>Profession</td><td> <form:input path="profession" name="profession"/></td></tr>
                                <tr><td>Login</td><td> <form:input path="login" name="login" required="required"/><form:errors path="login" cssClass="error" /></td></tr>
                                <tr><td>Pass</td><td> <form:input path="pass" name="pass" required="required"/><form:errors path="pass" cssClass="error" /></td></tr>
                                <tr><td>Role</td><td> <form:input path="role" name="role" required="required"/><form:errors path="role" cssClass="error" /></td></tr>
                                <tr><td>Enabled</td><td> <form:input path="enabled" name="enabled" required="required"/><form:errors path="enabled" cssClass="error" /></td></tr>
                                <tr><td></td><td><input type="submit" value="Submit"/>

                                        <INPUT TYPE=RESET VALUE="CLEAR"></td></tr>
                            </table>
                        </form:form>
                    </td>

                </tr>
            </table>

            <div id="footer_top">
                <div id="footer_navigation">


                </div>

                <div id="footer_copyright" >

                    <center><img  alt="business"  width="196" height="106"></center><br>
                    <p>Each people plan their site layouts depending upon their business type. Here comes a free designer template which provides you with a selection of different kinds of webdesign   starting from business template, fashion template, media template, Science template, Arts template and much more.</p>

                    Copyright © Ghdiri Abdallah & Charef Hassen jsp</div>
            </div>

            <script type="text/javascript">
               
            </script>
        </div>

    </body>
</html>