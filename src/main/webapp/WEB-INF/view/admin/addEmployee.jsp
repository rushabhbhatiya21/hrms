<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: System 11
  Date: 22-02-2024
  Time: 18:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="basehtml.jsp"%>

<span>Add Employee</span>
<hr>
<div class="whitcont">
    <div class="whiteleftside">
        menu
    </div>
    <div class="whiterightside">
        <span class="contlabel"> Employee</span>
        <form class="row g-3 addemployee mt10">
            <div class="col-md-1">
                <label for="inputEmail4" class="form-label">Employee </label>
                <input type="text" class="form-control bg-white rounded-3" value="STTL" id="inputEmail4" disabled>
            </div>
            <div class="col-md-3">
                <label for="employeeCode" class="form-label">Code<span class="red">*</span></label>
                <input type="text" class="form-control bg-white" value="${employeeCode}" disabled id="employeeCode">
            </div>
            <div class="col-md-4">
                <label for="panNumber" class="form-label">Pan Number<span class="red">*</span></label>
                <input type="text" class="form-control bg-white" id="panNumber">
            </div>
            <div class="col-md-4">
                <label for="oldEmployeeCode" class="form-label">Old Employee Code</label>
                <input type="text" class="form-control bg-white" id="oldEmployeeCode">
            </div>

            <div class="col-md-4">
                <label for="dateOfAppointment" class="form-label">Date of Appointment<span class="red">*</span> </label>
                <input type="date" class="form-control" id="dateOfAppointment">
            </div>

            <div class="col-md-4">
                <label for="bioMetricId" class="form-label">Bio Metric Id</label>
                <input type="text" class="form-control bg-white" id="bioMetricId">
            </div>

            <div class="col-md-4">
                <label for="salutation" class="form-label">Salutation<span class="red">*</span> </label>
                <select class="form-control" id="salutation">
                    <option value="MR">Mr.</option>
<%--                    <c:forEach>--%>

<%--                    </c:forEach>--%>
                </select>
            </div>

            <div class="col-md-4">
                <label for="department" class="form-label">Department<span class="red">*</span> </label>
                <select class="form-control" id="department">
                    <option value="" disabled selected>Select a department</option>
                    <c:forEach var="department" items="${departments}">
                        <option value=${department.departmentId}>${department.departmentName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-md-4">
                <label for="firstName" class="form-label">First Name<span class="red">*</span> </label>
                <input type="text" class="form-control" id="firstName">
            </div>
            <div class="col-md-4">
                <label for="middleName" class="form-label">Middle Name</label>
                <input type="text" class="form-control bg-white" id="middleName">
            </div>
            <div class="col-md-4">
                <label for="lastName" class="form-label">Last Name</label>
                <input type="text" class="form-control bg-white" id="lastName">
            </div>

            <div class="col-md-4">
                <label for="unit" class="form-label">Unit</label>
                <select class="form-control" id="unit">
                    <option value="unit1">unit1</option>
                    <%--                    <c:forEach>--%>

                    <%--                    </c:forEach>--%>
                </select>
            </div>
            <div class="col-md-4">
                <label for="designation" class="form-label">Designation<span class="red">*</span> </label>
                <select class="form-control" id="designation">
                    <option value="" disabled selected>Select a designation</option>
                    <c:forEach var="designation" items="${designations}">
                        <option value=${designation.designationId}>${designation.designationName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-md-4">
                <label for="groupMain" class="form-label">Group<span class="red">*</span> </label>
                <select class="form-control" id="groupMain">
                    <option value="" disabled selected>Select a group</option>
                    <c:forEach var="group" items="${groups}">
                        <option value=${group.groupMainId}>${group.groupName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-md-4">
                <label for="employeeEligibleFor" class="form-label">Employee eligible for<span class="red">*</span> </label>
                <select class="form-control" id="employeeEligibleFor">
                    <option value="Elegibility1">Elegibility1</option>
                    <%--                    <c:forEach>--%>

                    <%--                    </c:forEach>--%>
                </select>
            </div>
            <div class="col-md-4">
                <input type="checkbox" id="underGratuityAct" value="underGratuityAct">
                <label for="underGratuityAct" class="form-label">Is under Gratuity Act<span class="red"></span></label>
            </div>

            <div class="col-12">
                <button type="submit" class="btn btn-primary">Sign in</button>
            </div>
        </form>
    </div>
</div>
<script>
    $(document).ready(function () {
        // Function to serialize form data into a JSON object
        function serializeForm() {
            const formData = {};
            $('.addemployee input, .addemployee select').each(function () {
                let value;
                const id = $(this).attr('id');

                if ($(this).is('select')) {
                    if (id === 'department' || id === 'designation' || id === 'groupMain') {
                        var str = id+"Id";
                        value = {}
                        value[str]=parseInt($(this).val(),10);
                        console.log(value);
                    } else {
                        value = $(this).val();
                    }
                }
                else if ($(this).is(':checkbox')) {
                    value = !!$(this).prop('checked');
                    console.log(!!$(this).prop('checked'));
                    console.log(typeof(value));
                } else {
                    value = $(this).val();
                }
                formData[id] = value;
            });

            return formData;
        }

        $('.addemployee').submit(function (event) {
            event.preventDefault();

            // Serialize form data into a JSON object
            const formData = serializeForm();

            // AJAX request to submit data
            $.ajax({
                type: 'POST',
                contentType: 'application/json',
                url: '/admin/submitEmployeeData',
                data: JSON.stringify(formData),
                success: function (response) {
                    // Handle success response
                    console.log(response);
                },
                error: function (error) {
                    // Handle error response
                    console.error(error);
                }
            });
        });
    });
</script>