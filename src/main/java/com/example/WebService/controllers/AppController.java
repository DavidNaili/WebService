package com.example.WebService.controllers;


import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.WebService.MimeTypes;

import net.sf.jmimemagic.Magic;
import net.sf.jmimemagic.MagicException;
import net.sf.jmimemagic.MagicMatchNotFoundException;
import net.sf.jmimemagic.MagicParseException;

@Controller
public class AppController {

    @RequestMapping (value = "/", method = RequestMethod.GET)
    public String get(HttpServletRequest request) {
        return "fileUpload";
	}

	/**
	 * @param file
	 * @param model
	 * @return
	 * @throws MagicParseException
	 * @throws MagicMatchNotFoundException
	 * @throws MagicException
	 * @throws IOException
	 */
	@RequestMapping (value = "/uploadFile", method=RequestMethod.POST)
	public String saveFile(@RequestParam("file") MultipartFile file, Model model)
		throws MagicParseException, MagicMatchNotFoundException, MagicException, IOException {
			System.out.println("--------" + file.getOriginalFilename());

	String mimeType = Magic.getMagicMatch(file.getBytes()).getMimeType();
	if (!mimeType.equalsIgnoreCase(MimeTypes.CSV)){
	model.addAttribute("mimeError", Boolean.TRUE);
	return "mimeError";
	}
	else if (!file.getOriginalFilename().matches("^.*(image/png, image/apng, image/jpg, image/jpeg, image/pdf, image/gif," + 
												"application/vnd.ms-excel, application/zip, application/xml, text/css, text/html," + 
												"text/php, text/plain, text/xml, audio/mpeg, audio/ogg)$")){
		model.addAttribute("fileError", Boolean.TRUE);
		return "fileError";
	}
	else if (!file.getOriginalFilename().matches("^.*(text/csv)$")){
	String baseDir = "F:/Projekt/WebService/src/main/resources/static/upload/";
	model.addAttribute("success", Boolean.TRUE);
	file.transferTo(new File(baseDir + file.getOriginalFilename()));
	return "success";
	}
	return mimeType;
	}   
}
