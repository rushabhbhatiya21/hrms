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
                    <c:forEach var="gender" items="${gender}">
                        <option value=${gender.name()}>${gender.name()}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-md-4">
                <label for="marriageStatus" class="form-label">Marriage status</label>
                <select class="form-control" id="marriageStatus">
                    <option value="" disabled selected>-- Select Type --</option>
                    <c:forEach var="ms" items="${marriageStatus}">
                        <option value=${ms.name()}>${ms.name()}</option>
                    </c:forEach>
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
                    <c:forEach var="cc" items="${communityCategory}">
                        <option value=${cc.name()}>${cc.name()}</option>
                    </c:forEach>
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
                <label for="bankDetail" class="form-label">Bank Name</label>
                <select class="form-control" id="bankDetail">
                    <option value="" disabled selected>-- Select Type --</option>
                    <c:forEach var="bank" items="${banks}">
                        <option value=${bank.bankId}>${bank.bankName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-md-4">
                <label for="bankBranch" class="form-label">Branch Name</label>
                <select class="form-control" id="bankBranch">
                    <option value="" disabled selected>-- Select Type --</option>
                    <c:forEach var="bankBranch" items="${bankBranches}">
                        <option  class="opts ${bankBranch.bank.bankId}" data="${bankBranch.ifscCode}" value=${bankBranch.bankBranchId}>${bankBranch.bankBranchName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-md-4">
                <label for="bankAccountNumber" class="form-label">Bank A/C No.<span class="red">*</span></label>
                <input type="text" class="form-control bg-white" id="bankAccountNumber">
            </div>
            <div class="col-md-4">
                <label for="ifscCode" class="form-label">IFSC Code<span class="red">*</span></label>
                <input type="text" class="form-control bg-white" disabled id="ifscCode">
            </div>
            <div class="col-md-4">
                <label for="bsrCode" class="form-label">BSR Code</label>
                <input type="text" class="form-control bg-white" id="bsrCode">
            </div>





            <hr>
            <div class="col-md-4">
                <label for="passportNumber" class="form-label">Passport No.</label>
                <input type="text" class="form-control bg-white" id="passportNumber">
            </div>
            <div class="col-md-4">
                <label for="passportDateOfExpiry" class="form-label">Date of Expiry </label>
                <input type="date" class="form-control" id="passportDateOfExpiry">
            </div>
            <div class="col-md-4">
                <label for="visaDetails" class="form-label">Visa Details</label>
                <input type="text" class="form-control bg-white" id="visaDetails">
            </div>
            <div class="col-md-4">
                <label for="drivingLicenceNumber" class="form-label">Driving licence No.</label>
                <input type="text" class="form-control bg-white" id="drivingLicenceNumber">
            </div>
            <div class="col-md-4">
                <label for="vehicleType" class="form-label">Driving Vehicle Type<span class="red">*</span> </label>
                <select class="form-control" id="vehicleType">
                    <option value="" disabled selected>-- Select Type --</option>
                    <c:forEach var="vehicle" items="${vehicleType}">
                        <option value=${vehicle.name()}>${vehicle.name()}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-md-4">
                <label for="drivingLicenceValidUpto" class="form-label">Valid upto</label>
                <input type="date" class="form-control" id="drivingLicenceValidUpto">
            </div>
            <div class="col-md-4">
                <label for="issuedState" class="form-label">Issued State/UT</label>
                <input type="text" class="form-control" id="issuedState">
            </div>
            <div class="col-md-8">
                <label for="additionalInfo" class="form-label">Additional Info</label>
                <input type="text" class="form-control" id="additionalInfo">
            </div>
            <div class="col-md-4">
                <input type="checkbox" id="govVehicleProvided" value="govVehicleProvided">
                <label for="govVehicleProvided" class="form-label">Government vehicle Provided?</label>
            </div>

            <div class="col-md-4">
                <input type="checkbox" id="residentOfCountry" value="residentOfCountry">
                <label for="residentOfCountry" class="form-label">is Resident of other Country?</label>
            </div>
            <div class="col-md-4">
                <input type="checkbox" id="isAnyProceedings" value="residentOfCountry">
                <label for="isAnyProceedings" class="form-label">Is Any Disciplinary Proceeding?</label>
            </div>



            <div class="col-md-4 gvp">
                <input type="checkbox" id="govVehicleUsedOnDuty" value="govVehicleUsedOnDuty">
                <label for="govVehicleUsedOnDuty" class="form-label">Government vehicle Used On Duty?</label>
            </div>
            <div class="col-md-8 gvp"></div>

            <div class="col-md-4 iroc">
                <label for="migrationDate" class="form-label">Migration Date</label>
                <input type="date" class="form-control" id="migrationDate">
            </div>
            <div class="col-md-4 iroc">
                <label for="country" class="form-label">Country</label>
                <input type="text" class="form-control" id="country">
            </div>
            <div class="col-md-4 iroc">
                <label for="countryAddress" class="form-label">Other Country Address</label>
                <input type="text" class="form-control" id="countryAddress">
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
            $('.addPersonal input, .addPersonal select').each(function () {
                let value;
                const id = $(this).attr('id');

                if ($(this).is('select')) {
                    if (id === 'bankDetail' || id === 'bankBranch' || id === 'ifscCode' ) {
                        return;
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

        $('.addPersonal').submit(function (event) {
            event.preventDefault();

            const formData = serializeForm();

            formData["bankDetail"] = {"bankBranchId":parseInt($('#bankBranch').val()),}

            console.log(formData);

            $.ajax({
                type: 'POST',
                contentType: 'application/json',
                url: '/admin/submitPersonal',
                data: JSON.stringify(formData),
                success: function (response) {
                    console.log(response);
                },
                error: function (error) {
                    console.error(error);
                }
            });
        });
    });
</script>