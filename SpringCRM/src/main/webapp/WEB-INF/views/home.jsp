<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Customer Relationship Management</title>
</head>
<body>
    <h1>CRM - Customer Relationship Management</h1>
    <form action="addCustomer">
        <button type="submit">Add Customer!</button>
    </form>
    <br><br>
    <table border="1" cellpadding="5px">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="singleCustomer" items="${customer}">
                <tr>
                    <c:url var = "updateLink" value="/showFormForUpdate">
                        <c:param name="customerId" value="${singleCustomer.c_id}"/>
                    </c:url>

                    <c:url var = "deleteLink" value="/deleteCustomer">
                        <c:param name="customerIdDelete" value="${singleCustomer.c_id}"/>
                    </c:url>

                    <td>${singleCustomer.c_id}</td>
                    <td>${singleCustomer.name}</td>
                    <td>${singleCustomer.email}</td>
                    <td><a href="${updateLink}">Update</a>|<a href="${deleteLink}">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>