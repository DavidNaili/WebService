package com.example.WebService;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@SpringBootApplication
@Controller
public class WebServiceApplication {

	@GetMapping("/success")
	public String success(){
		return "success";
	}
	@GetMapping("/error")
	public String error(){
		return "error";
	}

	@PostMapping("/upload")
	public String uploadFile(@RequestParam("file")MultipartFile file)
		throws IllegalStateException, IOException {

		String baseDir = "F:/Projekt/WebService/src/main/resources/static/upload/";
	
	if (file.getOriginalFilename().endsWith(".csv")){
		file.transferTo(new File(baseDir + file.getOriginalFilename()));
		return "redirect:/success";
	}
	else
	{return "redirect:/error";}
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