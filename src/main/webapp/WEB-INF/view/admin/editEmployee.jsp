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
        <div id="personal">
        <span class="contlabel">Personal</span>
        <form class="row g-3 addPersonal mt10">
            <div class="col-md-4">
                <label for="gender" class="form-label">Gender<span class="red">*</span> </label>
                <select class="form-control" id="gender">
                    <option value="" disabled selected>Select Gender</option>
<%--                    <c:forEach var="group" items="${group}">--%>
<%--                        <option value=${department.departmentId}>${department.departmentName}</option>--%>
<%--                    </c:forEach>--%>
                </select>
            </div>
            <div class="col-md-4">
                <label for="marriageStatus" class="form-label">Marriage status</label>
                <select class="form-control" id="marriageStatus">
                    <option value="" disabled selected>-- Select Type --</option>
                    <%--                    <c:forEach var="group" items="${group}">--%>
                    <%--                        <option value=${department.departmentId}>${department.departmentName}</option>--%>
                    <%--                    </c:forEach>--%>
                </select>
            </div>
            <div class="col-md-4">
                <label for="dateOfBirth" class="form-label">Date of Birth<span class="red">*</span> </label>
                <input type="date" class="form-control" id="dateOfBirth">
            </div>
            <div class="col-md-4">
                <label for="dateOfMarriage" class="form-label">Date of Marrige</label>
                <input type="date" class="form-control" id="dateOfMarriage">
            </div>
            <div class="col-md-4">
                <label for="birthPlace" class="form-label">Birth Place</label>
                <input type="text" class="form-control bg-white" id="birthPlace">
            </div>
            <div class="col-md-4">
                <label for="communityCategory" class="form-label">Community Category</label>
                <select class="form-control" id="communityCategory">
                    <option value="" disabled selected>-- Select Type --</option>
                    <%--                    <c:forEach var="group" items="${group}">--%>
                    <%--                        <option value=${department.departmentId}>${department.departmentName}</option>--%>
                    <%--                    </c:forEach>--%>
                </select>
            </div>

            <div class="col-md-4">
                <label for="uidNumber" class="form-label">UID Number</label>
                <input type="text" class="form-control bg-white" id="uidNumber">
            </div>
            <div class="col-md-4">
                <label for="gpfAccountNumber" class="form-label">GPF A/C No.</label>
                <input type="text" class="form-control bg-white" id="gpfAccountNumber">
            </div>
            <div class="col-md-4">
                <label for="religion" class="form-label">Religion</label>
                <select class="form-control" id="religion">
                    <option value="" disabled selected>-- Select Type --</option>
                    <option value="Hinduism">Hinduism</option>
                    <option value="Islam">Islam</option>
                    <option value="Christianity">Christianity</option>
                    <option value="Sikhism">Sikhism</option>
                    <option value="Buddhism">Buddhism</option>
                    <option value="Jainism">Jainism</option>
                    <option value="Zoroastrianism">Zoroastrianism</option>
                    <option value="Other">Other</option>
                </select>
            </div>
            <div class="col-md-4">
                <label for="caste" class="form-label">Caste</label>
                <select class="form-control" id="caste">
                    <option value="" disabled selected>-- Select Type --</option>
                    <option value="Brahmin">Brahmin</option>
                    <option value="Kshatriya">Kshatriya</option>
                    <option value="Vaishya">Vaishya</option>
                    <option value="Shudra">Shudra</option>
                    <option value="Jat">Jat</option>
                    <option value="Scheduled Caste">Scheduled Caste</option>
                    <option value="Scheduled Tribe">Scheduled Tribe</option>
                    <option value="Other">Other</option>
                </select>
            </div>
            <div class="col-md-8">
                <label for="communityCategoryReference" class="form-label">Community Category Reference</label>
                <input type="text" class="form-control bg-white" id="communityCategoryReference">
            </div>
            <div class="col-md-4">
                <label for="nationality" class="form-label">Nationality</label>
                <select class="form-control" id="nationality">
                    <option value="" disabled selected>-- Select Type --</option>
                    <option value="Indian">Indian</option>
                    <option value="American">American</option>
                    <option value="British">British</option>
                    <option value="Chinese">Chinese</option>
                    <option value="Japanese">Japanese</option>
                    <option value="Russian">Russian</option>
                    <option value="Brazilian">Brazilian</option>
                    <option value="Australian">Australian</option>
                    <option value="South African">South African</option>
                    <option value="Canadian">Canadian</option>
                    <option value="Other">Other</option>
                </select>
            </div>


            <div class="col-md-4">
                <label for="insurancePolicyNumber" class="form-label">Post Insurance Policy Number</label>
                <input type="text" class="form-control bg-white" id="insurancePolicyNumber">
            </div>
            <div class="col-md-4">
                <label for="hobbies" class="form-label">Hobbies</label>
                <input type="text" class="form-control bg-white" id="hobbies">
            </div>
            <hr>

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
                <label for="group" class="form-label">Group<span class="red">*</span> </label>
                <select class="form-control" id="group">
                    <option value="" disabled selected>Select a group</option>
                    <c:forEach var="group" items="${groups}">
                        <option value=${group.groupId}>${group.groupName}</option>
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
                    if (id === 'department' || id === 'designation' || id === 'group') {
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