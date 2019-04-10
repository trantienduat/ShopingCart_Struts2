<%-- 
    Document   : insertMobile
    Created on : Nov 5, 2018, 8:27:39 PM
    Author     : trant
--%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert</title>
        <s:head/>
    </head>
    <body>
        <s:if test="%{#session.USER != null}">
            <h3 style="color: blue">
                Hi, <s:property value="%{#session.USER.userId}"/>(<s:a action="logout">LogOut</s:a>)
                </h3>
        </s:if>


        <h1>Insert New Device</h1>


        <s:if test="%{exception.message.contains('duplicate')}">
            <h3 style="color: red;font-style: italic">
                Item <s:property value="%{mobileId}"/> is already existed!!!
            </h3>
        </s:if>

        <s:if test="%{status != null}">
            <h3 style="color: green;font-style: italic">
                <s:property value="%{status}"/>
            </h3>
        </s:if>




        <table border="0">
            <tbody>
                <s:form action="insertMobile" theme="simple">
                    <tr>
                        <td>Mobile ID</td>
                        <td><s:textfield name="mobileId" theme="css_xhtml"/></td>
                    </tr>
                    <tr>
                        <td>Description</td>
                        <td><s:textfield name="description" theme="css_xhtml"/></td>
                    </tr>
                    <tr>
                        <td>Price</td>
                        <td><s:textfield name="price" theme="css_xhtml"/></td>
                    </tr>
                    <tr>
                        <td>Mobile Name</td>
                        <td><s:textfield name="mobileName" theme="css_xhtml"/></td>
                    </tr>
                    <tr>
                        <td>Year Of Production</td>
                        <td><select name="yearOfProduction">
                                <s:set value="%{1970}" name="years"/>
                                <s:iterator begin="1970" end="2018" step="1">
                                    <option value="<s:property value="%{#years}"/>"><s:property value="%{#years}"/></option>
                                    <s:set value="%{#years+1}" name="years"/>
                                </s:iterator>
                            </select></td>
                    </tr>
                    <tr>
                        <td>Quantity</td>
                        <td><s:textfield name="quantity" theme="css_xhtml"/></td>
                    </tr>
                    <tr>
                        <td>Sale</td>
                        <td><select name="isNotSale">
                                <option value="false">Not Sale</option>
                                <option value="true">Sale</option>
                            </select></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <s:submit value="Insert"/>
                        </td>
                    </tr>




                <br>
            </s:form>
            </tbody><br>
        </table>
        <s:a href="staffSearch.jsp"><<< Search Page <<<</s:a>

    </body>
</html>
