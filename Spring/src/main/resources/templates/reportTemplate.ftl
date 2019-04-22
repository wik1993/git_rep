<!DOCTYPE html>
<html>
    <head>
        <title>List of Subjects with low than average marks</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/style.css" />
        </head>
    <body>
        <h2>The Results</h2>

        <table>
            <tr>
                <th>Subject</th>
                <th>Number of hours</th>
                <th>Marks average</th>
            </tr>

            <#list subjects as subject>
                <tr>
                    <td>${subject.name}</td>
                    <td>${subject.numberOfHours}</td>
                    <td>${subject.average}</td>
                </tr>
            </#list>

        </table>
    </body>
</html>