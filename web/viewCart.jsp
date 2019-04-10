<%-- 
    Document   : viewCart
    Created on : Nov 8, 2018, 5:00:38 PM
    Author     : trant
--%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <s:head/>
    </head>

    <body>
            <s:if test="%{#session.USER != null}">
                <h3 style="color: blue">
                    Hi, <s:property value="%{#session.USER.userId}"/>(<s:a action="logout">LogOut</s:a>)
                    </h3>
            </s:if>
            <font style="color: blue">

            </font>

            <s:if test="%{status != null}">
                <p style="color: red;font-style: italic">
                    ${status}
                </p>
            </s:if>


            <s:a href="userSearch.jsp">Back To Seach Page</s:a>
            <s:if test="%{#session.CART!= null and !#session.CART.items.isEmpty()}">
                <h1>Your Cart Information:</h1>
                <table border="1" style="border-collapse: collapse">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Mobile Name</th>
                            <th>Quantity</th>
                            <th>Price</th>
                            <th>Total</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <s:form action="removeFromCart" theme="simple">
                            <s:set name="totalCart" value="%{0}"/>
                            <s:iterator value="%{#session.CART.items}" status="counter">
                                <s:set name="totalCart" value="%{#totalCart + key.price * value}"/>
                                <tr>
                                    <td><s:property value="%{#counter.count}"/></td>
                                    <td><s:property value="%{key.mobileName}"/></td>
                                    <td><s:property value="%{value}"/></td>

                                    <td><s:text name="money">
                                            <s:param name="price" value="%{key.price}"/>
                                        </s:text></td>

                                    <td><s:text name="money">
                                            <s:param name="total" value="%{key.price * value}"/>
                                        </s:text></td>

                                    <td>
                                        <s:checkbox name="selectedItems" fieldValue="%{key.mobileId}"/>
                                    </td>
                                </tr>
                            </s:iterator>
                            <tr>
                                <td colspan="4">TOTAL</td>
                                <td><s:text name="money">
                                        <s:param name="totalCart" value="totalCart"/>
                                    </s:text></td>
                                <td><s:submit value="Remove"/></td>
                            </tr>
                        </s:form>
                    </tbody>
                </table>
                <s:form action="order">
                    <button style="padding: 5px 20px;">Order Now</button>
                </s:form>
            </s:if>
            <s:else>

                <h4 style="color: red;font-style: italic">
                    Your Cart is empty!
                </h4>
            </s:else>
    </body>
</html>
