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
                toastr.success(response);
            },
            error: function (error) {
                toastr.error(error);
            }
        });
    });



    $('.addFamily').submit(function (event){
        event.preventDefault();
        if(familyList.length <= 0){
            toastr.error("no records are added");
            return;
        }
        $.ajax({
            type: 'POST',
            contentType: 'application/json',
            url: '/admin/submitFamily/'+employeeId,
            data: JSON.stringify(familyList),
            success: function (response) {
                toastr.success(response);
            },
            error: function (error) {
                toastr.error(error);
            }
        });
    });

    $('.addPersonal').submit(function (event) {
        event.preventDefault();
        if(!validateFormbyclass('addPersonal')){
            toastr.error("all * fields are require");
            return;
        }
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
        var flag = false;
        $.ajax({
            type: 'POST',
            contentType: 'application/json',
            url: '/admin/submitPersonal/' + employeeId,
            data: JSON.stringify(formData),
            success: function (response) {
                toastr.success(response);
            },
            error: function (error) {
                console.error(error);
                flag = true;
            }
        });
        if(flag) {
            return;
        }
        const somevarValue = parseInt($('#somevalue').val());
        if(somevarValue <= 0)$('#somevalue').val(1);
        $('#contactMenu').click();
    });

    $('.addEmergency').submit(function (event) {
        event.preventDefault();
        $.ajax({
            type: 'POST',
            contentType: 'application/json',
            url: '/admin/submitEmergency/'+employeeId,
            data: JSON.stringify(emergencyList),
            success: function (response) {
                toastr.success(response);
            },
            error: function (error) {
                toastr.error(error);
            }
        });
    });

    $('.addNominee').submit(function (event) {
        event.preventDefault();
        console.log(nomineeList);
        $.ajax({
            type: 'POST',
            contentType: 'application/json',
            url: '/admin/submitNominee/'+employeeId,
            data: JSON.stringify(nomineeList),
            success: function (response) {
                toastr.success(response);
            },
            error: function (error) {
                toastr.error(error);
            }
        });
    });

    $('.addHealth').submit(function (event) {
        event.preventDefault();
        const healthData = {
            "height": $("#height").val(),
            "weight": $("#weight").val(),
            "bloodGroup": $("#bloodGroup").val(),
            "idMark1": $("#idMark1").val(),
            "idMark2": $("#idMark2").val(),
            "physicallyHandicapped": $("#handicapped").val(),
        };
        $.ajax({
            type: 'POST',
            contentType: 'application/json',
            url: '/admin/submitHealth/'+ employeeId,
            data: JSON.stringify(healthData),
            success: function (response) {
                toastr.success(response);
            },
            error: function (error) {
                toastr.error(error);
            }
        });
    });

    $('#addAttachment').submit(function (event) {
        event.preventDefault();

        const formData = new FormData();
        formData.append('documentCategory',$('#documentCategory').val());
        formData.append('titleOfDocument', $('#titleOfDocument').val());
        formData.append('documentDescription', $('#documentDescription').val());

        // Append file data (assuming you have an input with ID 'documentPhoto')
        const fileInput = document.getElementById('documentPhoto');
        if (fileInput.files.length > 0) {
            formData.append('documentPhoto', fileInput.files[0]);
        }

        $.ajax({
            url: 'http://localhost:8080/admin/submitAttachment/' + employeeId,
            type: 'POST',
            data: formData,
            contentType: false, // Let jQuery handle the contentType
            processData: false, // Prevent jQuery from processing the data

            success: function (data) {
                toastr.success('Upload successful:', data);
            },
            error: function (error) {
                toastr.error('Error during upload:', error);
            }
        });
    })

    $('.menu-option').click(function () {
        const somevarValue = parseInt($('#somevalue').val());
        console.log(somevarValue);
        if($(this).attr('ydata')<=somevarValue){
            toggleMenuOption($(this).attr('xdata'));
        }
    });
});