<!DOCTYPE html>
<html>
    <head>
        <title>List of Subjects with low than average marks</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

        <link href='http://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>

        <style>
            body {
                font-family: 'Roboto', sans-serif;
                font-size: 48px;
            }
            td {
                border: none;
            }
        </style>
    </head>
    <body>
        <h2>${studName}'s Results</h2>

        <table align="center" border="0" cellpadding="0" cellspacing="0" width="600" style="border-collapse: collapse;">
            <tr>
                <th>Subject</th>
                <th>Marks</th>
            </tr>
            <#list subjectsAndMarks as subject, marks>
                <tr>
                    <td align="center" bgcolor="#eaeaea" style="padding: 2px 2px 2px 2px;">${subject.name}</td>
                    <#list marks as mark>
                     <td align="center" bgcolor="#777777" style="padding: 2px 10px 2px 2px;">${mark.value}</td>
                     </#list>
                </tr>
            </#list>
        </table>
    </body>
</html>