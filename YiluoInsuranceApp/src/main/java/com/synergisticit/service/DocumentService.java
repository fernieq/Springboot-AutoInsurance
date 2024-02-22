package com.synergisticit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.synergisticit.domain.Document;
import com.synergisticit.repository.DocumentRepository;

@Service
public class DocumentService {
	
	@Autowired DocumentRepository documentRepository;

	public Document save(MultipartFile file) throws Exception{
		
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		
		try {
			if(fileName.contains("..")) {
				throw new Exception("Filename contains invalid path sequence" + fileName);
			}
			Document document = new Document(fileName, file.getContentType(), file.getBytes());
	
//			System.out.println(document.getFileName());
//			System.out.println(document.getFileType());
//			System.out.println(document.getDriverLicense());

			return documentRepository.save(document);
		} catch (Exception e) {
			throw new Exception("Could not upload the file: " + fileName);
		}
	}
}
