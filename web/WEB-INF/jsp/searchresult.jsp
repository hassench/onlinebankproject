<%-- 
    Document   : creation
    Created on : Jan 13, 2014, 11:40:11 PM
    Author     : abdallahghdiri
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Global Banking ..</title>
        <link href="../style.css" rel="stylesheet" type="text/css">
        <script src="../jquery.com_jquery-1.10.1.min.js"></script>
        <script src="../jquery-migrate-1.2.1.min.js"></script>
    <SCRIPT LANGUAGE="JavaScript">
        function send(ident)
        {
            var url = '../admin/modification.html';
            var form = $('<form action="' + url + '" method="post">' +
              '<input type="text" name="id" value="' + ident + '" />' +
              '</form>');
            $('body').append(form);
            $(form).submit();
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
                        <td>Nom </td>
                        <td>Prénom </td>
                        <td>CIN </td>
                        <td>Date de Naissance </td>
                        <td>Adresse </td>
                        <td>profession </td>
                        <td>Telephone </td>
                        <td>Login </td>
                        <td>Pass </td>
                        <td>Role </td>
                        <td>Enabled </td>
                    </tr>

                <c:forEach var="u" items="${utilisateurs}">
                    <tr onclick="send(${u.id})">
                        <td hidden="true">${u.id}</td>
                        <td>${u.nom} </td>
                        <td>${u.pernom} </td>
                        <td>${u.cin} </td>
                        <td>${u.dateNaissance} </td>
                        <td>${u.adresse} </td>
                        <td>${u.profession} </td>
                        <td><fmt:formatNumber type="number" maxFractionDigits="0" value="${u.telephone}" /></td>
                        <td>${u.login} </td>
                        <td>${u.pass} </td>
                        <td>${u.role} </td>
                        <td>${u.enabled} </td>
                    </tr>
                </c:forEach>


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


