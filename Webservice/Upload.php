<?php
	
	echo "<pre>";
	echo "FILES:<br>";
	print_r ($_FILES );
	echo "</pre>";
	
	if ( $_FILES['uploaddatei']['name']  <> "" )
	{
		$zugelassenedateitypen = array(".csv");

    if ( ! in_array( $_FILES['uploaddatei']['type'] , $zugelassenedateitypen ))
    {
        echo "<p>Dateitype ist NICHT zugelassen</p>";
    }
    else
    {
		$_FILES['uploaddatei']['name'] = dateiname_bereinigen($_FILES['uploaddatei']['name']);

        if ( $_FILES['uploaddatei']['name'] <> '' )
        {
            move_uploaded_file ($_FILES['uploaddatei']['tmp_name'] ,'f:/Projekt/hochgeladenes/'. $_FILES['uploaddatei']['name'] );

            echo "<p>Hochladen war erfolgreich: ";
            echo '<a href="hochgeladenes/'. $_FILES['uploaddatei']['name'] .'">';
            echo 'hochgeladenes/'. $_FILES['uploaddatei']['name'];
            echo '</a>';
        }
        else
        {
            echo "<p>Dateiname ist nicht zul�ssig</p>";
        }
    }
}

function dateiname_bereinigen($dateiname)
{
    $dateiname = strtolower ( $dateiname );
    $dateiname = str_replace ('"', "-", $dateiname );
    $dateiname = str_replace ("'", "-", $dateiname );
    $dateiname = str_replace ("*", "-", $dateiname );
    $dateiname = str_replace ("�", "ss", $dateiname );
    $dateiname = str_replace ("�", "ss", $dateiname );
    $dateiname = str_replace ("�", "ae", $dateiname );
    $dateiname = str_replace ("�", "ae", $dateiname );
    $dateiname = str_replace ("�", "oe", $dateiname );
    $dateiname = str_replace ("�", "oe", $dateiname );
    $dateiname = str_replace ("�", "ue", $dateiname );
    $dateiname = str_replace ("�", "ue", $dateiname );
    $dateiname = str_replace ("�", "ae", $dateiname );
    $dateiname = str_replace ("�", "oe", $dateiname );
    $dateiname = str_replace ("�", "ue", $dateiname );
    $dateiname = htmlentities ( $dateiname );
    $dateiname = str_replace ("&", "und", $dateiname );
    $dateiname = str_replace (" ", "und", $dateiname );
    $dateiname = str_replace ("(", "-", $dateiname );
    $dateiname = str_replace (")", "-", $dateiname );
    $dateiname = str_replace (" ", "-", $dateiname );
    $dateiname = str_replace ("'", "-", $dateiname );
    $dateiname = str_replace ("/", "-", $dateiname );
    $dateiname = str_replace ("?", "-", $dateiname );
    $dateiname = str_replace ("!", "-", $dateiname );
    $dateiname = str_replace (":", "-", $dateiname );
    $dateiname = str_replace (";", "-", $dateiname );
    $dateiname = str_replace (",", "-", $dateiname );
    $dateiname = str_replace ("--", "-", $dateiname );
    $dateiname = filter_var($dateiname, FILTER_SANITIZE_URL);
    return ($dateiname);
}
?>