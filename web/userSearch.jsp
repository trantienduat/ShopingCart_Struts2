<%-- 
    Document   : userSearch
    Created on : Nov 5, 2018, 10:30:17 AM
    Author     : trant
--%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
        <s:head/>
    </head>
    <body>
            <s:if test="%{#session.USER != null}">
                <h3 style="color: blue">
                    Welcome, <s:property value="%{#session.USER.fullName}"/>(<s:a action="logout">LogOut</s:a>)
                    </h3>
            </s:if>
            <h1>User Search</h1>

            <!--Display NumberFormatException-->

            <%--<s:if test="%{exception.message.contains('Price')}">--%>
            <!--<h4 style="color: green;font-style: italic">-->
            <%--<s:property value="%{exception.message}"/>--%>
            <!--</h4>-->
            <%--</s:if>--%>

            <%--<s:if test="%{!exception.message.contains('Price')}">--%>
            <%--<s:set name="minPriceChecked" value="%{minPrice}"/>--%>
            <%--<s:set name="maxPriceChecked" value="%{maxPrice}"/>--%>
            <%--</s:if>--%>

            <s:form action="userSearch">            
                <s:textfield name="minPrice" placeholder="min price..." label="Min"/>
                <s:textfield name="maxPrice" placeholder="max price..." label="Max"/>
                <s:submit value="Search"/>
            </s:form>


            <!--Display Result-->
            <s:if test="%{minPrice!=null and maxPrice!=null and minPrice > 0 and maxPrice > 0}">
                <s:if test="%{mobilesList != null}">
                    <table border="1" style="border-collapse: collapse">
                        <thead>
                            <tr>
                                <th>No.</th>
                                <th>Mobile Name</th>
                                <th>Description</th>
                                <th>Price</th>
                                <th>Year Of Production</th>
                                <th>Sale</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <s:iterator value="mobilesList" status="counter">
                                <s:form action="addToCart" theme="simple">
                                    <s:if test="%{quantity>0}">

                                        <tr>
                                            <td><s:property value="%{#counter.count}"/></td>
                                            <td><s:property value="mobileName"/></td>
                                            <td><s:property value="description"/></td>
                                            <td><s:text name="money">
                                                    <s:param name="price" value="price"/>
                                                </s:text></td>
                                            <td><s:property value="yearOfProduction"/></td>
                                            <td><s:if test="isNotSale">Not Sale</s:if>
                                                <s:else><font color="red">Sale</font></s:else></td>
                                            <td><s:submit value="Add To Cart"/>
                                                <s:hidden name="mobileId" value="%{mobileId}"/>
                                                <s:hidden name="minPrice" value="%{minPrice}"/>
                                                <s:hidden name="maxPrice" value="%{maxPrice}"/>
                                            </td>
                                        </tr>
                                    </s:if>
                                </s:form>
                            </s:iterator>
                        </tbody>
                    </table>
                </s:if>
                <s:else>
                    <h2 style="color: red; font-style: italic">
                        No record is matched!
                    </h2>
                </s:else>
            </s:if>
            <s:a href="viewCart">View Your Cart</s:a>
    </body>
</html>
