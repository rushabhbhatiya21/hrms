<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Search</title>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>
<body>
<h1>Employee Search</h1>

<label for="searchInput">Search by Name:</label>
<input type="text" id="searchInput" oninput="searchEmployees()">

<ul id="searchResults"></ul>

<div id="employeeDetails"></div>

<script>
    function searchEmployees() {
        const searchTerm = $('#searchInput').val();

        if (searchTerm.length >= 1) {
            $.ajax({
                url: '/admin/searchEmployees?searchTerm=' + searchTerm,
                method: 'GET',
                success: function (data) {
                    displaySearchResults(data);
                },
                error: function (error) {
                    console.error('Error during search:', error);
                }
            });
        } else {
            // Clear the search results if the search term is too short
            $('#searchResults').empty();
        }
    }

    function displaySearchResults(results) {
        const searchResultsList = $('#searchResults');
        searchResultsList.empty();

        results.forEach(function (employee) {
            const listItem = $('<li>')
                .text(employee.firstName + ' ' + employee.lastName)
                .click(function () {
                    // Display details when a search result is clicked
                    displayEmployeeDetails(employee);
                });

            searchResultsList.append(listItem);
        });
    }

    function displayEmployeeDetails(employee) {
        const employeeDetailsDiv = $('#employeeDetails');
        employeeDetailsDiv.empty();

        const detailsParagraph = $('<p>').text('Employee Details:');
        const detailsList = $('<ul>')
            .append($('<li>').text('ID: ' + employee.employeeId))
            .append($('<li>').text('First Name: ' + employee.firstName))
            .append($('<li>').text('Middle Name: ' + employee.middleName))
            .append($('<li>').text('Last Name: ' + employee.lastName))
            .append($('<li>').text('Department: ' + employee.department.departmentName));

        employeeDetailsDiv.append(detailsParagraph).append(detailsList);
    }
</script>
</body>
</html>
