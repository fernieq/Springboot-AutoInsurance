package com.synergisticit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.synergisticit.domain.Document;
import com.synergisticit.domain.User;
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
	
			return documentRepository.save(document);
		} catch (Exception e) {
			throw new Exception("Could not upload the file: " + fileName);
		}
	}

	public Document save(Document document) {
		return documentRepository.save(document);
	}

	public List<Document> findAll() {
		return documentRepository.findAll();
	}

	public Document findById(Long documentId) {
		Optional<Document> optional = documentRepository.findById(documentId);
		if (optional != null)
			return optional.get();
		return null;
	}
}
