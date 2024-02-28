$(document).ready(function () {
    $('.address-card-container').hide();
    toggleMenuOption('personal');
    $('#employeeInfoMenu').click(function () {
        $('.menu-card').toggle();
    });

    $('#submitContact').click(function () {

        if(!validateFormbyclass('addContact')){
            return;
        }
        if(addressList.length <= 0){
            toastr.error("add atleast one address");
            return;
        }

        const formData = {};
        $('.addContact input').each(function () {
            const id = $(this).attr('id');
            formData[id] =  $(this).val();
        });
        formData["addresses"] = addressList;

        $.ajax({
            type: "POST",
            url: "http://localhost:8080/admin/submitContact/" + employeeId,
            contentType: "application/json",
            data: JSON.stringify(formData),
            success: function (response) {
                toastr.success(response);
                addressList = [];
                $('.addContact')[0].reset();
                $('#submitted').html('');
                const somevarValue = parseInt($('#somevalue').val());
                if(somevarValue <= 1) {
                    $('#somevalue').val(2);
                }
                $('#familyMenu').click();
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
        var flag = false;
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
                flag = true;
            }
        });
        if(flag) {
            return;
        }
        $('.addFamily')[0].reset();
        $('.familyTempData').removeClass("familyTempData");
        $('#submitted').html('');
        const somevarValue = parseInt($('#somevalue').val());
        if(somevarValue <= 2) {
            $('#somevalue').val(3);
        }
        $('#emergencyMenu').click();
    });

    $('.addPersonal').submit(function (event) {
        event.preventDefault();
        if(!validateFormbyclass('addPersonal')){
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
        if(emergencyList.length <= 0){
            toastr.error("add some records.");
            return;
        }
        var flag = false;
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
                flag= true;
            }
        });
        if(flag){return}
        $('.tempEmrData').removeClass('tempEmrData');
        const somevarValue = parseInt($('#somevalue').val());
        if(somevarValue <= 3)$('#somevalue').val(4);
        $('#nomineeMenu').click();
    });

    $('.addNominee').submit(function (event) {
        event.preventDefault();
        if(nomineeList <= 0){
            toastr.error("add atleast one record");
            return;
        }
        $.ajax({
            type: 'POST',
            contentType: 'application/json',
            url: '/admin/submitNominee/'+employeeId,
            data: JSON.stringify(nomineeList),
            success: function (response) {
                toastr.success(response);
                nomineeList = [];
                $('.tempNomData').removeClass('tempNomData');
                const somevarValue = parseInt($('#somevalue').val());
                if(somevarValue <= 4)$('#somevalue').val(5);
                $('#healthMenu').click();
            },
            error: function (error){
                toastr.error("something went wrong");
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
                const somevarValue = parseInt($('#somevalue').val());
                if(somevarValue <= 5)$('#somevalue').val(6);
                $('#photoMenu').click();
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

    $('.menu-card').click(function () {
        const somevarValue = parseInt($('#somevalue').val());
        console.log(somevarValue);
        const element = $(this).children().first();
        if(element.attr('ydata')<=somevarValue){
            toggleMenuOption(element.attr('xdata'));
        }
    });



    var employeeSignflag = parseInt($('#empsign').val()) === 1;
    var employeePhotoflag = parseInt($('#empphoto').val()) === 1;

    console.log(employeePhotoflag+","+employeeSignflag)

    $('.photobutton').click(function () {
        const inputId = $(this).attr('xdata');
        const fileInput = document.getElementById(inputId);
        const selectedFile = fileInput.files[0];

        if (selectedFile) {
            const formData = new FormData();
            formData.append(inputId, selectedFile);


            $.ajax({
                url: 'http://localhost:8080/admin/submitPhoto/' + employeeId,
                type: 'POST',
                data: formData,
                contentType: false, // Let jQuery handle the contentType
                processData: false, // Prevent jQuery from processing the data

                // // Custom XMLHttpRequest to allow handling file uploads
                // xhr: function () {
                //     const xhr = new window.XMLHttpRequest();
                //     xhr.upload.addEventListener("progress", function (evt) {
                //         if (evt.lengthComputable) {
                //             let percentComplete = (evt.loaded / evt.total) * 100;
                //             console.log('Upload Progress: ' + percentComplete + '%');
                //         }
                //     }, false);
                //     return xhr;
                // },

                success: function (data) {
                    toastr.success('Upload successful:', data);
                    if(inputId == 'employeeSign') {
                        employeeSignflag = true;
                    }
                    if(inputId == 'employeePhoto') {
                        employeePhotoflag = true;
                        console.log("here photo" + employeeSignflag);
                    }
                    if(employeeSignflag && employeePhotoflag){
                        const somevarValue = parseInt($('#somevalue').val());
                        if (somevarValue <= 6) $('#somevalue').val(7);
                    }

                },
                error: function (error) {
                    toastr.error('Error during upload:', error);
                }
            });
        } else {
            alert('Please select a file before uploading.');
        }
    })
});