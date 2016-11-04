<%-- 
    Document   : creation
    Created on : Jan 13, 2014, 11:40:11 PM
    Author     : abdallahghdiri
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
    <head>
        <SCRIPT LANGUAGE="JavaScript">
            function dil(form)
            {
                for (var i = 0; i < 3; i++)
                {
                    if (!isNaN(form.elements[i].value))
                    {
                        alert("This Field must be Char's");
                        form.elements[i].value = "";
                        form.elements[i].focus();
                        return false;
                    }
                }
                if (document.F1.password.value != document.F1.repassword.value)
                {
                    alert("Check Confirm PWD");
                    document.F1.repassword.value = "";
                    document.F1.repassword.focus();
                    return false;
                }


                if (!isNaN(document.F1.phone.value))
                {
                    if (document.F1.phone.value > 9999999999)
                    {
                        alert("ye kabhi nhi aayegi");
                        document.F1.phone.value = "";
                        document.F1.phone.focus();
                        return false;
                    }
                }
                else
                {
                    alert("This  field  must  be  number")
                    document.F1.phone.value = "";
                    return false;
                }




                if (!isNaN(document.F1.amount.value))
                {
                    if (document.F1.amount.value < 500)
                    {
                        alert("Minimum Balance should be 500 /-");
                        document.F1.amount.value = "";
                        document.F1.amount.focus();
                        return false;
                    }
                }
                else
                {
                    alert("This  field  must  be  number");
                    document.F1.amount.value = "";
                    return false;
                }



                for (var i = 0; i < form.elements.length; i++)
                {
                    if (form.elements[i].value == "")
                    {
                        alert("Fill out all Fields");
                        document.F1.username.focus();
                        return false;
                    }
                }



                return true;
            }
        </SCRIPT>

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
                        <form:form commandName="commandSearch">
                            <form:errors path="" />
                            <table cellspacing="5" cellpadding="3">	

                                <tr><td WIDTH="35%">Nom</td><td WIDTH="65%"> <form:input path="nom" name="nom"/></td></tr>
                                <tr><td>Pernom</td><td> <form:input path="pernom" name="pernom"/></td></tr>
                                <tr><td>CIN</td><td> <form:input path="cin" name="cin"/><form:errors path="cin" cssClass="error" maxlength="8"/></td></tr>
                                <tr><td>Date Naissance</td><td> <form:input path="dateNaissance" type="date" name="dateNaissance" min="1900-01-01" maxlength="10"/><form:errors path="dateNaissance" cssClass="error" /></td></tr>
                                <!-- Gender:<br/><br/>
                                Male<input type="radio" name="gender" value="male"> Female<input type="radio" name="gender" value="female"/><br/><br/> -->
                                <tr><td>Adresse</td><td> <form:input path="adresse" name="addresse" /></td></tr>
                                <tr><td>Tel</td><td> <form:input path="telephone" name="telephone" maxlength="8"/><form:errors path="telephone" cssClass="error" /></td></tr>
                                <tr><td>Profession</td><td> <form:input path="profession" name="profession"/></td></tr>
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

                    Copyright © Ghdiri Abdallah & Charef Hassen</div>
            </div>

            <script type="text/javascript">
                document.onload = ctck();
            </script>
        </div>

    </body>
</html>


