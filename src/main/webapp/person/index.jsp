
<%@ page import="java.util.List" %>
<%@ page import="com.javatpoint.entity.Person" %><%--
  Created by IntelliJ IDEA.
  User: amirs
  Date: 2/7/2020
  Time: 8:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Person CRUD</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/assets/bootstrap.min.css">
    <script src="/assets/jquery.min.js"></script>
    <script src="/assets/bootstrap.min.js"></script>
</head>
<body>
<%
    request.setAttribute("person","active");
%>
<jsp:include page="/header.jsp"/>
<div class="container">
    <div class="panel panel-primary">
        <div class="panel-heading">PersonCrud</div>
        <div class="panel-body">


    <form action="/person/save.do" method="post">
        <div class="form-group">
            <label for="firstName">First Name</label>
            <input type="text " class="form-control" name="firstName" id="firstName"/>
        </div>
        <div class="form-group">
            <label for="lastName">Last Name</label>
            <input type="text" class="form-control" name="lastName" id="lastName"/>
        </div>
        <div class="form-group">
            <label for="nationalCode">National Code</label>
            <input type="text" class="form-control" name="nationalCode" id="nationalCode"/>
        </div>
        <input type="submit" class="btn btn-default" value="SAVE"/>
    </form>
    <table class="table table-hover">
        <thead>
        <tr>
            <td>National Code</td>
            <td>First Name</td>
            <td>Last Name</td>
            <td>ACTION</td>
            <td>ACTION</td>
        </tr>
        </thead>
        <tbody>
        <%
            List<Person> personList = (List<Person>) request.getAttribute("list");
            for (Person person : personList) {
        %>
        <tr>
            <form action="/person/update.do" method="post">
                <td><input type="text" class="form-control"  name="nationalCode" value="<%=person.getNationalCode()%>" readonly/>
                </td>
                <td><input type="text" class="form-control"  name="firstName" value="<%=person.getFirstName()%>"/>
                </td>
                <td><input type="text" class="form-control"  name="lastName" value="<%=person.getLastName()%>"/>
                </td>
                <td><input type="submit" class="btn btn-info" value="UPDATE"/></td>
            </form>
            <td><input type="button" value="DELETE" class="btn btn-danger" onclick="deletePerson(<%=person.getNationalCode()%>)"></td>
        </tr>

        <%
            }
        %>
        </tbody>
    </table>
    <script>
        function deletePerson(nationalCode) {
            window.location = "/person/delete.do?nationalCode=" + nationalCode;
        }
    </script>
        </div>
    </div>
</div>
</body>
</html>
