package com.sendemailapi.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sendemailapi.model.EmailModel;
import com.sendemailapi.service.EmailService;

@RestController
public class EmailController {

	boolean result=false;
	
	@Autowired
	private EmailService emailService;
	
	  private static String UPLOADED_FOLDER = "E:\\New folder";
	
	@PostMapping(value="/sendemail")
	public ResponseEntity<?> sendEmail(@RequestParam("to") String to, @RequestParam("cc") String cc, @RequestParam("subject") String subject, @RequestParam("messagebody") String messagebody, @RequestParam("file") MultipartFile file) throws IOException
	{
		
		byte[] bytes = file.getBytes();
        Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
        Files.write(path, bytes);
        
		result=this.emailService.sendEmail(to, cc, subject, messagebody, file);
		if(result==false)
		{
			return ResponseEntity.ok("Email Sent Successfully");
		}
		else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email not sent");
		}
		
	}
	
}
