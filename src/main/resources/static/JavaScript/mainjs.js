$(document).ready(function () {
    var notificationMessage = localStorage.getItem('notificationMessage');
    if (notificationMessage) {
        toastr.success(notificationMessage);
        localStorage.removeItem('notificationMessage');
    }

    $('.iroc').hide();
    $('.gvp').hide();
    $('.opts').hide();
    $('#bankBranch').change(function () {
        var selectedOption = $(this).find('option:selected');
        var customDataValue = selectedOption.attr('data');
        $('#ifscCode').val(customDataValue);
    });

    $('#govVehicleProvided').change(function () {
        if ($(this).is(':checked')) {
            $('.gvp').show();
        } else {
            $('.gvp').hide();
        }
    });

    $('#residentOfCountry').change(function () {
        if ($(this).is(':checked')) {
            $('.iroc').show();
        } else {
            $('.iroc').hide();
        }
    });

    $('#bankDetail').change(function (){
        $('.opts').hide();
        $('#bankBranch').val("");
        $('#ifscCode').val("");
        $('.'+$(this).val()).show();
    });


    $('.addemployee').submit(function (event) {
        event.preventDefault();
        if(!validateFormbyclass('addemployee')){
            toastr.error("all * fields are require");
            return;
        }
        let regex = new RegExp(/^[A-Z]{5}[0-9]{4}[A-Z]{1}$/);
        if (!regex.test($('#panNumber').val())) {
            $('#panNumber').focus();
            toastr.error("invalid pan");
            return;
        }

        const formData = {};
        $('.addemployee input, .addemployee select').each(function () {
            let value;
            const id = $(this).attr('id');

            if ($(this).is('select')) {
                if (id === 'department' || id === 'designation' || id === 'groupMain') {
                    var str = id+"Id";
                    value = {}
                    value[str]=parseInt($(this).val(),10);
                } else {
                    value = $(this).val();
                }
            }
            else if ($(this).is(':checkbox')) {
                value = !!$(this).prop('checked');
            } else {
                value = $(this).val();
            }
            formData[id] = value;
        });

        $.ajax({
            type: 'POST',
            contentType: 'application/json',
            url: '/admin/submitEmployeeData',
            data: JSON.stringify(formData),
            success: function (response) {
                localStorage.setItem('notificationMessage', 'Employee added successfully');
                window.location.href = 'http://localhost:8080/admin/editEmployee/'+response;

            },
            error: function (error) {
                toastr.error(error.responseText);
                console.error(error);
            }
        });
    });
});