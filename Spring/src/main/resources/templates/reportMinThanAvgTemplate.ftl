<!DOCTYPE html>
<html>
<style>
    table {
    border: 1px solid #CCC;

    }

    td {
        border: none;
    }
</style>
    <head>
        <title>List of Subjects with low than average marks</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h2>${studName}'s Results</h2>

        <table>
            <tr>
                <th>Subject</th>
                <th>Marks</th>
            </tr>
            <#list subjectsAndAvg as subject, avg>
                <tr>
                    <td align="center">${subject.name}</td>
                    <td align="center">${avg}</td>
                </tr>
            </#list>
        </table>
    </body>
</html>