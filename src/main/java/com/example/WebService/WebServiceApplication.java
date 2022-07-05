package com.example.WebService;

import java.io.File;
import java.io.IOException;

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

	@GetMapping("/index")
	public String index(){
		return "index";
	}

	@PostMapping("/upload")
	public String uploadFile(@RequestParam("file")MultipartFile file)
		throws IllegalStateException, IOException {

		String baseDir = "F:/Projekt/WebService/src/main/resources/static/upload/";
		file.transferTo(new File(baseDir + "myfile.csv"));
		return "redirect:/index";
	}

	public static void main(String[] args) {
		SpringApplication.run(WebServiceApplication.class, args);
	}
}
