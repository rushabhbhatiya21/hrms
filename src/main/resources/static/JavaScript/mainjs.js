$(document).ready(function () {
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