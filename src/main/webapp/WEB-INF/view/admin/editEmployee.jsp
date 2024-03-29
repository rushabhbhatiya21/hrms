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

<span class="contlabel" > Add Employee</span>
<hr>
<div class="whitcont">
    <div class="whiteleftside">
        <div class="leftSideMenu">
            <div class="menu-card-header" id="employeeInfoMenu">
                <span class="menu"><strong>Employee Information</strong></span>
                <span><strong><i class="fa-solid fa-minus"></i></strong></span>
            </div>
            <hr>
            <div class="menu-card">
                <div class="menu-option" id="personalMenu" ydata="0" xdata="personal">Personal</div>
                <span class="menu-option"><strong>&#129138</strong></span>
            </div>
            <div class="menu-card">
                <div class="menu-option" id="contactMenu" ydata="1" xdata="contact">Contact</div>
                <span class="menu-option"><strong>&#129138</strong></span>
            </div>
            <div class="menu-card">
                <div class="menu-option" id="familyMenu" ydata="2" xdata="family">Family</div>
                <span class="menu-option"><strong>&#129138</strong></span>
            </div>
            <div class="menu-card">
                <div class="menu-option" id="emergencyMenu" ydata="3" xdata="emergency">Emergency</div>
                <span class="menu-option"><strong>&#129138</strong></span>
            </div>
            <div class="menu-card">
                <div class="menu-option" id="nomineeMenu" ydata="4" xdata="nominee">Nominee</div>
                <span class="menu-option"><strong>&#129138</strong></span>
            </div>
            <div class="menu-card">
                <div class="menu-option" id="healthMenu" ydata="5" xdata="health">Health</div>
                <span class="menu-option"><strong>&#129138</strong></span>
            </div>
            <div class="menu-card">
                <div class="menu-option" id="photoMenu" ydata="6" xdata="photo">Photo</div>
                <span class="menu-option"><strong>&#129138</strong></span>
            </div>
            <div class="menu-card">
                <div class="menu-option" id="attachmentMenu" ydata="7" xdata="attachment">Attachment</div>
                <span class="menu-option"><strong>&#129138</strong></span>
            </div>
        </div>
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
                <input type="checkbox" id="anyProceedings" value="residentOfCountry">
                <label for="anyProceedings" class="form-label">Is Any Disciplinary Proceeding?</label>
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
                <button type="reset" class="btn btn-secondary">Reset</button>
                <button type="submit" class="btn btn-warning">Save</button>
            </div>
        </form>
        </div>
        <div id="contact">
            <span class="contlabel">Contact</span>
            <form class="row g-3 addContact mt10">
                <div class="col-md-3">
                    <label for="workPhone" class="form-label">Work Phone</label>
                    <input type="tel" id="workPhone" name="workPhone" class="form-control" required>
                </div>
                <div class="col-md-1">
                    <label for="extension" class="form-label">Extension</label>
                    <input type="text" id="extension" name="extension" class="form-control">
                </div>
                <div class="col-md-4">
                    <label for="homeMobile" class="form-label">Home Mobile:</label>
                    <input type="tel" id="homeMobile" name="homeMobile" class="form-control" required>
                </div>
                <div class="col-md-4">
                    <label for="workMobile" class="form-label">Work Mobile:</label>
                    <input type="tel" id="workMobile" name="workMobile" class="form-control">
                </div>
                <div class="col-md-4">
                    <label for="homePhone" class="form-label">Home Phone</label>
                    <input type="tel" id="homePhone" name="homePhone" class="form-control">
                </div>
                <div class="col-md-4">
                    <label for="corporateEmail" class="form-label">Corporate Email<span class="red">*</span></label>
                    <input type="email" id="corporateEmail" name="corporateEmail" class="form-control">
                </div>
                <div class="col-md-4">
                    <label for="personalEmail" class="form-label">Personal Email</label>
                    <input type="email" id="personalEmail" name="personalEmail" class="form-control">
                </div>
                <div class="col-md-4">
                    <label for="secondaryEmail" class="form-label">Secondary Email</label>
                    <input type="email" id="secondaryEmail" name="secondaryEmail" class="form-control">
                </div>
                <hr>
            </form>
            <div class="container" id="submitted">
            </div>
            <div class="btn btn-primary col-md-2" onclick="$('.address-card-container').show();">Add address</div>
            <div class="address-card-container" style="display: none">
                <div class="address-card">
                    <h2 class="address-card-title">Add New Address</h2>
                    <form class="row g-3 addAddress mt10">
                        <div class="col-md-6">
                            <label for="addressType">Address Type:</label>
                            <select id="addressType" class="form-control">
                                <option value="" selected disabled>-- Select --</option>
                                <option value="permanent">Permanent</option>
                                <option value="temporary">Temporary</option>
                            </select>
                        </div>
                        <div class="col-md-6">
                            <label for="propertyType">Property Type:</label>
                            <select id="propertyType" class="form-control">
                                <option value="" selected disabled>-- Select --</option>
                                <option value="owner">Owner</option>
                                <option value="tenant">Tenant</option>
                            </select>
                        </div>
                        <div class="col-md-6">
                            <label for="address">Address</label>
                            <input type="text" id="address" class="form-control">
                        </div>
                        <div class="col-md-6">
                            <label for="city">City:</label>
                            <input type="text" id="city" class="form-control"/>
                        </div>
                        <div class="col-md-6">
                            <label for="district">District:</label>
                            <input id="district" class="form-control" type="text">
                        </div>
                        <div class="col-md-6">
                            <label for="state">State</label>
                            <input type="text" id="state" class="form-control"/>
                        </div>
                        <div class="col-md-6">
                            <label for="address-country">Country:</label>
                            <input id="address-country" class="form-control" type="text">
                        </div>
                        <div class="col-md-6">
                            <label for="pincode">Pincode:</label>
                            <input type="text" id="pincode" class="form-control"/>
                        </div>


                        <div class="col-md-6">
                            <label for="areAllAddressSame">All Addresses are same</label>
                            <input type="checkbox" id="areAllAddressSame"/>
                        </div>
                        <div class="col-md-6"></div>
                        <div class="col-md-6"></div>
                        <div class="col-md-6">
                            <button type="submit" class="btn btn-primary" onclick="addAddress(event);">Add</button>
                            <button type="button" class="btn btn-danger" onclick="$('.address-card-container').hide(); document.querySelector('.addAddress').reset();">
                                Cancel
                            </button>
                        </div>
                    </form>
                </div>
            </div>
            <div class="btn btn-warning col-md-4" id="submitContact">Save & Continue</div>

        </div>
        <div id="family">
            <span class="contlabel">Family</span>
            <form class="row g-3 addFamily mt10">
                <div class="col-md-4">
                    <label for="firstName" class="form-label">First Name<span class="red">*</span> </label>
                    <input type="text" class="form-control bg-white" id="familyfirstName">
                </div>
                <div class="col-md-4">
                    <label for="middleName" class="form-label">Middle Name<span class="red">*</span> </label>
                    <input type="text" class="form-control bg-white" id="familymiddleName">
                </div>
                <div class="col-md-4">
                    <label for="lastName" class="form-label">Last Name<span class="red">*</span> </label>
                    <input type="text" class="form-control bg-white" id="familylastName">
                </div>
                <div class="col-md-4">
                    <label for="familyrelation" class="form-label">Relation<span class="red">*</span></label>
                    <select class="form-control" id="familyrelation">
                        <option value="" disabled selected>-- Select Relation --</option>
                        <option value="father">Father</option>
                        <option value="mother">Mother</option>
                        <option value="brother">Brother</option>
                        <option value="sister">Sister</option>
                        <option value="friend">Friend</option>
                    </select>
                </div>
                <div class="col-md-4">
                    <label for="familydateOfBirth" class="form-label">Date of Birth<span class="red">*</span> </label>
                    <input type="date" class="form-control" id="familydateOfBirth">
                </div>
                <div class="col-md-4">
                    <label for="familygender" class="form-label">Gender<span class="red">*</span> </label>
                    <select class="form-control" id="familygender">
                        <option value="" disabled selected>--Select Type--</option>
                        <c:forEach var="gender" items="${gender}">
                            <option value=${gender.name()}>${gender.name()}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-md-4">
                    <input type="checkbox" id="isNominee" value="isNominee">
                    <label for="isNominee" class="form-label">is Nominee?</label>
                </div>

                <div class="col-md-4">
                    <label for="maritalStatus" class="form-label">Marital Status<span class="red">*</span> </label>
                    <select class="form-control" id="maritalStatus">
                        <option value="" disabled selected>--Select Marital Status--</option>
                        <c:forEach var="ms" items="${marriageStatus}">
                            <option value=${ms.name()}>${ms.name()}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="col-md-4">
                    <label for="occupancy" class="form-label">Occupancy</label>
                    <input type="text" class="form-control bg-white" id="occupancy">
                </div>

                <div class="col-md-4">
                    <input type="checkbox" id="isDependent" value="isNominee">
                    <label for="isDependent" class="form-label">is Dependent?</label>
                </div>

                <div class="col-md-4">
                    <label for="contectDetails" class="form-label">Contact Details</label>
                    <input type="text" class="form-control bg-white" id="contectDetails">
                </div>
                <div class="col-md-4">
                    <label for="familynationality" class="form-label">Nationality</label>
                    <select class="form-control" id="familynationality">
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
                    <input type="checkbox" id="isResidingWith" value="isResidingWith">
                    <label for="isResidingWith" class="form-label">is Residing with?</label>
                </div>
                <div class="col-md-4">
                    <input type="checkbox" id="isEmergencyContact" value="isEmergencyContact">
                    <label for="isEmergencyContact" class="form-label">Can be contact in Emergency?</label>
                </div>
                <div class="col-md-4">
                    <input type="checkbox" id="isDisabled" value="isDisabled">
                    <label for="isDisabled" class="form-label">Is Physically Disabled?</label>
                </div>
                <div class="col-md-4">
                    <label for="familyaddress">Address</label>
                    <textarea class="form-control" id="familyaddress" rows="3"></textarea>
                </div>
                <div class="form-row">
                    <button type="reset" class="btn btn-secondary" onclick="resetFamily();">Reset</button>
                    <button type="button" onclick="addFamilyRecord();" class="btn btn-primary">Add Record</button>
                    <button type="submit" class="btn btn-warning">Save & Continue</button>
                </div>
            </form>

            <table id="familytable" class="table table-bordered table-striped">
                <thead class="thead-dark">
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Relation</th>
                        <th>D.O.B.</th>
                    </tr>
                </thead>
                <tbody id="familyTableBody">
                    <c:forEach var="fam" items="${families}" varStatus="loop">
                        <tr>
                            <td>${fam.firstName}</td>
                            <td>${fam.lastName}</td>
                            <td>${fam.relation}</td>
                            <td>${fam.dateOfBirth.toString().split(" ")[0]}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

        </div>
        <div id="emergency">
            <span class="contlabel">Emergency</span>
            <form class="row g-3 addEmergency mt10">
                <div class="col-md-4">
                    <label for="firstName" class="form-label">First Name<span class="red">*</span></label>
                    <input type="text" class="form-control" id="firstName">
                </div>
                <div class="col-md-4">
                    <label for="middleName" class="form-label">Middle Name</label>
                    <input type="text" class="form-control" id="middleName">
                </div>
                <div class="col-md-4">
                    <label for="lastName" class="form-label">Last Name</label>
                    <input type="text" class="form-control" id="lastName">
                </div>
                <div class="col-md-4">
                    <label for="priority" class="form-label">Priority</label>
                    <input type="text" class="form-control" id="priority">
                </div>
                <div class="col-md-4">
                    <label for="phoneNumber" class="form-label">Phone No.</label>
                    <input type="number" class="form-control bg-white" id="phoneNumber">
                </div>
                <div class="col-md-4">
                    <label for="mobileNumber" class="form-label">Mobile No.<span class="red">*</span></label>
                    <input type="number" class="form-control bg-white" id="mobileNumber">
                </div>
                <div class="col-md-4">
                    <label for="relation" class="form-label">Relation<span class="red">*</span></label>
                    <select class="form-control" id="relation">
                        <option value="" disabled selected>-- Select Type --</option>
                        <option value="father">Father</option>
                        <option value="mother">Mother</option>
                        <option value="brother">Brother</option>
                        <option value="sister">Sister</option>
                        <option value="friend">Friend</option>
                    </select>
                </div>
                <div class="col-md-8">
                    <label for="email" class="form-label">EmergencyEmail</label>
                    <input type="email" class="form-control bg-white" id="email">
                </div>
                <div class="col-md-12">
                    <label for="emergencyAddress" class="form-label">Address</label>
                    <textarea class="form-control bg-white" rows="3" id="emergencyAddress"></textarea>
                </div>
                <div>
                    <button type="reset" class="btn btn-secondary" onclick="emergencyReset();">Reset</button>
                    <button type="button" onclick="addEmergencyrecord();" class="btn btn-primary">Add Record</button>
                    <button type="submit" class="btn btn-warning">Save & Continue</button>
                </div>
            </form>
            <table id="EmergencyTable" class="table table-bordered table-striped">
                <thead class="thead-dark">
                <tr>
                    <th>First Name</th>
                    <th>Relation</th>
                    <th>Mobile no.</th>
                </tr>
                </thead>
                <tbody id="EmergencyTableBody">
                <c:forEach var="emr" items="${emergency}" varStatus="loop">
                    <tr>
                        <td>${emr.firstName}</td>
                        <td>${emr.relation}</td>
                        <td>${emr.mobileNumber}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div id="nominee">
            <span class="contlabel">Nominee</span>
            <br>
            <a onclick="$('.familycontainer').show();">Import from family</a>
            <div class="familycontainer" style="display: none">
                <div class="familycontainer-card">
                    <table class="table table-bordered table-striped" style="width: 100%;">
                        <thead class="thead-dark">
                        <tr>
                            <th>First Name</th>
                            <th>D.O.B</th>
                            <th>Relation</th>
                            <th>Gender</th>
                        </tr>
                        </thead>
                        <c:forEach var="fam" items="${familiesByNominee}">
                            <tr onclick="populatenominee('${fam.firstName}','${fam.dateOfBirth}','${fam.relation}','${fam.gender}')">
                                <td>${fam.firstName}</td>
                                <td>${fam.dateOfBirth.toLocaleString().split(',')[0]}</td>
                                <td>${fam.relation}</td>
                                <td>${fam.gender}</td>
                            </tr>
                        </c:forEach>
                    </table>
                    <button class="btn btn-danger" onclick="$('.familycontainer').hide();">Close</button>
                </div>
            </div>
            <form class="row g-3 addNominee mt10">
                <div class="col-md-4">
                    <label for="nomineepriority" class="form-label">Priority<span class="red">*</span></label>
                    <input type="text" class="form-control" id="nomineepriority">
                </div>
                <div class="col-md-8"></div>
                <div class="col-md-4">
                    <label for="nomineefirstName" class="form-label">First Name<span class="red">*</span></label>
                    <input type="text" class="form-control" id="nomineefirstName">
                </div>
                <div class="col-md-4">
                    <label for="nomineemiddleName" class="form-label">Middle Name</label>
                    <input type="text" class="form-control" id="nomineemiddleName">
                </div>
                <div class="col-md-4">
                    <label for="nomineelastName" class="form-label">Last Name</label>
                    <input type="text" class="form-control" id="nomineelastName">
                </div>
                <div class="col-md-4">
                    <label for="nomineerelation" class="form-label">Relation<span class="red">*</span></label>
                    <select class="form-control" id="nomineerelation">
                        <option value="" disabled selected>-- Select Type --</option>
                        <option value="father">Father</option>
                        <option value="mother">Mother</option>
                        <option value="brother">Brother</option>
                        <option value="sister">Sister</option>
                        <option value="friend">Friend</option>
                    </select>
                </div>
                <div class="col-md-4">
                    <label for="nomineegender" class="form-label">Gender<span class="red">*</span> </label>
                    <select class="form-control" id="nomineegender">
                        <option value="" disabled selected>Select Gender</option>
                        <c:forEach var="gender" items="${gender}">
                            <option value=${gender.name()}>${gender.name()}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-md-4">
                    <label for="nomineedateOfBirth" class="form-label">Date of Birth<span class="red">*</span> </label>
                    <input type="date" class="form-control" id="nomineedateOfBirth">
                </div>
                <div class="col-md-4">
                    <label for="nomineeuidNumber" class="form-label">UID Number</label>
                    <input type="text" class="form-control" id="nomineeuidNumber">
                </div>
                <div class="col-md-4">
                    <label for="nomineePAN" class="form-label">PAN Number</label>
                    <input type="text" class="form-control" id="nomineePAN">
                </div>
                <div class="col-md-4">
                    <label for="nomineeContact" class="form-label">Contact Number</label>
                    <input type="text" class="form-control" id="nomineeContact">
                </div>

                <div class="col-md-12">
                    <label for="nomineeInvalidCondition" class="form-label">Nominee Invalid Condition</label>
                    <textarea class="form-control bg-white" rows="3" id="nomineeInvalidCondition"></textarea>
                </div>
                <div>
                    <button type="reset" onclick="nomineeReset()" class="btn btn-secondary">Reset</button>
                    <button type="button" onclick="addNomineeRecord();" class="btn btn-primary">Add Record</button>
                    <button type="submit" class="btn btn-warning">Save & Continue</button>
                </div>
            </form>
            <table id="NomineeTable" class="table table-bordered table-striped">
                <thead class="thead-dark">
                <tr>
                    <th>Priority</th>
                    <th>First Name</th>
                    <th>Relation</th>
                    <th>Gender</th>
                    <th>D.O.B.</th>
                </tr>
                </thead>
                <tbody id="NomineeTableBody">
                <c:forEach var="nom" items="${nominees}" varStatus="loop">
                    <tr>
                        <td>${nom.priority}</td>
                        <td>${nom.firstName}</td>
                        <td>${nom.relation}</td>
                        <td>${nom.gender}</td>
                        <td>${nom.dateOfBirth.toString().split(" ")[0]}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div id="health">
            <span class="contlabel">Health</span>
            <form class="row g-3 addHealth mt10">
                <div class="col-md-4">
                    <label for="height" class="form-label">Height(cms)<span class="red">*</span></label>
                    <input type="number" class="form-control" <c:if test="${health != null}">value="${health.height}"</c:if> id="height">
                </div>
                <div class="col-md-4">
                    <label for="weight" class="form-label">Weight(kgs)</label>
                    <input type="number" class="form-control" id="weight">
                </div>
                <div class="col-md-4">
                    <label for="bloodGroup" class="form-label">Blood Group</label>
                    <input type="text" class="form-control" id="bloodGroup">
                </div>
                <div class="col-md-4">
                    <label for="idMark1" class="form-label">Identification Mark-1</label>
                    <input type="text" class="form-control" id="idMark1">
                </div>
                <div class="col-md-4">
                    <label for="idMark2" class="form-label">Identification Mark-2</label>
                    <input type="text" class="form-control bg-white" id="idMark2">
                </div>
                <div class="col-md-4">
                    <input type="checkbox" id="handicapped" value="handicapped">
                    <label for="handicapped" class="form-label">Physically Handicapped</label>
                </div>
                <div>
                    <button type="reset" class="btn btn-secondary">Reset</button>
                    <button type="submit" class="btn btn-warning">Save & Continue</button>
                </div>
            </form>
        </div>
        <div id="photo">
            <span class="contlabel">Photo</span>
            <form id="photoForm">
                <div class="image-card">
                    <div class="outside-preview">
                        <span class="preview-text">No Image</span>
                    </div>
                    <div class="preview-next">
                        <div class="image-input">
                            <label for="employeePhoto" class="form-label">Employee Photo<span class="red">*</span></label>
                            <input type="file" accept=".jpg, .jpeg, .png" id="employeePhoto" class="form-control bg-white" style="display: none">
                            <input type="text" class="form-control bg-white" disabled>
                            <button id="browsePhoto" class="btn btn-secondary btn-browse" type="button" value="Browse" onclick="browseAndPreview('employeePhoto', 'browsePhoto')">Browse</button>
                        </div>
                        <span>only jpg/png/jpeg are allowed</span>
                    </div>
                    <div class="btn-upload">
                        <button id="uploadPhoto" class="btn btn-outline-warning photobutton" type="button" xdata="employeePhoto">Upload</button>
                    </div>
                </div>
                <div class="image-card">
                    <div class="outside-preview">
                         <span class="preview-text">No Image</span>
                    </div>
                    <div class="preview-next">
                        <div class="image-input">
                            <label for="employeeSign" class="form-label">Employee Sign<span class="red">*</span></label>
                            <input type="file" accept=".jpg, .jpeg, .png" id="employeeSign" class="form-control bg-white" style="display: none">
                            <input type="text" class="form-control bg-white" disabled>
                            <button id="browseSign" class="btn btn-secondary btn-browse" type="button" value="Browse" onclick="browseAndPreview('employeeSign','browseSign')">Browse</button>
                        </div>
                        <span>only jpg/png/jpeg are allowed</span>
                    </div>
                    <div class="btn-upload">
                        <button id="uploadSign" class="btn btn-outline-warning photobutton" type="button" value="Upload" xdata="employeeSign" >Upload</button>
                    </div>
                </div>
            </form>
            <c:if test="${photograph != null}">
            <div class="image-uploaded">
                <div class="photo-container">
                    <div class="header">Photo:</div>
                    <div class="outside-preview">
                        <img src="data:image/png;base64,${photograph.employeePhotoString}" alt="No stored image" style="max-width: 100%; max-height: 100%;">
                    </div>
                </div>

                <div class="sign-container">
                    <div class="header">Sign:</div>
                    <div class="outside-preview">
                        <img src="data:image/png;base64,${photograph.employeeSignString}" alt="No stored image" style="max-width: 100%; max-height: 100%;">
                    </div>
                </div>
            </div>
            </c:if>
        </div>
        <div id="attachment">
            <span class="contlabel">Attachment</span>
            <form id="addAttachment" class="row g-3 mt10">
                <div class="col-md-6">
                    <label for="documentCategory" class="form-label">Document Category<span class="red">*</span></label>
                    <select class="form-control" id="documentCategory">
                        <option value="" disabled selected>-- Select type --</option>
                        <option value="aadharCard">Aadhar Card</option>
                        <option value="voterID">Voter ID</option>
                        <option value="passport">Passport</option>
                        <option value="drivingLicense">Driving License</option>
                        <option value="rationCard">Ration Card</option>
                        <option value="bankStatement">Bank Statement</option>
                        <option value="utilityBill">Utility Bill</option>
                        <option value="incomeCertificate">Income Certificate</option>
                        <option value="other">Other</option>
                    </select>
                </div>
                <div class="col-md-6">
                    <label for="titleOfDocument" class="form-label">Title of document<span class="red">*</span></label>
                    <input type="text" class="form-control" id="titleOfDocument">
                </div>
                <div class="col-md-12">
                    <label for="documentDescription">Document Description</label>
                    <textarea class="form-control" id="documentDescription" rows="3"></textarea>
                </div>
                <div class="image-card">
                    <div class="outside-preview">
                        <span class="preview-text">No Image</span>
                    </div>
                    <div class="preview-next">
                        <div class="image-input">
                            <label for="documentPhoto" class="form-label">Document Photo<span class="red">*</span></label>
                            <input type="file" accept=".jpg, .jpeg, .png" id="documentPhoto" class="form-control bg-white" style="display: none">
                            <input type="text" class="form-control bg-white" disabled>
                            <button id="browseDocumentPhoto" class="btn btn-secondary btn-browse" type="button" value="Browse" onclick="browseAndPreview('documentPhoto', 'browseDocumentPhoto')">Browse</button>
                        </div>
                        <span>only jpg/png/jpeg are allowed</span>
                    </div>
                </div>
                <div class="col-md-4">
                    <button class="btn btn-secondary" type="reset" >Reset</button>
                    <button class="btn btn-warning" type="submit">Add record</button>
                </div>
            </form>
        </div>
        <div id="job">
            <span class="contlabel">Contact</span>
            <form class="row g-3 addJob mt10">
                <div class="col-md-3">
                    <label for="employmentType" class="form-label">Employment Type</label>
                    <select id="employmentType" class="form-control" required>
                        <option value="" selected disabled>-- Select --</option>
                        <c:forEach var="employmentType" items="${employmentTypes}">
                            <option value=${employmentType.employmentTypeId}>${employmentType.employmentTypeName}</option>
                        </c:forEach>
                    </select>
                </div>
               <div class="col-md-3">
                    <label for="employmentCategory" class="form-label">Employment Category</label>
                    <select id="employmentCategory" class="form-control" required>
                        <option value="" selected disabled>-- Select --</option>
                        <c:forEach var="employmentCategory" items="${employmentCategories}">
                            <option value=${employmentCategory.employmentCategoryId}>${employmentCategory.employmentCategoryName}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-md-3">
                    <label for="employmentStatus" class="form-label">Employment Status</label>
                    <select id="employmentStatus" class="form-control" required>
                        <option value="" selected disabled>-- Select --</option>
                        <c:forEach var="employmentStatus" items="${employmentStatus}">
                            <option value=${employmentStatus.name()}>${employmentStatus.name()}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-md-1">
                    <label for="noticePeriod" class="form-label">Notice Period</label>
                    <input type="number" id="noticePeriod" name="extension" class="form-control">
                </div>
                <div class="col-md-4">
                    <label for="employeeGrade" class="form-label">Employee Grade</label>
                    <select id="employeeGrade" class="form-control" required>
                        <option value="" selected disabled>-- Select --</option>
                        <option value="A">A</option>
                        <option value="B">B</option>
                        <option value="C">C</option>
                        <option value="D">D</option>
                    </select>
                </div>
                <div class="col-md-4">
                    <label for="dateOfRetirement" class="form-label">Date Of Retirement</label>
                    <input type="date" id="dateOfRetirement" name="workMobile" class="form-control">
                </div>
                <div class="col-md-4">
                    <label for="dutiesAndResponsibility" class="form-label">Duties And Responsibility</label>
                    <textarea rows="3" id="dutiesAndResponsibility" name="dutiesAndResponsibility" class="form-control"></textarea>
                </div>
                <hr>
            </form>
        </div>
    </div>

    <c:set var="somevar" value="0" />
    <c:if test="${personal != null}">
        <c:set var="somevar" value="1"/>
        <c:if test="${contact != null}">
            <c:set var="somevar" value="2"/>
            <c:if test="${families.size()>0}">
                <c:set var="somevar" value="3"/>
                <c:if test="${emergency.size()>0}">
                    <c:set var="somevar" value="4"/>
                    <c:if test="${nominees.size()>0}">
                        <c:set var="somevar" value="5"/>
                        <c:if test="${health != null}">
                            <c:set var="somevar" value="6"/>
                            <c:if test="${photograph.employeePhoto != null && photograph.employeeSign != null}">
                                <c:set var="somevar" value="7"/>
                            </c:if>
                        </c:if>
                    </c:if>
                </c:if>
            </c:if>
        </c:if>
    </c:if>
    <input id="somevalue" value="${somevar}" type="hidden">
    <input id="empphoto" value="${(photograph.employeePhoto != null)?1:0}" type="hidden">
    <input id="empsign" value="${(photograph.employeeSign != null)?1:0}" type="hidden">
</div>

