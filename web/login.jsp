<%-- 
    Document   : login
    Created on : Nov 4, 2018, 10:36:15 PM
    Author     : trant
--%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login Page</h1>
        <s:if test="%{exception.message.contains('string') and password.trim().length() > 0}">
            <font style="font-style: italic; color: red">
            Password is required with digits
            </font>
        </s:if>
        <%--<s:form action="login">--%>
            <%--<s:textfield name="username" label="Username"/>--%>
            <%--<s:password name="password" label="Password"/>--%>
            <%--<s:submit value="Login"/>--%>
        <%--</s:form>--%>
        <form action="login" method="POST">
            <table>
                <tbody>
                    <tr>
                        <td>Username</td>
                        <td><input type="text" name="username" value="" /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password" value="" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Login" /></td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
