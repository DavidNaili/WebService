package com.example.WebService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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

	public boolean LoadCSV(String baseDir, String csvfile, String separator) throws FileNotFoundException, IOException {
    boolean ret = false;
     
    File f = new File(csvfile);
     
    // prüfen, ob Datei existiert
    if (f.exists() && f.isFile())
    {
        BufferedReader br = null;
        FileReader fr = null;
 
        try
        {
            fr = new FileReader(f);
            br = new BufferedReader(fr);
             
            String l;
             
            // solange Zeilen in der Datei vorhanden
            while ((l = br.readLine()) != null)
            {
                // Zeilen anhand des Separators,
                // z.B. ";", aufsplitten
                String[] col = l.split(separator);
                 
                // testweise einzelne Spalten ausgeben
                for (String s : col)
                {
                    System.out.println(s);
                }
            }
             
            ret = true;
        }
        finally
        {
            if (br != null)
            {
                br.close();
            }
 
            if (fr != null)
            {
                fr.close();
            }
        }
    }
     
    return ret;
}


	public static void main(String[] args) {
		SpringApplication.run(WebServiceApplication.class, args);
	}
}
