<%-- 
    Document   : search
    Created on : Nov 4, 2018, 10:56:00 PM
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
                    Welcome, <s:property value="%{#session.USER.userId}"/>(<s:a action="logout">LogOut</s:a>)
                    </h3>
            </s:if>

            <h1>Staff Search</h1>

            <s:if test="%{status != null}">
                <h4 style="color: green;font-style: italic">
                    <s:property value="%{status}"/>
                </h4>
            </s:if>


            <s:form action="staffSearch" theme="simple">
                Search <s:textfield label="Search " name="searchValue"/>
                <select name="searchType">
                    <option value="mobileId" ${param.searchType=="mobileId" ? 'selected' : ''}>id</option>
                    <option value="mobileName"  ${param.searchType=="mobileName" ? 'selected' : ''}>name</option>
                </select>
                <s:submit value="Search"/>
            </s:form><br>



            <s:if test="%{#session.USER != null}">
                <s:a href="insertMobile.jsp">Insert New Device</s:a>
                    <div></div> <br>
            </s:if>



            <s:if test="%{searchValue.trim().length() > 0}">
                <s:if test="%{mobilesList!= null}">
                    <table border="1" style="border-collapse: collapse">
                        <thead>
                            <tr>
                                <th>No.</th>
                                <th>Mobile ID</th>
                                <th>Description</th>
                                <th>Price</th>
                                <th>Mobile Name</th>
                                <th>YearOfProduction</th>
                                <th>Quantity</th>
                                <th>Not Sale</th>
                                <th>Delete</th>
                                <th>Update</th>
                            </tr>
                        </thead>
                        <tbody>
                            <s:set name="mobileId" value="%{mobileId}"/>
                            <s:set name="description" value="%{description}"/>
                            <s:set name="price" value="%{price}"/>
                            <s:set name="quantity" value="%{quantity}"/>
                            <s:iterator var="dto" value="mobilesList" status="counter">
                                <s:form action="updateMobile" theme="simple">
                                    <tr>
                                        <td><s:property value="%{#counter.count}"/></td>
                                        <td><s:property value="%{#dto.mobileId}"/></td>
                                        <s:if test="%{mobileId.equals(#mobileId)}">
                                            <td>
                                                <s:textfield value="%{#description}" name="description" theme="css_xhtml"/>
                                            </td>
                                            <td><s:textfield value="%{#price}" name="price" theme="css_xhtml"/></td>
                                            <td><s:property value="%{#dto.mobileName}"/></td>
                                            <td><s:property value="%{#dto.yearOfProduction}"/></td>
                                            <td><s:textfield value="%{#quantity}" name="quantity" theme="css_xhtml"/></td>
                                        </s:if>
                                        <s:else>
                                            <td>
                                                <s:textfield value="%{description}" name="description"/>
                                            </td>
                                            <td><s:textfield value="%{#dto.price}" name="price"/></td>
                                            <td><s:property value="%{#dto.mobileName}"/></td>
                                            <td><s:property value="%{#dto.yearOfProduction}"/></td>
                                            <td><s:textfield value="%{#dto.quantity}" name="quantity"/></td>
                                        </s:else>
                                        <td><s:select list="saleList" value="%{#dto.isNotSale}" name="notSale"/></td>
                                        <td>
                                            <s:url action="deleteMobile" id="delLink">
                                                <s:param name="pk" value="mobileId" />
                                                <s:param name="searchType" value="searchType" />
                                                <s:param name="searchValue" value="searchValue" />
                                            </s:url>
                                            <s:a href="%{delLink}">Delete</s:a>
                                            </td>
                                            <td>
                                            <s:hidden value="%{#dto.mobileId}" name="mobileId"/>
                                            <s:hidden value="%{searchValue}" name="searchValue"/>
                                            <s:hidden value="%{searchType}" name="searchType"/>
                                            <s:submit value="Update"/>
                                        </td>
                                    </tr>
                                </s:form>
                            </s:iterator>
                        </tbody>
                    </table>

                </s:if>
                <s:if test="%{mobilesList== null}">
                    <h2 style="font-style: italic; color: red">No record is matched!!</h2>
                </s:if>
            </s:if>
    </body>
</html>
