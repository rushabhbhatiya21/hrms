function toggleMenuOption(menuOptionId) {
    $('.whiterightside > div').not('#' + menuOptionId).hide();
    $('#' + menuOptionId).show();
}
var addressList = [];
const employeeId = window.location.href.split('/').pop();


function addAddress(e) {
    e.preventDefault();
    const addressType = document.getElementById("addressType").value;
    const country = document.getElementById("address-country").value;
    const district = document.getElementById("district").value;
    const pincode = document.getElementById("pincode").value;
    const propertyType = document.getElementById("propertyType").value;
    const address = document.getElementById("address").value;
    const state = document.getElementById("state").value;
    const city = document.getElementById("city").value;
    const areAllAddressSame = document.getElementById("areAllAddressSame").checked;

    let newAddress = {
        addressType: addressType,
        country: country,
        district: district,
        pincode: pincode,
        propertyType: propertyType,
        address: address,
        state: state,
        city: city,
        areAllAddressSame: areAllAddressSame
    };

    addressList.push(newAddress);

    var submittedData = '<div class="addcard"><table><tbody><tr><td><strong>All Addresses Same:</strong></td><td>'+(areAllAddressSame ? 'Yes' : "No")+'</td><td>'+(areAllAddressSame ? '' : addressType)+"</td></tr><tr><td colspan='2'>"+address+ " ,"+ city +" ,"+ district +"</td></tr><tr><td>"+ state + " ," + country + " ,"+ pincode +"</td><td>"+ propertyType +"</td></tr></tbody></table></div>";
    document.getElementById("submitted").innerHTML += submittedData;
    $('.address-card-container').hide();
    document.querySelector('.addAddress').reset();

}
const familyList =[];
function addFamilyRecord(){
    const formData = {};
    $('.addFamily input, .addFamily select, .addFamily textarea').each(function () {
        const id = $(this).attr('id');
        let value;

        if ($(this).is(':checkbox')) {
            value = $(this).prop('checked');
        } else {
            value = $(this).val();
        }

        formData[id] = value;
    });

    const familyData = {
        // Add other properties as needed
        firstName: formData.familyfirstName,
        middleName: formData.familymiddleName,
        lastName: formData.familylastName,
        relation: formData.familyrelation,
        dateOfBirth: formData.familydateOfBirth,
        gender: formData.familygender,
        nominee: formData.isNominee,
        dependant: formData.isDependent,
        maritalStatus: formData.maritalStatus,
        occupation: formData.occupancy,
        canContactInEmergency: formData.isEmergencyContact,
        disabled: formData.isDisabled,
        nationality: formData.familynationality,
        residingWith: formData.isResidingWith,
        contactDetail: formData.contectDetails,
        address: formData.familyaddress
    };

    console.log(familyData);
    familyList.push(familyData);
    document.querySelector('.addFamily').reset();
}

const emergencyList = [];
function addEmergencyrecord(){
    const formData = {};
    $('.addEmergency input, .addEmergency select, .addEmergency textarea').each(function () {
        const id = $(this).attr('id');
        let value;

        if ($(this).is(':checkbox')) {
            value = $(this).prop('checked');
        } else {
            value = $(this).val();
        }

        formData[id] = value;
    });

    // Construct the Emergency object
    const emergencyData = {
        priority: formData.priority,
        firstName: formData.firstName,
        middleName: formData.middleName,
        lastName: formData.lastName,
        relation: formData.relation,
        phoneNumber: formData.phoneNumber,
        mobileNumber: formData.mobileNumber,
        email: formData.email,
        address: formData.emergencyAddress
    };

    console.log(emergencyData);
    emergencyList.push(emergencyData);
    $('.addEmergency').reset();
}

function formatToYYYYMMDD(dateString) {
    const date = new Date(dateString);
    const year = date.getFullYear();
    const month = (date.getMonth() + 1).toString().padStart(2, '0');
    const day = date.getDate().toString().padStart(2, '0');
    return `${year}-${month}-${day}`;
}
function populatenominee(fname,dateofbirth,relation,gender){
    $('.familycontainer').hide();
    $('#nomineefirstName').val(fname);
    $('#nomineedateOfBirth').val(formatToYYYYMMDD(dateofbirth));
    $('#nomineerelation').val(relation);
    $('#nomineegender').val(gender);
}

var nomineeList = [];
function addNomineerecord() {
    var nomineeData = {
        "priority": $("#nomineepriority").val(),
        "firstName": $("#nomineefirstName").val(),
        "middleName": $("#nomineemiddleName").val(),
        "lastName": $("#nomineelastName").val(),
        "relation": $("#nomineerelation").val(),
        "gender": $("#nomineegender").val(),
        "dateOfBirth": $("#nomineedateOfBirth").val(),
        "uidNumber": $("#nomineeuidNumber").val(),
        "panNumber": $("#nomineePAN").val(),
        "contactNumber": $("#nomineeContact").val(),
        "nomineeInvalidCondition": $("#nomineeInvalidCondition").val()
    };
    console.log(nomineeData);
    nomineeList.push(nomineeData);
    $('.addNominee').reset();
}



function browseAndPreview(inputId, browseButtonId) {
    const fileInput = document.getElementById(inputId);
    const browseButton = document.getElementById(browseButtonId);

    // Check if elements are found
    if (!fileInput || !browseButton) {
        console.error('Element not found. Check the IDs.');
        return;
    }

    const previewText = browseButton.parentElement?browseButton.previousElementSibling:browseButton.firstElementChild;
    const previewImage = browseButton.parentElement.parentElement.parentElement.firstElementChild;


    // Check if elements are found
    if (!previewText || !previewImage) {
        console.error('Preview elements not found. Check the HTML structure.');
        return;
    }

    // Trigger file input click
    fileInput.click();

    fileInput.addEventListener('change', function () {
        const selectedFile = fileInput.files[0];

        if (selectedFile) {
            // Display preview
            const reader = new FileReader();
            reader.onload = function (e) {
                previewImage.innerHTML = `<img src="${e.target.result}" alt="Preview" style="max-width: 100%; max-height: 100%;">`;
                previewText.value = selectedFile.name;
            };
            reader.readAsDataURL(selectedFile);
        } else {
            // Display "No Image" if no file is selected
            previewImage.innerHTML = '';
            previewText.textContent = 'No Image';
        }
    });
}

function uploadPhoto(inputId) {
    const fileInput = document.getElementById(inputId);
    const selectedFile = fileInput.files[0];

    if (selectedFile) {
        const formData = new FormData();
        formData.append(inputId, selectedFile);


        $.ajax({
            url: 'http://localhost:8080/admin/submitPhoto/'+employeeId,
            type: 'POST',
            data: formData,
            processData: false, // Prevent jQuery from automatically processing data
            contentType: false, // Prevent jQuery from setting contentType
            success: function (data) {
                // Handle successful response from the server
                console.log('Upload successful:', data);
            },
            error: function (error) {
                // Handle errors
                console.error('Error during upload:', error);
            }
        });
    } else {
        alert('Please select a file before uploading.');
    }
}








$(document).ready(function () {
    $('.address-card-container').hide();
    toggleMenuOption('personal');
    $('#employeeInfoMenu').click(function () {
        $('.menu-option').toggle();
    });

    $('#submitContact').click(function () {

        const formData = {};
        $('.addContact input').each(function () {
            const id = $(this).attr('id');
            formData[id] =  $(this).val();
        });
        formData["addresses"] = addressList;

        console.log(formData);

        $.ajax({
            type: "POST",
            url: "http://localhost:8080/admin/submitContact/" + employeeId,
            contentType: "application/json",
            data: JSON.stringify(formData),
            success: function (response) {
                console.log(response);
            },
            error: function (error) {
                console.log(error);
            }
        });
    });



    $('.addFamily').submit(function (event){
        event.preventDefault();

        $.ajax({
            type: 'POST',
            contentType: 'application/json',
            url: '/admin/submitFamily/'+employeeId,
            data: JSON.stringify(familyList),
            success: function (response) {
                console.log(response);
            },
            error: function (error) {
                console.error(error);
            }
        });
    });

    $('.addPersonal').submit(function (event) {
        event.preventDefault();
        const formData = {};
        $('.addPersonal input, .addPersonal select').each(function () {
            let value;
            const id = $(this).attr('id');
            if (id === 'bankDetail' || id === 'bankBranch' || id === 'ifscCode' ) {
                return;
            }
            else if ($(this).is(':checkbox')) {
                value = !!$(this).prop('checked');
            } else {
                value = $(this).val();
            }
            formData[id] = value;
        });

        formData["bankDetail"] = {"bankBranchId":parseInt($('#bankBranch').val())};

        $.ajax({
            type: 'POST',
            contentType: 'application/json',
            url: '/admin/submitPersonal' + employeeId,
            data: JSON.stringify(formData),
            success: function (response) {
                console.log(response);
            },
            error: function (error) {
                console.error(error);
            }
        });
    });

    $('.addEmergency').submit(function (event) {
        event.preventDefault();
        $.ajax({
            type: 'POST',
            contentType: 'application/json',
            url: '/admin/submitEmergency/'+employeeId,
            data: JSON.stringify(emergencyList),
            success: function (response) {
                console.log(response);
            },
            error: function (error) {
                console.error(error);
            }
        });
    });

    $('.addNominee').submit(function (event) {
        event.preventDefault();
        console.log(nomineeList);
        // $.ajax({
        //     type: 'POST',
        //     contentType: 'application/json',
        //     url: '/admin/submitNominee/'+employeeId,
        //     data: JSON.stringify(nomineeList),
        //     success: function (response) {
        //         console.log(response);
        //     },
        //     error: function (error) {
        //         console.error(error);
        //     }
        // });
    });
});