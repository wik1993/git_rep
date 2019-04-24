<!DOCTYPE html>
<html>
    <head>
        <title>List of Subjects with low than average marks</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/style.css" />
        </head>
    <body>
        <h2>${studName}'s Results</h2>

        <table border="1">
            <tr>
                <th>Subject</th>
                <th>Marks</th>
            </tr>
            <#list subjectsAndMarks as subject, marks>
                <tr>
                    <td align="center">${subject.name}</td>
                    <#list marks as mark>
                    <td align="center">${mark.value}</td>
                    </#list>
                </tr>
         </#list>
        </table>
    </body>
</html>