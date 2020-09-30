<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Note - Simple Note Keeper</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2>
        <Strong>Title: </Strong> ${note.title} <br><br>
        <Strong>Contents:</Strong>
        <div>
            ${note.contents}
        </div>    
        <br>       
        <div>
            <a href="note?edit">Edit</a>
        </div>
    </body>
</html>
