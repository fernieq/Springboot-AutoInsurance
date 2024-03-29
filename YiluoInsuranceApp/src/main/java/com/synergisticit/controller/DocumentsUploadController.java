package com.synergisticit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.synergisticit.domain.Document;
import com.synergisticit.domain.User;
import com.synergisticit.service.DocumentService;
import com.synergisticit.service.UserService;

@Controller
public class DocumentsUploadController {
	
	@Autowired DocumentService documentService;
	@Autowired UserService userService;

	@GetMapping("upload") 
	public String displayUploadForm() {
        return "uploadForm";
    }

    @PostMapping("upload") 
    public String uploadImage(Model model, @RequestParam("file") MultipartFile file, 
    			@RequestParam("userName") String userName, @RequestParam("userEmail") String userEmail) throws Exception {
    	try {
    		List<User> users = userService.findAll();
    		for (User user : users) {
    			if (user.getUserName().equals(userName) && user.getUserEmail().equals(userEmail)) {
    				String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    				
    				try {
    					if(fileName.contains("..")) {
    						throw new Exception("Filename contains invalid path sequence" + fileName);
    					}
    					//create the download url
    					String downloadUrl = "";
    					downloadUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
    							.path("/download")
    							.toUriString();
    					Document document = new Document(fileName, file.getContentType(), file.getBytes(), file.getSize(), downloadUrl, user);
    					//save the document to the db
        				documentService.save(document);
        				return "uploadSuccess";
    			
    				} catch (Exception e) {
    					throw new Exception("Could not upload the file: " + fileName);
    				}
    				
    				
    			}
    		}
    		model.addAttribute("msg", "User Name or User Email Does Not Match With The System.");
		} catch (Exception e) {
			throw new Exception("Could not upload the file: " + file.getOriginalFilename());
		}
    	return "uploadForm";
    }
    
    @GetMapping("uploadSuccess") 
    public String uploadSuccess() {
    	return "uploadSuccess";
    }
	
}
