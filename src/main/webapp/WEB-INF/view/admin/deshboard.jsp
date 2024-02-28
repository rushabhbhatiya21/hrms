<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: System 11
  Date: 28-02-2024
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="basehtml.jsp"%>

<div class="addEmployeeButton">
    <a class="btn btn-warning" href="/admin/addEmployee">Add Employee</a>
</div>

<table id="familytable" class="table table-bordered table-striped">
    <thead class="thead-dark">
    <tr>
        <th>First Name</th>
        <th>Department</th>
        <th>action</th>
    </tr>
    </thead>
    <tbody id="familyTableBody">
    <c:forEach var="emp" items="${employees}" varStatus="loop">
        <tr>
            <td>${emp.firstName}</td>
            <td>${emp.department.departmentName}</td>
            <td> <a class="btn btn-danger" href="/admin/editEmployee/${emp.employeeId}">Edit</a> </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
