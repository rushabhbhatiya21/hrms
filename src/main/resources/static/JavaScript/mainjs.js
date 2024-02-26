
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

    console.log(previewText);

    // Check if elements are found
    if (!previewText || !previewImage) {
        console.error('Preview elements not found. Check the HTML structure.');
        return;
    }

    // Trigger file input click
    fileInput.click();

    // Listen for file selection
    fileInput.addEventListener('change', function () {
        const selectedFile = fileInput.files[0];

        if (selectedFile) {
            // Display preview
            const reader = new FileReader();
            reader.onload = function (e) {
                previewImage.innerHTML = `<img src="${e.target.result}" alt="Preview" style="max-width: 100%; max-height: 100%;">`;
                previewText.textContent = '';
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
        // Use FormData to send the file in a POST request
        const formData = new FormData();
        formData.append('photo', selectedFile);

        // Replace the URL with your backend endpoint
        const uploadUrl = 'your_backend_upload_endpoint';

        // Make a POST request using Fetch API
        fetch(uploadUrl, {
            method: 'POST',
            body: formData
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json();
            })
            .then(data => {
                // Handle successful response from the server
                console.log('Upload successful:', data);
            })
            .catch(error => {
                // Handle errors
                console.error('Error during upload:', error);
            });
    } else {
        alert('Please select a file before uploading.');
    }
}

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


    $('.addemployee').submit(function (event) {
        event.preventDefault();
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

        $.ajax({
            type: 'POST',
            contentType: 'application/json',
            url: '/admin/submitEmployeeData',
            data: JSON.stringify(formData),
            success: function (response) {
                window.location.href = 'http://localhost:8080/admin/editEmployee/'+response;
            },
            error: function (error) {
                console.error(error);
            }
        });
    });
});