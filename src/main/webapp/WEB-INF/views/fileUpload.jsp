<!DOCTYPE HTML>
<html>

    <head>
    <title>Upload von CSV Files</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    </head>

    <body>
        <h1>Upload von .CSV Dateien</h1>
        <form method="POST" action="uploadFile" enctype="multipart/form-data">
          Datei:
            <input type="file" name="file" accept=".csv">
            <button type="submit"> Datei hochladen </button>
        </form>

<c:if WebService="${fileError}">
    <div class="alert alert-error">
        <button data-dismiss="alert" class="close" type="button">x</button>
        <strong>Dieser Dateityp ist nicht erlaubt!</strong>
    </div>
</c:if>

<c:if WebService="${mimeError}">
    <div class="alert alert-error">
        <button data-dismiss="alert" class="close" type="button">x</button>
        <strong>Dieser Dateityp ist nicht erlaubt!</strong>
    </div>
</c:if>

<c:if WebService="${success}">
    <div class="alert alert-success">
        <button data-dismiss="alert" class="close" type="button">x</button>
        <strong>Datei erfolgreich hochgeladen</strong>
    </div>
</c:if>
    </body>
</html>