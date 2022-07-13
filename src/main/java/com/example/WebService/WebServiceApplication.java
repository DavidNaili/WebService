package com.example.WebService;


import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import net.sf.jmimemagic.Magic;
import net.sf.jmimemagic.MagicException;
import net.sf.jmimemagic.MagicMatchNotFoundException;
import net.sf.jmimemagic.MagicParseException;

@SpringBootApplication
@Controller
public class WebServiceApplication{
	
	@RequestMapping (value = "/", method = RequestMethod.GET)
    public String get(HttpServletRequest request) {
        return "fileUpload";
	}

	@RequestMapping (value = "/uploadFile", method=RequestMethod.POST)
	public String saveFile(@RequestParam("file") MultipartFile file, Model model)
		throws MagicParseException, MagicMatchNotFoundException, MagicException, IOException {
			System.out.println("--------" + file.getOriginalFilename());

			String baseDir = "F:/Projekt/WebService/src/main/resources/static/upload/";
	
	if (!file.getOriginalFilename().matches("^.*(png)$")){
			model.addAttribute("Error", Boolean.TRUE);
			return "fileUpload";
	}
	String mimeType = Magic.getMagicMatch(file.getBytes()).getMimeType();
	if (!mimeType.equalsIgnoreCase(MimeTypes.CSV)){
		model.addAttribute("mimeError", Boolean.TRUE);
		return "fileUpload";
	}
	model.addAttribute("success", Boolean.TRUE);
	file.transferTo(new File(baseDir + file.getOriginalFilename()));
	return "fileUpload";
}
	
static String jdbcURL = "jdbc:h2:~/WebService";
static String username = "Naili";
static String password = "nami1980";

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(WebServiceApplication.class, args);

	Connection connection = DriverManager.getConnection(jdbcURL, username, password);
    	System.out.println("Connected to H2 embedded database.");

    connection.close();
		}

	}