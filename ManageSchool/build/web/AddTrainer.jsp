<%-- 
    Document   : AddTrainer
    Created on : 15-Oct-2020, 23:40:41
    Author     : kienv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action="ControllerTrainer?ac=add">
            TrainerID: <input type="text" name="txtID" size="20"/><br/>
            Pass: <input type="password" name="txtPass" size="20"/><br/>
            Mail:  <input type="text" name="txtMail" size="20"/><br/>
            Address:  <input type="text" name="txtAddress" size="20"/><br/>
            Birthday:  <input type="text" name="txtBirthday" size="20"/><br/>  
            Profile:  <input type="text" name="txtProfile" size="20"/><br/>  
            Topic:<br/> 
            <jsp:useBean id="mrBean" class="model.TrainerTopic" scope="session"/>
            <c:forEach var="t" items="${mrBean.topics}">
                <input type="checkbox" name="cbTopic" value="${t.id}"> ${t.name}<br/>
                
            </c:forEach>
            <input type="submit"value="Add"/>
        </form>
    </body>
</html>
