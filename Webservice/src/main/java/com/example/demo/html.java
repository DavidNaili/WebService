package com.example.demo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class html{
	
    static final String DB_URL = "jdbc:h2:~/localhost/F/H2/bin";


	public static void main(String[]args){
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

        try {
           
            Connection conn = DriverManager.getConnection(DB_URL);
            conn.close();

        } catch (SQLException e) {
            System.err.println("Fehler bei der Datenbankabfrage");
            e.printStackTrace();
        }
		
		String html = "<div><h1>Upload von .CSV Dateien</h1><form name=\"uploadformular\" enctype=\"multipart/form-data\" action=\"Webservice/commons-fileupload-1.4\" method=\"post\"  >\r\n"
				+ "  Datei:\r\n"
				+ "  <input id=\"upload\" name=\"uploaddatei\" class=\"w3-input\" type=\"file\" accept=\".csv\">\r\n"
				+ "  <input type=\"submit\" name=\"Submit\" value=\"Datei hochladen\">\r\n"
				+ "	</form></div>";

		File f = new File("F:/Webservice/WebService/Webservice/Webservice.html");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
			bw.write(html);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
