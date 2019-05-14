<!DOCTYPE html>
<html>
    <head>
        <title>List of Subjects with low than average marks</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

        <link href='http://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>

        <style>
                table {
                    border: 0;
                }
                body {
                    font-family: 'Roboto', sans-serif;
                    font-size: 48px;
                }
                td {
                    border: 0;
                }
            </style>
    </head>
    <body>
        <h2 align="center">${studName}'s Results</h2>

        <table align="center" cellpadding="0" cellspacing="0" width="300" style="border-collapse: collapse;">
            <tr>
                <th>Subject</th>
                <th>Marks</th>
            </tr>
            <#list subjectsAndAvg as subject, avg>
                <tr>
                    <td align="center" bgcolor="#eaeaea" style="padding: 2px 2px 2px 2px;">${subject.name}</td>
                    <td align="center"  style="padding: 2px 10px 2px 10px;">${avg}</td>
                </tr>
            </#list>
        </table>
    </body>
</html>