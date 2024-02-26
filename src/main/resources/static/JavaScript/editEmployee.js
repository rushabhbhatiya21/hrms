function toggleMenuOption(menuOptionId) {
    $('.whiterightside > div').not('#' + menuOptionId).hide();
    $('#' + menuOptionId).show();
}
var addressList = [];
const employeeId = window.location.href.split('/').pop();
console.log(employeeId);


function addAddress(e) {
    e.preventDefault();
    var addressType = document.getElementById("addressType").value;
    var country = document.getElementById("address-country").value;
    var district = document.getElementById("district").value;
    var pincode = document.getElementById("pincode").value;
    var propertyType = document.getElementById("propertyType").value;
    var address = document.getElementById("address").value;
    var state = document.getElementById("state").value;
    var city = document.getElementById("city").value;
    var areAllAddressSame = document.getElementById("areAllAddressSame").checked;

    var newAddress = {
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
            url: "http://localhost:8080/admin/submitContact/"+employeeId,
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
            url: '/admin/submitPersonal'+employeeId,
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